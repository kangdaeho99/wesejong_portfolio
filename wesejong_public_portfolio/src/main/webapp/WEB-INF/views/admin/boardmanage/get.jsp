<%@ include file="../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardmanage의 특정 데이터를 조회합니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/boardmanage/remove";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_modify(){
	document.formm.action="/admin/boardmanage/modify";
	document.formm.method = 'post';
	document.formm.submit();
}
function go_list(){
	document.formm.action="/admin/boardmanage/list";
	document.formm.method = 'get';
	document.formm.submit();
}
</script>
</head>
<body>

	<form name="formm">	
		
		<span>mbno</span>
		<input type="text" name="mbno" readonly="readonly" value='<c:out value="${boardmanage.mbno}"/>'/>
		<br/>
		<span>board_id</span>
		<input type="text" name="board_id" value='<c:out value="${boardmanage.board_id}"/>'>
		<br/>
		<span>board_name</span>
		<input type="text" name="board_name" value='<c:out value="${boardmanage.board_name}"/>'>
		<br/>
		<span>board_type</span>
		<input type="text" name="board_type" value='<c:out value="${boardmanage.board_type}"/>'>
		<br/>
		<span>board_url</span>
		<input type="text" name="board_url" value='<c:out value="${boardmanage.board_url}"/>'>
		<br/>
		<span>board_desc</span>
		<input type="text" name="board_desc" value='<c:out value="${boardmanage.board_desc}"/>'>
		<span>board_order</span>
		<input type="text" name="board_order" value='<c:out value="${boardmanage.board_order}"/>'>
		<br/>
		<input type="button" value="modify" onclick="go_modify()"/>
		<input type="button" value="remove" onclick="go_remove()"/>
		<input type="button" value="list" onclick="go_list()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
</body>
</html>