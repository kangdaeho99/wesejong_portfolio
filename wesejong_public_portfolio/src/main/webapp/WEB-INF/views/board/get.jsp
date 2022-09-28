<%@include file="../include/header.jsp" %>
<%@include file="../include/nav.jsp" %>

<title>게시글</title>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<link rel="stylesheet" type="text/css" href="../../../resources/css/board/board_list.css">
<link rel="stylesheet" type="text/css" href="../../../resources/css/index/home.css">
<link rel="stylesheet" type="text/css" href="../../../resources/css/board/post.css">

<script src="../../../resources/javascript/board/board_list.js"defer></script>
<script src="../../../resources/javascript/board/post.js"></script>
<script src="../../../resources/javascript/board/boardlike.js"defer></script>
<!-- <script src="../../../resources/javascript/index/link.js"defer></script> -->
<script src="../../../resources/javascript/index/removehome.js"defer></script>


<script type="text/javascript">

/* rereply가 여러개인 상황이기에 classList로 remove를 해주어야합니다. */
function getform_reply_register(reply_button){
	document.getform.action = "/board/reply/register";
	document.getform.method = "post";
	document.querySelector("input[name=parent]").value = 0;
	reply_button.previousElementSibling.name = 'reply';
	/* alert(reply_button.previousElementSibling.name); */
	document.getform.submit();
}

function getform_rereply_register(rereply_button){
	document.getform.action = "/board/reply/reregister";
	document.getform.method = "post";
	document.querySelector("input[name=parent]").value = rereply_button.value;
	rereply_button.previousElementSibling.name = 'reply';
	/* alert(rereply_button.previousElementSibling.name); */
	document.getform.submit();
}

function getform_remove_board(){
	if(confirm("게시글을 삭제하시겠습니까? 완전히 삭제됩니다.")){
		document.getform.action = "/board/remove";
		document.getform.method = "post";
		document.getform.submit();		
	} else{
		return false;
	}
}

function getform_remove_reply(reply_remove_button){
	if(confirm("답글을 삭제하시겠습니까?")){
		document.getform.action = "/board/reply/remove";
		document.getform.method = "post";
		document.querySelector("input[name=brno]").value = reply_remove_button.nextElementSibling.value;
/* 		alert(reply_remove_button.nextElementSibling.name)
		alert(reply_remove_button.nextElementSibling.value); */
		document.getform.submit();		 
	} else{
		return false;
	}
}

function getform_remove_rereply(rereply_remove_button){
	if(confirm("대댓글을 삭제하시겠습니까?")){
		document.getform.action = "/board/reply/rereply/remove";
		document.getform.method = "post";
		document.querySelector("input[name=brno]").value = rereply_remove_button.nextElementSibling.value;
/* 		alert(rereply_remove_button.nextElementSibling.name);
		alert(rereply_remove_button.nextElementSibling.value); */
		document.getform.submit();
	} else{
		return false;
	}
}

function getform_like_btn_clicked(){
	likebtnclicked();
/* 	document.getform.action = "/board/like/likebtnclicked";
	document.getform.method = "post";
	document.getform.submit(); */
}

function getform_dislike_btn_clicked(){
	dislikebtnclicked();
/* 	document.getform.action = "/board/dislike/dislikebtnclicked";
	document.getform.method = "post";
	document.getform.submit(); */
}

</script>
	


    <main>
        <section id="contents">
            <div class="container">
            
            
             <form name="getform">
              <div class="wrapper">
<!--제목 및 본문 정보-->
              <section id="post_header">
                  <ul class="post_category">
                    <li><a href="/board/list?board_id=<c:out value='${boardmanage.board_id}'/>"><c:out value="${boardmanage.board_name}"/><!-- 자유게시판 --></a></li>
                    <li></li>
                    <li></li>
                    <li class="edit_post">
                    <!--post_category 오른쪽 상단 ellipsis-v 클릭-->
                    <sec:authorize access="isAuthenticated()">
                      <sec:authentication property="principal.member.mem_seq" var="mem_seq"/>
                      <c:if test="${mem_seq eq board.mem_seq}">
	                      <div class="a_o_category">
	                        <a href="/board/modify?bno=<c:out value='${board.bno}'/>" class="com1"><span>수정</span></a>
	                        <span>|</span>
	                        <a href="#" onclick="getform_remove_board()"class="com2"><span>삭제</span></a>
	                      </div>                      
                      </c:if>
                     </sec:authorize>
                    </li>
                  </ul>
<br/>
                  <div class="post_title"><h1><a href="#"><c:out value="${board.title}"/></a></h1></div>
                  <div>

                  <ul class="post_detail">
                    <li class="chat_writer"><a href="/socket/chatcheck?mem_seq=<c:out value='${board.mem_seq}'/>" onclick="window.open(this.href,'_blank','width=570,  height=800, toolbar=no, menubar=no, scrollbars=no, resizable=yes'); return false;"><i class="fa fa-user" aria-hidden="true"></i>&nbsp<span class="user_name"><c:if test="${board.anonymous == 1}">익명</c:if><c:if test="${board.anonymous eq 0}"><c:out value="${board.writer}"/></c:if></span></a><!--글쓴이 클릭 시, 채팅하기 기능-->
                    </li>
                    <li><a href="#"><i class="fas fa-eye"></i></a>&nbsp<span class="views_"><c:out value="${board.viewcount}"/></span></li>
                    <li><a href="#"><i class="fa fa-commenting-o" aria-hidden="true"></i></a>&nbsp<span class="comment_num_"><c:out value="${board.boardreply_count}"/></span></li>
                    <li><a href="#"><i class="fa fa-clock-o" aria-hidden="true"></i></a>&nbsp<span class="writing_time_"><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regdate}"/></span></li>
                  </ul>
<!--url복사-->
                  <span class="copy_url"><input type="text" id = "text_url"><button OnClick="copy_url_to_clipboard()"><i class="fa fa-clone" aria-hidden="true" style="font-size:20px;"></i></button></span>
                  <!--출처: https://doolyit.tistory.com/111 [동해둘리의 IT Study]-->
                </section>
				<hr/>
<!--본문-->
                <section>
                
                <article id="post_content">
                    <!-- <pre> --><c:out value="${board.content}" escapeXml='false'/><!-- </pre> -->
                  
				<br/>
                <br/>
                  <div class="evaluate_post">
                      <div class="like_it">
                      <c:choose>
                      	<c:when test="${boardlikeexists eq 0}">
                      		<button onclick="getform_like_btn_clicked();" name="likebtn" type="button"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i><div class="like_it_num"><c:out value="${board.boardlikecount}"/></div></button>
                      	</c:when>
                      	<c:when test="${boardlikeexists eq 1}">
                      		<button onclick="getform_like_btn_clicked();" name="likebtn" type="button" style="background-color:#c3200e"><i class="fa fa-thumbs-o-up" aria-hidden="true" style="color:white"></i><div class="like_it_num" style="color:white"><c:out value="${board.boardlikecount}"/></div></button>
                      	</c:when>                                	
                     </c:choose>
                       </div>   
                       
                     <div class="hate_it"> 
                     <c:choose>  
                       	<c:when test="${boarddislikeexists eq 0}">
                     		<button onclick="getform_dislike_btn_clicked();" name="dislikebtn" type="button"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i><div class="like_it_num"><c:out value="${board.boarddislikecount}"/></div></button>
                      	</c:when>
                      	<c:when test="${boarddislikeexists eq 1}">
                      		<button onclick="getform_dislike_btn_clicked();" name="dislikebtn" type="button" style="background-color:#283598"><i class="fa fa-thumbs-o-down" aria-hidden="true" style="color:white"></i><div class="like_it_num" style="color:white"><c:out value="${board.boarddislikecount}"/></div></button>
                      	</c:when>        
                     </c:choose> 
                      </div>
                      
<%--                         <button onclick="getform_like_btn_clicked();" type="button"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i><div class="like_it_num"><c:out value="${boardliketotalcount}"/></div></button>
                        <button onclick="thumbs_up()"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i><div class="like_it_num_clicked"><c:out value="${boardliketotalcount}"/></div></button>
                        <!--클릭 시 : border: 2px solid #c3002e;-->
                        </div>
                        <div class="hate_it">
                          <button onclick="thumbs_down()"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i><div class="hate_it_num">10</div></button>
                          <!--클릭 시 변화 :   border: 2px solid #283598;--> --%>

                    </div>
                    <span class="edit_post right_ver">
                    <!--post_category 오른쪽 상단 ellipsis-v 클릭-->
                    <div class="a_o_category">
                      <a href="/board/list?board_id=<c:out value="${board.board_id}"/>" class="com1"><span>목록보기</span></a>
                      <!--<span>|</span>
                      <a href="#" class="com2"><span>삭제</span></a>-->
                    </span>
                  </article>
                </section>
				<hr/>
<!-- ---------------- -->
<!--댓글부분 시작입니다.-->
<!-- ---------------- -->


                <section id="post_comments">
                  <div>
                    <h1>댓글</h1>
				<!-- <form name="replyform"> -->
				
				
				
				
				
	                <div class="write_comment">
	                  <input type="text" value="댓글을 작성해주세요." class="hide_comment" onclick="show_comment_box()"/>
	                  <textarea class="reply_textarea" name="" rows="8" cols="80"></textarea>
	                  <button onclick="getform_reply_register(this);"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
	                </div>
	                <input type="hidden" name="bno" value="${board.bno}"/>
               	    <input type="hidden" name="brno"/> 
	                <input type="hidden" name="board_id" value="${board.board_id}"/>
	                <input type="hidden" name="replyer" value="writer"/>
	                <input type="hidden" name="anonymous" value="1"/>
	                <input type="hidden" name="parent" value="0"/>
	                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                
                
                
                
                
                
<!--댓글목록--> <article>
<!--베댓은 댓글 목록 상단 노출(ex유튜브 댓글)-->
				<c:forEach items="${boardreply}" var="boardreply" varStatus="status">
					<c:if test="${boardreply.parent eq 0 }">
						
<!--예시댓글1-->       <div class="comment">
						
						<!-- 일반 댓글 -->
						<c:if test="${boardreply.deleteflag eq 0}">
                         <span class="img"><img src="../../../resources/img/profile.jpg" width="50" height="50"/></span>
                         
                         <c:choose>
                         	<c:when test="${board.mem_seq ne boardreply.mem_seq}">
                         		<span class="writer_name"><a href="/socket/chatcheck?mem_seq=<c:out value="${boardreply.mem_seq}"/>">익명</a></span>
                         	</c:when>
                         	<c:otherwise>
                         		<span class="writer_name"><a href="/socket/chatcheck?mem_seq=<c:out value="${boardreply.mem_seq}"/>" style="color:black;">익명(글쓴이)</a></span>
                         	</c:otherwise>
                         </c:choose>
                        
                         <div class="writing_time"><fmt:formatDate pattern="yyyy.MM.dd HH:mm" value="${boardreply.regDate}"/></div>
                         <span class="comm"> 
                           <!--댓글 ellipsis-v-->
                           <div class="a_o_comment">
                             <!-- <a href="#" class="com1" onclick="modify_comment()"><span>수정</span></a> -->
                             <span>|</span>
                             
                             
		                    <sec:authorize access="isAuthenticated()">
		                      <sec:authentication property="principal.member.mem_seq" var="mem_seq"/>
		                      <c:if test="${mem_seq eq boardreply.mem_seq}">
			                        <a href="#" class="com2" onclick="getform_remove_reply(this); return false;"><span>삭제</span></a>
			                        <input type="hidden" name="${status.count}" value="${boardreply.brno}"/>
		                      </c:if>
		                     </sec:authorize>                             
                          
                             
                           </div>
                         </span>
                         <div class="edit_cmt" onclick="show_reply_box(this)">
			              <%-- <textarea class="cmt" height="auto" ><c:out value="${boardreply.reply}"/> </textarea> --%>
			              
			              <br/><pre><c:out value="${boardreply.reply}"/></pre>
			              <%-- <c:out value="${boardreply.reply}"/> --%>
                     		  <button onclick="submit_comment()"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
                         </div>
                         <input type="hidden" value="${status.count}" />
                       <table class="comment_per" height="20">
                         <tr>
<!--                            <td><button class="like"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i><span class="good">33</span></button></td>
                           <td><button class="dislike"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i><span class="bad">10</span></button></td>
                           <td><button class="cmt_comment"onclick="hide_reply_list()"><i class="far fa-comment-dots"></i><span>10</span></button></td> -->
                         </tr>
                       </table>		
                       </c:if>
                       
                       <!-- 삭제된 댓글(대댓글이 존재햇을경우) -->
						<c:if test="${boardreply.deleteflag ne 0}">
                         <span class="img"><img src="../../../resources/img/profile.jpg" width="50" height="50"/></span>
                         <%-- <span class="writer_name"><a href="/socket/chatcheck?mem_seq=<c:out value="${boardreply.mem_seq}"/>">익명<c:out value="${boardreply.replyer}"/></a></span> --%>
                         <%-- <div class="writing_time"><fmt:formatDate pattern="yyyy.MM.dd HH:mm:ss" value="${boardreply.regDate}"/></div> --%>
                         <span class="comm"> 
                           <!--댓글 ellipsis-v-->
                           <div class="a_o_comment">
                             
                           </div>
                         </span>
                         <div class="edit_cmt" onclick="show_reply_box(this)">
			              <textarea class="cmt" height="auto"  style="color:gray">댓글작성자에 의해 삭제된 댓글입니다.</textarea>
                     		  <button onclick="submit_comment()"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
                         </div>
                         <input type="hidden" value="${status.count}" />
                       <table class="comment_per" height="20">
                         <tr>
<!--                            <td><button class="like"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i><span class="good">33</span></button></td>
                           <td><button class="dislike"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i><span class="bad">10</span></button></td>
                           <td><button class="cmt_comment"onclick="hide_reply_list()"><i class="far fa-comment-dots"></i><span>10</span></button></td> -->
                         </tr>
                       </table>		
                       </c:if>
                        
                        
                        
                        
                        
                        
                        				
<!-- 대댓글 작성버튼 -->
                	 <article>
	                    <div  class="reply reply${status.count}">
	                    <!-- 이게 작은 답댓달기  이걸 클릭하면 아래에 write_reply가 생기는것임-->
	                      <input type="hidden" placeholder="답댓 달기" class="hide_reply rereply_input${status.count}" /> <!-- onclick="show_reply_box(this)" -->
	                      <input type="hidden" value="${status.count}" />
	                        <div class="write_reply write_reply${status.count}">
	                          <textarea class="rereply_textarea rereply_textarea${status.count}" name="" rows="8" cols="80" ></textarea>
	                          <button class="button${status.count}" onclick="getform_rereply_register(this)" value="${boardreply.brno}"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
	                      	</div>			
				                      
				                      
				                      
				                      
				                      
				                      
				                      
				                      
				                      
  <!-- 대댓글 목록 -->              			
	                        <div class="reply_list">
	                        	
	                        	<div>
	                        	
									<c:forEach items="${boardrereply}" var="boardrereply" varStatus="rereply_status">
	                        			<c:if test="${boardreply.brno eq boardrereply.parent}">
	                        			
	                        			<span class="reply_arrow"><i class="fa fa-arrow-right" aria-hidden="true" style="font-size:8px; padding-top:15px;"></i></span>
										<div class="comment">
											
											<span class="monitor_reply_arrow"><i class="fa fa-arrow-right" aria-hidden="true"></i></span>
											
								        	<span><img src="../../../resources/img/profile.jpg" width="40" height="50"/></span>

					                         <c:choose>
					                         	<c:when test="${board.mem_seq ne boardrereply.mem_seq}">
					                         		<span class="writer_name"><a href="/socket/chatcheck?mem_seq=<c:out value="${boardreply.mem_seq}"/>">익명</a></span>
					                         	</c:when>
					                         	<c:otherwise>
					                         		<span class="writer_name"><a href="/socket/chatcheck?mem_seq=<c:out value="${boardreply.mem_seq}"/>" style="color:black; font-weight:bold" >익명(글쓴이)</a></span>
					                         	</c:otherwise>
					                         </c:choose>

								            <span class="writing_time"><fmt:formatDate pattern="yyyy.MM.dd HH:mm" value="${boardrereply.regDate}"/></span>
								            <span class="comm">
								            
											 <sec:authorize access="isAuthenticated()">
						                      <sec:authentication property="principal.member.mem_seq" var="mem_seq"/>
						                      <c:if test="${mem_seq eq boardrereply.mem_seq}">
							                        <a href="#" class="com2" onclick="getform_remove_rereply(this)"><span>삭제</span></a>
						                      		<input type="hidden" name="${rereply_status.count}" value="${boardrereply.brno}"/>
						                      </c:if>
						                     </sec:authorize>     

								         	
								         	</span>
										    <div class="edit_cmt">
										    	<%-- <textarea class="cmt" height="auto"><c:out value="${boardrereply.reply}"/></textarea> --%>
										    	<br/><pre><c:out value="${boardrereply.reply}"/></pre>
												<%-- <pre class="cmt"><c:out value="${boardrereply.reply}"/></pre> --%>
										        <button onclick="submit_comment()"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
										  	</div>
											<table class="comment_per" height="20">
										  		<tr>
<!-- 										    		<td><button class="like"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i><span class="good">33</span></button></td>
										    		<td><button class="dislike"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i><span class="bad">10</span></button></td>
										    		<td><button class="cmt_comment"onclick="hide_reply_list()"><i class="far fa-comment-dots"></i><span>10</span></button></td> -->
										    	</tr>
										  	</table>
										</div>
		                      			<!-- <button onclick="hide_reply_list()" class="extra_reply"><i class="fa fa-angle-double-up" aria-hidden="true"></i></button> -->
		                       			</c:if>
		                        	</c:forEach>
		                        	<!-- <button onclick="hide_reply_list()" class="extra_reply"><i class="fa fa-angle-double-up" aria-hidden="true"></i></button> -->
	                        	</div>
	                        </div>
				            </div>
				          </article>
       	      		   </div>

       	      		   </c:if>
       	      		   </c:forEach>
      		   		  </article>
      		   		<!-- </form> -->
      		   	</div>
               </section>
               </div>						
						
		</form>
		
					

<%-- <%@include file="include/get_list.jsp" %> --%>
<%@include file="include/include_board_get_list.jsp" %>
<%@include file="../include/content_right.jsp" %>
<%-- <%@include file="include/include_board_get_content_right.jsp" %> --%>
<%-- <%@include file="../include/footer.jsp" %> --%>
<%@include file="include/include_board_footer.jsp" %>