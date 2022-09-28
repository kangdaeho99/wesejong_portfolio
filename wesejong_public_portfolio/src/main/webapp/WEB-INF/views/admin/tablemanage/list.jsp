<%@ include file="../include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardmanage 테이블 데이터의 목록을 보여줍니다.</title>
<script type="text/javascript">
function go_remove(){
	document.formm.action="/admin/boardmanage/removebychkbox";
	document.formm.submit();
}
</script>
</head>
<body>
	<h1>table 목록조회</h1>
	<p>
		주의사항
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
					<th>table</th>
				</tr>
			</thead>
			
			<c:forEach items="${tablelist}" var="table_name">
				<tr>
					<td><input type="checkbox" name="chkbox" value="${table_name}"/></td>
					<td>
						<a href="${pageContext.request.contextPath}/admin/tablemanage/get?table_name=<c:out value="${table_name}"/>">
						<c:out value="${table_name}"/></a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
	    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    <!-- <input type="button" value="remove" onclick="go_remove()"/> -->
	</form>
</body>
</html>