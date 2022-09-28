<%@ include file="../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>alarm의 특정 데이터를 조회합니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/alarm/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	document.formm.action="/admin/alarm/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/alarm/list";
	document.formm.method = 'get';
	document.formm.submit();
}
</script>
</head>
<body>

	<form name="formm">	
		
		<span>alarm_seq</span>
		<input type="text" name="alarm_seq" readonly="readonly" value='<c:out value="${alarm.alarm_seq}"/>'/>
		<br/>
		<span>alarm_title</span>
		<input type="text" name="alarm_title" value='<c:out value="${alarm.alarm_title}"/>'>
		<br/>
		<span>alarm_writer</span>
		<input type="text" name="alarm_writer" value='<c:out value="${alarm.alarm_writer}"/>'>
		<br/>
		<span>alarm_content</span>
		<input type="text" name="alarm_content" value='<c:out value="${alarm.alarm_content}"/>'>
		<br/>
		<span>alarm_type</span>
		<input type="text" name="alarm_type" value='<c:out value="${alarm.alarm_type}"/>'>
		<br/>
<%-- 		<span>alarm_regdate</span>
		<input type="text" name="alarm_regdate" value='<c:out value="${alarm.alarm_regdate}"/>'> --%>
		<span>alarm_readcheck</span>
		<input type="text" name="alarm_readcheck" value='<c:out value="${alarm.alarm_readcheck}"/>'>
		<span>mem_seq</span>
		<input type="text" name="mem_seq" value='<c:out value="${alarm.mem_seq}"/>'>
		<br/>
		
		<input type="button" value="modify" onclick="go_modify()"/>
		<input type="button" value="remove" onclick="go_remove()"/>
		<input type="button" value="list" onclick="go_list()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>