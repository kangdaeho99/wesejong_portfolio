<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
<%@include file="../include/httptohttps.jsp" %>
<meta charset="UTF-8">
<title>탈퇴하기</title>    
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!-- <link rel="stylesheet" type="text/css" href="../../../resources/css/member/info.css"> -->
<!-- info.js에서 함꼐 처리합니다.-->
<script src="../../../resources/javascript/member/info.js"defer></script>

<style>
#secession header a{
  text-decoration: none;color:black;font-family: 돋움;opacity: 0.7;
}
#secession header h1{
  font-size: 50px;text-align: center;
}
#secession{
  width:500px;margin:10px;font-size:12px;
}
.secession {
border:1px solid #c3200e;z-index: 2;background-color: white;padding:20px;
}
.secession h1{font-weight: lighter;}
#pw{
    width:410px;padding:10px;border: 1px solid #888888;outline: none;margin:10px;
}
/*탈퇴하기 버튼*/
.secession button{
  width:450px;background-color: #c3200e; color:white;padding:10px;border: none;
}
@media (max-width:768px)and (min-width:320px){
  #secession{width:95%;}
  .secession {padding:5%;}
  #pw{width:90%;margin:10px auto;}
  .secession button{width:95%;}
}
  </style>

</head>

<body>
	<form role="form" name="secessionform">
	    <section id="secession">
	      <header>
	        <h1><a href="/index">위세종<span>wesju</span></a></h1>
	      </header>
	      <div class="secession">
	          <h1>탈퇴하기</h1>
	          <label for="cb">채팅, 알림 내역이 모두 사라지며 글 쓴 내용에 대한 권한이 없어지는 것을 인지하고 있고 이에 동의합니다. 또한, 재가입 시 동일 아이디는 사용하실 수 없습니다.</label><input type="checkbox" id="scb">
	          <input id="pw" name="mem_password"  onkeyup="secession_mem_password_check();" type="password" placeholder="비밀번호 입력"/>
	          <button onclick="secessionform_submit();" type="button">탈퇴하기</button>
	        </div>
	      </section>
	</form>
</body>
</html>
