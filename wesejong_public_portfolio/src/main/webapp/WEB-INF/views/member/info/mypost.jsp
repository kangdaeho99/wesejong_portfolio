<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/header.jsp" %>
<%@include file="../../include/nav.jsp" %>

<link rel="stylesheet" type="text/css" href="../../../../resources/css/member/info/info_list.css">

<script src="../../../../resources/javascript/member/info/info_mypost_list.js"defer></script>

<title>내가쓴글</title>

<style>
  .link_box>.chat,.link_box>.alarm{
    background-color: white;color:#c3200e;border: 1px solid #c3200e;
  }
  .link_box>.my_post{
    background-color:#c3200e; color:white;
  }
</style>
    
    
<title>mypage</title>

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
            <div class="info_post_list">
              <table>
              
              	<c:forEach items="${list}" var="board">
	                <tr>
	                  <td><a href="/board/get?bno=<c:out value="${board.bno}"/>">글제목 : <c:out value="${board.title}"/> </a></td>
	                  <td><fmt:formatDate pattern="YYYY-MM-dd mm:ss" value="${board.regdate}"/></td>
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