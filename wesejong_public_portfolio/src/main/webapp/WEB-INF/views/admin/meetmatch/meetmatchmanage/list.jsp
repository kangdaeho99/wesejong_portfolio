<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchmanage 테이블 데이터의 목록을 보여줍니다.</title>
<script type="text/javascript">
function go_submit(){
	document.form.action = "/admin/meetmatch/meetmatchmanage/register";
	document.form.method = 'post';
	document.form.submit();
}

function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchmanage/removebychkbox";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>meetmatchmanage 데이터등록</h1>
	<p>
		주의사항
	</p>
	<form name="form">		
		<span>meetmatchmanage_eventid</span>
		<input type="text" name="meetmatchmanage_eventid" placeholder="eventid:10,11,12">
		
		<span>meetmatchmanage_eventtitle</span>
		<input type="text" name="meetmatchmanage_eventtitle" placeholder="이벤트 제목">
		
		<span>meetmatchmanage_eventcontent</span>
		<input type="text" name="meetmatchmanage_eventcontent" placeholder="이벤트 내용">
		
		<br/>
		
		<span>meetmatchmanage_eventstartdate</span>
		<input type="datetime-local"  name="meetmatchmanage_eventstartdate" placeholder="이벤트 시작일">
		
		<span>meetmatchmanage_eventenddate</span>
		<input type="datetime-local"  name="meetmatchmanage_eventenddate" placeholder="이벤트 종료일">

		<span>meetmatchmanage_eventreleasedate</span>
		<input type="datetime-local"  name="meetmatchmanage_eventreleasedate" placeholder="이벤트 결과발표일">
		
		<span>meetmatchmanage_eventendflag</span>
		<input type="text" name="meetmatchmanage_eventendflag" placeholder="이벤트 종료확인(0:진행,1:종료)">
		
		<input type="submit" value="submit" onclick="go_submit()">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
	<form name="formm" method="post">
		<table border="1">
			<colgroup>
<!-- 				<col width="100px">
				<col width="100px">
				<col width="100px">
				<col width="100px">
				<col width="100px"> -->
			</colgroup>
			
			<thead>
				<tr>
					<th><input type="checkbox"/></th>
					<th>seq</th>
					<th>eventid</th>
					<th>eventtitle</th>
					<th>eventcontent</th>
					
					<th>eventregdate</th>
					<th>eventupdatedate</th>
					<th>eventstartdate</th>
					<th>eventenddate</th>
					<th>eventreleasedate</th>
					
					<th>eventendflag</th>
					
					<!-- <th>meetmatchpersonnelmanage_seq</th> -->
					<th>meetmatchpersonnelmanage_personnel</th>

				</tr>
			</thead>
			
			<c:forEach items="${meetmatchmanagelist}" var="meetmatchmanage">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${meetmatchmanage.meetmatchmanage_seq}"/></td>
					<td><c:out value="${meetmatchmanage.meetmatchmanage_seq}"/></td>
					<td><c:out value="${meetmatchmanage.meetmatchmanage_eventid}"/></td>
					<td><a href="/admin/meetmatch/meetmatchmanage/get?meetmatchmanage_seq=<c:out value="${meetmatchmanage.meetmatchmanage_seq}"/>"><c:out value="${meetmatchmanage.meetmatchmanage_eventtitle}"/></a></td>
					<td><c:out value="${meetmatchmanage.meetmatchmanage_eventcontent}"/></td>
					
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
									value="${meetmatchmanage.meetmatchmanage_eventregdate}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
									value="${meetmatchmanage.meetmatchmanage_eventupdatedate}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
									value="${meetmatchmanage.meetmatchmanage_eventstartdate}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
									value="${meetmatchmanage.meetmatchmanage_eventenddate}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" 
									value="${meetmatchmanage.meetmatchmanage_eventreleasedate}"/></td>					
					<td><c:out value="${meetmatchmanage.meetmatchmanage_eventendflag}"/></td>
					
					<td><c:forEach items="${meetmatchmanage.meetmatchpersonnelmanagevoList}" var="meetmatchpersonnelmanagevoList">
						 <c:out value="${meetmatchpersonnelmanagevoList.meetmatchpersonnelmanage_personnel}"/>명
					</c:forEach></td>
					
					
					<%-- <td><c:out value="${meetmatchmanage.meetmatchpersonnelmanagevoList[0].meetmatchpersonnelmanage_seq}"/></td>
					<td><c:out value="${meetmatchmanage.meetmatchpersonnelmanagevoList[0].meetmatchpersonnelmanage_personnel}"/></td> --%>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>