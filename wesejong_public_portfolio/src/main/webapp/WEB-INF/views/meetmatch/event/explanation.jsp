<%-- <%@ include file="../../admin/include/admin_header.jsp" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatch explanation</title>
<%@ include file="../include/meetmatch_header.jsp" %>


<%-- 
-수정사항
1. <div class="geeks" onclick="gotoapply_button()"> 
사유 : 버튼에 버튼을 주기 위해서입니다.

 
--%>
<script type="text/javascript">
/* 검색어:javascript button onclick document.location.href */
function gotoapply_button(){
	document.location.href="/meetmatch/event/apply";
}

</script>
</head>
<body>

    <div class="wrapper">
        <div class="container">
            <div class="page">
                <a href="/meetmatch/event/explanation" class="glitch" data-glitch="MEETMATCH">MEETMATCH</a>
            </div>
            <div class="page ex">
              <div data-aos="fade-right"><h1 class="title_kor">세종대 랜덤 미팅 이벤트</h1></div>
              <div data-aos="fade-left"><h1 class="title">MeetMatch</h1></div>
            </div>
            <div class="page ex">
                <div data-aos="zoom-in">
                    <!--h1 : mm_explanation연결-->
                    <h1 onClick="location.href='/meetmatch/event/explanation'" class="title">MeetMatch</h1>
                    <!--<p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Necessitatibus, temporibus esse magni illum</p>-->
                    <p>대면 수업으로 전환된 2022 첫 학기😉</p>
                    <p>학교 갈 생각에 설레는 <span>새내기들</span>과 대학생활을 마음껏 즐기지 못한 <span>헌내기들</span>을 위한 랜덤 미팅</p>
                    <div class="schedule">
                        <p>지원일시 : 3.2(수) 00:00~ 3.15(화) 23:59</p>
                        <p>매칭발표 : 3.16(수) 12:00</p>
                    </div>
                    <!--
                        0. 기획의도
                        1. 대표자가 성별 인원 수 입력->참여자 아이디 입력
                        2. 랜덤매칭
                        3. 결과발표날 공개
                        4. 톡방에서 미팅
                        5. 위세종에 가입해야 가능
                    -->
                </div>
            </div>
            
            <div class="page ex">
                <div data-aos="zoom-out">
                    <h1 class="title">MeetMatch</h1>
                    <p><참여방법></p>
                    <p>1. 위세종 홈페이지 회원가입하기</p>
                    <p>2. 대표자가 성별과 인원 수, 참여자 아이디를 모두 입력!</p>
                    <p>3. 발표날까지 설렘 가득 기다리기</p>
                    <p>4. 결과 발표 후 <span>위세종 대화방</span>에서 미팅 start!</p>
                    <div class="caution">
                    <p>※주의※</p>
                    <p>인원 수는 1:1, 2:2, 4:4만 선택 가능합니다.</p>
                    <p>세종대생만 참여할 수 있습니다.</p>
                    <p>이벤트 참여횟수는 1회로 제한됩니다.</p>
                </div>
                </div>
            </div>
          <div class="page ex">
              <h1>참여하시겠습니까?</h1>
              <br/>
             <!--<button data-glitch="MEETMATCH">yes</button><i class="fas fa-mouse"></i><i class="fa fa-mouse-pointer" aria-hidden="true"></i>--> 
             <div class="geeks" onclick="gotoapply_button()">
                <a onMouseOver='this.innerHTML="Yes"' onMouseOut='this.innerHTML="Yes"' ><i class="fas fa-mouse"></i></a>
            </div>
                            <!--link to history지원목록 보기-->
                <div class="go_list"><a href="/meetmatch/event/applicationhistory"><span>지원목록 보기</span><i class="fa-solid fa-angle-right"></i></a></div>
      </div>
  </div>
  
  <script>
    AOS.init();
    //https://michalsnik.github.io/aos/
  </script>
	
</body>
</html>