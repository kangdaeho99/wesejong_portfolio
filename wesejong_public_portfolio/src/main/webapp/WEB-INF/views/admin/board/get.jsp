<%@ include file="../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board의 특정 데이터를 조회합니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/board/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	document.formm.action="/admin/board/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/board/list";
	document.formm.method = 'get';
	document.formm.submit();
}
</script>
</head>
<body>

	<form name="formm">	
		<span>bno</span>
		<input type="text" name="bno" readonly="readonly" value='<c:out value="${board.bno}"/>'/>
		<br/>
		<span>board_id</span>
		<input type="text" name="board_id" value='<c:out value="${board.board_id}"/>'>
		<br/>
		<span>title</span>
		<input type="text" name="title" value='<c:out value="${board.title}"/>'>
		<span>content</span>
		<input type="text" name="content" value='<c:out value="${board.content}"/>'>
		<br/>
		<span>notice</span>
		<input type="text" name="notice" value='<c:out value="${board.notice}"/>'>
		<br/>
		<input type="button" value="modify" onclick="go_modify()"/>
		<input type="button" value="remove" onclick="go_remove()"/>
		<input type="button" value="list" onclick="go_list()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>