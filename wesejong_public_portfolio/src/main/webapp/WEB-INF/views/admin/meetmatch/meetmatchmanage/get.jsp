<%@ include file="../../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>meetmatchmanage의 특정 데이터를 조회합니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/meetmatch/meetmatchmanage/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	document.formm.action="/admin/meetmatch/meetmatchmanage/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/meetmatch/meetmatchmanage/list";
	document.formm.method = 'get';
	document.formm.submit();
}
</script>
</head>
<body>

	<form name="formm">	
		
		<span>meetmatchmanage_seq</span>
		<input type="text" name="meetmatchmanage_seq" readonly="readonly" value='<c:out value="${meetmatchmanage.meetmatchmanage_seq}"/>'/>
		<br/>
		<span>meetmatchmanage_eventid</span>
		<input type="text" name="meetmatchmanage_eventid" value='<c:out value="${meetmatchmanage.meetmatchmanage_eventid}"/>'>
		<br/>
		<span>meetmatchmanage_eventtitle</span>
		<input type="text" name="meetmatchmanage_eventtitle" value='<c:out value="${meetmatchmanage.meetmatchmanage_eventtitle}"/>'>
		<br/>
		<span>meetmatchmanage_eventcontent</span>
		<input type="text" name="meetmatchmanage_eventcontent" value='<c:out value="${meetmatchmanage.meetmatchmanage_eventcontent}"/>'>
		<br/>
		<!-- 
		검색어:Date 타입을 datetime-local
		https://velog.io/@litien/datetime-local-issue
		 -->
		<span>meetmatchmanage_eventstartdate</span>
		<input type="datetime-local"  name="meetmatchmanage_eventstartdate" value='<c:out value="${meetmatchmanage.meetmatchmanage_eventstartdate}"/>'>
		<br/>
		<span>meetmatchmanage_eventenddate</span>
		<input type="datetime-local"  name="meetmatchmanage_eventenddate" value='<c:out value="${meetmatchmanage.meetmatchmanage_eventenddate}"/>'>
		<br/>
		<span>meetmatchmanage_eventreleasedate</span>
		<input type="datetime-local"  name="meetmatchmanage_eventreleasedate" value='<c:out value="${meetmatchmanage.meetmatchmanage_eventenddate}"/>'>
		<br/>
		<span>meetmatchmanage_eventendflag</span>
		<input type="text" name="meetmatchmanage_eventendflag" value='<c:out value="${meetmatchmanage.meetmatchmanage_eventendflag}"/>'>
		<br/>
		<input type="button" value="modify" onclick="go_modify()"/>
		<input type="button" value="remove" onclick="go_remove()"/>
		<input type="button" value="list" onclick="go_list()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>