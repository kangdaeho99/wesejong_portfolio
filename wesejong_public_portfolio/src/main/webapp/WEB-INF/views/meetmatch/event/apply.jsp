<%-- <%@ include file="../../admin/include/admin_header.jsp" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>boardmanage의 특정 데이터를 조회합니다.</title>

<%@ include file="../include/meetmatch_header.jsp" %>

<script type="text/javascript">
function go_submit(){
	if(mm_submit() == false){
		return false;
	}
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

 document.addEventListener("DOMContentLoaded", function(event){
	 
	 /* alert(document.querySelector('select[name=meetmatchpersonnelmanage_personnel]').value); */
	controlPersonnelInputTag(document.querySelector('select[name=meetmatchpersonnelmanage_personnel]').value);
	 is_mem_userid_duplication_check = true;
 });
 
function controlPersonnelInputTag(personnel){
	is_mem_userid_duplication_check = false;
    /* alert(personnel); */
    var personnelInputTag_start = document.querySelector('#personnelInputStart');
    
    var child = personnelInputTag_start.lastElementChild;
    while(child){
        personnelInputTag_start.removeChild(child);
        child = personnelInputTag_start.lastElementChild;
    }
   
    for(var i=0;i<parseInt(personnel)-1;i++){
    	var div = document.createElement('div');
    	div.setAttribute('class','inrow input_check chk'+(i+1));
    	/* div.setAttribute('display','flex'); */
    	
    	/* function a(this)식으로 사용해야 this가 객체 전체를 가져옵니다. */
    	var input = document.createElement('input');
    	input.setAttribute('type','text');
    	input.setAttribute('name','meetmatchteammate_mem_userid');
    	input.setAttribute('onkeyup','mem_userid_duplication_check(this)');
    	
    	
    	var i_tag = document.createElement('i');
    	i_tag.setAttribute('class','fa-solid fa-check');
    	/* i_tag.setAttribute('display','flex'); */
    	
    	var nbsp = document.createElement('div');
    	nbsp.innerHTML += ' &nbsp;'; 
    	
    	var br = document.createElement('br');
    	
    	div.append(input,nbsp,i_tag,br);
		
    	personnelInputTag_start.append(div);    	

    }
}
/*     	var teammate = document.createElement('span');
    	teammate.innerHTML = '참가자'+(i+2)+' : ';
    	
    	var test = document.createElement('input');
        test.setAttribute('type','text');
        test.setAttribute('name','meetmatchteammate_mem_userid');
        test.setAttribute('placeholder','참가자의 아이디를 입력.');
        
        var button = document.createElement('input');
        button.setAttribute('type','button');
        button.setAttribute('value','send invitation');
        
        var br = document.createElement('br');
        personnelInputTag_start.append(teammate, test,button, br); */
     	

    
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
    

    

</script>
</head>
<body>

<form name="formm">

   <div class="wrapper">
        <div class="container">
            <div class="page">
                <h1 class="title"><a href="/meetmatch/event/explanation">MeetMatch</a></h1>
                <div class="inrow">
                    <p class="select_date">성별을 입력해주세요</p>
                    <c:choose>
					<c:when test="${empty meetmatchprofile.meetmatchprofile_gender}">
	                    <input type="radio" value="male" id="meetmatchteam_gender_male" name="meetmatchteam_gender"><label>male</label>
	                    &nbsp
	                    <input type="radio" value="female" id="meetmatchteam_gender_female" name="meetmatchteam_gender"><label>female</label>
					</c:when>
					<c:when test="${meetmatchprofile.meetmatchprofile_gender eq 'male'}">
	                    <input type="radio" value="male" id="meetmatchteam_gender_male"  name="meetmatchteam_gender" checked onclick="return(false);"><label>male</label>
	                    &nbsp
	                    <input type="radio" value="female" id="meetmatchteam_gender_female" name="meetmatchteam_gender" onclick="return(false);"><label>female</label>
					</c:when>
					<c:when test="${meetmatchprofile.meetmatchprofile_gender eq 'female'}">
	                    <input type="radio" value="male" id="meetmatchteam_gender_male" name="meetmatchteam_gender" onclick="return(false);"><label>male</label>
	                    &nbsp
	                    <input type="radio" value="female" id="meetmatchteam_gender_female" name="meetmatchteam_gender" checked onclick="return(false);"><label>female</label>				
					</c:when>
					</c:choose>

                    
                </div>
                <div class="inrow"> 
                    <label>개인정보 제공에 동의하십니까?&nbsp</label>
                    <input onclick="collect_personal()" type="checkbox" class="agree">
                    <label>Yes</label>
                </div>
                <!--다음 페이지 넘어감-->
                <div class="turn_next"><a href="#page2"><i class="fa-solid fa-angle-down"></i></a></div>
            </div>
            
            
            <!-- 			    -->
            <!-- 인원선택하는 칸  -->
            <!--  			    -->
            <div class="page">
                    <a name="page2">
                        <h1 class="title">MeetMatch</h1>
                    </a>
                <div data-aos="flip-left" class="select_data">
                    <div class="inrow select">
                        <p class="select_date">인원을 선택해주세요</p>
                        <select class="personnel" name="meetmatchpersonnelmanage_personnel" onchange="controlPersonnelInputTag(this.value)">
							<c:forEach var="meetmatchpersonnel" items="${meetmatchmanage.meetmatchpersonnelmanagevoList}" begin="0" end="${fn:length(meetmatchmanage.meetmatchpersonnelmanagevoList)}">
                            	<option value="${meetmatchpersonnel.meetmatchpersonnelmanage_personnel}">${meetmatchpersonnel.meetmatchpersonnelmanage_personnel}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    
                    <div class="enter_info">
                    <label>멤버 아이디</label>

                            <!--input의 id가 유효하면 i에 display:flex 처리-->
                             <div class="inrow input_check chk1">
                                <input type="text" name="meetmatchteammate_mem_userid" value="<sec:authentication property='principal.member.mem_userid'/>" onkeyup="mem_userid_duplication_check(this)" readonly="readonly"><div>&nbsp</div><i class="fa-solid fa-check" style="display:flex"></i>
                            </div>
                            
                            <div class="info" id="personnelInputStart">
                            <!-- 
                            <div class="inrow input_check chk2">
                                <input type="text">&nbsp<i class="fa-solid fa-check"></i>
                            </div>
                            <div class="inrow input_check chk3">
                                <input type="text">&nbsp<i class="fa-solid fa-check"></i>
                            </div>
                            <div class="inrow input_check chk4">
                                <input type="text">&nbsp<i class="fa-solid fa-check"></i>
                            </div> -->
                        </div>
                    </div>
                </div>
                <div class="geeks submit">
                    <!--아이디 유효하지 않으면 제출 못 함-->
                    <a href="#"  onclick="go_submit()"onMouseOver='this.innerHTML="Submit"' onMouseOut='this.innerHTML="Submit"'><i class="fas fa-mouse"></i></a>
                </div>
            </div>
        </div>
    </div>
    
    
</form>
    <script>
        AOS.init();
        //https://michalsnik.github.io/aos/
    </script>

	
</body>
</html>