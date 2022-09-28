<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchprofile의 특정 데이터를 조회합니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchprofile/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	document.formm.action="/admin/meetmatch/meetmatchprofile/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/meetmatch/meetmatchprofile/list";
	document.formm.method = 'get';
	document.formm.submit();
}
</script>
</head>
<body>

	<form name="formm">	
		
		<span>meetmatchprofile_seq</span>
		<input type="text" name="meetmatchprofile_seq" readonly="readonly" value='<c:out value="${meetmatchprofile.meetmatchprofile_seq}"/>'/>
		<br/>
		<span>meetmatchprofile_gender</span>
		<input type="text" name="meetmatchprofile_gender" value='<c:out value="${meetmatchprofile.meetmatchprofile_gender}"/>'>
		<br/>
		<span>meetmatchprofile_department</span>
		<input type="text" name="meetmatchprofile_department" value='<c:out value="${meetmatchprofile.meetmatchprofile_department}"/>'>
		<br/>
<%-- 		<span>meetmatchprofile_regdate</span>
		<input type="text" name="meetmatchprofile_regdate" readonly="readonly" value='<c:out value="${meetmatchprofile.meetmatchprofile_regdate}"/>'>
		<br/> --%>
		<span>mem_seq</span>
		<input type="text" name="mem_seq" value='<c:out value="${meetmatchprofile.mem_seq}"/>'>
		<br/>
		<br/>
		<br/>
		<input type="button" value="modify" onclick="go_modify()"/>
		<input type="button" value="remove" onclick="go_remove()"/>
		<input type="button" value="list" onclick="go_list()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>