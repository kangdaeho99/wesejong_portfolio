<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchpersonnelmanage의 특정 데이터를 조회합니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchpersonnelmanage/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	document.formm.action="/admin/meetmatch/meetmatchpersonnelmanage/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/meetmatch/meetmatchpersonnelmanage/list";
	document.formm.method = 'get';
	document.formm.submit();
}
</script>
</head>
<body>

	<form name="formm">	
		
		<span>meetmatchpersonnelmanage_seq</span>
		<input type="text" name="meetmatchpersonnelmanage_seq" readonly="readonly" value='<c:out value="${meetmatchpersonnelmanage.meetmatchpersonnelmanage_seq}"/>'/>
		<br/>
		<span>meetmatchpersonnelmanage_personnel</span>
		<input type="text" name="meetmatchpersonnelmanage_personnel" value='<c:out value="${meetmatchpersonnelmanage.meetmatchpersonnelmanage_personnel}"/>'>
		<br/>
		<span>meetmatchmanage_seq</span>
		<input type="text" name="meetmatchmanage_seq" value='<c:out value="${meetmatchpersonnelmanage.meetmatchmanage_seq}"/>'>
		<br/>

		<input type="button" value="modify" onclick="go_modify()"/>
		<input type="button" value="remove" onclick="go_remove()"/>
		<input type="button" value="list" onclick="go_list()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>