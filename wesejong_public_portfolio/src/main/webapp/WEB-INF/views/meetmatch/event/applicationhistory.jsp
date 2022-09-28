<%-- <%@ include file="../../admin/include/admin_header.jsp" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신청지원내역</title>
<%@ include file="../include/meetmatch_header.jsp" %>
</head>



<style>
    html{overflow: hidden;}
</style>


<fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="today" />  
  
<!-- 출처: https://bbuljj.tistory.com/44 [bbuljj] -->

<body>
    <div class="wrapper">
        <div class="container">
            <div class="page list">
                <!--h1 : mm_explanation연결-->
                <h1 onClick="location.href='/meetmatch/event/explanation'" class="title">MeetMatch</h1>
                <p class="progress">매칭결과는 발표날짜에 공개됩니다.</p>
                <div data-aos="flip-left" class="details">
                    <table border="1px" style="border-color:white">
                        <tr>
                            <td>회차</td>
                            <td>이벤트명</td>
                            <td>성별</td>
                            <td>발표일</td>
                            <td>승인현황</td>
                            <td>매칭결과</td>
                            <!--매칭결과는 성공/실패-->
                        </tr>
                        <c:forEach items="${meetmatchapplicationhistory}" var="meetmatchapplicationhistory">
                        <tr onClick="location.href='/meetmatch/event/applicationdetails?meetmatchteam_seq=<c:out value='${meetmatchapplicationhistory.meetmatchteam_seq}'/>'">
                            <td><c:out value="${meetmatchapplicationhistory.meetmatchmanage_eventid}"/></td>
                            <td><c:out value="${meetmatchapplicationhistory.meetmatchmanage_eventtitle}"/></td>
                        	<td><c:out value="${meetmatchapplicationhistory.meetmatchteam_gender}"/></td>                            		
                            <td><fmt:formatDate pattern="MM/dd HH:mm" value="${meetmatchapplicationhistory.meetmatchmanage_eventreleasedate}"/></td>
							<td><c:out value="${meetmatchapplicationhistory.meetmatchteammate_certifiedcount}"/>/<c:out value="${meetmatchapplicationhistory.meetmatchpersonnelmanage_personnel}"/></td>		
							<td><c:if test="${meetmatchapplicationhistory.meetmatchteam_matchedflag eq 0}">-</c:if>
								<c:if test="${meetmatchapplicationhistory.meetmatchteam_matchedflag eq -1}"><span style="color:red">매칭실패</span></c:if>
								<c:if test="${meetmatchapplicationhistory.meetmatchteam_matchedflag eq 1}"><span style="color:green">매칭성공</span></c:if>
							</td>                            
                        </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="flex"> 
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