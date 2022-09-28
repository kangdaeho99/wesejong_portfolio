<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
                <section id="cont_right">
                    <!-- <h3>Responsive Site Right Content</h3> -->
                    <article class="column col5 mt5 account notice24">
                    	<sec:authorize access="isAnonymous()">
                           <h4 class="ir_su col_tit">로그인박스</h4>
                            <p class="login_msg">세종대 커뮤니티사이트에 로그인해보세요.</p>
                            <a href="/member/login" class="link_login">LOGIN</a>

                            <div class="login_sub_area">
                                <div class="login_sub_area_find">
                                    <a href="#" onclick="open_find_idpw()">아이디 /</a>
                                    <a href="#" onclick="open_find_idpw()">비밀번호 찾기</a>
                                </div>
                                <div class="login_sub_area_join">
                                    <a href="/member/join">회원가입</a>>
                                </div>
                            </div>
                        </sec:authorize>
<!--로그인 후 로그인박스 변경-->

					<sec:authorize access="isAuthenticated()">
                    <h4 class="ir_su col_tit">로그인박스</h4>
                       <img src="../../../resources/img/profile.jpg" alt=""/>
                        <p class="login_msg"><span><sec:authentication property="principal.member.mem_nickname"/></span>님</p>
                        <table>
                          <tr>
                            <td><a href="/member/info/alarm">알림<c:if test="${new_alarm ne 0}"><span class="unread">˚</span></c:if></a></td>
                            <td><a href="/member/info/chatroomlist">채팅</a></td>
                          </tr>
                          <tr>
                            <td><a href="/member/info/mypost">내가쓴글</a></td>
                            <td><a href="/member/mypage">정보수정</a></td>
                          </tr>
                        </table>
                        <form action="/customLogout" method="post">
                        <div class="box_logout"><button><a class="link_logout">LOGOUT</a></button></div><!--logout박스는 임시로 넣어놓은 것-->
                     	</form>
                     </sec:authorize>
                     
                    </article>
                    <article class="column col11">
                            <h4 class="ir_su col_tit">title</h4>
                            <p class="ir_su col_desc">설명부분</p>

                            <h4 class="ir_su col_tit">공지사항이미지</h4>
                            <p class="col_desc"><a href="/meetmatch/event/explanation"><img src="../../../resources/img/event_banner.gif" class="cont_right_img"></a></p>
                            <!-- <p class="col_desc rainbow"></span> -->
                    </article>
                    <article class="column col12">
                        <div class="notice25 pr5">
                            <h5 class="ir_su">Notice1</h5>                            
							<h5><c:out value="${boardmanagevo_board_id_102.board_name}"/></h5>
	                        <ol type="1">
							<c:forEach items="${board_id_102}" var="board">
								<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
							</c:forEach>
	                        </ol>
	                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_102.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                        </div>
                    </article>
                    <article class="column col13">
                      <div class="notice26 pr5">
	                      <h5 class="ir_su">Notice1</h5>
	                      <h5>바로가기</h5>
	                      <div class="img10"><div class="innerimg10"><a href="http://www.sejong.ac.kr/"><img src="../../../resources/img/short_cut1.PNG"><div class="txt_on_img">세종대</div></a></div></div>
	                      <div class="img10"><div class="innerimg10"><a href="https://sjpt.sejong.ac.kr/main/view/Login/doSsoLogin.do?p="><img src="../../../resources/img/short_cut2.PNG"><div class="txt_on_img">학사정보</div></a></div></div>
	                      <div class="img10"><div class="innerimg10"><a href="https://do.sejong.ac.kr/"><img src="../../../resources/img/short_cut3.PNG"><div class="txt_on_img">두드림</div></a></div></div>
	                      <div class="img10"><div class="innerimg10"><a href="http://classic.sejong.ac.kr/"><img src="../../../resources/img/short_cut4.PNG"><div class="txt_on_img">대양<br />휴머니티</div></a></div></div>
	                      <div class="img10"><div class="innerimg10"><a href="https://library.sejong.ac.kr/index.ax"><img src="../../../resources/img/short_cut5.PNG"><div class="txt_on_img">학술<br />정보원</div></a></div></div>
	                      <div class="img10"><div class="innerimg10"> <a href="https://portal.sejong.ac.kr/jsp/login/loginSSL.jsp?rtUrl=portal.sejong.ac.kr/comm/member/user/ssoLoginProc.do"><img src="../../../resources/img/short_cut6.PNG"><div class="txt_on_img">세종포탈</div></a></div></div>
	                      <!-- <p class="col_desc rainbow"></span> -->
                      </div>
                    </article>


                    <article class="column col14">
                        <!-- 검색어: 별점주기 스프링 star rating-->
                        <!-- https://blog.naver.com/tnakekd/220313628830 -->
                        <!-- https://miuus.tistory.com/2 -->
                        
                        <div class="notice27 star_rating pr5">
	                         <h5 class="ir_su">Notice1</h5>
	                        <h5><c:out value="${boardmanagevo_board_id_405.board_name}"/></h5>
	                        <c:forEach items="${board_id_405}" var="board">
	                        <ul>
	                        	<li class="star_title"><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
	                        	<li class="star_content">
	                        		<span class="star_rate">
	                        			<a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.content}"/></a>
	                        		</span>
	                        	</li>
	                        </ul>
							</c:forEach>
	                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_405.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                        </div>
                        
                        
                        
                    </article>

                   <article class="column col15">
                        <div class="notice28 pr5">
                            <h5 class="ir_su">Notice1</h5>
	                        <h5><c:out value="${boardmanagevo_board_id_999.board_name}"/></h5>
	                        <ul>
							<c:forEach items="${board_id_999}" var="board">
								<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
							</c:forEach>
	                        </ul>
	                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_999.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                        </div>
                    </article>

                </section>
            </div>

       </section>
    </main>