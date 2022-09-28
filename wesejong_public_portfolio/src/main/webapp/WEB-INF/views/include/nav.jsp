<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <nav id="nav">
        <div class="container">
            <div class="row">
                <div class="nav">
                    <h2 class="ir_su">Category</h2>
                    <div>
                        <h3><i class="fas fa-university"></i>커뮤니티</h3>
                        <ol>
                            <li><a href="/board/list?board_id=999"><span>전체보기<c:if test="${new_board_id_999 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="/board/list?board_id=102"><span>인기게시판<c:if test="${new_board_id_102 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="/board/list?board_id=103"><span>자유게시판<c:if test="${new_board_id_103 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="/board/list?board_id=104"><span>질문게시판<c:if test="${new_board_id_104 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="/board/list?board_id=105"><span>코딩게시판<c:if test="${new_board_id_105 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="/board/list?board_id=106"><span>홍보게시판<c:if test="${new_board_id_106 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                        </ol>
                    </div>
                    <div>
                            <h3><i class="fas fa-university"></i>커뮤니티</h3>
                        <ol>
                            <!-- <li><a href="#" onclick="open_sejongtalk()"><span>세종톡</span></a></li> -->
                            <li><a href="/board/list?board_id=202"><span>중고거래게시판<c:if test="${new_board_id_202 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li></span></a></li>
                            <li><a href="/board/list?board_id=203"><span>일상게시판<c:if test="${new_board_id_203 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li></span></a></li>
                            <li><a href="/board/list?board_id=204"><span>연애게시판<c:if test="${new_board_id_204 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li></span></a></li>
                            <li><a href="/board/list?board_id=205"><span>고민게시판<c:if test="${new_board_id_205 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li></span></a></li>
                            <li><a href="/board/list?board_id=206"><span>정치게시판<c:if test="${new_board_id_206 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li></span></a></li>
                        </ol>
                    </div>
                    <div>
                            <h3><i class="fas fa-university"></i>대학생활</h3>
                        <ol>
                            <li><a href="/board/list?board_id=301"><span>새내기<c:if test="${new_board_id_301 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li></span></a></li>
                            <li><a href="/board/list?board_id=302"><span>동아리<c:if test="${new_board_id_302 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li></span></a></li>
                            <li><a href="/board/list?board_id=303"><span>맛집<c:if test="${new_board_id_303 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li></span></a></li>
                            <li><a href="/board/list?board_id=304"><span>스터디<c:if test="${new_board_id_304 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li></span></a></li>
                            <li><a href="/board/list?board_id=305"><span>졸업생<c:if test="${new_board_id_305 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li></span></a></li>
                            <li><a href="/board/list?board_id=306"><span>자취방<c:if test="${new_board_id_306 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li></span></a></li>
                        </ol>
                    </div>
                    <div>
                            <h3><i class="fas fa-university"></i>학교정보</h3>
                        <ol>
                            <li><a href="http://www.sejong.ac.kr/unilife/program_01.html?menu_id=1.1"><span>학사일정</span></a></li>
                            <li><a href="/board/list?board_id=402"><span>학생회게시판<c:if test="${new_board_id_402 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="http://www.sejongpr.ac.kr/index.do"><span>학교소식</span></a></li>
                            <li><a href="/board/list?board_id=404"><span>족보<c:if test="${new_board_id_404 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="/board/list?board_id=405"><span>강의평가<c:if test="${new_board_id_405 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="http://www.sejong.ac.kr/unilife/subject_01.html"><span>졸업요건</span></a></li>
                        </ol>
                    </div>
                    <div>
                            <h3><i class="fas fa-university"></i>안내</h3>
                        <ol>
                            <li><a href="/board/list?board_id=501"><span>취업후기<c:if test="${new_board_id_501 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="/board/list?board_id=502"><span>학업상담<c:if test="${new_board_id_502 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="/board/list?board_id=503"><span>공지사항<c:if test="${new_board_id_503 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="/board/list?board_id=504"><span>문의사항<c:if test="${new_board_id_504 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                            <li><a href="https://forms.gle/iEWf65gXDYbje3Ay9"><span>피드백하기</span></a></li>
                            <li><a href="/board/list?board_id=506"><span>369게시판<c:if test="${new_board_id_506 eq 1}"><span class="new_post">&nbspnew</span></c:if></span></a></li>
                        </ol>
                    </div>
                </div>
            </div>
            <article id="toggle">
                <div class="container">
                    <div class="toggle">
                        <span></span>
                        <a href="#" class="btn" onclick="drop_down_monitor_menu()">
                            <i class="fa fa-angle-down" aria-hidden="true"></i>
                        </a>
                    </div>
                </div>
            </article>
        </div>
    </nav>