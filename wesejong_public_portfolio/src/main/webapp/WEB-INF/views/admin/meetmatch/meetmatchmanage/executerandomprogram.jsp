<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchmanage 테이블 데이터의 목록을 보여줍니다.</title>
<script type="text/javascript">
function go_executerandomprogram(){
	document.form.action = "/admin/meetmatch/meetmatchmanage/executerandomprogram";
	document.form.method = 'post';
	document.form.submit();
}

function go_matchingprogram(){
	document.form.action = "/admin/meetmatch/meetmatchmanage/matchingprogram";
	document.form.method = 'post';
	document.form.submit();
}

function go_matchingfailalarm(){
	document.form.action = "/admin/meetmatch/meetmatchmanage/matchingfailalarm";
	document.form.method = 'post';
	document.form.submit();
}

function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchmanage/removebychkbox";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>executerandomprogram 실행</h1>
	<p>
	<br/>
	
		주의사항 : insertSelectKey에서 max(chatroom_seq)이런식으로 진행하기 떄문에 값을 한번 넣어야합니다. 

	</p>
	
	
	<form name="form">		
		<span>meetmatchmanage_seq</span>
		<input type="text" name="meetmatchmanage_seq" placeholder="실제존재하는값">
		랜덤프로그램은 matchedflag만 바꿔줍니다.
		<br/>
		<button type="submit" value="submit" onclick="go_executerandomprogram()" style="color:red;">1.매칭될 것들을 먼저 골라주는 executerandomprogram 실행</button>
		<br/>
		<button type="submit" value="submit" onclick="go_matchingprogram()" style="color:blue;">2.매칭될것들중에서 실제로 매칭을 해주는 랜덤매칭프로그램실행</button>
		<br/>
		<button type="submit" value="submit" onclick="go_matchingfailalarm()" style="color:black;">3.매칭이 안된 team들에게 alarm으로 실패여부알람발송</button>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>