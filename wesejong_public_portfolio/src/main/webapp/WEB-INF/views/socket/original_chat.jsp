<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.10/semantic.min.css" />
    <!-- <script type="text/javascript" src="webstomp.js"></script> -->
   <!-- <script type="text/javascript" src="../../resources/js/websocket/stomp.js"></script> -->
   <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.0/sockjs.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script type="text/javascript" src="../../resources/javascript/websocket/app.js"></script>
</head>
<body>

	<input type='hidden' id='chatroom_seq' value="${chatroomvo.chatroom_seq}"/>
	

    <div id="connect-container" class="ui centered grid">
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
    </div>
</body>
</html>