<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chatroom의 특정 데이터를 조회합니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/chat/chatroom/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	
	document.formm.action="/admin/chat/chatroom/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/chat/chatroom/list";
	document.formm.method = 'get';
	document.formm.submit();
}
</script>
</head>
<body>

	<form name="formm">	
		
		<span>chatroom_seq</span>
		<input type="text" name="chatroom_seq" readonly="readonly" value='<c:out value="${chatroom.chatroom_seq}"/>'/>
		<br/>
		<span>chatroom_uuid</span>
		<input type="text" name="chatroom_uuid" value='<c:out value="${chatroom.chatroom_uuid}"/>'>
		<br/>
		<span>chatroom_name</span>
		<input type="text" name="chatroom_name" value='<c:out value="${chatroom.chatroom_name}"/>'>

		
		<input type="button" value="modify" onclick="go_modify()"/>
		<input type="button" value="remove" onclick="go_remove()"/>
		<input type="button" value="list" onclick="go_list()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>