/**
 * 
 */

/******************************************************************/
/******************************************************************/
/*							BackEnd								  */
/*																  */
/*						 	forgot ID						      */
/******************************************************************/
/******************************************************************/

function forgot_mem_userid_sendEmail_mem_userid_by_mem_email(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				console.log(xhr.response);
				if(xhr.response == '1'){
					
//					alert("발송성공여");
				} else if(xhr.response == '-1'){
//					alert("발송실패여");
				}			
			}else{
//				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
			}
		}
	};
	
	var mem_email = document.getElementById('find_id_mem_email').value;
	var data = {
			mem_email : mem_email
	};
	xhr.open('post'
			,'/member/forgot/sendEmail_mem_userid_by_mem_email'	
//			,false);
			,true); //	동기 방식을 통해 비동기의 오류발생가능성 없애기
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send(JSON.stringify(data));
}

/******************************************************************/
/******************************************************************/
/*							Front								  */
/*																  */
/*							forgot ID						      */
/******************************************************************/
/******************************************************************/
function forgot_mem_userid_emailcerti(){//아이디찾기 - 이메일 인증
	
	forgot_pw_is_mem_email_certification_check = false;
	
    var pt = /[@]/;
    if(document.querySelector('#find_id_mem_email').value=="") {
    	alert('이메일을 입력하세요.');
    }else if(!pt.test(document.querySelector('#find_id_mem_email').value)){
      alert('도메인을 입력해주세요');
    }else{
    alert('입력한 이메일로 아이디가 발송되었습니다.\n일치하지 않는 아이디가 없다면 발송되지 않습니다.');
//    const email=document.querySelector('#cor_mem_email');
//    const btn=document.querySelector('.email_cert_btn');
//    email.style.display="block";
//    btn.style.display="block";
    forgot_mem_userid_sendEmail_mem_userid_by_mem_email();
//    timer();
  }
}


/******************************************************************/
/******************************************************************/
/*							BackEnd								  */
/*																  */
/*						 	forgot PW						      */
/******************************************************************/
/******************************************************************/

var forgot_pw_is_mem_email_certification_check = false;
var forgot_pw_is_mem_email_change_check = false;

function forgot_pw_formvalidation(){
	if(document.querySelector('#find_pw_mem_email').length == 0){
		alert('이메일값을 입력하세요.'); return false;
	} else if(document.querySelector('#mem_password').length == 0){
		alert('새비밀번호를 입력하세요.'); return false;
	} else if(document.querySelector('#cor_mem_password').length == 0){
		alert('새비밀번호를 다시 입력하세요.'); return false;
	} else if(check_pw() == false){
		alert('비밀번호 조건을 지켜주세요.'); return false;
	} else if(check_cor_pw() == false){
		alert('비밀번호 조건을 지켜주세요.'); return false;
	} else if(document.querySelector('#mem_password').value != document.querySelector('#cor_mem_password').value){
		alert('비밀번호를 일치하게 입력하세요.'); return false;
	} else if(forgot_pw_is_mem_email_certification_check == false || forgot_pw_is_mem_email_change_check == false){
		alert('이메일인증을 하세요.'); return false;
	}
	
	return true;
	
}

function find_pw_mem_email_onkeyup_check(){
	forgot_pw_is_mem_email_certification_check = false;
	forgot_pw_is_mem_email_change_check = false;
}

function forgot_pw_form_submit(){
	if(forgot_pw_formvalidation()){
//		alert('hello');
		document.forgot_pw_form.action="/member/forgot/mem_password_modify";
		document.forgot_pw_form.method = 'post';
		document.forgot_pw_form.submit();
	}
}


function forgot_pw_sendEmail_certificationnumber_by_mem_email(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				console.log(xhr.response);
				if(xhr.response == '1'){
					forgot_pw_is_mem_email_certification_check = false;
					forgot_pw_is_mem_email_change_check = true;
//					alert("이메일인증번호 발송");
				} else if(xhr.response == '-1'){
//					alert("이메일인증번호 발송실패");
				}			
			}else{
//				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
			}
		}
	};
	
	var mem_email = document.getElementById('find_pw_mem_email').value;
	var data = {
			mem_email : mem_email
	};
	xhr.open('post'
			,'/member/forgot/sendEmail_certificationnumber_by_mem_email'	
//			,false);
			,true); //	동기 방식을 통해 비동기의 오류발생가능성 없애기
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send(JSON.stringify(data));
}

function forgot_pw_check_sendEmail_certificationnumber_by_mem_email(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				console.log(xhr.response);
				if(xhr.response == '1'){
					forgot_pw_is_mem_email_certification_check = true;
					alert("인증번호일치합니다.");
					document.querySelector('.pw_input').style.display = 'block';
				} else if(xhr.response == '-1'){
					alert("인증번호 불일치합니다.");
				}			
			}else{
				alert("인증번호 불일치합니다.");
//				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
			}
		}
	};
	
	var cor_mem_email = document.querySelector('#cor_mem_email').value;
	xhr.open('GET'
			,'/member/forgot/check_sendEmail_certificationnumber_by_mem_email?cor_mem_email='+cor_mem_email	
//			,false);
			,true); //	동기 방식을 통해 비동기의 오류발생가능성 없애기
	xhr.send();
}


/******************************************************************/
/******************************************************************/
/*							Front								  */
/*																  */
/*							forgot PW						      */
/******************************************************************/
/******************************************************************/

function forgot_pw_emailcerti(){//패스워드찾기 - 이메일 인증
	
	var find_pw_mem_email = document.querySelector('#find_pw_mem_email').value;
    var pt = /[@]/;    
    
    if(find_pw_mem_email=="") {
    	alert('이메일을 입력하세요.');
    }else if(!pt.test(find_pw_mem_email)){
      alert('도메인을 입력해주세요');
    }else{
//	document.getElementById('find_pw_mem_email').readOnly = true;
    alert('입력한 이메일로 인증번호가 발송되었습니다.');
    const email=document.querySelector('#cor_mem_email');
    const btn=document.querySelector('.email_cert_btn');
    email.style.display="block";
    btn.style.display="block";
    forgot_pw_sendEmail_certificationnumber_by_mem_email();
//    timer();
  }
}

function forgot_pw_check_certificationnumber_validation(){//패스워드찾기 - 이메일 인증
	
	var cor_mem_email = document.querySelector('#cor_mem_email').value;
    
    if(cor_mem_email=="") {
    	alert('인증번호를 입력하세요.');
    }else{

    forgot_pw_check_sendEmail_certificationnumber_by_mem_email();
//    timer();
  }
}

function check_pw(){//비밀번호 영문 숫자 검사
	  var pw = document.getElementById('mem_password').value;
	  var pt = /[a-zA-Z]/;
	  var pt2=/[0-9]/;
	  if(!pt.test(pw)||!pt2.test(pw)||pw.length<4||pw.length>12){
	    document.getElementById('pw_txt').innerHTML = "영문+숫자를 4자리 이상 12자리 이하로 입력하세요";
	    return false;
	  }
	  else{
	    document.getElementById('pw_txt').innerHTML = "";
	    return true;
	  }
	}

function check_cor_pw(){  //비밀번호 재입력 검사
    var pw = document.getElementById('mem_password').value;
    var cor_pw = document.getElementById('cor_mem_password').value;

    if (pw!=cor_pw) {
      document.getElementById('cor_pw_txt').innerHTML = "비밀번호가 달라요. 다시 입력해주세요.";
      return false;
    }
    else {
        document.getElementById('cor_pw_txt').innerHTML = "";
        return true;
    }
    if (cor_pw=="") {
      document.getElementById('cor_pw_txt').innerHTML = "";
      return true;
    }
}


  function timer(){//인증 시간 제한
    var time=300;
    var min='';
    var sec='';
    var x=setInterval(function(){
      min=parseInt(time/60);
      sec=time%60;
      document.getElementById("timer").innerHTML=min+"분"+sec+"초";
      time--;
      if(time<0){

      }
    },1000);
  }
  function select_id(){
  const id=document.querySelector(".find_id");
  const pw=document.querySelector(".find_pw");
  const id_btn=document.querySelector(".select_id_btn");
  const pw_btn=document.querySelector(".select_pw_btn");
    id.style.display="block";
    pw.style.display="none";

    pw_btn.style.backgroundColor="white";
    pw_btn.style.border="1px solid gray";
    pw_btn.style.color="black";
    id_btn.style.backgroundColor="#c3200e";
    id_btn.style.color="white";
    id_btn.style.border="none";
  }
  function select_pw(){
  const id=document.querySelector(".find_id");
  const pw=document.querySelector(".find_pw");
  const id_btn=document.querySelector(".select_id_btn");
  const pw_btn=document.querySelector(".select_pw_btn");
    id.style.display="none";
    pw.style.display="block";
    id_btn.style.backgroundColor="white";
    id_btn.style.border="1px solid gray";
    id_btn.style.color="black";
    pw_btn.style.backgroundColor="#c3200e";
    pw_btn.style.color="white";
    pw_btn.style.border="none";
  }
