<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html lang="ko">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>채팅</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <script type="text/javascript" src="../../resources/javascript/websocket/1.5.2.sockjs.min.js"></script>
    <script type="text/javascript" src="../../resources/javascript/websocket/2.3.3.stomp.min.js"></script>
    <script type="text/javascript" src="../../resources/javascript/websocket/app.js"></script>
    <script type="text/javascript" src="../../resources/javascript/chat/chat.js"defer></script>
    <link rel="stylesheet" type="text/css" href="../../resources/css/chat/chat.css">
</head>
<body>

<script type="text/javascript">

function chatform_leavechatroom(){
	document.chatform.action = "/socket/chat/leavechatroom";
	document.chatform.method = "post";
	document.chatform.submit();
}

function onEnterChat(){
	
	if(window.event.keyCode == 13){	//엔터키 이면
		if(document.querySelector('#message').value.length == 0) {
			document.querySelector('#message').value = '';
			return false;
		}
		echo();
		document.querySelector('#message').value = null;
	}
}

</script>
	
<!--채팅창-->
<section>
  <div class="chat"id="app_chat_list">
<!--채팅 상대 이름, 나가기 버튼-->
    <header id="chat_head">
      <span class="contactor">익명채팅방 (<c:out value="${chatroomvo.chatroom_personnel}"/>명)</span>
      <span class="sign_out"><button id="show"><i class="fas fa-sign-out-alt"></i></button></span>
    </header>
<!--chat내용-->
    <section>
      <div class="chat_content" >
        <ul class="chat_content_ul">
		   	<c:forEach items="${chatmessagevolist}" var="chatmessage">
		   	
		   		<sec:authorize access="isAuthenticated()">
	   			<sec:authentication property="principal.member.mem_seq" var="mem_seq"/>
	   			
	   			<c:choose>
		   			<c:when test = "${chatmessage.mem_seq eq mem_seq }">
		   			<li class="right">
	              		<span><img src="../../resources/img/profile.jpg"/></span>
	              		<span class="name">나</span>
	              		<div class="content"><span><c:out value="${chatmessage.chatmessage}"/></span><span><!-- 읽음 --></span><div class="time"><fmt:formatDate pattern="MM-dd hh:mm:ss" value="${chatmessage.chatregdate}"/></div></div>
	           		</li>	
		   			</c:when>
		   			<c:otherwise>
				   	<li class="left">
		              <span><img src="../../resources/img/profile.jpg"/></span>
		              <span class="name">익명</span>
		              <div class="content"><span><c:out value="${chatmessage.chatmessage}"/></span><span><!-- 읽음 --></span><div class="time"><fmt:formatDate pattern="MM-dd hh:mm:ss" value="${chatmessage.chatregdate}"/></div></div>
		            </li>	   					   			
		   			</c:otherwise>	   			
	   			</c:choose>	            
    		   	</sec:authorize>
		   	</c:forEach>
<!--입장-->
<!--           <li class="enter">
            <div><span class="contactor">이용자2</span>님이 입장하였습니다.</div>
          </li> -->
          
<!--             <li class="left">
              <span><img src="img/profile.jpg"/></span>
              <span class="name">이용자2</span>
              <div class="content"><span>안녕하세요</span><span>읽음</span><div class="time">12:00</div></div>
            </li> -->
            
<!--날짜 구분선-->
<!--             <li class="date">
              <div>2022.03.01</div>
            </li> -->
            
  <!--대화-->
<!--             <li class="right">
              <span><img src="img/profile.jpg"/></span>
              <span class="name">이용자1</span>
              <div class="content"><span>아</span><span>읽음</span><div class="time">13:00</div></div>
            </li> -->
<!--             <li class="right">
              <span><img src="img/profile.jpg"/></span>
              <span class="name">이용자1</span>
              <div class="content"><span>안녕하세요</span><span>읽음</span><div class="time">13:00</div></div>
            </li> -->
            
<!--입장-->
<!--             <li class="read_here">
              <div>여기까지 읽으셨습니다.</div>
            </li> -->
            
<!--             <li class="left">
              <span><img src="img/profile.jpg"/></span>
              <span class="name">이용자2</span>
              ipsumlorem
              <div class="content"><span>각급 선거관리위원회는 선거인.</span><span>안읽음</span><div class="time">14:00</div></div>
            </li> -->
            
<!--             <li class="left">
              <span><img src="img/profile.jpg"/></span>
              <span class="name">이용자2</span>
              ipsumlorem
              <div class="content"><span>각급 선거관리위원회는 선거인명부의 작성등 구할 권리를 가진다. 국가는 개인이 가지는 불가침의 기본적 인권을 확인하고 이를 보장할 의무를 진다.</span><span>안읽음</span><div class="time">14:00</div></div>
            </li> -->
            
        </ul>
    </div>
<!--입력-->
    <section>
      <div class="input">
        <textarea id="message" placeholder="메세지를 입력하세요" onkeyup="onEnterChat()"></textarea>
        <button onclick="if(document.querySelector('#message').value == '') return false; echo(); document.querySelector('#message').value = null;  "><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
      </div>
    </section>
    </section>
<!--나가기 팝업-->
    <section>
    <form name="chatform" method="post">
      <div class="background">
        <div class="window">
          <div class="popup">
            <div>채팅창을 정말 나가시겠습니까?(채팅방에서 나갈시 채팅방목록에서 사라집니다.나가신 후 새로고침하시기 바랍니다.)</div>
            <button onclick="chatform_leavechatroom()" type="button">예</button>
            <button id="close" type="button">아니오</button>
          </div>
          <div>
            <div></div>
          </div>
        </div>
      </div>
	<input type='hidden' name="chatroom_seq" value="${chatroomvo.chatroom_seq}"/>
	<input type='hidden' name="mem_seq" value="<sec:authentication property="principal.member.mem_seq"/>"/>
    </form>
  </section>

    </div>

</section>
<!---->
	
	
	
	<%-- <input type='hidden' name="chatroom_seq" value="${chatroomvo.chatroom_seq}"/>
	<input type='hidden' name="mem_seq"value="<sec:authentication property="principal.member.mem_seq"/>"/> --%>
	
<%--     <div id="connect-container" class="ui centered grid">
        <div class="row">
            <button id="connect" onclick="connect();" class="ui green button">Connect</button>
            <button id="disconnect" disabled="disabled" onclick="disconnect();" class="ui red button">Disconnect</button>
        </div>
        <div class="row">
            <textArea id="message" style="width: 350px" class="ui input" placeholder="Message to Echo"></textArea>
        </div>
        <div class="row">
            <button id="echo" onclick="echo();" disabled="disabled" class="ui button">Echo message</button>
        </div>
        <div id="console-container">
            <h3>Logging</h3>
            <div id="logging">
            
            	<c:forEach items="${chatmessagevolist}" var="list">
            		<p>chatmessage:<c:out value="${list.chatmessage}"/> chatregdate:<fmt:formatDate pattern="MM-dd mm:ss" value="${list.chatregdate}"/></p>
            	</c:forEach>
            	<p>
            	</p>
            </div>
        </div>
    </div> --%>
    
    <script type="text/javascript">
	window.addEventListener('DOMContentLoaded',()=>{
      var objDiv = document.getElementById("app_chat_list");
       objDiv.scrollTop = objDiv.scrollHeight;
    });
    </script>
</body>
</html>