<%@ include file="../../admin/include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청지원내역</title>
<script type="text/javascript">
/* 검색어:javascript button onclick document.location.href */
function gotoapply_button(){
	document.location.href="/meetmatch/event/profile";
}
</script>
</head>
<body>
<h1>applicationdetailshistoryy.jsp입니다.</h1>
<p>
- applicationdetailshistory.jsp : 본인이 참가했던 내역들의 정보(매칭결과 포함)를 보여주는 화면입니다. 
</p>

<table border="1">
	<thead>
		<tr>
			<th><input type="checkbox"/></th>
			<th>번호</th>
			<th>이벤트명</th>
			<th>지원기간</th>
			<th>초대승인현황</th>
			<th>매칭여부</th>
			
		</tr>
	</thead>
	
	<c:forEach items="${meetmatchmanage}" var="meetmatchmanage">
		<tr>
			<td><input type="checkbox" name="chkbox" value="${meetmatchmanage.meetmatchmanage_seq}"/></td>
			<td><c:out value="${meetmatchmanage.meetmatchmanage_seq}"/></td>
			<td><c:out value="${meetmatchmanage.meetmatchmanage_eventtitle}"/></td>
			<td><c:out value="${meetmatchmanage.meetmatchmanage_eventstartdate}"/> ~ <c:out value="${meetmatchmanage.meetmatchmanage_eventenddate}"/>(<c:out value="${meetmatchmanage.meetmatchmanage_eventreleasedate}"/></td>
			<c:forEach items="${meetmatchteam}" var="meetmatchteam">
				<c:if test="${meetmatchmanage.meetmatchmanage_seq eq meetmatchteam.meetmatchmanage_seq}">
					<td><a href="/meetmatch/event/teammateconfirmdetails?meetmatchteam_seq=<c:out value="${meetmatchmanage.meetmatchmanage_seq}"/>"><c:out value="${meetmatchteam.meetmatchteammate_certifiedcount}"/>/<c:out value="${meetmatchteam.meetmatchpersonnelmanage_personnel}"/></a></td>		
				</c:if>
			</c:forEach>
		</tr>
	</c:forEach>
</table>


<br/>
<button type="button" onclick="gotoapply_button()">go to apply</button>

	
</body>
</html>