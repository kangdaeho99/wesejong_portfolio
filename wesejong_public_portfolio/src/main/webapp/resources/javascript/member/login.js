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

function submit_loginform(){
//	alert("login");
	document.loginform.action = "/login";
	document.loginform.method = "post";
	document.loginform.submit();
}



/******************************************************************/
/******************************************************************/
/*							FrontEnd							  */
/*																  */
/*						 									      */
/******************************************************************/
/******************************************************************/

function empty_value_test_login(){//비어있는 값에 대한 검사
  if(document.querySelector('#userid').value=="") alert('아이디를 입력하세요.');
  else if(document.querySelector('#password').value=="") alert('비밀번호를 입력하세요.');

}

function open_find_idpw(){//아이디찾기 창을 열어줌
    window.open('/member/forgot','_blank','width=570,  height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;alert('g');
  }
