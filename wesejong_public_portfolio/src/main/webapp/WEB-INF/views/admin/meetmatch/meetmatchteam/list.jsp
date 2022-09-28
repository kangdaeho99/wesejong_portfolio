<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchteam 테이블 데이터의 목록을 보여줍니다.</title>
<script type="text/javascript">
function go_submit(){
	document.form.action = "/admin/meetmatch/meetmatchteam/register";
	document.form.method = 'post';
	document.form.submit();
}

function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchteam/removebychkbox";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>meetmatchteam 데이터등록</h1>
	<p>
		주의사항
	</p>
	<form name="form" method="post">		
		
		<span>meetmatchteam_gender</span>
		<input type="radio" name="meetmatchteam_gender" value="male">male
		<input type="radio" name="meetmatchteam_gender" value="female">female
		
		<span>meetmatchteam_certified</span>
		<input type="text" name="meetmatchteam_certified" placeholder="0:not ,1:certified">
		
		<span>meetmatchteam_matchedflag</span>
		<input type="text" name="meetmatchteam_matchedflag" placeholder="meetmatchteam_matchedflag">

		<span>meetmatchteam_matchedpartner</span>
		<input type="text" name="meetmatchteam_matchedpartner" placeholder="meetmatchteam_matchedpartner">
		
		<span>meetmatchmanage_seq</span>
		<input type="text" name="meetmatchmanage_seq" placeholder="meetmatchmanage_seq">
	
		<span>meetmatchpersonnelmanage_personnel</span>
		<input type="text" name="meetmatchpersonnelmanage_personnel" placeholder="meetmatchpersonnelmanage_personnel">

		<span>meetmatchteammate_certifiedcount</span>
		<input type="text" name="meetmatchteammate_certifiedcount" placeholder="meetmatchteammate_certifiedcount">
		
		<input type="button" value="submit" onclick="go_submit()"/>
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
					<th>meetmatchteam_seq</th>
					<th>meetmatchmanage_seq</th>
					<th>meetmatchteam_gender</th>
					<th>meetmatchteam_certified</th>
					<th>meetmatchteam_matchedflag</th>
					<th>meetmatchteam_matchedpartner</th>
					<th>meetmatchteam_regdate</th>
					<th>meetmatchteam_certifieddate</th>
					<th>meetmatchmanage_seq</th>
					<th>meetmatchpersonnelmanage_personnel</th>
					<th>meetmatchteammate_certifiedcount</th>
				</tr>
			</thead>
			
			<c:forEach items="${meetmatchteamlist}" var="meetmatchteam">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${meetmatchteam.meetmatchteam_seq}"/></td>
					<td><c:out value="${meetmatchteam.meetmatchteam_seq}"/></td>
					<td><c:out value="${meetmatchteam.meetmatchmanage_seq}"/></td>
					<td><a href="/admin/meetmatch/meetmatchteam/get?meetmatchteam_seq=<c:out value="${meetmatchteam.meetmatchteam_seq}"/>"><c:out value="${meetmatchteam.meetmatchteam_gender}"/></a></td>
					<td><c:out value="${meetmatchteam.meetmatchteam_certified}"/></td>
					<td><c:out value="${meetmatchteam.meetmatchteam_matchedflag}"/></td>
					<td><c:out value="${meetmatchteam.meetmatchteam_matchedpartner}"/></td>
					<td><c:out value="${meetmatchteam.meetmatchteam_regdate}"/></td>
					<td><c:out value="${meetmatchteam.meetmatchteam_certifieddate}"/></td>
					<td><c:out value="${meetmatchteam.meetmatchmanage_seq}"/></td>
					<td><c:out value="${meetmatchteam.meetmatchpersonnelmanage_personnel}"/></td>
					<td><c:out value="${meetmatchteam.meetmatchteammate_certifiedcount}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>