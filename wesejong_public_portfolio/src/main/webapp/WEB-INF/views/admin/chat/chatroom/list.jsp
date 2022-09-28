<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ChatRoom 관리자페이지</title>
<script type="text/javascript">
function go_submit(){
	document.form.action = "/admin/chat/chatroom/register";
	document.form.method = 'post';
	document.form.submit();
}
function go_remove(){
	document.formm.action="/admin/chat/chatroom/removebychkbox";
	document.formm.method = 'post';
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
	<form name="form" method="post">		
		<span>chatroom_uuid</span>
		<!-- <input type="text" name="chatroom_id" placeholder="chatroom_id"> -->
		
		
		<span>chatroom_name</span>
		<input type="text" name="chatroom_name" placeholder="chatroom_name">
		
		
		<input type="submit" value="submit" onclick="go_submit()">
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
					<th>chatroom_uuid</th>
					<th>chatroom_name</th>
				</tr>
			</thead>
			
			<c:forEach items="${chatroomlist}" var="list">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${list.chatroom_seq}"/></td>
					<td><a href="/admin/chat/chatroom/get?chatroom_seq=<c:out value="${list.chatroom_seq}"/>"><c:out value="${list.chatroom_seq}"/></a></td>
					<td><a href="/socket/chat?chatroom_uuid=<c:out value="${list.chatroom_uuid}"/>"><c:out value="${list.chatroom_uuid}"/></a></td>
					<td><c:out value="${list.chatroom_name}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>