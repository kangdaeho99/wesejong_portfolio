<%-- <%@ include file="../../admin/include/admin_header.jsp" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초대승인현황</title>
<%@ include file="../include/meetmatch_header.jsp" %>
<script>

	function go_certify_button(){
		document.certifyformm.action = '/meetmatch/event/applicationdetails_confirm';
		document.certifyformm.method = 'post';
		document.certifyformm.submit();
	}


    //진행현황 퍼센티지
    window.onload = function () { document.getElementById('jb').value = '25';  }
</script>
</head>
<style>
    .page{height:90vh;}/*상단 뒤로가기 버튼 공간*/
</style>
<body>
    <div class="wrapper">
        <div class="container">
            <!--a : mm_applicationhistory.html: 목록으로 돌아가기-->
            <a href="/meetmatch/event/applicationhistory"><i class="fa-solid fa-arrow-left"></i></a>
            <div class="page">
                <!--h1 : mm_explanation연결-->
                <h1 onClick="location.href='/meetmatch/event/explanation'" class="title">MeetMatch</h1>
                <p class="progress">매칭결과는 발표날에 공개됩니다.</p>
                <div data-aos="flip-left" class="details">
                    <!-- <progress id="jb" value="0" min="10" max="100"></progress> -->

                    <table border="1px" style="table-layout: fixed;border-color:white">
                        <tr>
                            <td style="width:35%;">지원자 id</td>
                            <td>성별</td>
                            <!--매칭결과는 성공/실패-->
                            <td>지원날짜</td>
                            <td>승인여부</td>
                            <td>매칭결과</td>
                        </tr>
                        <!--본인은 border로 효과줌-->
                        <sec:authentication property="principal.member.mem_userid" var="mem_userid"/>
                        <c:forEach items="${meetmatchapplicationdetails}" var="meetmatchapplicationdetails">
                        	<tr <c:if test="${meetmatchapplicationdetails.mem_userid eq mem_userid}">style="border: 2px rgb(37, 206, 206) solid;"</c:if>>
	                            <td><c:out value="${meetmatchapplicationdetails.mem_userid}"/></td>
	                            <td><c:out value="${meetmatchapplicationdetails.meetmatchteammate_gender}"/></td>
	                            <td><fmt:formatDate pattern="MM/dd HH:mm" value="${meetmatchapplicationdetails.meetmatchteaammate_regdate}"/></td>
	                            <td><c:if test="${meetmatchapplicationdetails.meetmatchteammate_certified eq 1}">O</c:if><c:if test="${meetmatchapplicationdetails.meetmatchteammate_certified eq 0}">-</c:if></td>
	                            <td><c:if test="${meetmatchapplicationdetails.meetmatchteam_matchedflag eq 0}">-</c:if>
									<c:if test="${meetmatchapplicationdetails.meetmatchteam_matchedflag eq -1}"><span style="color:red">매칭실패</span></c:if>
									<c:if test="${meetmatchapplicationdetails.meetmatchteam_matchedflag eq 1}"><span style="color:green">매칭성공</span></c:if>
	                            </td>                        	
                        	</tr>
                        </c:forEach>
                    </table>
                </div>
                
                <form name="certifyformm">
                <div class="flex"> 
                    <!--참여 버튼 클릭 후에는 취소하기 버튼으로 변함-->
                    <c:forEach items="${meetmatchapplicationdetails}" var="meetmatchapplicationdetails">
                    	<c:if test="${meetmatchapplicationdetails.mem_userid eq mem_userid}">
                    		<c:if test="${meetmatchapplicationdetails.meetmatchteammate_certified eq 0}">
                    			<button type="button" onclick="go_certify_button()">참여하기</button>		
                    		</c:if>
                    		<c:if test="${meetmatchapplicationdetails.meetmatchteammate_certified eq 1}">
                    			<button type="button" onclick="go_certify_button()">취소하기</button>		
                    		</c:if>                    		
                    	</c:if>
                    </c:forEach>                    
                    <input type="hidden" name="meetmatchteam_seq" value="${meetmatchteam.meetmatchteam_seq}"/>
                </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        AOS.init();
        //https://michalsnik.github.io/aos/
    </script>
	
</body>
</html>