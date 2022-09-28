<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchdepartment 테이블 데이터의 목록을 보여줍니다.</title>
<script type="text/javascript">
function go_submit(){
	document.form.action = "/admin/meetmatch/meetmatchdepartment/register";
	document.form.method = 'post';
	document.form.submit();
}
function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchdepartment/removebychkbox";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>meetmatchdepartment 데이터등록</h1>
	<p>
		주의사항
	</p>
	<form name="form">		
		
		<span>meetmatchdepartment_department</span>
		<input type="text" name="meetmatchdepartment_department" placeholder="자유">
		
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
					<th>meetmatchdepartment_seq</th>
					<th>meetmatchdepartment_department</th>
					<th>meetmatchdepartment_regdate</th>
				</tr>
			</thead>
			
			<c:forEach items="${meetmatchdepartmentlist}" var="meetmatchdepartment">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${meetmatchdepartment.meetmatchdepartment_seq}"/></td>
					<td><c:out value="${meetmatchdepartment.meetmatchdepartment_seq}"/></td>
					<td><a href="/admin/meetmatch/meetmatchdepartment/get?meetmatchdepartment_seq=<c:out value="${meetmatchdepartment.meetmatchdepartment_seq}"/>"><c:out value="${meetmatchdepartment.meetmatchdepartment_department}"/></a></td>
					<td><c:out value="${meetmatchdepartment.meetmatchdepartment_regdate}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>