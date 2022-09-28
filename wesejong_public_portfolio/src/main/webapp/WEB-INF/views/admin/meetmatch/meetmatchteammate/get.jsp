<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchteammate의 특정 데이터를 조회합니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchteammate/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	document.formm.action="/admin/meetmatch/meetmatchteammate/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/meetmatch/meetmatchteammate/list";
	document.formm.method = 'get';
	document.formm.submit();
}
</script>
</head>
<body>

	<form name="formm">	
		
		<span>meetmatchteammate_seq</span>
		<input type="text" name="meetmatchteammate_seq" readonly="readonly" value='<c:out value="${meetmatchteammate.meetmatchteammate_seq}"/>'/>
		<br/>
		<span>meetmatchteammate_gender</span>
		<input type="text" name="meetmatchteammate_gender" value='<c:out value="${meetmatchteammate.meetmatchteammate_gender}"/>'>
		<br/>
		<span>meetmatchteammate_department</span>
		<input type="text" name="meetmatchteammate_department" value='<c:out value="${meetmatchteammate.meetmatchteammate_department}"/>'>
		<br/>
		<span>meetmatchteammate_teamleaderflag</span>
		<input type="text" name="meetmatchteammate_teamleaderflag" value='<c:out value="${meetmatchteammate.meetmatchteammate_teamleaderflag}"/>'>
		<br/>
		<span>meetmatchteammate_certified</span>
		<input type="text" name="meetmatchteammate_certified" value='<c:out value="${meetmatchteammate.meetmatchteammate_certified}"/>'>
		<br/>
		<span>meetmatchteam_seq</span>
		<input type="text" name="meetmatchteam_seq" value='<c:out value="${meetmatchteammate.meetmatchteam_seq}"/>'>	
		<br/>	
		<span>mem_seq</span>
		<input type="text" name="mem_seq" value='<c:out value="${meetmatchteammate.mem_seq}"/>'>

		<br/>
		<input type="button" value="modify" onclick="go_modify()"/>
		<input type="button" value="remove" onclick="go_remove()"/>
		<input type="button" value="list" onclick="go_list()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>