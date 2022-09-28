<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
<%@include file="../include/httptohttps.jsp" %>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>분실</title>
    <link rel="stylesheet" type="text/css" href="../../../resources/css/member/forgot.css">
    <!-- <script src="../../../resources/javascript/member/join.js"defer></script> -->
    <script src="../../../resources/javascript/member/forgot.js"defer></script>
</head>
<body>


    <section id="forgot">
      <header>
        <h1><a href="http://sjucomme.cafe24.com/index">위세종<span>wesju</span></a></h1>
      </header>
      <div class="select_lost">
        <ul>
          <li onclick="select_id()" class="select_id_btn">아이디 찾기</li>
          <li onclick="select_pw()" class="select_pw_btn">비밀번호 찾기</li>
        </ul>
      </div>
      <div class="forgot">
		
<!--아이디 찾기-->
          <div class="find_id">
            <h1>아이디 찾기</h1>
            <p>회원가입 시 입력한 이메일을 통해 아이디를 확인할 수 있습니다.</p>
            <input type="text" id="find_id_mem_email" placeholder="@sju.ac.kr"/>
            <button onclick="forgot_mem_userid_emailcerti();" type="button">아이디 찾기</button>
          </div>
          
<!--비밀번호 찾기-->
		<form role="form" name="forgot_pw_form">
          <div class="find_pw">
            <h1>비밀번호 찾기</h1>
            <p>회원가입 시 입력한 이메일 인증을 통해 새 비밀번호를 설정할 수 있습니다.</p>
            <input type="text"id="find_pw_mem_email" name="mem_email" onkeyup="find_pw_mem_email_onkeyup_check();" placeholder="@sju.ac.kr"/>
            <button onclick="forgot_pw_emailcerti()" type="button">인증번호 보내기</button>
            <p id="timer"></p>
            <input id="cor_mem_email" type="text" placeholder="인증번호 입력"/>
            <button class="email_cert_btn" type="button" onclick="forgot_pw_check_certificationnumber_validation()" >확인하기</button>
<!--인증번호 맞을 시에 display:block-->
            <div class="pw_input">
              <label for="mem_password"class="join_title">새 비밀번호</label>
              <input id="mem_password" name="mem_password" type="password" placeholder="비밀번호 입력"onkeyup="check_pw()"/>
              <p id="pw_txt"></p>
              <label for="cor_mem_password"class="join_title">새 비밀번호 확인</label>
              <input id="cor_mem_password" type="password" placeholder="비밀번호 재입력" onkeyup="check_cor_pw()" required/>
              
              <button onclick="forgot_pw_form_submit()" type="button">비밀번호 변경하기</button>
              <p id="cor_pw_txt"></p>
              <!--비밀번호 조건 js-->
              <!--https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=dme1004&logNo=220958840520-->
            </div>
          </div>
        </form>
        
        </div>
      </section>
      

      <script>

      function timer(){//인증 시간 제한
        document.getElementById("timer").style.display="block";
        var time=300;
        var min='';
        var sec='';  var x;
        clearInterval(x);
        x=setInterval(function(){
          min=parseInt(time/60);
          sec=time%60;
          document.getElementById("timer").innerHTML=min+"분"+sec+"초";
          time--;

          if(time==-1){//제힌시간 초과 시 경고 뜨고 시간 카운트 다운 p 사라짐
            alert('인증시간을 초과하였습니다.\n다시 인증해주세요.')
            document.getElementById("timer").style.display="none";
            clearInterval(x);
          }

        },1000);
          document.getElementById("timer").innerHTML="";
          return;
      }
      </script>

</body>
</html>