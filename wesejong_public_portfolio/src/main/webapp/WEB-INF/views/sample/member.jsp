<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>sample/member page</h1>
<%-- <p>principal : <sec:authentication property="principal"/></p>
<p>MemberVO : <sec:authentication property="principal.member"/></p>
<p>Member Name : <sec:authentication property="principal.member.mem_nickname"/></p>
<p>Member UserID : <sec:authentication property="principal.member.mem_userid"/></p>
<p>Member AuthList : <sec:authentication property="principal.member.mem_authorityList"/></p> --%>

<a href="/customLogout">Logout</a>
</body>
</html>