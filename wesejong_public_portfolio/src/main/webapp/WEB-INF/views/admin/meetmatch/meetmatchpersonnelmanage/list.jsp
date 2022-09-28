<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchpersonnelmanage 테이블 데이터의 목록을 보여줍니다.</title>
<script type="text/javascript">
function go_submit(){
	document.form.action = "/admin/meetmatch/meetmatchpersonnelmanage/register";
	document.form.method = 'post';
	document.form.submit();
}

function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchpersonnelmanage/removebychkbox";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>meetmatchpersonnelmanage 데이터등록</h1>
	<p>
		주의사항
	</p>
	<form name="form">		
		
		<span>meetmatchpersonnelmanage_seq</span>
		<br/>
		
		<span>meetmatchpersonnelmanage_personnel</span>
		<input type="text" name="meetmatchpersonnelmanage_personnel" placeholder="몇명(1,2,3...)">
		<br/>
		
		<span>meetmatchmanage_seq</span>
		<input type="text" name="meetmatchmanage_seq" placeholder="meetmatchmanage 고유번호">
		<br/>
		
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
					<th>meetmatchpersonnelmanage_seq</th>
					<th>meetmatchpersonnelmanage_personnel</th>
					<th>meetmatchmanage_seq</th>

				</tr>
			</thead>
			
			<c:forEach items="${meetmatchpersonnelmanagelist}" var="meetmatchpersonnelmanage">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${meetmatchpersonnelmanage.meetmatchpersonnelmanage_seq}"/></td>
					<td><a href="/admin/meetmatch/meetmatchpersonnelmanage/get?meetmatchpersonnelmanage_seq=<c:out value="${meetmatchpersonnelmanage.meetmatchpersonnelmanage_seq}"/>"><c:out value="${meetmatchpersonnelmanage.meetmatchpersonnelmanage_seq}"/></a></td>
					<td><c:out value="${meetmatchpersonnelmanage.meetmatchpersonnelmanage_personnel}"/>명</td>
					<td><c:out value="${meetmatchpersonnelmanage.meetmatchmanage_seq}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>