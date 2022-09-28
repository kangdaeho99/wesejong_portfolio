<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta name="viewport" content="width=device-width,initial-scale=1">

 
 <script type="text/javascript">

function go_search(){
	document.searchformm.action="/board/list";
}


</script>
<!--   													-->
<!--   													-->
<!--   													-->



                      <section id="cont_right">
                          <!-- <h3>Responsive Site Right Content</h3> -->
                          <article class="column col5 mt5 account notice24">
                              <!--    <h4 class="ir_su col_tit">로그인박스</h4>
                                  <p class="login_msg">세종대 커뮤니티사이트에 로그인해보세요.</p>
                                  <a href="#" class="link_login">LOGIN</a>

                                  <div class="login_sub_area">
                                      <div class="login_sub_area_find">
                                          <a href="#">아이디 /</a>
                                          <a href="#">비밀번호 찾기</a>
                                      </div>
                                      <div class="login_sub_area_join">
                                          <a href="#">회원가입</a>>
                                      </div>
                                  </div>-->
                <!--로그인 후 로그인박스 변경-->
                          <h4 class="ir_su col_tit">로그인박스</h4>
                             <img src="../../../../resources/img\profile.JPG" alt=""/>
                              <p class="login_msg"><span><sec:authentication property="principal.member.mem_nickname"/></span>님</p>
                              <table>
                                <tr>
                                  <td><a href="#">알림</a></td>
                                  <td>채팅</td>
                                </tr>
                                <tr>
                                  <td>내가쓴글</td>
                                  <td>정보수정</td>
                                </tr>
                              </table>
                              <div class="box_logout"><a href="#" class="link_logout">LOGOUT</a></div><!--logout박스는 임시로 넣어놓은 것-->
                          </article>
                          <article class="column col6">
                                  <h4 class="ir_su col_tit">title</h4>
                                  <p class="ir_su col_desc">설명부분</p>

                                  <h4 class="ir_su col_tit">공지사항이미지</h4>
                                  <p class="col_desc"><img src="http://placehold.it/250x150" class="cont_right_img"></p>
                                  <!-- <p class="col_desc rainbow"></span> -->
                          </article>
                          <article class="column col12">
                              <div class="notice25 pr5">
                                  <h5 class="ir_su">Notice1</h5>
                                  <h5>인기글</h5>
                                  <ol type="1" >
                                      <li><a href="#">이줄은 한줄효과입니다.이줄과입니다.[1]</a></li>
                                      <li><a href="#">이줄은 한줄효과입니다이줄은 한줄효과입니다.[3]</a></li>
                                      <li><a href="#">이줄은 한줄효과입입이줄은 한줄효과입니다.</a></li>
                                      <li><a href="#">이줄은 한입니다.한줄효과입니다.[1]</a></li>
                                      <li><a href="#">이줄은 한줄효과입입이줄은 한줄효과입니다.</a></li>
                                  </ol>
                                  <a href="#" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                              </div>
                          </article>
                          <article class="column col13">
                            <div class="notice26 pr5">
                            <h5 class="ir_su">Notice1</h5>
                            <h5>바로가기</h5>
                            <div class="img10"><div class="innerimg10"><a href="#"><img src="img/대양.png"></a></div></div>
                            <div class="img10"><div class="innerimg10"><a href="#"><img src="http://placehold.it/80x80"></a></div></div>
                            <div class="img10"><div class="innerimg10"><a href="#"><img src="http://placehold.it/80x80"></a></div></div>
                            <div class="img10"><div class="innerimg10"><a href="https://sjpt.sejong.ac.kr/main/view/Login/doSsoLogin.do?p="><img src="img/학사정보시스템.png"></a></div></div>
                            <div class="img10"><div class="innerimg10"><a href="#"><img src="img/두드림.png"></a></div></div>
                          <div class="img10"><div class="innerimg10">  <a href="#"><img src="http://placehold.it/80x80"></a></div></div>
                                  <!-- <p class="col_desc rainbow"></span> -->
                            </div>
                          </article>


                          <article class="column col14">
                                  <!-- 검색어: 별점주기 스프링 star rating-->
                                  <!-- https://blog.naver.com/tnakekd/220313628830 -->
                                  <!-- https://miuus.tistory.com/2 -->
                                  <div class="notice27 star_rating pr5">
                                      <h5 class="ir_su">Notice1</h5>
                                      <h5>강의평가</h5>
                                      <ul>
                                          <li class="star_rate"><a href="#"><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i></a></li>
                                          <li class="star_title">강의제목-교수님</li>
                                          <li class="star_content">강의평가내용입니다.강의평가내용입니다.강의평가내용입니다.강의평가내용입니다.강의평가내용입니다.</li>
                                      </ul>

                                      <ul>
                                          <li class="star_rate"><a href="#"><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i></a></li>
                                          <li class="star_title">강의제목-교수님</li>
                                          <li class="star_content">강의평가내용입니다.강의평가내용입니다.강의평가내용입니다.강의평가내용입니다.강의평가내용입니다.</li>
                                      </ul>

                                      <ul>
                                          <li class="star_rate"><a href="#"><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i><i class="fa fa-star" aria-hidden="true"></i></a></li>
                                          <li class="star_title">강의제목-교수님</li>
                                          <li class="star_content">강의평가내용입니다.강의평가내용입니다.강의평가내용입니다.강의평가내용입니다.강의평가내용입니다.</li>
                                      </ul>
                                      <a href="#" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                                  </div>
                          </article>

                         <article class="column col5">
                              <div class="notice28 pr5">
                                  <h5 class="ir_su">Notice1</h5>
                                  <h5>학사일정</h5>
                                  <ul>
                                      <li><a href="#">이줄은 한줄효과입니다.이줄과입니다.[1]</a></li>
                                      <li><a href="#">이줄은 한줄효과입니다이줄은 한줄효과입니다.[3]</a></li>
                                      <li><a href="#">이줄은 한줄효과입입이줄은 한줄효과입니다.</a></li>
                                      <li><a href="#">이줄은 한입니다.한줄효과입니다.[1]</a></li>
                                      <li><a href="#">이줄은 한줄효과입입이줄은 한줄효과입니다.</a></li>
                                  </ul>
                                  <a href="#" class="more" title="더 보기">More <i class="fa fa-plus-circle"></i></a>
                              </div>
                          </article>

                      </section>
              </div>
              </section>