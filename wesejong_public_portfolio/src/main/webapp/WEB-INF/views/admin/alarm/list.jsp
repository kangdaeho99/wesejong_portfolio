<%@ include file="../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>alarm 테이블 데이터의 목록을 보여줍니다.</title>
<script type="text/javascript">
function go_submit(){
	document.form.action = "/admin/alarm/register";
	document.form.method = 'post';
	document.form.submit();
}
function go_remove(){
	document.formm.action="/admin/alarm/removebychkbox";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>alarm 데이터등록</h1>
	<p>

	</p>
	<form name="form">		
		<span>alarm_title</span>
		<input type="text" name="alarm_title" placeholder="alarm_title">
		
		<span>alarm_writer</span>
		<input type="text" name="alarm_writer" placeholder="자유">
		
		<span>alarm_content</span>
		<input type="text" name="alarm_content" placeholder="1:기본,2:파일">
		
		<span>alarm_type</span>
		<input type="text" name="alarm_type" placeholder="alarm_type">

		<span>mem_seq</span>
		<input type="text" name="mem_seq" placeholder="mem_seq">
		
		<input type="button" value="submit" onclick="go_submit()">
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
					<th>alarm_seq</th>
					<th>alarm_title</th>
					<th>alarm_writer</th>
					<th>alarm_content</th>
					<th>alarm_type</th>
					<th>alarm_regdate</th>
					<th>alarm_readcheck</th>
					<th>mem_seq</th>
				</tr>
			</thead>
			
			<c:forEach items="${alarmlist}" var="alarm">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${alarm.alarm_seq}"/></td>
					<td><c:out value="${alarm.alarm_seq}"/></td>
					<td><c:out value="${alarm.alarm_title}"/></td>
					<td><a href="/admin/alarm/get?alarm_seq=<c:out value="${alarm.alarm_seq}"/>"><c:out value="${alarm.alarm_writer}"/></a></td>
					<td><c:out value="${alarm.alarm_content}"/></td>
					<td><a href="/board/list?alarm_title=<c:out value="${alarm.alarm_title}"/>"><c:out value="${alarm.alarm_type}"/></a></td>
					<td><fmt:formatDate pattern="YYYY-MM-dd HH:mm:ss" value="${alarm.alarm_regdate}"/></td>
					<td><c:out value="${alarm.alarm_readcheck}"/></td>
					<td><c:out value="${alarm.mem_seq}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>