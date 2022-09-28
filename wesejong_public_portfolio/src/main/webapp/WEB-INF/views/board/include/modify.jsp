<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/../../../../resources/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" type="text/css" href="/../../../../resources/css/board/board_list.css">
 <link rel="stylesheet" type="text/css" href="/../../../../resources/css/board/post.css">
 
 <script src="../../../../resources/js/board/board_list.js"defer></script>
 <script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/boardmanage/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	document.formm.action="/admin/boardmanage/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/boardmanage/list";
	document.formm.method = 'get';
	document.formm.submit();
}
/* 
<input type="button" value="modify" onclick="go_modify()"/>
	<input type="button" value="remove" onclick="go_remove()"/>
	<input type="button" value="list" onclick="go_list()"/> */
</script>
     <main>
        <section id="contents">
            <div class="container">
              <div class="wrapper">
<!--제목 및 본문 정보-->

			<form role="form" action="/board/register" method="post">
				
			

              <section id="post_header">
                  <ul class="post_category">
                    <li><a href="board.html">자유게시판</a></li>
                    <li></li>
                    <li><a href="#">#&nbsp<span class="board_categoty">공지</span></a></li>
                    <li class="edit_post">
                      <a href="#" onclick="show_edit_post_box()"><i class="fa fa-ellipsis-v" aria-hidden="true" style="font-size:15px"></i></a>
                      <!--post_category 오른쪽 상단 ellipsis-v 클릭-->
                      <div class="a_o_category">
                        <ul>
                          <a href="#"><li>수정하기</li></a>
                          <hr style="width:80%; border:0.1px solid #AAAAAA;"noshade>
                          <a href="#"><li>삭제하기</li></a>
                        </ul>
                      </div>
                    </li>
                  </ul>
<br/>
                  <div class="post_title">
               	   <h1><input type="text" name="title" placeholder="제목입니다." size=40 value="<c:out value="${board.title}"/>"></h1>
                  </div>
                  <div>

                  <ul class="post_detail">
                    <li class="chat_writer"><a onclick="show_chat_to_writer_box()" href="#" ><i class="fa fa-user" aria-hidden="true"></i>&nbsp<span class="user_name"><input type="text" name="writer" value="익명" readonly="readonly"></span></a><!--글쓴이 클릭 시, 쪽지 보내기 채팅하기 기능-->
                          <!--post_detail의 글쓴이 클릭-->
                      <div class="a_o_writer">
                        <ul>
                          <a href="#" onclick="open_chat()"><li>채팅하기</li></a>
                        </ul>
                      </div>
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

					<textarea id="textarea1" placeholder="내용입니다." autofocus required wrap="hard" rows="30" cols="80" name="content" style='width:100%'><c:out value="${board.content}"/></textarea>
					<input type="submit" value="수정하기"/>
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
                  <div class="evaluate_post">
                      <div class="like_it">
                        <button onclick="thumbs_up()"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i>&nbsp<span class="like_it_num">3053</span></button>
                        </div>
                        <div class="hate_it">
                          <button onclick="thumbs_down()"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i>&nbsp<span class="hate_it_num">10</span></button>
                          </div>
                    </div>
                  </article>
                </section>
<hr/>
<!--댓글-->
                <section id="post_comments">
                  <div>
                    <h1>댓글</h1>
<!--댓글쓰기-->
                <div class="write_comment">
                  <input type="text" value="댓글을 작성해주세요. 비방이나 욕설은 삭제될 수 있습니다." class="hide_comment" onclick="show_comment_box()"/>
                  <textarea name="name" rows="8" cols="80" ></textarea>
                  <button onclick="submit_comment"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
                </div>
<!--댓글목록-->      <article>
<!--베댓은 댓글 목록 상단 노출(ex유튜브 댓글)-->
<!--예시댓글1-->        <div class="comment">
                          <span><img src="http://placehold.it/50x50"/></span>
                          <span class="writer_name"><a href="#">관리자관리자관리자관리자관리자관리자35</a></span>
                          <span>
                            <button onclick="show_edit_comment_box()"><i class="fa fa-ellipsis-v" aria-hidden="true"></i></button>
<!--댓글 ellipsis-v-->
                            <div class="a_o_comment">
                              <ul>
                                <a onclick="edit_comment()"><li>수정하기</li></a>
                                <hr style="width:80%; border:0.1px solid #AAAAAA;"noshade>
                                <a href="#"><li>삭제하기</li></a>
                              </ul>
                            </div>
                          </span>
                          <span class="writing_time">2021.04.24 15:30</span>
                 <table class="comment_per">
                            <tr>
                              <td><button class="like"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i><span class="good">33</span></button></td>
                              <td><button class="dislike"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i><span class="bad">10</span></button></td>
                              <td><button onclick="show_reply()"><i class="fa fa-comments-o" aria-hidden="true"></i><span class="bad">22</span></button></td>
                              <td></td>
                            </tr>
                          </table>
                          <div class="edit_cmt">
<!--댓내용-->              <textarea class="cmt" height="auto" disabled>글로벌 버디는 국제교류센터(CISS) 산하 봉사 자치단체이다. 외국인 학생들과 문화 교류를 통해 친밀한 관계를 형성하는 활동을 한다.글로벌 버디는 국제교류센터(CISS) 산하 봉사 자치단체이다. 외국인 학생들과 문화 교류를 통해 친밀한 관계를 형성하는 활동을 한다. </textarea><button onclick="submit_comment"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button></div>
<!--답댓 펼치기-->
                          <div class="show_reply_with_arrow"><button onclick="hide_reply_list()"><span class="reply_arrow"><i class="fa fa-chevron-down" aria-hidden="true"></i></span>&nbsp답글<span class="reply_num">(22)</span></button></div>

<!--답댓, 답댓에 대한 추가답댓(reply)을 달수 없음-->
<article>
<div  class="reply">
                        <div class="write_reply">
                          <input type="text" value="답댓 달기" class="hide_reply" onclick="show_reply_box()"/>
                          <textarea name="name" rows="8" cols="80" ></textarea>
                          <button onclick="submit_reply"><i class="fa fa-paper-plane" aria-hidden="true"></i></button>
                          </div>
  <!--동적생성,댓글 예시-->
                        <div class="reply_list">
    <!--예시댓글1-->        <div class="comment">
                              <span><img src="http://placehold.it/50x50"/></span>
                              <span class="writer_name"><a href="#">관리자1</a></span>
                              <span>
                                <button onclick="show_edit_comment_box()"><i class="fa fa-ellipsis-v" aria-hidden="true"></i></button>
    <!--댓글 ellipsis-v-->
                                <div class="a_o_comment">
                                  <ul>
                                    <a href="#"><li>수정하기</li></a>
                                    <hr style="width:80%; border:0.1px solid #AAAAAA;"noshade>
                                    <a href="#"><li>삭제하기</li></a>
                                  </ul>
                                </div>
                              </span>
                              <span class="writing_time">2021.04.24 15:30</span>
                              <table class="comment_per">
                                <tr>
                                  <td><button class="like"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i><span class="good">33</span></button></td>
                                  <td><button class="dislike"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i><span class="bad">10</span></button></td>
                                  <td></td>
                                </tr>
                              </table>

                              <div class="edit_cmt">
    <!--댓내용-->              <textarea class="cmt" height="auto" disabled>글로벌 버디는 국제교류센터(CISS) 산하 봉사 자치단체이다. 외국인 학생들과 문화 교류를 통해 친밀한 관계를 형성하는 활동을 한다.글로벌 버디는 국제교류센터(CISS) 산하 봉사 자치단체이다. 외국인 학생들과 문화 교류를 통해 친밀한 관계를 형성하는 활동을 한다. </textarea><button onclick="submit_comment"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button></div>
                          </div>
  <!--예시대댓글-->        <div class="comment">
                            <span><img src="http://placehold.it/50x50"/></span>
                            <span class="writer_name"><a href="#">관리자1</a></span>
                            <span>
                              <button onclick="show_edit_comment_box()"><i class="fa fa-ellipsis-v" aria-hidden="true"></i></button>
  <!--댓글 ellipsis-v-->
                              <div class="a_o_comment">
                                <ul>
                                  <a href="#"><li>수정하기</li></a>
                                  <hr style="width:80%; border:0.1px solid #AAAAAA;"noshade>
                                  <a href="#"><li>삭제하기</li></a>
                                </ul>
                              </div>
                            </span>
                            <span class="writing_time">2021.04.24 15:30</span>
                            <table class="comment_per">
                              <tr>
                                <td><button class="like"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i><span class="good">33</span></button></td>
                                <td><button class="dislike"><i class="fa fa-thumbs-o-down" aria-hidden="true"></i><span class="bad">10</span></button></td>
                                <td></td>
                              </tr>
                            </table>

                            <div class="edit_cmt">
  <!--댓내용-->              <textarea class="cmt" height="auto" disabled>글로벌 버디는 국제교류센터(CISS) 산하 봉사 자치단체이다. 외국인 학생들과 문화 교류를 통해 친밀한 관계를 형성하는 활동을 한다.글로벌 버디는 국제교류센터(CISS) 산하 봉사 자치단체이다. 외국인 학생들과 문화 교류를 통해 친밀한 관계를 형성하는 활동을 한다. </textarea><button onclick="submit_comment"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button></div>
                        </div>
                        </div>

                      <button onclick="hide_reply_list()" class="extra_reply"><i class="fa fa-angle-double-up" aria-hidden="true"></i></button>
                        </div>

                        </div>




                    </article>
                  </div>

                  </section>
                  
                  
                  
                  
                  
                  
                  	<script>
	CKEDITOR.replace('textarea1',{
		filebrowserUploadUrl:'${pageContext.request.contextPath}/upload/imageUploadAction'

			
	});
	
// 	window.parent.CKEDITOR.tools.callFunction(1,"${url}",'submit complete')
// 	{"filename" : "[fileName]", "uploaded" : 1, "url":"url]"}
	
	/* ?${_csrf.parameterName}=${_csrf.token} */
	/* it doesn;t looks like csrf problem 404 error cannot find the file */
	
 	CKEDITOR.on('dialogDefinition', function(ev){
	    var dialogName = ev.data.name;
	    var dialog = ev.data.definition.dialog;
	    var dialogDefinition = ev.data.definition;
	    if(dialogName == 'image'){
	        dialog.on('show', function(obj){
	            this.selectPage('Upload');  // 업로드 탭으로 시작
	        });

	        
	        
	        dialogDefinition.removeContents('advanced');    //자세히탭 제거
	        dialogDefinition.removeContents('Link');    //링크탭 제거
	        var infoTab = dialogDefinition.getContents('info'); // info탭을 제거하면 
	        //info 탭내에 불필요한 엘리먼트들 제거
	        // dialogDefinition.removeContents('info'); 
	        
	        
	        //Get a reference to the "upload" tab
	        var uploadTab = dialogDefinition.getContents('Upload');
	        //Get the "Chhose file" input definition
	        var fileChooserDef = uploadTab.get('upload');
	        //Get the "Send it to the Server" button definition, and hide that button
	        var sendButtonDef = uploadTab.get('uploadButton');
	        sendButtonDef.hidden = true;
	        
	        //When a file is choosen, automicatly send it to the server
	        fileChooserDef.onChange = function(){
	        		//Get the "Send it to the Server button Element.
	        		var sendButton = this.getDialog().getContentElement('Upload', 'uploadButton');
	        		//simulate clicking that button.
	        		sendButton.click();
	        }
	    }
	}); 
	
	
	</script>
                  
                  