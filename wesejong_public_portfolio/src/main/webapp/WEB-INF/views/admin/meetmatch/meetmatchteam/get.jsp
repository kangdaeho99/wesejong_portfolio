<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchteam의 특정 데이터를 조회합니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchteam/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	document.formm.action="/admin/meetmatch/meetmatchteam/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/meetmatch/meetmatchteam/list";
	document.formm.method = 'get';
	document.formm.submit();
}
</script>
</head>
<body>


	<form name="formm">	


		<br/>
		<span>meetmatchteam_seq</span>
		<input type="text" name="meetmatchteam_seq" readonly="readonly" value='<c:out value="${meetmatchteam.meetmatchteam_seq}"/>'/>
		<br/>
		<span>meetmatchteam_gender</span>
		<input type="text" name="meetmatchteam_gender" value='<c:out value="${meetmatchteam.meetmatchteam_gender}"/>'>
		<br/>
		<span>meetmatchteam_certified</span>
		<input type="text" name="meetmatchteam_certified" value='<c:out value="${meetmatchteam.meetmatchteam_certified}"/>'>
		<br/>
		<span>meetmatchteam_matchedflag</span>
		<input type="text" name="meetmatchteam_matchedflag" value='<c:out value="${meetmatchteam.meetmatchteam_matchedflag}"/>'>
		<br/>
		<span>meetmatchteam_matchedpartner</span>
		<input type="text" name="meetmatchteam_matchedpartner" value='<c:out value="${meetmatchteam.meetmatchteam_matchedpartner}"/>'>
		<br/>
		<span>meetmatchmanage_seq</span>
		<input type="text" name="meetmatchmanage_seq" value='<c:out value="${meetmatchteam.meetmatchmanage_seq}"/>'>
		<br/>
		<span>meetmatchpersonnelmanage_personnel</span>
		<input type="text" name="meetmatchpersonnelmanage_personnel" value='<c:out value="${meetmatchteam.meetmatchpersonnelmanage_personnel}"/>'>
		<br/>
		<span>meetmatchteammate_certifiedcount</span>
		<input type="text" name="meetmatchteammate_certifiedcount" value='<c:out value="${meetmatchteam.meetmatchteammate_certifiedcount}"/>'>
		<br/>
		
		<br/>
		<input type="button" value="modify" onclick="go_modify()"/>
		<input type="button" value="remove" onclick="go_remove()"/>
		<input type="button" value="list" onclick="go_list()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>