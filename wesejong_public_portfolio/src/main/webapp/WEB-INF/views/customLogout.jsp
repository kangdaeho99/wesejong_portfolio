<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>Logout Page</h1>
<form action="/customLogout" method='post'>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<button>logout</button>
</form>
</body>
</html>