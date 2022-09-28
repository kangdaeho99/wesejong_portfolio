<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchdepartment의 특정 데이터를 조회합니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchdepartment/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	document.formm.action="/admin/meetmatch/meetmatchdepartment/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/meetmatch/meetmatchdepartment/list";
	document.formm.method = 'get';
	document.formm.submit();
}
</script>
</head>
<body>

	<form name="formm">	
		
		<span>meetmatchdepartment_seq</span>
		<input type="text" name="meetmatchdepartment_seq" readonly="readonly" value='<c:out value="${meetmatchdepartment.meetmatchdepartment_seq}"/>'/>
		<br/>
		<span>meetmatchdepartment_department</span>
		<input type="text" name="meetmatchdepartment_department" value='<c:out value="${meetmatchdepartment.meetmatchdepartment_department}"/>'>
		<br/>
<%-- 		<span>meetmatchdepartment_regdate</span>
		<input type="text" name="meetmatchdepartment_regdate" value='<c:out value="${meetmatchdepartment.meetmatchdepartment_regdate}"/>'>
		<br/> --%>
		<br/>
		<input type="button" value="modify" onclick="go_modify()"/>
		<input type="button" value="remove" onclick="go_remove()"/>
		<input type="button" value="list" onclick="go_list()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>