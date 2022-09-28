<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchprofile 테이블 데이터의 목록을 보여줍니다.</title>
<script type="text/javascript">
function go_submit(){
	document.form.action = "/admin/meetmatch/meetmatchprofile/register";
	document.form.method = 'post';
	document.form.submit();
}
function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchprofile/removebychkbox";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>meetmatchprofile 데이터등록</h1>
	<p>
		주의사항
	</p>
	<form name="form">		
		<span>meetmatchprofile_gender</span>
		<input type="text" name="meetmatchprofile_gender" placeholder="meetmatchprofile_gender">
		
		<span>meetmatchprofile_department</span>
		<input type="text" name="meetmatchprofile_department" placeholder="자유">
		
		<span>mem_seq</span>
		<input type="text" name="mem_seq" placeholder="1:기본,2:파일">
		
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
					<th>meetmatchprofile_seq</th>
					<th>meetmatchprofile_gender</th>
					<th>meetmatchprofile_department</th>
					<th>meetmatchprofile_regdate</th>
					<th>mem_seq</th>
				</tr>
			</thead>
			
			<c:forEach items="${meetmatchprofilelist}" var="meetmatchprofile">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${meetmatchprofile.meetmatchprofile_seq}"/></td>
					<td><a href="/admin/meetmatch/meetmatchprofile/get?meetmatchprofile_seq=<c:out value="${meetmatchprofile.meetmatchprofile_seq}"/>"><c:out value="${meetmatchprofile.meetmatchprofile_seq}"/></a></td>
					<td><c:out value="${meetmatchprofile.meetmatchprofile_gender}"/></td>
					<td><c:out value="${meetmatchprofile.meetmatchprofile_department}"/></td>
					
					<td><fmt:formatDate pattern="YYYY-MM-dd mm:ss" value="${meetmatchprofile.meetmatchprofile_regdate}"/></td>
					<td><c:out value="${meetmatchprofile.mem_seq}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>