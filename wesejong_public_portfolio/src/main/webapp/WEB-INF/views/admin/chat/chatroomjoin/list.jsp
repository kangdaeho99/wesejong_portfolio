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
	document.form.action = "/admin/chat/chatroomjoin/register";
	document.form.method = 'post';
	document.form.submit();
}
function go_remove(){
	document.formm.action="/admin/chat/chatroomjoin/removebychkbox";
	document.formm.method = 'post';
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>chatroomjoin 데이터등록</h1>
	<p>,

	</p>
	<form name="form" method="post">		
		<span>chatroomjoin_seq</span>
		<!-- <input type="text" name="chatroomjoin_id" placeholder="chatroomjoin_id"> -->
		
		<span>chatroom_seq</span>
		<input type="text" name="chatroom_seq" placeholder="chatroomjoin_name">
		<span>mem_seq</span>
		<input type="text" name="mem_seq" placeholder="mem_seq">		
		
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
					<th>chatroomjoin_seq</th>
					<th>chatroom_seq</th>
					<th>mem_seq</th>
				</tr>
			</thead>
			
			<c:forEach items="${chatroomjoinlist}" var="list">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${list.chatroomjoin_seq}"/></td>
					<td><a href="/admin/chat/chatroomjoin/get?chatroomjoin_seq=<c:out value="${list.chatroomjoin_seq}"/>"><c:out value="${list.chatroomjoin_seq}"/></a></td>
					<td><c:out value="${list.chatroom_seq}"/></td>
					<td><c:out value="${list.mem_seq}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>