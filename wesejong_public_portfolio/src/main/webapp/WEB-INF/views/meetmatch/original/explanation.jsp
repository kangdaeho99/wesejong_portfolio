<%@ include file="../../admin/include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatch 이벤트에 관한 설명 페이지입니다.</title>
<script type="text/javascript">
/* 검색어:javascript button onclick document.location.href */
function gotoapply_button(){
	document.location.href="/meetmatch/event/profile?meetmatchmanage_seq=1";
}
</script>
</head>
<body>
<h1><%-- <c:out value="${meetmatchmanage.meetmatchmanage_eventid}"/> --%>
<c:out value="${meetmatchmanage.meetmatchmanage_eventid}"/> 번쨰 meetmatch 이벤트에 관한 설명 페이지입니다.</h1>
<p>

(1)미팅매칭참여 이벤트 진행방식 안내
<br/>
-지원일:<fmt:formatDate pattern="yyyy-MM-dd (E) HH:mm" value="${meetmatchmanage.meetmatchmanage_eventstartdate}"/>
 ~ 
 <fmt:formatDate pattern="yyyy-MM-dd (E) HH:mm" value="${meetmatchmanage.meetmatchmanage_eventenddate}"/> 일주일간
<br/>
-발표일시:<fmt:formatDate pattern="yyyy-MM-dd (E) HH:mm" value="${meetmatchmanage.meetmatchmanage_eventreleasedate}"/> 일주일간
<br/>
<button type="button" onclick="gotoapply_button()">go to apply</button>

</p>
	
</body>
</html>