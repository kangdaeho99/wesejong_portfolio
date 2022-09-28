<%@ include file="../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board 테이블 데이터의 목록을 보여줍니다.</title>
<script type="text/javascript">
function go_submit(){
	document.form.action = "/admin/board/register";
	document.form.method = 'post';
	document.form.submit();
}
function go_remove(){
	document.formm.action="/admin/board/removebychkbox";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>board게시판글 삭제와 공지사항 등록을 위한 페이지입니다.</h1>
	<p>
	300개까지 볼수있습니다.
	</p>
	
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
					<th>bno</th>
					<th>board_id</th>
					<th>title</th>
					<th>notice</th>
				</tr>
			</thead>
			
			<c:forEach items="${boardnoticelist}" var="board">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${board.bno}"/></td>
					<td><c:out value="${board.bno}"/></td>
					<td><c:out value="${board.board_id}"/></td>
					<td><a href="/admin/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/></a></td>
					<td><c:out value="${board.notice}"/></td>
				</tr>
			</c:forEach>
			
			<thead>
				<tr>
					<th><input type="checkbox"/></th>
					<th>bno</th>
					<th>board_id</th>
					<th>title</th>
					<th>notice</th>
				</tr>
			</thead>
			
			<c:forEach items="${boardlist}" var="board">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${board.bno}"/></td>
					<td><c:out value="${board.bno}"/></td>
					<td><c:out value="${board.board_id}"/></td>
					<td><a href="/admin/board/get?bno=<c:out value="${board.bno}"/>"><c:out value="${board.title}"/></a></td>
					<td><c:out value="${board.notice}"/></td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <input type="button" value="remove" onclick="go_remove()"/>
	</form>
</body>
</html>