<%@ include file="../../admin/include/admin_header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardmanage의 특정 데이터를 조회합니다.</title>

<script type="text/javascript">
function go_submit(){
	document.formm.action="/meetmatch/event/apply";
	document.formm.method = 'post';
	document.formm.submit();
}
function send_invitation_button(){
	alert("invitation send");
}
/* Failed to execute 'appendChild' on 'Node' */

 /*검색어:html 태그로 인식하게 하는방법
 * https://okky.kr/article/784139
		var test = document.createElement('input');
		test.setAttribute('type','text');
	검색어:[Javascript] 버튼 이름 변경하기 (버튼 클릭)
	https://hianna.tistory.com/475
 */
function controlPersonnelInputTag(personnel){
    alert(personnel);
    var personnelInputTag_start = document.querySelector('#personnelInputStart');
    
    var child = personnelInputTag_start.lastElementChild;
    while(child){
        personnelInputTag_start.removeChild(child);
        child = personnelInputTag_start.lastElementChild;
    }
    /* From JavaScript, HTML 태그로 변환되서 들어가기 위해서는 변수를 사용하지 않고 직접 써야합니다.
    ex) personnelInputTag_start.innerHTML +=  '<input type="text">'; 
    If From JQuery, $('#testDiv").after('<div id="insertDiv"></div>'); 
  	  로하면 잘될것같음
	personnelInputTag_start.after('<div id="insertDiv"></div>');했을때는 태그로 인식안됨
    (reply.js after를 사용해서 어떻게 잘작동되는지 궁금) */
    
    /*  Using JQuery*/
/*     var test = '<input type="text"/>';
    $('#personnelInputStart').append(test); */
    
    /*  USing JAVASCRIPT*/
/* 	var test = document.createElement('input');
    test.setAttribute('type','text');
    
    var button = document.createElement('input');
    button.setAttribute('type','button');
    button.setAttribute('value','send invitation'); */
    
    for(var i=0;i<personnel-1;i++){
    	var teammate = document.createElement('span');
    	teammate.innerHTML = '참가자'+(i+2)+' : ';
    	
    	var test = document.createElement('input');
        test.setAttribute('type','text');
        test.setAttribute('name','meetmatchteammate_mem_userid');
        test.setAttribute('placeholder','참가자의 아이디를 입력.');
        
        var button = document.createElement('input');
        button.setAttribute('type','button');
        button.setAttribute('value','send invitation');
        
        var br = document.createElement('br');
        personnelInputTag_start.append(teammate, test,button, br);
     	
    }
    

 	
}

</script>
</head>
<body>
<!-- create table meetmatchteam(
meetmatchteam_seq int(11) not null auto_increment primary key,
meetmatchteam_eventid int(11) not null,
meetmatchteam_gender varchar(400) not null,
meetmatchteam_certified int(11) not null default 0,
meetmatchteam_matchedflag int(11) not null default 0, 
meetmatchteam_regdate timestamp default current_timestamp,
meetmatchteam_certifieddate timestamp default null
);

create table meetmatchteammate(
meetmatchteammate_seq int(11) not null auto_increment primary key,
meetmatchteammate_gender varchar(400) not null default '',
meetmatchteammate_department varchar(400) not null default '',
meetmatchteammate_teamleaderflag int(11) not null default 0,
meetmatchteammate_certified int(11) not null default 0,
meetmatchteammate_certifieddate timestamp default null,

meetmatchteam_seq int(11) not null,
meetmatchteam_eventid int(11) not null,
mem_userid varchar(400) not null
); -->

	<c:choose>
		<c:when test="${empty meetmatchprofile}">
			<h1>프로필입력이 완료되지 않았습니다. 프로필 입력 후 다시 시도하시기 바랍니다.</h1>
		</c:when>
		
		<c:when test="${not empty meetmatchprofile}">
		
			<div id="desc">
				<h1>현재 지원하시는 미팅매칭 일정에 대한 설명입니다.</h1>
				<h4>너무 허전해보여서 재확인차원에서 일단 넣었습니다(다시 생각해보기).</h4>
				<h4>추가로, 지원할때 개인정보동의체크 하는것 넣는것도 생각해봅니다.(이유는 있으면 뭔가 믿음이감)</h4>
				<p>
				**설명**
				미팅매칭프로그램은 순간순간미팅프로그램이 성사되는것이아닌
				<br/>
				지원일시가 존재하고, 결과발표일이 따로 존재하도록 합니다.
				<br/>
				이유는 프로그램의 안전성을 위해 그렇습니다.
				<br/>
				<%-- -지원일:<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss [E]" value="${meetmatchmanage.meetmatchmanage_eventstartdate}"/>
				 ~ 
				 <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss [E]" value="${meetmatchmanage.meetmatchmanage_eventenddate}"/> 일주일간 --%>
				-지원일:2020-11-11(월) ~ 2020-11-18(토) 일주일간
				<br/>
				-미팅일시:2020-11-19(일) 1500~1600i 발표
				<br/>
				이번 미팅매칭에서 가능한 인원매칭은 3,4,7,10명입니다.
				
				</p>
			</div>
		
			<form name="formm">
				
				<h1>미팅매칭 이벤트지원서</h1>
				<span>meetmatchteam_gender(미팅매칭 이벤트지원성별)</span>
				<p>프로필에 입력된 성별로 자동 입력됩니다.</p>
				<c:choose>
					<c:when test="${empty meetmatchprofile.meetmatchprofile_gender}">
						<input type="radio" name="meetmatchteam_gender" value="male" >male
						<input type="radio" name="meetmatchteam_gender" value="female">female			
					</c:when>
					<c:when test="${meetmatchprofile.meetmatchprofile_gender eq 'male'}">
						<input type="radio" name="meetmatchteam_gender" value="male" checked onclick="return(false);">male
						<input type="radio" name="meetmatchteam_gender" value="female" onclick="return(false);">female			
					</c:when>
					<c:when test="${meetmatchprofile.meetmatchprofile_gender eq 'female'}">
						<input type="radio" name="meetmatchteam_gender" value="male" onclick="return(false);">male
						<input type="radio" name="meetmatchteam_gender" value="female" checked onclick="return(false);">female				
					</c:when>
				</c:choose>
				
				
				<input type="hidden" name="meetmatchteam_eventid" value="10"/>
			
				
				
				<h1>미팅매칭팀원 입력란</h1>
				<!--meetmatchteammate_gender will be inserted when certify -->
				<!--meetmatchteammate_department will be inserted when certify -->
				<!--meetmatchteam_seq will be inserted in MeetMatchController -->
				<!--meetmatchteam_eventid will be inserted-->
				<p>이번 매칭에 가능한 인원매칭은 
				<c:forEach var="meetmatchpersonnel" items="${meetmatchmanage.meetmatchpersonnelmanagevoList}" begin="0" end="${fn:length(meetmatchmanage.meetmatchpersonnelmanagevoList)}" >
				${meetmatchpersonnel.meetmatchpersonnelmanage_personnel}
				</c:forEach>
				입니다.
				</p>
				<p>같이 행사에 참여할 인원의 아이디를 입력했을때, 중복체크처럼 존재하지 않는지 존재하는지 뜨게할것입니다.
				input옆에 뜨게할지 아니면 아래에 뜨게할지 생각해봅니다.
				<br/>
				
				<label for="select-id">meetmatchpersonnelmanage_personnel</label>
				
				<%-- ${meetmatchmanage.meetmatchpersonnelmanagevoList.length} --%>
				
				<c:if test="${fn:length(meetmatchmanage.meetmatchpersonnelmanagevoList) != 0 } ">
					${fn:length(meetmatchmanage.meetmatchpersonnelmanagevoList)}
				</c:if>
				
				
				<select name="meetmatchpersonnelmanage_personnel" id="meetmatchpersonnelmanage_personnel" onchange="controlPersonnelInputTag(this.value)">
				  <option>선택</option>
				  <c:forEach var="meetmatchpersonnel" items="${meetmatchmanage.meetmatchpersonnelmanagevoList}" begin="0" end="${fn:length(meetmatchmanage.meetmatchpersonnelmanagevoList)}" >
				     <p>번호 : ${meetmatchpersonnel.meetmatchpersonnelmanage_personnel}</p>
				     <option value="${meetmatchpersonnel.meetmatchpersonnelmanage_personnel}">${meetmatchpersonnel.meetmatchpersonnelmanage_personnel}</option>
				  </c:forEach>
				  
				  
<!-- 				  <option>선택</option>
				  <option value="1">1</option>
				  <option value="2">2</option>
				  <option value="3">3</option>
				  <option value="4">4</option> -->
				</select>
				<br/>
				
				<div id="teamleader">
					참가자1 : <input type="text" name="meetmatchteammate_mem_userid" value="mem_userid" readonly="readonly">	
					<button type="button" onclick="send_invitation_button()">CERTIFIED ALREADY </button>				
				</div>
				
				<div id="personnelInputStart">
				
<!-- 					<div>
					<span>TeamMate : </span> <input type="text" name="mem_userid">	
					<button type="button" onclick="send_invitation_button()">send invitation</button>
					</div> -->
				</div>
				<br/>
					
				<input type="hidden" name="meetmatchteam_eventid" value="10"/>		
				<input type="hidden" name="meetmatchmanage_seq" readonly="readonly" value="${meetmatchmanage.meetmatchmanage_seq}"/>
				<input type="button" value="submit" onclick="go_submit()"/>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>		
			
		</c:when>


	</c:choose>
	
	

	

	
</body>
</html>