<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" type="text/css" href="../../../../resources/css/index/home.css">
<link rel="stylesheet" type="text/css" href="../../../../resources/css/board/board_list.css">
<link rel="stylesheet" type="text/css" href="../../../../resources/css/index/link.css">
<link rel="stylesheet" type="text/css" href="../../../../resources/css/chat/chatList.css">
<link rel="stylesheet" type="text/css" href="../../../../resources/css/board/post.css">
 
 <script src="../../../../resources/javascript/chat/chat.js"defer></script>
 <script src="../../../../resources/javascript/member/join.js"defer></script>
 <script src="../../../../resources/javascript/index/link.js"defer></script>
 <script src="../../../../resources/javascript/board/post.js"defer></script>
 
<script type="text/javascript">
function replyform_register(){
	document.replyform.action = "/board/reply/register";
	document.replyform.method = "post";
	document.querySelector("input[name=parent]").value = 0;
	document.querySelector(".rereply_textarea").remove();
	document.replyform.submit();
	alert("hello");
}

function rereplyform_register(button){
	document.replyform.action = "/board/reply/reregister";
	document.replyform.method = "post";
	document.querySelector("input[name=parent]").value = button.value;
	document.querySelector(".reply_textarea").remove();
	document.replyform.submit();
}
</script>
 
    <main>
        <section id="contents">
            <div class="container">
              <div class="wrapper">
<!--제목 및 본문 정보-->
              <section id="post_header">
                  <ul class="post_category">
                    <li><a href="board.html">자유게시판</a></li>
                    <li></li>
                    <li><a href="#">#&nbsp<span class="board_categoty">공지</span></a></li>
                    <li class="edit_post">
                      <!--post_category 오른쪽 상단 ellipsis-v 클릭-->
                      <div class="a_o_category">
                        <a href="#" class="com1"><span>수정</span></a>
                        <span>|</span>
                        <a href="#" class="com2"><span>삭제</span></a>
                      </div>
                    </li>
                  </ul>
<br/>
                  <div class="post_title"><h1><a href="#">세종 글로벌 버디, 17기 신입버디 모집세종 글로벌 버디, 17기 신입버디 모집</a></h1></div>
                  <div>

                  <ul class="post_detail">
                    <li class="chat_writer"><a onclick="open_chat()" href="#" ><i class="fa fa-user" aria-hidden="true"></i>&nbsp<span class="user_name">관리자</span></a><!--글쓴이 클릭 시, 채팅하기 기능-->
                    </li>
                    <li><a href="#"><i class="fas fa-eye"></i></a>&nbsp<span class="views_">35</span></li>
                    <li><a href="#"><i class="fa fa-commenting-o" aria-hidden="true"></i></a>&nbsp<span class="comment_num_">25</span></li>
                    <li><a href="#"><i class="fa fa-clock-o" aria-hidden="true"></i></a>&nbsp<span class="writing_time_">2015.03.22 15:30</span></li>
                  </ul>
<!--url복사-->
                  <span class="copy_url"><input type="text" id = "text_url"><button OnClick="copy_url_to_clipboard()"><i class="fa fa-clone" aria-hidden="true" style="font-size:20px;"></i></button></span>
                  <!--출처: https://doolyit.tistory.com/111 [동해둘리의 IT Study]-->
                </section>
<hr/>
<!--본문-->
                <section>
                <article id="post_content">
                    <pre><c:out value="${board.content}" escapeXml='false'/></pre>
                  <div class="evaluate_post">
                      <div class="like_it">
                        <button onclick="thumbs_up();"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i>&nbsp<span class="like_it_num">3053</span></button>
                        </div>
                        <div class="hate_it">
                          <button onclick="thumbs_down()"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i>&nbsp<span class="hate_it_num">10</span></button>
                          </div>
                    </div>
                    <span class="edit_post right_ver">
                      <!--post_category 오른쪽 상단 ellipsis-v 클릭-->
                      <div class="a_o_category">
                        <a href="#" class="com1"><span>수정</span></a>
                        <span>|</span>
                        <a href="#" class="com2"><span>삭제</span></a>
                      </div>
                    </span>
                  </article>
                </section>
<hr/>
<!--댓글-->
                <section id="post_comments">
                  <div>
                    <h1>댓글</h1>
<!--댓글쓰기-->
				<form name="replyform">
	                <div class="write_comment">
	                  <input type="text" value="댓글을 작성해주세요. 비방이나 욕설은 삭제될 수 있습니다." class="hide_comment" onclick="show_comment_box()"/>
	                  <textarea class="reply_textarea" name="reply" rows="8" cols="80"></textarea>
	                  <button onclick="replyform_register();"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
	                </div>
	                
	                <input type="hidden" name="bno" value="${board.bno}"/>
	                <input type="hidden" name="board_id" value="${board.board_id}"/>
	                <input type="hidden" name="replyer" value="writer"/>
	                <input type="hidden" name="anonymous" value="0"/>
	                <input type="hidden" name="parent" value="0"/>
	                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                
                
                
<!--댓글목록-->      <article>
<!--베댓은 댓글 목록 상단 노출(ex유튜브 댓글)-->
						<c:forEach items="${boardreply}" var="boardreply" varStatus="status">
						<c:if test="${boardreply.parent eq 0 }">
<!--예시댓글1-->        <div class="comment">
                          <span><img src="http://placehold.it/50x50"/></span>
                          <span class="writer_name"><a href="#"><c:out value="${boardreply.replyer}"/></a></span>
                          <span>
<!--댓글 ellipsis-v-->
                            <div class="a_o_comment">
                              <a href="#" class="com1"><span><i class="fas fa-eraser"></i></span></a>
                              <span>|</span>
                              <a href="#" class="com2"><span><i class="far fa-trash-alt"></i></span></a>
                            </div>
                          </span>
                          <span class="writing_time"><c:out value=""/><fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss" value="${boardreply.regDate}"/></span>
                 <table class="comment_per">
                            <tr>
                              <td><button class="like"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i><span class="good">33</span></button></td>
                              <td><button class="dislike"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i><span class="bad">10</span></button></td>
                              <td><button onclick="show_reply()"><i class="fa fa-comments-o" aria-hidden="true"></i><span class="bad">22</span></button></td>
                              <td></td>
                            </tr>
                          </table>
                          <div class="edit_cmt">
<!--댓내용-->              <textarea class="cmt" height="auto" disabled><c:out value="${boardreply.reply}"/></textarea><button onclick="submit_comment"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button></div>
<!--답댓 펼치기-->
                          <div class='show_reply_with_arrow "show_reply_with_arrow"+${status.count}' id="show_reply_with_arrow">
                          	<button type="button" name="show_hide_rereply_button" value="${status.count}" onclick="hide_reply_list(this)"><span class='"reply_arrow"+${status.count}'><i class="fa fa-chevron-down" aria-hidden="true"></i></span>&nbsp답글<span class="reply_num">(22)</span></button>
                          	<input type="hidden" name="brno" value="${boardreply.brno}"/>
                          </div>
<!--답댓, 답댓에 대한 추가답댓(reply)을 달수 없음-->
					<!-- <article> -->
                        
                    
                    <div  class="reply reply${status.count}">    
					<%-- <div  class='"reply_"+${status.count}'> --%>
						
<!--                         <div class="write_reply">
                          <input type="text" value="답댓 달기" class="hide_reply" onclick="show_reply_box()"/>
                          <textarea name="name" rows="8" cols="80" ></textarea>
                          <input type="hidden" name="parent" value=""/>
                          <button onclick="submit_reply"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
                        </div> -->
  <!--동적생성,댓글 예시-->

                        <div class="reply_list">
                        
                        	<c:forEach items="${boardrereply}" var="boardrereply">
                        		<c:if test="${boardreply.brno eq boardrereply.parent}">
		    <!--예시댓글1-->        <div class="comment">
		                              <span><img src="http://placehold.it/50x50"/></span>
		                              <span class="writer_name"><a href="#"><c:out value="${boardrereply.replyer}"/></a></span>
		                              <span>
		                                <!--댓글 수정 삭제-->
		                                <div class="a_o_comment">
		                                  <a href="#" class="com1"><span><i class="fas fa-eraser"></i></span></a>
		                                  <span>|</span>
		                                  <a href="#" class="com2"><span><i class="far fa-trash-alt"></i></span></a>
		                                </div>
		                              </span>
		                              <span class="writing_time"><fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss" value="${boardrereply.regDate}"/></span>
		                              <table class="comment_per">
		                                <tr>
		                                  <td><button class="like"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i><span class="good">33</span></button></td>
		                                  <td><button class="dislike"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i><span class="bad">10</span></button></td>
		                                  <td></td>
		                                </tr>
		                              </table>
		
		                              <div class="edit_cmt">
		    <!--댓내용-->              <textarea class="cmt" height="auto" disabled><c:out value="${boardrereply.reply}"/></textarea><button onclick="submit_comment"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button></div>
		                        	  </div>
		                          </c:if>
                          </c:forEach>
                        </div>

                      <button onclick="hide_reply_list()" class="extra_reply"><i class="fa fa-angle-double-up" aria-hidden="true"></i></button>
                       		 </div>
                       </div>
                     



						</c:if>
						</c:forEach>
                    </article>
                  </form>
                    
                  </div>

                  </section>
                  
                  