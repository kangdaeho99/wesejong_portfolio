<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
<%@include file="../../include/nav.jsp" %>

<link rel="stylesheet" type="text/css" href="../../../../resources/css/member/info/info_list.css">

<script src="../../../../resources/javascript/member/info/info_mypost_list.js"defer></script>

<title>채팅목록</title>

<style>
.link_box>.alarm ,.link_box>.my_post{
  background-color: white;color:#c3200e;border: 1px solid #c3200e;
}
.link_box>.chat{
  background-color:#c3200e; color:white;
}
</style>
    
   

<main>
    <div class="container" class="parallax_base_layer">
        <section id="cont_alarm">
          <div class="info_list">
            <!--링크-->
            <div class="link_box">
              <div class="alarm" onclick="location.href='/member/info/alarm';">알림</div>
              <div class="chat" onclick="location.href='/member/info/chatroomlist';">채팅</div>
              <div class="my_post" onclick="location.href='/member/info/mypost';">내가쓴글</div>
            </div>
            <!--내가쓴글 목록-->
            <section>
            <div class="info_chat_list">
              <table>

              	<c:forEach items="${list}" var="chatroom" varStatus="status">  	
                      <tr onclick="window.open('/socket/chatcheck?chatroom_uuid=<c:out value='${chatroom.chatroom_uuid}'/>','_blank','width=580,  height=800, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">
                        <td><img src="../../../../resources/img/profile.jpg"/><%-- ${status.count} --%>익명</td>
                        <td>
                        	<div class="contactor">
                        		<c:out value="${chatroom.chatroom_uuid}"/> 익명님과의 채팅방입니다  <br/>(채팅방 소속인원 : <c:out value="${chatroom.chatroom_personnel}"/>명 )
                        	</div>
                        	<a href="/socket/chatcheck?chatroom_uuid=<c:out value='${chatroom.chatroom_uuid}'/>" class="last_mention">
                        		<i class="fa fa-comment-o" aria-hidden="true">&nbsp</i>
                        		채팅방의 대화는 30개까지 저장됩니다.
                        	</a>
                        </td>
                      </tr>
                      
              	</c:forEach>
              	
              </table>
            </div>
          </section>



          </div>
        </section>
    </div>
</main>




<%@include file="../../include/footer.jsp" %>