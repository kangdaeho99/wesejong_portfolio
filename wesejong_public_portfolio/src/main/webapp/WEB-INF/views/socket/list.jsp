<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/socket/remove";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>chatroom 데이터등록</h1>
	<p>,
		주의사항:아직 안만듬 삭제는 다중선택말고 한개씩만 삭제가능하도록 설정함
		이유는 실제페이지에서도 한개씩만 삭제가능하도록할생각
	</p>
	<form action="/socket/register" method="post">		
		<span>chatroom_id</span>
		<input type="text" name="chatroom_id" placeholder="chatroom_id">
		
		<span>chatroom_name</span>
		<input type="text" name="chatroom_name" placeholder="chatroom_name">
		
		
		<input type="submit" value="submit">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
	<form name="formm" method="post">
		<table border="1">
			<colgroup>
<!-- 				<col width="100px">
				<col width="100px">
				<col width="100px">
				<col width="100px">
				<col width="100px"> -->
			</colgroup>
			
			<thead>
				<tr>
					<th><input type="checkbox"/></th>
					<th>chatroom_seq</th>
					<th>chatroom_id</th>
					<th>chatroom_name</th>
				</tr>
			</thead>
			
			<c:forEach items="${chatroomlist}" var="list">
				<tr>
					<td><input type="checkbox" name="chatroom_seq" value="${list.chatroom_seq}"/></td>
					<td><c:out value="${list.chatroom_seq}"/></td>
					<td><a href="/socket/chat?chatroom_id=<c:out value="${list.chatroom_id}"/>"><c:out value="${list.chatroom_id}"/></a></td>
					<td><c:out value="${list.chatroom_name}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>