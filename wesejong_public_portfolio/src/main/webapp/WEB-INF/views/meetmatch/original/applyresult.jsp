<%@ include file="../../admin/include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청결과페이지</title>
<script type="text/javascript">
/* 검색어:javascript button onclick document.location.href */
function gotoapply_button(){
	document.location.href="/meetmatch/event/profile";
}
</script>
</head>
<body>
<h1>applyresult.jsp입니다.</h1>
<p>

성공적으로 지원이 완료되었습니다.

<a href="/meetmatch/event/applicationdetailshistory">지원내역 확인하기</a>
<a href="/index">메인페이지</a>

<br/>
<button type="button" onclick="gotoapply_button()">go to apply</button>

</p>
	
</body>
</html>