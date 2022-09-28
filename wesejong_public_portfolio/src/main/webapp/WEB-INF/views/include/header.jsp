<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
	<%@include file="httptohttps.jsp" %>
    <%@include file="webmaster_naver.jsp" %>
    <%@include file="webmaster_google.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <title>위세종</title>
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/69fe52bc75.js" crossorigin="anonymous"></script>
    
    <link rel="stylesheet" type="text/css" href="../../../resources/css/index/link.css">
    <link rel="stylesheet" type="text/css" href="../../../resources/css/chat/chatList.css">
    <link rel="stylesheet" type="text/css" href="../../../resources/css/index/home.css">
    <script src="../../../resources/javascript/chat/chat.js"defer></script>
    <script src="../../../resources/javascript/member/join.js"defer></script>
    <script src="../../../resources/javascript/index/link.js"defer></script>
	<script src="../../../resources/javascript/index/home.js"defer></script>
    <style></style>
    <script>
    function sidebar_logout(){
    	document.sidebarformm.submit();
    }
    function sidebar_right_logout(){
    	document.sidebar_right_formm.submit();	
    }
    function open_sejongtalk(){//아이디찾기 창을 열어줌
    	
    	window.open('/socket/chatcheck?chatroom_uuid=e59e07d4-af89-424a-83a5-12bea863a7c0','_blank','width=580,  height=800, toolbar=no, menubar=no, scrollbars=no, resizable=yes'); return false;
      }
    
    
    </script>

</head>
<%@include file="../include/layerpopup.jsp"%>
<body>

<!-- desktop header -->
  <div class="parallax_page">
    <div id="group2" class="parallax">
    <div class="overlay"></div>
    <header id="header">
        <div class="container">
            <div class="header">
                <div class="header_title">
                    <a href="/" class="header_title_img"><div>위세종<span>wesju</span></div></a>
                    <!-- <a href="#" class="header_title_img"><img src="https://via.placeholder.com/200x60" width="200" height="60" alt="wesejong"/></a> 나중에는 아마 이미지를 사용할것입니다. 이미지 관련해서 아래가 뜨는것은 https://blog.naver.com/jhc9639/222174944051-->
                </div>
                
                <div class="header_search">
                <form name='searchformm' action="/board/list" method="get">
                    <input type="text" name="keyword" placeholder="search..."/>
                    <button type="submit">검색</button>
                    <input type='hidden' name='pageNum' value='1'>
					<input type='hidden' name='amount' value='15'>
                    <input type="hidden" name="board_id" value="999">
                    <input type="hidden" name="type" value="TCW"/>
                </form>
                </div>
                
                <div class="header_menu">
                    <div class="header_menu_intro">
                        <a href="/member/info/alarm" class="header_menu_intro_a notice"><span>알림<c:if test="${new_alarm ne 0}"><span class="unread">˚</span></c:if></span></a>
                        <a href="/member/info/chatroomlist" class="header_menu_intro_a chat"><span>채팅</span></a>
                        <a href="/member/info/mypost" class="header_menu_intro_a mypost"><span>내가쓴글</span></a>
                        <a href="/member/mypage" class="header_menu_intro_a privacypolicy"><span>정보수정</span></a>


						<sec:authorize access="isAnonymous()">
                        <!--로그인 전-->
                        
                        <div class="header_menu_signinbox">
                            <a href="/member/login" class="header_menu_intro_a header_signinbox_span signin"><span>로그인</span></a>
                            <span class="header_menu_intro header_signinbox_span">|</span>
                            <a href="/member/join" class="header_menu_intro_a header_signinbox_span join"><span>회원가입</span></a>
                        </div>
                        
                        </sec:authorize>
                        
                        <sec:authorize access="isAuthenticated()">
                         <!-- 로그인 후 -->
                    	<div class="header_menu_signinbox enter_wesju">
                              <form action="/customLogout" name="sidebarformm" method="post">
                            	  <span class="header_menu_intro_a header_signinbox_span">"<a href="/member/mypage"><sec:authentication property="principal.member.mem_nickname"/></a>"님
                            	  <span class="header_menu_intro header_signinbox_span">|</span>
                            	  <button class="header_menu_intro_a" onclick="sidebar_logout()">로그아웃</button></span>
                              </form> 
                        </div>

                        </sec:authorize>
                        
						</div>
<!--알림목록-->
<%--                 <section>
                  <div class="alarm_list">
                    <table>
                      <tr>
                        <td><span>이용자1가 <a href="#">자유게시판</a> 게시글 "<a href="#">공지사항</a>"에 댓글을 남겼습니다. </span><a href="#" class="alarm_list_cmt"><i class="fas fa-arrow-right"></i> "안녕하세요 컴퓨터공학과 18학번 세종대왕입니다." </a></td><td></td>
                      </tr>
                      <tr>
                        <td><span>관리자로부터 채팅이 왔습니다.</span></td>
                      </tr>
                    </table>
                  </div>
                </section> --%>
<!--채팅목록-->
<%--                 <section>
                  <div class="chat_list">
                    <table>
                      <tr onclick="open_chat()">
                        <td><img src="img/profile.jpg"/></td>
                        <td><span class="contactor">이용자2</span></td>
                      </tr>
                      <tr>
                        <td><img src="img/profile.jpg"/></td>
                        <td><span class="contactor">관리자</span></td>
                      </tr>
                    </table>
                    </div>
                 </section> --%>
<!--내가쓴글 목록-->
<%--                     <section>
                    <div class="post_list">
                      <table>
                        <tr>
                          <td> 선거운동은 각급 선거관리위원회의 관리하에 법률이 정하는 범위안에서 하되, 균등한 기회가 보장되어야 한다.  </td>
                          <td>2015.03.22</td>
                        </tr>
                        <tr>
                          <td><span>공지사항3</span></td>
                          <td>2015.03.22</td>
                        </tr>
                      </table>
                    </div>
                 	 </section> --%>

             	 </div>
                <div class="header_icon">
                    <!-- I have no idea
                    <ul>
                        <li><a href="#"><span>HTML5</span></a></li>
                        <li><a href="#"><span>HTML5</span></a></li>
                        <li><a href="#"><span>HTML5</span></a></li>
                        <li><a href="#"><span>HTML5</span></a></li>
                    </ul>     -->
                </div>

            </div>
        </div>
    </header>

    <!-- mobile header -->
    <header id="mobile_header">
        <div class="mobile_container">
            <div class="mobile_header">
                <div class="mobile_header_sidebar">
                        <!-- https://kutar37.tistory.com/entry/%EC%82%AC%EC%9D%B4%EB%93%9C%EB%B0%94-%EC%99%B8%EB%B6%80%ED%81%B4%EB%A6%AD%EC%8B%9C-%EC%88%A8%EA%B8%B0%EA%B8%B0 -->
                        <!-- http://v2.eyoom.net/bbs/board.php?bo_table=js&wr_id=7 -->
                        <!-- https://www.youtube.com/watch?v=O9l75KOB2pE -->

                    <!-- hamburger left menu -->
                    <a href="#" onclick="drop_down_mobile_menu()"><i class="hamburger sidebarCollapse fas fa-bars 4px"></i></a>

                    <!-- when you click hamburger -->
                    <div class="sidebar">
                    <sec:authorize access="isAnonymous()">
                        <div class="sidebar_signinbox">
                            <a href="/member/join" class="sidebar_signinbox_span signin"><span>회원가입</span></a>
                            <a href="/member/login" class="sidebar_signinbox_span join"><span><i class="fas fa-sign-in-alt 5px"></i>로그인</span></a>
                        </div>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <div class="sidebar_signinbox">
                            <a href="/member/info/mypost" class="sidebar_signinbox_span signin"><span>내가쓴글</span></a>
                            
                            <form action="/customLogout" name="sidebarformm" method="post">
                            	<a href="#" class="sidebar_signinbox_span join" onclick="sidebar_logout()"><span>로그아웃</span></a>
                            </form>
                        </div>
                    </sec:authorize>     

                        <div class="sidebar_nav"></div>
<!--소메뉴 클릭 시 메뉴바 닫히면서 링크따라 이동-->
                        <div class="sidebar_img">
                           <a href="/meetmatch/event/explanation"><img src="../../../resources/img/event_banner.gif"></a>
                        </div>
                        <div class="sidebar_ul">
                            <ul>
                                <li class="parent_menu home"><a href="/"><i class="fas fa-home"></i>HOME</a></li>
                                <li class="parent_menu parent_menu_havesub features"><a href="#"><i class="fas fa-smile"></i>Community><i class="fas fa-angle-up"></i></a>
                                    <ul class="sub_ul sub1">
                                        <li class="sub_menu"><a href="/board/list?board_id=999">전체보기<c:if test="${new_board_id_999 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=102">인기게시판<c:if test="${new_board_id_102 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=103">자유게시판<c:if test="${new_board_id_103 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=104">질문게시판<c:if test="${new_board_id_104 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=105">코딩게시판<c:if test="${new_board_id_105 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=106">홍보게시판<c:if test="${new_board_id_106 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                    </ul>
                                </li>
                                <li class="parent_menu parent_menu_havesub Dashboard"><a href="#"><i class="fas fa-smile"></i>Community><i class="fas fa-angle-up"></i></a>
                                    <ul class="sub_ul sub2">
                                        <!-- <li class="sub_menu"><a href="#" onclick="open_sejongtalk()">세종톡</a></li> -->
                                        <li class="sub_menu"><a href="/board/list?board_id=202">중고거래게시판<c:if test="${new_board_id_202 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=203">일상게시판<c:if test="${new_board_id_203 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=204">연애게시판<c:if test="${new_board_id_204 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=205">고민게시판<c:if test="${new_board_id_205 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=206">정치게시판<c:if test="${new_board_id_206 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                    </ul>
                                </li>
                                <li class="parent_menu parent_menu_havesub Information"><a href="#"><i class="fas fa-smile"></i>College Life<i class="fas fa-angle-up"></i></a>
                                    <ul class="sub_ul sub3">
                                        <li class="sub_menu"><a href="/board/list?board_id=301">새내기<c:if test="${new_board_id_301 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=302">동아리<c:if test="${new_board_id_302 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=303">맛집<c:if test="${new_board_id_303 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=304">스터디<c:if test="${new_board_id_304 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=305">졸업생<c:if test="${new_board_id_305 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=306">자취방<c:if test="${new_board_id_306 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                    </ul>
                                </li>
                                <li class="parent_menu parent_menu_havesub Information"><a href="#"><i class="fas fa-smile"></i>Information<i class="fas fa-angle-up"></i></a>
                                    <ul class="sub_ul sub5">
                                        <li class="sub_menu"><a href="http://www.sejong.ac.kr/unilife/program_01.html?menu_id=1.1">학사일정</a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=402">학생회게시판<c:if test="${new_board_id_402 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="http://www.sejongpr.ac.kr/index.do">학교소식</a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=404">족보<c:if test="${new_board_id_404 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=405">강의평가<c:if test="${new_board_id_405 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="http://www.sejong.ac.kr/unilife/subject_01.html">졸업요건</a></li>
                                    </ul>
                                </li>
                                <li class="parent_menu parent_menu_havesub Guide"><a href="#"><i class="fas fa-smile"></i>Guide<i class="fas fa-angle-up"></i></a>
                                    <ul class="sub_ul sub5">
                                        <li class="sub_menu"><a href="/board/list?board_id=501">취업후기<c:if test="${new_board_id_501 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=502">학업상담<c:if test="${new_board_id_502 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=503">공지사항<c:if test="${new_board_id_503 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=504">문의사항<c:if test="${new_board_id_504 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                        <li class="sub_menu"><a href="https://forms.gle/iEWf65gXDYbje3Ay9">피드백하기</a></li>
                                        <li class="sub_menu"><a href="/board/list?board_id=506">369게임<c:if test="${new_board_id_506 eq 1}"><span class="new_post mb_new_post">&nbspnew</span></c:if></a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="mobile_header_title">
                    <a href="/" class="mobile_header_title_img"><span class="kor_logo">위세종</span><span class="mobile_span">wesju</span></a>
                </div>

              <div class="mobile_header_sidebar2">
              	<sec:authorize access="isAnonymous()">
                	<a href="/member/login" class="mobile_signin_a mobile_header_signinbox_span signin" onclick=""><i class="fas fa-fingerprint"></i></a>
                </sec:authorize>
              	<sec:authorize access="isAuthenticated()">
              		<a href="#" class="mobile_signin_a mobile_header_signinbox_span signin" onclick="drop_down_mobile_menu_right()"><i class="fas fa-fingerprint"></i><c:if test="${new_alarm ne 0}"><span class="unread">˚</span></c:if></a>
              	</sec:authorize>
                <div class="sidebar_right">
                      <ul>
                          <li><a href="/member/info/alarm"><i class="fa fa-bell-o"></i>알림<c:if test="${new_alarm ne 0}"><span class="unread_alarm alarm_cnt"><c:out value="${new_alarm}"/></span></c:if></a></li>
                          <li><a href="/member/info/chatroomlist"><i class="fa fa-commenting" aria-hidden="true"></i>채팅</a></li>
                          <li><a href="/member/info/mypost"><i class="fa fa-pencil-square-o" aria-hidden="true"></i>내가쓴글</a></li>
                          <li><a href="/member/mypage"><i class="fa fa-info-circle" aria-hidden="true"></i>정보수정</a></li>
                          <li><form action="/customLogout" name="sidebar_right_formm" method="post"><a href="#" onclick="sidebar_right_logout()"><i class="fa fa-info-circle" aria-hidden="true" ></i>로그아웃</a></form></li>
                          
                      </ul>
                  <div class="sidebar_img2"><img src="../../../resources/img/교포1.jpg"></div>

                </div>
                <!--<i class="far fa-bell"></i>-->
            </div>
          </div>
        </div>
    </header>