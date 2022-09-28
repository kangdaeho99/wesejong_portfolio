<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
<%@include file="../../include/nav.jsp" %>

<link rel="stylesheet" type="text/css" href="../../../../resources/css/member/info/info_list.css">

<script src="../../../../resources/javascript/member/info/info_alarm_list.js"defer></script>

<title>알림</title>
  <style>
    .link_box .chat,
    .link_box .my_post {
      background-color: white;
      color: #c3200e;
      border: 1px solid #c3200e;
    }

    .link_box>.alarm {
      background-color: #c3200e;
      color: white;
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
            <div class="info_alarm_list">
            
            <!-- 미팅매칭성공, 실패 알림 '4' -->
            
            <!-- 미팅매칭신청과 승인,취소 알림 '3' -->
            
            <!-- 회원가입관련 알림 '0' -->
              <table>
              	<c:forEach items="${list}" var="alarm">  


              		<c:choose>

		     			<c:when test="${alarm.alarm_type eq '0'}">
	                      <tr>
                  		      <td><span style="color:#c3200e"><c:out value="${alarm.alarm_title}"/></span><a href="/board/list?board_id=103" class="alarm_list_cmt"><i class="fas fa-arrow-right"></i> "<c:out value="${alarm.alarm_content}"/>" </a></td>
		                      <td><fmt:formatDate pattern="YYYY-MM-dd HH:mm:ss" value="${alarm.alarm_regdate}"/></td>
	                      </tr>
              			</c:when>
              		
              			<c:when test="${alarm.alarm_type eq '3'}">
	                      <tr>
		                      <td><span><c:out value="${alarm.alarm_title}"/></span><a href="/meetmatch/event/applicationhistory" class="alarm_list_cmt"><i class="fas fa-arrow-right"></i> "<c:out value="${alarm.alarm_content}"/>" </a></td>
		                      <td><fmt:formatDate pattern="YYYY-MM-dd HH:mm:ss" value="${alarm.alarm_regdate}"/></td>
	                      </tr>                    			
              			</c:when>
              			
              			<c:when test="${alarm.alarm_type eq '4'}">
	                      <tr>
		                      <td><span><c:out value="${alarm.alarm_title}"/></span><a href="/member/info/chatroomlist" class="alarm_list_cmt"><i class="fas fa-arrow-right"></i> "<c:out value="${alarm.alarm_content}"/>" </a></td>
		                      <td><fmt:formatDate pattern="YYYY-MM-dd HH:mm:ss" value="${alarm.alarm_regdate}"/></td>
	                      </tr>                    			
              			</c:when>
              			

              			
              			<c:otherwise>
              				<tr>
		                      <td><span><%-- <c:out value="${alarm.alarm_title}"/> --%></span><a href="#" class="alarm_list_cmt"><i class="fas fa-arrow-right"></i> "<c:out value="${alarm.alarm_content}"/>" </a></td>
		                      <td><fmt:formatDate pattern="YYYY-MM-dd HH:mm:ss" value="${alarm.alarm_regdate}"/></td>              					
              				</tr>
              			</c:otherwise>
              			
              		</c:choose>
              	
              	
 	
              	</c:forEach>
              </table>
            </div>
          </section>



          </div>
        </section>
    </div>
</main>




<%@include file="../../include/footer.jsp" %>