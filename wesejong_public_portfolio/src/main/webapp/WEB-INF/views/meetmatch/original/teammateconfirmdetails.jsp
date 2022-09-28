<%@ include file="../../admin/include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초대승인현황</title>
<script type="text/javascript">
/* 검색어:javascript button onclick document.location.href */
function gotoapply_button(){
	document.location.href="/meetmatch/event/profile";
}
</script>
</head>
<body>
<h1>teammateconfirmdetails.jsp입니다.</h1>
<p>

팀원들이 현재 팀에 초대된 member들의 현황을 알 수 있습니다.

<table border="1">
	<thead>
		<tr>
			<th><input type="checkbox"/></th>
			<th>번호</th>
			<th>초대자</th>
			<th>초대일시</th>
			<th>승인여부</th>
		</tr>
	</thead>
	
	<c:forEach items="${meetmatchteammate}" var="meetmatchteammate">
		<tr>
			<td><input type="checkbox" name="chkbox" value="${meetmatchteammate.meetmatchteammate_seq}"/></td>
			<td><c:out value="${meetmatchteammate.meetmatchteammate_seq}"/></td>
			<td><c:out value="${meetmatchteammate.meetmatchteammate_teamleaderflag}"/></td>
			<td><c:out value="${meetmatchteammate.meetmatchteammate_regdate}"/></td>
			<td><c:out value="${meetmatchteammate.meetmatchteammate_certified}"/></td>
		</tr>
	</c:forEach>
</table>

<br/>
<button type="button" onclick="gotoapply_button()">go to apply</button>

</p>
	
</body>
</html>