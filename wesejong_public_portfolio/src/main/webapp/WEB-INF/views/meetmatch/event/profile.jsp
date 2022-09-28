<%@ include file="../../admin/include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardmanage의 특정 데이터를 조회합니다.</title>


<script type="text/javascript">
function go_profile_submit(){
	document.formm.action="/meetmatch/event/profile";
	document.formm.method = 'post';
	document.formm.submit();
}

</script>
</head>
<body>
	<form name="formm">
		<h1>MeetMatchProfile information check(회원프로필 입력) 이전에 프로필입력했었다면 그 기록을 가져옵니다.
			한번 등록시 수정불가합니다.
		</h1> 
		<span>meetmatchprofile_gender(회원개인성별)</span>
		<c:choose>
			<c:when test="${empty meetmatchprofile.meetmatchprofile_gender}">
				<input type="radio" name="meetmatchprofile_gender" value="male" >male
				<input type="radio" name="meetmatchprofile_gender" value="female">female			
			</c:when>
			<c:when test="${meetmatchprofile.meetmatchprofile_gender eq 'male'}">
				<input type="radio" name="meetmatchprofile_gender" value="male" checked onclick="return(false);">male
				<input type="radio" name="meetmatchprofile_gender" value="female" onclick="return(false);">female			
			</c:when>
			<c:when test="${meetmatchprofile.meetmatchprofile_gender eq 'female'}">
				<input type="radio" name="meetmatchprofile_gender" value="male" onclick="return(false);">male
				<input type="radio" name="meetmatchprofile_gender" value="female" checked onclick="return(false);">female				
			</c:when>
		</c:choose>

		<br/>
		<span>meetmatchprofile_meetmatchdepartment_department(회원소속학과)</span>
		
		<c:choose>
			<c:when test="${empty meetmatchprofile.meetmatchprofile_department}">
				<select name="meetmatchprofile_department">
					<option value="">선택해주세요.</option>
					<c:forEach var="meetmatchdepartment_department" items="${meetmatchdepartment}">
						<option value="${meetmatchdepartment_department.meetmatchdepartment_department}">${meetmatchdepartment_department.meetmatchdepartment_department}</option>
					</c:forEach>
				</select>								
			</c:when>
			<c:when test="${not empty meetmatchprofile.meetmatchprofile_department}">
					<%-- <input type="text" name="meetmatchprofile_department" value="${meetmatchprofile.meetmatchprofile_department}" readonly /> --%>
				<select name="meetmatchprofile_department">
					<!-- <option value="">-----</option> -->
					<c:forEach var="meetmatchdepartment" items="${meetmatchdepartment}">
						<%-- <option value="${meetmatchdepartment.meetmatchdepartment_department}" <c:if test="${meetmatchprofile.meetmatchprofile_department eq meetmatchdepartment.meetmatchdepartment_department}">selected="selected"</c:if>>${meetmatchdepartment.meetmatchdepartment_department}</option> --%>
						<option value="${meetmatchdepartment.meetmatchdepartment_department}" 
						<c:choose>
							<c:when test="${meetmatchprofile.meetmatchprofile_department eq meetmatchdepartment.meetmatchdepartment_department}">
								selected="selected"
							</c:when>
							<c:otherwise>
								disabled
							</c:otherwise>
						 </c:choose>> 
						 ${meetmatchdepartment.meetmatchdepartment_department}</option>
					</c:forEach>
						
				</select>
			</c:when>
		</c:choose>
				
		<br/>
		${meetmatchmanage.meetmatchmanage_seq}
		<input type="hidden" name="mem_seq" readonly="readonly" value="123"/>
		<input type="hidden" name="meetmatchmanage_seq" readonly="readonly" value="${meetmatchmanage.meetmatchmanage_seq}"/>
		<!-- <input type="hidden" name="mem_userid" readonly="readonly" value="mem_userid123"/> -->
		
		<input type="button" value="submit" onclick="go_profile_submit()"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
	
<!-- create table meetmatchprofile(
meetmatchprofile_seq int(11) not null auto_increment primary key,
meetmatchprofile_gender varchar(400) not null,
meetmatchprofile_meetmatchdepartment_department varchar(400) not null default '',
meetmatchprofile_regdate timestamp default current_timestamp,
mem_seq int(11) not null,
mem_userid varchar(400) not null
) -->

</body>
</html>