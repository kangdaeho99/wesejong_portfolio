<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="../include/httptohttps.jsp" %>
  <title>로그인 페이지</title>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="../../../../resources/css/member/join.css">
  <link rel="stylesheet" href="../../../../resources/css/member/login.css">
  <script src="../../../resources/javascript/member/login.js"defer></script>
  
</head>
<body>
  <div class="bck">
  <div class="container">
    <header>
      <h1><a href="/">위세종<span>wesju</span></a></h1>
    </header>
    <section id="login_field">
	
	
	<form role="form" name="loginform">
      <!--로그인 정보 입력-->
      <article>
        <div class="private_area">
          <input id="userid" name="mem_userid" type="text" placeholder="아이디 입력" required/>
          <input id="password" name="mem_password" type="password" placeholder="비밀번호 입력"/>
          <input type="submit" style="color:white" value="로그인" class="submit_login_form" onclick="empty_value_test_login(); submit_loginform();" />
		  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </div>
      <!--로그인 정보 분실 또는 신규회원 가입-->
        <div class="help_login">
          <a href="#" onclick="open_find_idpw()" class="find_id_link">아이디 찾기</a>
          <span>|</span>
          <a href="#" onclick="open_find_idpw()" class="find_pw_link">비밀번호 찾기</a>
          <a href="/member/join" class="signup_link">회원가입</a>
        </div>
      </article>
	</form>
	
    <!--분리선-->
    <div class="line"></div>
    <!--로그인 하단의 이미지 링크들-->
    <article>
      <div class="commercial">
        <a href="/meetmatch/event/explanation"><img src="../../resources/img/event_banner.gif"></a>
      </div>
      <!--이벤트 홍보 링크 버튼,아이콘 활용한 버튼 또는 간단한 이미지 사용-->
      <div class="promotion">
        <div class="pmt">
          <img src="../../resources/img/대양ai센터.jpg">
          <div class="content">
            <a href="http://www.sejong.ac.kr/">
              <h1>세종대<br />포탈 열기</h1>
            </a>
          </div>
        </div>
        <div class="pmt">
          <img src="../../resources/img/애지헌.jpg">
          <div class="content">
            <a href="http://www.sejong.ac.kr/">
              <h1>세종대 홈페이지</h1>
            </a>
          </div>
        </div>
      </div>
    </article>

	
	
    <div class="prod">copyright © all rights reserved</div>
    </section>
    </div>
  </div>
</body>
</html>