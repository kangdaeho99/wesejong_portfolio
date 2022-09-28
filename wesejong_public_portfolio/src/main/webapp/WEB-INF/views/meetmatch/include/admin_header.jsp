<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="google-site-verification" content="HN0_walUn_Josv0qILqUT9CLG0nYKdEM8w7LGdH4hBg" />
	<meta name="naver-site-verification" content="4b7bec86d93056778fd4e05e960d7e4d7db346c7" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Insert title here</title>

</head>
<body>
<h1>admin/admin page</h1>

<ol>
	<li>회원관리메뉴test</li>
	<ul>
		<li><a href="/admin/member/memberList">회원명단메뉴</a></li>
	</ul>
	
	<li>테이블 관리 메뉴</li>
	<ul>
		<li><a href="/admin/boardmanage/list">boardmanage 게시판관리테이블 목록조회</a></li>	
		<li><a href="/admin/tablemanage/list">전체테이블목록</a></li>
	</ul>
	<li>이벤트 관리 메뉴</li>
	<ul>
		<li><a href="/admin/meetmatch/meetmatchmanage/list">meetmatchmanage 이벤트관리테이블 목록조회</a></li>	
		<li><a href="/admin/meetmatch/meetmatchpersonnelmanage/list">meetmatchpersonnelmanage 테이블목록조회</a></li>
		<li><a href="/admin/meetmatch/meetmatchprofile/list">meetmatchprofile 테이블목록조회</a></li>
		<li><a href="/admin/meetmatch/meetmatchteam/list">meetmatchteam 테이블목록조회</a></li>
		<li><a href="/admin/meetmatch/meetmatchteammate/list">meetmatchteammate 테이블목록조회</a></li>
	</ul>
	
	<li>미팅매칭이벤트 사용자사용</li>
	<ol>
		<li><a href="/admin/meetmatch/meetmatchmanage/list">explanation.jsp : 미팅매칭프로그램에 지원하는 방법을 설명한 설명서입니다.</a></li>
		<li><a href="/admin/meetmatch/meetmatchmanage/list">profile.jsp : 본인의 성별, 학과를 기입하는 화면입니다. 한번 입력하면 수정불가합니다.</a></li>
		<li><a href="/admin/meetmatch/meetmatchmanage/list">apply.jsp : 팀장이 팀의 성별, 몇대몇 미팅, 미팅참여팀원들의 mem_userid 입력을 작성하는 화면입니다.</a></li>
		<li><a href="/admin/meetmatch/meetmatchmanage/list">applyresult.jsp : apply.jsp에서 신청을 완료한뒤, 성공/실패 여부를 알려줍니다.(신청이 완료되었습니다/실패되었습니다.)</a></li>
		<li><a href="/admin/meetmatch/meetmatchmanage/list">teammateconfirmdetails.jsp : 현재 진행현황을 보여줍니다. 예를들면,</a></li>
		<li><a href="/admin/meetmatch/meetmatchmanage/list">applicationdetailshistory.jsp</a></li>
		<li><a href="/admin/meetmatch/meetmatchmanage/list">alarm_invitation.jsp (이것은 알람부분에 구현합니다.)</a></li>
		<li><a href="/admin/meetmatch/meetmatchmanage/list">explanation.jsp</a></li>
		<li>profile.jsp</li>
		<li>apply.jsp</li>
		<li>applyresult.jsp</li>
		<li>explanation.jsp</li>
		
	</ol>
</ol>
<!-- <a href="/customLogout">Logout</a> -->
<form action="/customLogout" method='post'>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<button>logout</button>
</form>
