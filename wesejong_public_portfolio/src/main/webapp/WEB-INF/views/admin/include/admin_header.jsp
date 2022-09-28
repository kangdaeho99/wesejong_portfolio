<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="google-site-verification" content="HN0_walUn_Josv0qILqUT9CLG0nYKdEM8w7LGdH4hBg" />
	<meta name="naver-site-verification" content="4b7bec86d93056778fd4e05e960d7e4d7db346c7" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

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
		<li><a href="/admin/board/list">board 게시판공지관리테이블 목록조회</a></li>	
		<li><a href="/admin/tablemanage/list">전체테이블목록</a></li>
	</ul>
	<li>사용자 관리 메뉴</li>
	<ul>
		<li><a href="/admin/alarm/list">alarm 목록조회</a></li>	
		<li><a href="/admin/chat/chatroom/list">chatroom 목록조회</a></li>	
		<li><a href="/admin/chat/chatroomjoin/list">chatroomjoin 목록조회</a></li>	
	</ul>
	
	<li>이벤트 관리 메뉴</li>
	<ul>
		<li><a href="/admin/meetmatch/meetmatchmanage/list">meetmatchmanage 이벤트관리테이블 목록조회</a></li>	
		<li><a href="/admin/meetmatch/meetmatchpersonnelmanage/list">meetmatchpersonnelmanage 테이블목록조회</a></li>
		<li><a href="/admin/meetmatch/meetmatchdepartment/list">meetmatchdepartment 테이블목록조회</a></li>
		<li><a href="/admin/meetmatch/meetmatchprofile/list">meetmatchprofile 테이블목록조회</a></li>
		<li><a href="/admin/meetmatch/meetmatchteam/list">meetmatchteam 테이블목록조회</a></li>
		<li><a href="/admin/meetmatch/meetmatchteammate/list">meetmatchteammate 테이블목록조회</a></li>
		
		<li><a href="/admin/meetmatch/meetmatchmanage/executerandomprogram">meetmatchmanage 이벤트랜덤미팅프로그램실행</a></li>
	</ul>
</ol>
<!-- <a href="/customLogout">Logout</a> -->
<form action="/customLogout" method='post'>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<button>logout</button>
</form>
