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
                <p class="extra_contents">지원이 완료되었습니다.</p>
                <p class="extra_contents">매칭에 성공하면 결과 발표날 자동으로 대화방에 초대됩니다.</p>
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