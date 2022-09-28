<%-- <%@ include file="../../admin/include/admin_header.jsp" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청결과페이지</title>
<%@ include file="../include/meetmatch_header.jsp" %>
</head>

<style>
    html{overflow: hidden;}
</style>

<body>
    <div class="wrapper">
        <div class="container">
            <div class="page applyresult">
                <!--h1 : mm_explanation연결-->
                <h1 onClick="location.href='/meetmatch/event/explanation'" class="title">MeetMatch</h1>
                <p class="extra_contents" style="color:red">지원이 실패되었습니다.</p>
                <p class="extra_contents">올바르게 지원양식을 입력했는지 확인하세요.
                <br/>-유효하지 않은 아이디로 지원하였을때
                <br/>-한번의 이벤트에 중복으로 신청하였을때
                <br/>-아이디가 유효성검사를 위반하였을때
                <br/>위의 사항들을 확인하시기 바랍니다.</p>
                <div class="flex">
                    <button onclick="location.href='/meetmatch/event/applicationhistory'">지원 목록 보기 </button>
                    <button onclick="location.href='/'">wesju홈</button>
                </div>
            </div>
        </div>
    </div>
        <script>
            AOS.init();
        //https://michalsnik.github.io/aos/
        </script>
</body>
</html>