/**
 * 
 */

/******************************************************************/
/******************************************************************/
/*							BackEnd								  */
/*																  */
/*						 									      */
/******************************************************************/
/******************************************************************/

//검색어:바닐라 자바스크립트 ajax
//https://admm.tistory.com/22
//검색어:바닐라 자바스크립트 ajax
//https://teserre.tistory.com/7
//검색어:xhr.open data get
//https://sourcestudy.tistory.com/238
//id_length_test() 같은 유효성 검사에 함수들을 넣어 조건이 총족될시에만 작동되도록 할려고했지만
//그렇게 진행할시 시간차가 일어나 변수들이 true값으로 변하지 않아 onkeyup에 따로 넣습니다.


var is_mem_userid_duplication_check = false;
var is_mem_email_duplication_check = false;
var is_mem_email_certification_check = false;
var is_mem_nickname_duplication_check = true;


//유효성 검사하는곳에 onkeyup에 변경사항이 있을시, 다시 false 처리해놓아서 뒤쪽에 검사하도록했습니다.
function empty_value_test(){//비어있는 양식에 대한 검사
	  if(!document.querySelector('#agreement').checked) {
		  alert('개인정보약관에 동의해주세요.'); return false;
	  }	else if(id_length_test() == false){
		  alert('아이디 조건을 지켜주세요.'); return false;
	  } else if(nickname_length_test() == false){
		  alert('닉네임 조건을 지켜주세요.'); return false;
	  } else if(is_mem_userid_duplication_check == false){
		  alert('이미 존재하는 아이디입니다.'); return false;
	  } else if(is_mem_email_duplication_check == false){
		  alert('이메일 인증을 완료하세요.'); return false;
	  } else if(is_mem_email_certification_check == false){
		  alert('이메일 인증을 완료하세요.'); return false;
	  } else if(is_mem_nickname_duplication_check == false){
		  alert('닉네임 중복체크를 하시기 바랍니다.(익명으로 사용가능합니다.)'); return false;
	  } else if(check_email() == false){
		  alert('이메일 조건을 지켜주세요.'); return false;
	  } else if(check_pw() == false){
		  alert('패스워드 조건을 지켜주세요.'); return false;
	  } else if(check_cor_pw() == false){
		  alert('패스워드 조건을 지켜주세요.'); return false;
	  } 
	  return true;
}

function submit_joinform(){
	if(empty_value_test() == true){
		document.joinform.action = "/member/join";
		document.joinform.method = "post";
		document.joinform.submit();
	}

}

//검색어:javascript input value
// https://stackoverflow.com/questions/26946235/pure-javascript-listen-to-input-value-change
//document.getElementById('mem_userid').addEventListener('input', input_change_detection);
//
//function input_change_detection(){
//	
//	var id=document.getElementById('mem_userid').value;
//	
//	if(id.length>=4 && id.length<=12){
//		console.log("id length >=4 && id length <=12");
//		mem_userid_duplication_check();
//	}else{
//		console.log("id length < 4 && id length >12");
//	}
//
//}

function mem_userid_duplication_check(){
	//XMLHttpRequest 객체 생성
	var xhr = new XMLHttpRequest();

	
	
	
	// onreadystatechange는 서버와의 통신이 끝났을 때 호출 됨
	// xhr.open 보다 위에 있어야합니다.	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				console.log(xhr.response);
				
				
				
				if(xhr.response == '-1'){
					document.getElementById('id_txt').style.color = "#c3002e";
					document.getElementById('id_txt').innerHTML="이미 사용중인 아이디입니다.";
					is_mem_userid_duplication_check = false;
				} else if(xhr.response == '0'){
					document.getElementById('id_txt').style.color = "green";
					document.getElementById('id_txt').innerHTML="사용가능한 아이디입니다";
					is_mem_userid_duplication_check = true;
//					alert("is_mem_userid_dupkication_check="+is_mem_userid_duplication_check);
				}			
				
				
				
			}else{
				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
				is_mem_userid_duplication_check = false;
//				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
			}
		}
	};
	
	
	
	
	var mem_userid = document.getElementById('mem_userid').value;	
	//요청을 보낼 방식, 주소, 비동기 여부 설정
	xhr.open('GET'
			,'/member/mem_userid_duplication_check?mem_userid='+mem_userid		
//			,false);
			,true); //	동기 방식을 통해 비동기의 오류발생가능성 없애기
	
    // send method가 호출될 때 XMLHttpRequest객체가 통신을 시작하게 된다
    // 데이터는 문자열로 raw하게 날라가므로 반드시 본인이 타입에 맞게 인코딩 해야함 ex) xhr.send(JSON.parse(data));
	xhr.send();
	
}

//이메일 중복인지 확인하고, 중복이 아니라면 이메일을 발송합니다.
//email이 중복인지 확인하고, 중복이 아니라면 컨트롤러에서 해당 메일에 인증번호를 일단 보냅니다.
function mem_email_duplication_certification_check(){
	is_mem_email_duplication_check = false;
	is_mem_email_certification_check = false;
	var xhr = new XMLHttpRequest();
	
	
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				
				
				
				if(xhr.response == '1'){
					is_mem_email_duplication_check = true;
					is_mem_email_certification_check = false;
//					document.querySelector('#mem_email').readOnly = true;
//					alert("return 1 xhr.response 1");
//					email_certi_send();
					return 1;
				} else if(xhr.response == '-1'){
					alert("이미 존재하는 이메일 계정입니다.");
					is_mem_email_duplication_check = false;
					is_mem_email_certification_check = false;
//					alert("return -1");
					return -1;
				} else if(xhr.response == '-2'){
					is_mem_email_duplication_check = false;
					is_mem_email_certification_check = false;
					alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
//					alert("return -1");
					return -1;
				}				
			}else{
				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");	
				is_mem_email_duplication_check = false;
				is_mem_email_certification_check = false;
			}
		}
	};
	
	
	
	
	var mem_email = document.getElementById('mem_email').value;
	xhr.open('GET'
			,'/member/mem_email_duplication_certification_check?mem_email='+mem_email
			,true);
	
	xhr.send();
	
}

//인증번호를 확인해주는 함수입니다.
function mem_email_certification_check(){
	var xhr = new XMLHttpRequest();
	
	
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				
				
				
				if(xhr.response == 1){
					is_mem_email_certification_check = true;
					alert("인증이 완료되었습니다.");
				} else if(xhr.response == -1){
					is_mem_email_duplication_check = false;
					is_mem_email_certification_check = false;
					alert("인증번호가 일치하지 않습니다.");
				}
			}
			else{
//				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
				is_mem_email_duplication_check = false;
				is_mem_email_certification_check = false;
			}
		}
	};
	
	
	
	
	var cor_mem_email = document.getElementById('cor_mem_email').value;
	xhr.open('GET'
			,'/member/mem_email_certification_check?cor_mem_email='+cor_mem_email
			,true);
	
	xhr.send();
}


document.getElementById('nickname_txt').innerHTML="닉네임 '익명'은 중복처리 없이 누구나 사용가능합니다.";

function mem_nickname_duplication_check(){
	is_mem_nickname_duplication_check = false;
	var xhr = new XMLHttpRequest();
	
	
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status === 200){
				
				
				
				console.log(xhr.response);
				if(xhr.response == '-1'){
					document.getElementById('nickname_txt').style.color = "#c3002e";
					document.getElementById('nickname_txt').innerHTML="이미 사용중인 닉네임입니다.";
					is_mem_nickname_duplication_check = false;
				} else if(xhr.response == '99'){
					document.getElementById('nickname_txt').style.color = "green";
					document.getElementById('nickname_txt').innerHTML="닉네임 '익명'은 중복처리 없이 누구나 사용가능합니다.";
					is_mem_nickname_duplication_check = true;
				} else if(xhr.response == '0'){
					document.getElementById('nickname_txt').style.color = "green";
					document.getElementById('nickname_txt').innerHTML="사용가능한 닉네임입니다.";
					is_mem_nickname_duplication_check = true;
				} 			
			}else{
				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
				is_mem_nickname_duplication_check = false;
//				alert("현재 서버에 문제가 있습니다. 이후에 다시 시도하시기 바랍니다.");
			}
		}
		
		
		
	};
	
	
	
	
	var mem_nickname = document.getElementById('mem_nickname').value;
	//요청을 보낼 방식, 주소, 비동기 여부 설정
	xhr.open('GET'
			,'/member/mem_nickname_duplication_check?mem_nickname='+mem_nickname		
//			,false);
			,true); //	동기 방식을 통해 비동기의 오류발생가능성 없애기
	
    // send method가 호출될 때 XMLHttpRequest객체가 통신을 시작하게 된다
    // 데이터는 문자열로 raw하게 날라가므로 반드시 본인이 타입에 맞게 인코딩 해야함 ex) xhr.send(JSON.parse(data));
	xhr.send();
}




/******************************************************************/
/******************************************************************/
/*							Front								  */
/*															      */
/******************************************************************/
/******************************************************************/
function id_length_test(){//아이디 길이 제한
  var id=document.getElementById('mem_userid').value;
  
  if(id.length<4||id.length>12){
    document.getElementById('id_txt').innerHTML="아이디를 4자리 이상 12자리 이하로 입력하세요.";
    is_mem_userid_duplication_check = false;
    return false;
  } else{
	  document.getElementById('id_txt').innerHTML="";
	  mem_userid_duplication_check();
	  return true;
    
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
      	return false;
    }
}

 function check_email(){
   is_mem_email_duplication_check = false;
   is_mem_email_certification_check = false;
   var email = document.getElementById('mem_email').value;
   var pt = /[@]/;
   if(email.length <= 0){
	   document.getElementById('email_txt').innerHTML = "이메일을 인증하세요";
	   return false;
   }
   if(pt.test(email)){
     document.getElementById('email_txt').innerHTML = "도메인은 입력하지 마세요";
     return false;
   }
   else{
     document.getElementById('email_txt').innerHTML = "";
     return true;
   }
 
 }
function nickname_length_test(){//닉네임 길이 제한
	var nickname=document.getElementById('mem_nickname').value;
    if(nickname.length<2||nickname.length>12){
      document.getElementById('nickname_txt').innerHTML="닉네임을 2자리 이상 12자리 이하로 입력하세요.";
      return false;
    }
    else{
		return true;
    }
}
function check_studentID(){//학번 길이 검사
    var s_id=document.getElementById('mem_studentID').value;

    if(s_id.length!=8){
      document.getElementById('studentID_txt').innerHTML = "잘못된 학번입니다.";
      return false;
    }
    else {
      document.getElementById('studentID_txt').innerHTML = "";
      return true;
    }
}
/*function empty_value_test(){//비어있는 양식에 대한 검사
  if(!document.querySelector('#agreement').checked) alert('개인정보약관에 동의해주세요.');
  else if(document.querySelector('#mem_userid').value=="") alert('아이디를 입력하세요.');
  else if(document.querySelector('#mem_password').value=="") alert('비밀번호를 입력하세요.');
  else if(document.querySelector('#cor_mem_password').value=="") alert('비밀번호 확인을 입력하세요.');
  else if(document.querySelector('#mem_email').value=="") alert('이메일을 입력하세요.');
  else if(document.querySelector('#mem_nickname').value=="") alert('닉네임을 입력하세요.');
  else if(document.querySelector('#mem_studentID').value=="") alert('학번을 입력하세요.');
}*/
function email_certi(){//이메일 인증
   is_mem_email_certification_check = false;
  var email = document.getElementById('mem_email').value;
  var pt = /[@]/;
  if(pt.test(email)){
    alert('도메인을 삭제해주세요');
    return false;
  }else if(email==""){
    alert('이메일을 입력해주세요');
    return false;
  }else{
  alert('인증메일이 발송되었습니다.');
  const email=document.querySelector('#cor_mem_email');
  const btn=document.querySelector('.email_cert_btn');
  const junk=document.querySelector('#junk');
  email.style.display="block";
  btn.style.display="block";
  junk.style.display="block";
  timer();		 		  
  return true;
  }
}

function email_certi_send(){//ajax의 결과값이 늦게 반환됨으로써 ajax함수안에 넣습니다.
//	  alert('인증메일이 발송되었습니다.');
//	   is_mem_email_certification_check = false;
//	  const email=document.querySelector('#cor_mem_email');
//	  const btn=document.querySelector('.email_cert_btn');
//	  email.style.display="block";
//	  btn.style.display="block";
//	  timer();	
}
