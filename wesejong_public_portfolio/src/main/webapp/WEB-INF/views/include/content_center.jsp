<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <main>
        <section id="contents" >
            <div class="container" class="parallax_base_layer">
                <!-- ir_su는 그냥 주석임 -->
                <h2 class="ir_su">Responsive Site Content</h2>
                <section id="cont_center">
                    <h3 class="ir_su">Response Site Left Content</h3>
                    <article class="column col1">
                       <h4 class="ir_su col_tit">공지사항이미지</h4>
                        <p class="col_desc"><span class="ir_su">공지사항 이미지가 들어갈곳입니다.<br/></span><!--<img src="http://placehold.it/890x100">-->
                        <!-- <img src="../../../resources/img/main.png"> -->
                        </p>
                        <!-- <p class="col_desc rainbow"></span>
                        </p> -->
                        <!--자동재생

                        <iframe width="890" height="400" src="https://www.youtube.com/embed/nsQKgQHuygU?autoplay=1&mute=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>-->
<!--                         <iframe width="890" height="400" src="https://www.youtube.com/embed/nsQKgQHuygU"
                        title="YouTube video player" frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                        allowfullscreen></iframe> -->
						<a href="/"><img src="../../../resources/img/main_banner.png"></a>
                    </article>

                    <article class="column col2">
                        <!-- <h4 class="ir_su col_tit">Notice</h4>
                        <p class="ir_su col_desc">게시판 영역의 한줄효과와 두줄효과게시판입니다.</p> -->
                         <!-- 게시판  -->
                        <div class="notice1 pr5">
                            <h5 class="ir_su">Notice1</h5>
                            <h5><c:out value="${boardmanagevo_board_id_103.board_name}"/></h5>
                            <ul>
							<c:forEach items="${board_id_103}" var="board">
								<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
							</c:forEach>
                            </ul>
                            <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_103.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                        </div>

                         <!-- 게시판  -->
                         <div class="notice2 pr5">
                            <h5 class="ir_su">Notice1</h5>
                            <h5><c:out value="${boardmanagevo_board_id_301.board_name}"/></h5>
                            <ul>
							<c:forEach items="${board_id_301}" var="board">
								<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</c:if></a></li>
							</c:forEach>
                            </ul>
                            <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_301.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                        </div>

                        <div class="notice3">
                            <h5 class="ir_su">Notice1</h5>
                            <h5><c:out value="${boardmanagevo_board_id_104.board_name}"/></h5>
                            <ul>
							<c:forEach items="${board_id_104}" var="board">
								<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
							</c:forEach>
                            </ul>
                            <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_104.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                        </div>

                    </article>

                    <article class="column col3">
                            <!-- <h4 class="col_tit">title</h4>
                            <p class="col_desc">설명부분</p>  -->
                                <div class="slide" id="slide_">
                                    <button class="prev" type="button"><i class="fas fa-chevron-left"></i></button>
                                    <!--학생회 링크 모음-->
                                    <ul id="slide_ul">
                                        <!--dept1 소융대-->
                                        <li class="dept1">
                                            <a href="http://home.sejong.ac.kr/~cedpt/">소융대</a>
                                            <p>컴퓨터공학과</p>
                                        </li>
                                        <li class="dept2">
                                            <a href="http://home.sejong.ac.kr/~histdpt/">인문대</a>
                                            <p>역사학과</p>
                                        </li>
                                        <!--생과대-->
                                        <li class="dept7">
                                            <a href="http://home.sejong.ac.kr/~bioindustry/">생과대</a>
                                            <p>생명시스템학부</p>
                                        </li>
                                        <li class="dept10">
                                            <a href="http://home.sejong.ac.kr/~fasdpt/">예체능</a>
                                            <p>패션디자인학과</p>
                                        </li>
                                        <!--기항-->
                                        <li class="dept11">
                                            <a href="http://home.sejong.ac.kr/~medpt/">기항</a>
                                            <p>기계공학</p>
                                        </li>
                                        <li class="dept9">
                                            <a href="https://www.architecture.sejong.ac.kr/">공대</a>
                                            <p>건축학과</p>
                                        </li>
                                        <!--dept2 인문대-->
                                        <li class="dept2">
                                            <a href="http://home.sejong.ac.kr/~kordpt/">인문대</a>
                                            <p>국어국문학과</p>
                                        </li>
                                        <!--사과대-->
                                        <li class="dept3">
                                            <a href="http://home.sejong.ac.kr/~admdpt/">사과대</a>
                                            <p>행정학과</p>
                                        </li>
                                        <li class="dept10">
                                            <a href="http://home.sejong.ac.kr/~pedpt/">예체능</a>
                                            <p>체육학과</p>
                                        </li>
                                        <li class="dept9">
                                            <a href="http://home.sejong.ac.kr/~energydpt/">공대</a>
                                            <p>지구자원시스템공학과</p>
                                        </li>
                                        <li class="dept2">
                                            <a href="http://home.sejong.ac.kr/~interdpt/">인문대</a>
                                            <p>국제학부</p>
                                        </li>
                                        <li class="dept10">
                                            <a href="http://home.sejong.ac.kr/~musicdpt/">예체능</a>
                                            <p>음악과</p>
                                        </li>
                                        <li class="dept3">
                                            <a href="http://home.sejong.ac.kr/~nnbdpt/">사과대</a>
                                            <p>미디어커뮤니케이션학과</p>
                                        </li>
                                        <li class="dept1">
                                            <a href="http://home.sejong.ac.kr/~design/">소융대</a>
                                            <p>디자인이노베이션</p>
                                        </li>
                                        <li class="dept9">
                                            <a href="http://home.sejong.ac.kr/~eegdpt/">공대</a>
                                            <p>환경에너지공간융합학과</p>
                                        </li>
                                        <li class="dept1">
                                            <a href="http://imc.sejong.ac.kr/">소융대</a>
                                            <p>지능기전공학부</p>
                                        </li>
                                        <li class="dept9">
                                            <a href="http://home.sejong.ac.kr/~aerosysdpt/">공대</a>
                                            <p>항공시스템공학과</p>
                                        </li>
                                        <!--경영경제-->
                                        <li class="dept4">
                                            <a href="http://home.sejong.ac.kr/~entdpt/">경영경제</a>
                                            <p>경제학과</p>
                                        </li>
                                        <li class="dept1">
                                            <a href="http://home.sejong.ac.kr/~aidpt/">소융대</a>
                                            <p>인공지능학과</p>
                                        </li>
                                        <li class="dept9">
                                            <a href="http://home.sejong.ac.kr/~builddpt/">공대</a>
                                            <p>건설환경공학과</p>
                                        </li>
                                        <li class="dept4">
                                            <a href="http://home.sejong.ac.kr/~mnadpt/">경영경제</a>
                                            <p>경영학과</p>
                                        </li>
                                        <!--자연과학-->
                                        <li class="dept5">
                                            <a href="http://home.sejong.ac.kr/~appmath/">자연과학</a>
                                            <p>수학통계학과</p>
                                        </li>
                                        <li class="dept9">
                                            <a href="http://home.sejong.ac.kr/~nuedpt/">공대</a>
                                            <p>양자원자력공학과</p>
                                        </li>
                                        <li class="dept1">
                                            <a href="http://home.sejong.ac.kr/~digitdpt/">소융대</a>
                                            <p>소프트웨어학과</p>
                                        </li>
                                        <li class="dept5">
                                            <a href="http://home.sejong.ac.kr/~phyastrodpt/">자연과학</a>
                                            <p>물리천문학과</p>
                                        </li>
                                        <li class="dept1">
                                            <a href="http://home.sejong.ac.kr/~anitec/">소융대</a>
                                            <p>만화애니메이션텍</p>
                                        </li>
                                        <li class="dept9">
                                            <a href="http://www.sjname.ac.kr/">공대</a>
                                            <p>나노신소재공학과</p>
                                        </li>
                                        <li class="dept10">
                                            <a href="http://home.sejong.ac.kr/~dancedpt/">예체능</a>
                                            <p>무용과</p>
                                        </li>
                                        <li class="dept2">
                                            <a href="http://home.sejong.ac.kr/~edudpt/">인문대</a>
                                            <p>교육학과</p>
                                        </li>
                                        <li class="dept10">
                                            <a href="http://home.sejong.ac.kr/~moviedpt/">예체능</a>
                                            <p>영화예술학과</p>
                                        </li>
                                        <li class="dept9">
                                            <a href="http://home.sejong.ac.kr/~dsedpt/">공대</a>
                                            <p>국방시스템공학과</p>
                                        </li>
                                        <li class="dept5">
                                            <a href="http://home.sejong.ac.kr/~chemdpt/">자연과학</a>
                                            <p>화학과</p>
                                        </li>
                                        <!--호관대-->
                                        <li class="dept6">
                                            <a href="http://home.sejong.ac.kr/~biolodpt/">호관대</a>
                                            <p>호텔관광외식경영학부</p>
                                        </li>
                                        <li class="dept1">
                                            <a href="http://home.sejong.ac.kr/~dsdpt/">소융대</a>
                                            <p>데이터사이언스과</p>
                                        </li>
                                        <li class="dept7">
                                            <a href="http://home.sejong.ac.kr/~bioindustry/">생과대</a>
                                            <p>스마트생명산업융합대학</p>
                                        </li>
                                        <!--전정공-->
                                        <li class="dept8">
                                            <a href="http://home.sejong.ac.kr/~electrodpt/">전정공</a>
                                            <p>전자정보통신공학과</p>
                                        </li>
                                        <!--공대-->
                                        <li class="dept9">
                                            <a href="http://home.sejong.ac.kr/~constdpt/">공대</a>
                                            <p>건축공학과</p>
                                        </li>
                                        <li class="dept1">
                                            <a href="http://home.sejong.ac.kr/~isdpt/">소융대</a>
                                            <p>정보보호학과</p>
                                        </li>
                                        <!--법학부-->
                                        <li class="dept12">
                                            <a href="http://home.sejong.ac.kr/~openmajor/">법학부</a>
                                            <p>법학부</p>
                                        </li>
                                        <li class="dept11">
                                            <a href="http://home.sejong.ac.kr/~aerodpt/">기항</a>
                                            <p>항공우주공학</p>
                                        </li>
                                        <!--예체능-->
                                        <li class="dept10">
                                            <a href="http://home.sejong.ac.kr/~picdpt/">예체능</a>
                                            <p>회화과</p>
                                        </li>
                                    </ul>
                                    <button class="next" type="button"><i class="fas fa-chevron-right"></i></button>
                                </div>
                    </article>

                    <article class="column col4">
                            <h4 class="ir_su col_tit">title</h4>
                            <p class="ir_su col_desc">설명부분</p>

                            <div class="notice4 pr5">
                                <h5 class="ir_su">Notice1</h5>
                                <h5><c:out value="${boardmanagevo_board_id_302.board_name}"/></h5>
                                <ul>
									<c:forEach items="${board_id_302}" var="board">
										<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
									</c:forEach>
                                </ul>
                                <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_302.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                            </div>

                             <!-- 게시판  -->
                             <div class="notice5 pr5">
                                <h5 class="ir_su">Notice1</h5>
                                <h5><c:out value="${boardmanagevo_board_id_404.board_name}"/></h5>
                                <ul>
									<c:forEach items="${board_id_404}" var="board">
										<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
									</c:forEach>
                                </ul>
                                <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_404.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                            </div>

                            <div class="notice6">
                                <h5 class="ir_su">Notice1</h5>
                                <h5><c:out value="${boardmanagevo_board_id_105.board_name}"/></h5>
                                <ul>
									<c:forEach items="${board_id_105}" var="board">
										<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
									</c:forEach>
                                </ul>
                                <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_105.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                            </div>
                    </article>


                    <article class="column col5">
                        <h4 class="ir_su col_tit">title</h4>
                        <p class="ir_su col_desc">설명부분</p>

                         <!-- 게시판  -->
                         <div class="notice7 photo7 pr5">
                            <h5 class="ir_su">Notice1</h5>
                            <h5><c:out value="${boardmanagevo_board_id_303.board_name}"/></h5>
                            <c:forEach items="${board_id_303}" var="board" begin="0" end="1">
                            <ul>
                            	<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><img src="<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uploadpath}"/>/<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uuid}"/>" alt="" /><c:out value="${board.title}"/></a></li>
                            </ul>
                            </c:forEach>
                            <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_303.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                         </div>

                         <!-- 게시판  -->
                         <div class="notice8 photo8 pr5">
                            <h5 class="ir_su">Notice1</h5>
                            <h5><c:out value="${boardmanagevo_board_id_203.board_name}"/></h5>
                            <c:forEach items="${board_id_203}" var="board" begin="0" end="1">
                            <ul>
                            	<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><img src="<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uploadpath}"/>/<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uuid}"/>" alt="" /><c:out value="${board.title}"/></a></li>
                            </ul>
                            </c:forEach>
                            <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_203.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                        </div>

                </article>
                <!-- <br/><br/><br/><br/> -->
                <article class="column col6">
                    <h4 class="ir_su col_tit">title</h4>
                    <p class="ir_su col_desc">설명부분</p>

                    <div class="notice9 pr5">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_204.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_204}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_204.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                    </div>

                     <!-- 게시판  -->
                     <div class="notice10 pr5">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_205.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_205}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_205.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                    </div>

                    <div class="notice11">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_206.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_206}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_206.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                    </div>
            </article>
            <article class="column col7">
                <h4 class="ir_su col_tit">title</h4>
                <p class="ir_su col_desc">설명부분</p>

                 <!-- 게시판  -->
                 <div class="notice12 photo9 pr5">
                       <h5 class="ir_su">Notice1</h5>
                       <h5><c:out value="${boardmanagevo_board_id_202.board_name}"/></h5>
                       <c:forEach items="${board_id_202}" var="board" begin="0" end="1">
                       <ul>
                       	<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><img src="<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uploadpath}"/>/<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uuid}"/>" alt="" /><c:out value="${board.title}"/></a></li>
                       </ul>
                       </c:forEach>
                       <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_202.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                 </div>

                 <!-- 게시판  -->
                 <div class="notice13 photo10 pr5">
                       <h5 class="ir_su">Notice1</h5>
                       <h5><c:out value="${boardmanagevo_board_id_306.board_name}"/></h5>
                       <c:forEach items="${board_id_306}" var="board" begin="0" end="1">
                       <ul>
                       	<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><img src="<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uploadpath}"/>/<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uuid}"/>" alt="" /><c:out value="${board.title}"/></a></li>
                       </ul>
                       </c:forEach>
                       <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_306.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                </div>

          </article>
          <!-- <br/><br/><br/><br/> -->
          <article class="column col8">
              <h4 class="ir_su col_tit">title</h4>
              <p class="ir_su col_desc">설명부분</p>

              <div class="notice14 pr5">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_304.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_304}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_304.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
              </div>

               <!-- 게시판  -->
               <div class="notice15 pr5">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_501.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_501}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_501.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
              </div>

              <div class="notice16">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_502.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_502}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_502.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
              </div>
      </article>
      <article class="column col9">
          <h4 class="ir_su col_tit">title</h4>
          <p class="ir_su col_desc">설명부분</p>

           <!-- 게시판  -->
           <div class="notice17 photo8 pr5">
                  <h5 class="ir_su">Notice1</h5>
                 <h5><c:out value="${boardmanagevo_board_id_106.board_name}"/></h5>
                 <c:forEach items="${board_id_106}" var="board" begin="0" end="3">
                 <ul>
                 	<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><img src="<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uploadpath}"/>/<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uuid}"/>" alt="" /><c:out value="${board.title}"/></a></li>
                 </ul>
                 </c:forEach>
                 <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_106.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
              </div>


    </article>
      <!-- <br/><br/><br/><br/> -->
      <article class="column col10">
          <h4 class="ir_su col_tit">title</h4>
          <p class="ir_su col_desc">설명부분</p>

          <div class="notice18 pr5">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_402.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_402}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_402.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
          </div>

           <!-- 게시판  -->
           <div class="notice19 pr5">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_305.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_305}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_305.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
          </div>

          <div class="notice20 pr5">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_503.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_503}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_503.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
          </div>
  </article>
  <!-- <br/><br/><br/><br/> -->
<%--   <article class="column col6">
      <h4 class="ir_su col_tit">title</h4>
      <p class="ir_su col_desc">설명부분</p>

      <div class="notice21 pr5">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_403.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_403}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_403.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
      </div>

       <!-- 게시판  -->
       <div class="notice22 pr5">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_404.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_404}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_404.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
      </div>

      <div class="notice23">
                        <h5 class="ir_su">Notice1</h5>
                        <h5><c:out value="${boardmanagevo_board_id_405.board_name}"/></h5>
                        <ul>
						<c:forEach items="${board_id_405}" var="board">
							<li><a href="/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/><c:if test="${board.boardreply_count ne 0}">[<c:out value="${board.boardreply_count}"/>]</a></c:if></li>
						</c:forEach>
                        </ul>
                        <a href="/board/list?board_id=<c:out value="${boardmanagevo_board_id_405.board_id}"/>" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
      </div>
</article> --%>
</section>