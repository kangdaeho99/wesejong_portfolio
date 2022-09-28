<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chatroomjoin의 특정 데이터를 조회합니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/chat/chatroomjoin/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	
	document.formm.action="/admin/chat/chatroomjoin/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/chat/chatroomjoin/list";
	document.formm.method = 'get';
	document.formm.submit();
}
</script>
</head>
<body>

	<form name="formm">	
		
		<span>chatroomjoin_seq</span>
		<input type="text" name="chatroomjoin_seq" readonly="readonly" value='<c:out value="${chatroomjoin.chatroomjoin_seq}"/>'/>
		<br/>
		<span>chatroom_seq</span>
		<input type="text" name="chatroom_seq" value='<c:out value="${chatroomjoin.chatroom_seq}"/>'>
		<br/>
		<span>mem_seq</span>
		<input type="text" name="mem_seq" value='<c:out value="${chatroomjoin.mem_seq}"/>'>

		
		<input type="button" value="modify" onclick="go_modify()"/>
		<input type="button" value="remove" onclick="go_remove()"/>
		<input type="button" value="list" onclick="go_list()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>