<%@ include file="../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardmanage 테이블 데이터의 목록을 보여줍니다.</title>
<script type="text/javascript">
function go_submit(){
	document.form.action = "/admin/boardmanage/register";
	document.form.method = 'post';
	document.form.submit();
}
function go_remove(){
	document.formm.action="/admin/boardmanage/removebychkbox";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>boardmanage 데이터등록</h1>
	<p>
		주의사항:board_type 관련해서 화면단이동 BoardController에서 변경합니다.
		board_type:1 -> 일반게시판
		board_type:2 -> 인기게시판
		board_type:3 -> 전체게시판
		board_order : 게시글 작성할시 게시판 보여지는 순서
	</p>
	<form name="form">		
		<span>board_id</span>
		<input type="text" name="board_id" placeholder="board_id">
		
		<span>board_name</span>
		<input type="text" name="board_name" placeholder="자유">
		
		<span>board_type</span>
		<input type="text" name="board_type" placeholder="1:기본,2:파일">
		
		<span>board_url</span>
		<input type="text" name="board_url" placeholder="board_url">

		<span>board_desc</span>
		<input type="text" name="board_desc" placeholder="board_desc">

		<span>board_order</span>
		<input type="text" name="board_order" placeholder="board_order">
		
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
					<th>mbno</th>
					<th>board_id</th>
					<th>board_name</th>
					<th>board_type</th>
					<th>board_url</th>
					<th>board_desc</th>
					<th>board_order</th>
				</tr>
			</thead>
			
			<c:forEach items="${boardmanagelist}" var="boardmanage">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${boardmanage.mbno}"/></td>
					<td><c:out value="${boardmanage.mbno}"/></td>
					<td><c:out value="${boardmanage.board_id}"/></td>
					<td><a href="/admin/boardmanage/get?mbno=<c:out value="${boardmanage.mbno}"/>"><c:out value="${boardmanage.board_name}"/></a></td>
					<td><c:out value="${boardmanage.board_type}"/></td>
					<td><a href="/board/list?board_id=<c:out value="${boardmanage.board_id}"/>"><c:out value="${boardmanage.board_url}"/></a></td>
					<td><c:out value="${boardmanage.board_desc}"/></td>
					<td><c:out value="${boardmanage.board_order}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>