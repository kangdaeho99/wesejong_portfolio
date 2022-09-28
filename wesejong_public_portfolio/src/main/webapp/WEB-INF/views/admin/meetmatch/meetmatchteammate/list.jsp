<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchteammate 테이블 데이터의 목록을 보여줍니다.</title>
<script type="text/javascript">
function go_submit(){
	document.form.action = "/admin/meetmatch/meetmatchteammate/register";
	document.form.method = 'post';
	document.form.submit();
}

function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchteammate/removebychkbox";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>meetmatchteammate 데이터등록</h1>
	<p>
		주의사항
	</p>
	<form name='form'>		
		<span>meetmatchteammate_gender</span>
		<input type="text" name="meetmatchteammate_gender" placeholder="meetmatchteammate_gender">
		
		<span>meetmatchteammate_department</span>
		<input type="text" name="meetmatchteammate_department" placeholder="자유">
		
		<span>meetmatchteammate_teamleaderflag</span>
		<input type="text" name="meetmatchteammate_teamleaderflag" placeholder="1:기본,2:파일">
		
		<span>meetmatchteammate_certified</span>
		<input type="text" name="meetmatchteammate_certified" placeholder="meetmatchteammate_certified">
		
		<span>meetmatchteam_seq</span>
		<input type="text" name="meetmatchteam_seq" placeholder="meetmatchteam_seq">
		
		<span>mem_seq</span>
		<input type="text" name="mem_seq" placeholder="mem_seq">
		
		<input type="button" value="submit" onclick="go_submit()">
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
					<th>meetmatchteammate_seq</th>
					<th>meetmatchteammate_gender</th>
					<th>meetmatchteammate_department</th>
					<th>meetmatchteammate_teamleaderflag</th>
					<th>meetmatchteammate_regdate</th>
					<th>meetmatchteammate_certified</th>
					<th>meetmatchteammate_certifieddate</th>
					<th>meetmatchteam_seq</th>
					<th>mem_seq</th>
				</tr>
			</thead>
			
			<c:forEach items="${meetmatchteammatelist}" var="meetmatchteammate">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${meetmatchteammate.meetmatchteammate_seq}"/></td>
					<td><a href="/admin/meetmatch/meetmatchteammate/get?meetmatchteammate_seq=<c:out value="${meetmatchteammate.meetmatchteammate_seq}"/>"><c:out value="${meetmatchteammate.meetmatchteammate_seq}"/></a></td>
					<td><c:out value="${meetmatchteammate.meetmatchteammate_gender}"/></td>
					<td><a href="/admin/meetmatch/meetmatchteammate/get?meetmatchteammate_seq=<c:out value="${meetmatchteammate.meetmatchteammate_seq}"/>"><c:out value="${meetmatchteammate.meetmatchteammate_department}"/></a></td>
					<td><c:out value="${meetmatchteammate.meetmatchteammate_teamleaderflag}"/></td>
					<td><c:out value="${meetmatchteammate.meetmatchteammate_regdate}"/></td>
					<td><c:out value="${meetmatchteammate.meetmatchteammate_certified}"/></td>
					<td><c:out value="${meetmatchteammate.meetmatchteammate_certifieddate}"/></td>
					<td><c:out value="${meetmatchteammate.meetmatchteam_seq}"/></td>
					<td><c:out value="${meetmatchteammate.mem_seq}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>