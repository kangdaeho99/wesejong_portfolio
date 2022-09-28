<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
<head>
<%@include file="../include/httptohttps.jsp" %>
<title>회원가입 페이지</title>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="../../resources/css/member/join.css">
<script src="../../resources/javascript/member/join.js"defer></script>
</head>
<body>
  <div class="bck">
    <div class="overlay"></div>
    <div class="container">
      <div class="over_container">
        <header>
          <h1><a href="/">위세종<span>wesju</span></a></h1>
        </header>
  
  <form role="form" name="joinform" action="/member/join" method="post">
  
  <section id="join_field">
          <div class="terms_of_sevice">
            <!--회원가입약관-->
            <!--https://www.privacy.go.kr/a3sc/per/inf/perInfStep14.do 에서 작성-->
            <p>
            <p class="ls2 lh6 bs5 ts4"><em class="emphasis">
                < 위세종>('http://sjucomme.cafe24.com/index#'이하 '위세종')
              </em>은(는) 「개인정보 보호법」 제30조에 따라 정보주체의 개인정보를 보호하고 이와 관련한 고충을 신속하고 원활하게 처리할 수 있도록 하기 위하여 다음과 같이 개인정보 처리방침을
              수립·공개합니다.</p>
            <p class="ls2">○ 이 개인정보처리방침은 <em class="emphasis">2021</em>년 <em class="emphasis">1</em>월 <em
                class="emphasis">1</em>일부터 적용됩니다.</p></br>
            <p class='lh6 bs4'><strong>제1조(개인정보의 처리 목적)<br /><br /><em class="emphasis">
                  < 위세종>('http://sjucomme.cafe24.com/index#'이하 '위세종')
                </em>은(는) 다음의 목적을 위하여 개인정보를 처리합니다. 처리하고 있는 개인정보는 다음의 목적 이외의 용도로는 이용되지 않으며 이용 목적이 변경되는 경우에는 「개인정보 보호법」
                제18조에 따라 별도의 동의를 받는 등 필요한 조치를 이행할 예정입니다.</strong></p>
            <ul class="list_indent2 mgt10">
              <p class="ls2">1. 홈페이지 회원가입 및 관리</p>
              <p class="ls2">회원 가입의사 확인, 회원제 서비스 제공에 따른 본인 식별·인증, 서비스 부정이용 방지, 만14세 미만 아동의 개인정보 처리 시 법정대리인의 동의여부 확인 목적으로
                개인정보를 처리합니다.</p></br>
              <p class="ls2">2. 민원사무 처리</p>
              <p class="ls2">민원사항 확인 목적으로 개인정보를 처리합니다.</p></br>
              <p class="ls2">3. 재화 또는 서비스 제공</p>
              <p class="ls2">본인인증을 목적으로 개인정보를 처리합니다.</p></br>
            </ul></br></br>
            <p class='lh6 bs4'><strong>제2조(개인정보의 처리 및 보유 기간)</strong></br></br>① <em class="emphasis">
                < 위세종>
              </em>은(는) 법령에 따른 개인정보 보유·이용기간 또는 정보주체로부터 개인정보를 수집 시에 동의받은 개인정보 보유·이용기간 내에서 개인정보를 처리·보유합니다.</br></br>② 각각의
              개인정보 처리 및 보유 기간은 다음과 같습니다.</p>
            <ul class='list_indent2 mgt10'>
              <li class='tt'>1.<홈페이지 회원가입 및 관리>
              </li>
              <li class='tt'>
                <홈페이지 회원가입 및 관리>와 관련한 개인정보는 수집.이용에 관한 동의일로부터<3년>까지 위 이용목적을 위하여 보유.이용됩니다.
              </li>
              <li>보유근거 : 정보주체의 동의</li>
              <li>관련법령 : 신용정보의 수집/처리 및 이용 등에 관한 기록 : 3년</li>
              <li>예외사유 : </li>
            </ul></br></br>
            <p class='lh6 bs4'><strong>제3조(개인정보의 제3자 제공)</strong></br></br> ① <em class="emphasis">
                < 위세종>은(는) 개인정보를 제1조(개인정보의 처리 목적)에서 명시한 범위 내에서만 처리하며, 정보주체의 동의, 법률의 특별한 규정 등 「개인정보 보호법」 제17조 및 제18조에
                  해당하는 경우에만 개인정보를 제3자에게 제공합니다.
              </em>
            <p class="sub_p mgt10">② <span class="colorLightBlue">
                <위세종>
              </span>은(는) 다음과 같이 개인정보를 제3자에게 제공하고 있습니다.</p>
            <ul class="list_indent2 mgt10">
              <li class="tt">1. <위세종>
              </li>
              <li>개인정보를 제공받는 자 : 위세종</li>
              <li>제공받는 자의 개인정보 이용목적 : 이메일, 비밀번호, 로그인ID</li>
              <li>제공받는 자의 보유.이용기간: 3년</li>
            </ul></br></br>
            <p class='lh6 bs4'><strong>제4조(개인정보처리 위탁)</strong></br></br> ① <em class="emphasis">
                < 위세종>
              </em>은(는) 원활한 개인정보 업무처리를 위하여 다음과 같이 개인정보 처리업무를 위탁하고 있습니다.</p>
            <ul class='list_indent2 mgt10'>
              <li class='tt'>1. <.>
              </li>
              <li>위탁받는 자 (수탁자) : .</li>
              <li>위탁하는 업무의 내용 : 없음</li>
              <li>위탁기간 : 지체없이 파기</li>
            </ul>
            <p class='sub_p mgt10'>② <span class='colorLightBlue'>
                <위세종>
              </span>은(는) 위탁계약 체결시 「개인정보 보호법」 제26조에 따라 위탁업무 수행목적 외 개인정보 처리금지, 기술적․관리적 보호조치, 재위탁 제한, 수탁자에 대한 관리․감독, 손해배상
              등 책임에 관한 사항을 계약서 등 문서에 명시하고, 수탁자가 개인정보를 안전하게 처리하는지를 감독하고 있습니다.</p>
            <p class='sub_p mgt10'>③ 위탁업무의 내용이나 수탁자가 변경될 경우에는 지체없이 본 개인정보 처리방침을 통하여 공개하도록 하겠습니다.</p><br /><br />
            <p class="lh6 bs4"><strong>제5조(정보주체와 법정대리인의 권리·의무 및 그 행사방법)</strong></p>
            <p class="ls2"><br /><br />① 정보주체는 위세종에 대해 언제든지 개인정보 열람·정정·삭제·처리정지 요구 등의 권리를 행사할 수 있습니다.</p>
            <p class='sub_p'>② 제1항에 따른 권리 행사는위세종에 대해 「개인정보 보호법」 시행령 제41조제1항에 따라 서면, 전자우편, 모사전송(FAX) 등을 통하여 하실 수 있으며
              위세종은(는) 이에 대해 지체 없이 조치하겠습니다.</p>
            <p class='sub_p'>③ 제1항에 따른 권리 행사는 정보주체의 법정대리인이나 위임을 받은 자 등 대리인을 통하여 하실 수 있습니다.이 경우 “개인정보 처리 방법에 관한
              고시(제2020-7호)” 별지 제11호 서식에 따른 위임장을 제출하셔야 합니다.</p>
            <p class='sub_p'>④ 개인정보 열람 및 처리정지 요구는 「개인정보 보호법」 제35조 제4항, 제37조 제2항에 의하여 정보주체의 권리가 제한 될 수 있습니다.</p>
            <p class='sub_p'>⑤ 개인정보의 정정 및 삭제 요구는 다른 법령에서 그 개인정보가 수집 대상으로 명시되어 있는 경우에는 그 삭제를 요구할 수 없습니다.</p>
            <p class='sub_p'>⑥ 위세종은(는) 정보주체 권리에 따른 열람의 요구, 정정·삭제의 요구, 처리정지의 요구 시 열람 등 요구를 한 자가 본인이거나 정당한 대리인인지를 확인합니다.
            </p></br></br>
            <p class='lh6 bs4'><strong>제6조(처리하는 개인정보의 항목 작성) </strong></br></br> ① <em class="emphasis">
                < 위세종>
              </em>은(는) 다음의 개인정보 항목을 처리하고 있습니다.</p>
            <ul class='list_indent2 mgt10'>
              <li class='tt'>1< 홈페이지 회원가입 및 관리>
              </li>
              <li>필수항목 : 이메일, 비밀번호, 로그인ID</li>
              <li>선택항목 : </li>
            </ul></br></br>
            <p class='lh6 bs4'><strong>제7조(개인정보의 파기)<em class="emphasis"></strong></p>
            <p class='ls2'></br>① < 위세종></em> 은(는) 개인정보 보유기간의 경과, 처리목적 달성 등 개인정보가 불필요하게 되었을 때에는 지체없이 해당 개인정보를
                파기합니다.</br></br>② 정보주체로부터 동의받은 개인정보 보유기간이 경과하거나 처리목적이 달성되었음에도 불구하고 다른 법령에 따라 개인정보를 계속 보존하여야 하는 경우에는, 해당
                개인정보를 별도의 데이터베이스(DB)로 옮기거나 보관장소를 달리하여 보존합니다.</br>1. 법령 근거 :</br>2. 보존하는 개인정보 항목 : 계좌정보, 거래날짜</br></br>③
                개인정보 파기의 절차 및 방법은 다음과 같습니다.</br>1. 파기절차</br>
                < 위세종> 은(는) 파기 사유가 발생한 개인정보를 선정하고, < 위세종> 의 개인정보 보호책임자의 승인을 받아 개인정보를 파기합니다.</br></p>
            <p class='sub_p mgt10'>2. 파기방법</p>
            <p class='sub_p'>전자적 파일 형태의 정보는 기록을 재생할 수 없는 기술적 방법을 사용합니다</p></br></br>
            <p class='lh6 bs4'><strong>제8조(개인정보의 안전성 확보 조치)<em class="emphasis"></br></br>
                  < 위세종>
                </em>은(는) 개인정보의 안전성 확보를 위해 다음과 같은 조치를 취하고 있습니다.</strong></p>
            <p class='sub_p mgt10'>1. 정기적인 자체 감사 실시</br> 개인정보 취급 관련 안정성 확보를 위해 정기적(분기 1회)으로 자체 감사를 실시하고
              있습니다.</br></br>2. 내부관리계획의 수립 및 시행</br> 개인정보의 안전한 처리를 위하여 내부관리계획을 수립하고 시행하고 있습니다.</br></br>3. 해킹 등에 대비한 기술적
              대책</br>
              <<em class="emphasis">위세종</em>>('<em class="emphasis">위세종</em>')은 해킹이나 컴퓨터 바이러스 등에 의한 개인정보 유출 및 훼손을 막기 위하여
                보안프로그램을 설치하고 주기적인 갱신·점검을 하며 외부로부터 접근이 통제된 구역에 시스템을 설치하고 기술적/물리적으로 감시 및 차단하고 있습니다.</br></br>4. 개인정보의
                암호화</br> 이용자의 개인정보는 비밀번호는 암호화 되어 저장 및 관리되고 있어, 본인만이 알 수 있으며 중요한 데이터는 파일 및 전송 데이터를 암호화 하거나 파일 잠금 기능을 사용하는
                등의 별도 보안기능을 사용하고 있습니다.</br></br>5. 개인정보에 대한 접근 제한</br> 개인정보를 처리하는 데이터베이스시스템에 대한 접근권한의 부여,변경,말소를 통하여
                개인정보에 대한 접근통제를 위하여 필요한 조치를 하고 있으며 침입차단시스템을 이용하여 외부로부터의 무단 접근을 통제하고 있습니다.</br></br>
            </p></br></br>
            <p class="lh6 bs4"><strong>제9조(개인정보 자동 수집 장치의 설치•운영 및 거부에 관한 사항)</strong></p>
            <p class="ls2"><br /><br />위세종 은(는) 정보주체의 이용정보를 저장하고 수시로 불러오는 ‘쿠키(cookie)’를 사용하지 않습니다.
            <p class='sub_p mgt30'><strong>제10조 (개인정보 보호책임자) </strong></p>
            <p class='sub_p mgt10'> ① <span class='colorLightBlue'>위세종</span> 은(는) 개인정보 처리에 관한 업무를 총괄해서 책임지고, 개인정보 처리와
              관련한 정보주체의 불만처리 및 피해구제 등을 위하여 아래와 같이 개인정보 보호책임자를 지정하고 있습니다.</p>
            <ul class='list_indent2 mgt10'>
              <li class='tt'>▶ 개인정보 보호책임자 </li>
              <li>성명 :.</li>
              <li>직책 :.</li>
              <li>직급 :.</li>
              <li>연락처 :., ., .</li>
            </ul>
            <p class='sub_p'>※ 개인정보 보호 담당부서로 연결됩니다.
              <p />
            <ul class='list_indent2 mgt10'>
              <li class='tt'>▶ 개인정보 보호 담당부서</li>
              <li>부서명 :.</li>
              <li>담당자 :.</li>
              <li>연락처 :., ., .</li>
            </ul>
            <p class='sub_p'>② 정보주체께서는 위세종 의 서비스(또는 사업)을 이용하시면서 발생한 모든 개인정보 보호 관련 문의, 불만처리, 피해구제 등에 관한 사항을 개인정보 보호책임자 및
              담당부서로 문의하실 수 있습니다. 위세종 은(는) 정보주체의 문의에 대해 지체 없이 답변 및 처리해드릴 것입니다.</p>
            <p class='sub_p mgt30'><strong>제11조(개인정보 열람청구)</br> 정보주체는 ｢개인정보 보호법｣ 제35조에 따른 개인정보의 열람 청구를 아래의 부서에 할 수
                있습니다.<br />
                <위세종></span>은(는) 정보주체의 개인정보 열람청구가 신속하게 처리되도록 노력하겠습니다.
              </strong></p>
            <ul class='list_indent2 mgt10'>
              <li class='tt'>▶ 개인정보 열람청구 접수·처리 부서 </li>
              <li>부서명 : .</li>
              <li>담당자 : .</li>
              <li>연락처 : ., ., .</li>
            </ul></br></br>
            <p class='lh6 bs4'><strong>제12조(권익침해 구제방법)<em class="emphasis"></em></strong></p><br /><br />정보주체는 개인정보침해로
            인한 구제를 받기 위하여 개인정보분쟁조정위원회, 한국인터넷진흥원 개인정보침해신고센터 등에 분쟁해결이나 상담 등을 신청할 수 있습니다. 이 밖에 기타 개인정보침해의 신고, 상담에 대하여는 아래의
            기관에 문의하시기 바랍니다.<br /><br />



            1. 개인정보분쟁조정위원회 : (국번없이) 1833-6972 (www.kopico.go.kr)<br />

            2. 개인정보침해신고센터 : (국번없이) 118 (privacy.kisa.or.kr)<br />

            3. 대검찰청 : (국번없이) 1301 (www.spo.go.kr)<br />

            4. 경찰청 : (국번없이) 182 (cyberbureau.police.go.kr)<br /><br />



            「개인정보보호법」제35조(개인정보의 열람), 제36조(개인정보의 정정·삭제), 제37조(개인정보의 처리정지 등)의 규정에 의한 요구에 대 하여 공공기관의 장이 행한 처분 또는 부작위로 인하여
            권리 또는 이익의 침해를 받은 자는 행정심판법이 정하는 바에 따라 행정심판을 청구할 수 있습니다.<br /><br />



            ※ 행정심판에 대해 자세한 사항은 중앙행정심판위원회(www.simpan.go.kr) 홈페이지를 참고하시기 바랍니다.</br></br>
            <p class='lh6 bs4'><strong>제13조(개인정보 처리방침 변경)<em class="emphasis"></em></strong></p><br /></p>
            <p class='sub_p'>① 이 개인정보처리방침은 2021년 1월 1부터 적용됩니다.</p>
            <p class='sub_p'></p>
            <p class='sub_p'></p>
          </div>
          
      <!--개인정보처리방침에 대한 동의 여부-->
    <div class="agree_input">
      <input id="agreement" type="checkbox"/>
        <label for="agreement"><span>개인정보처리방침에 동의합니다.</span></label>
    </div>
    
    
      <!--입력양식 -->
    <div class="join_input">
        <!--아이디 입력-->
        <div class="id_input">
          <label for="mem_userid"class="join_title">아이디</label>
          <input id="mem_userid" name="mem_userid" type="text"placeholder="아이디 입력"onkeyup="id_length_test();" required/>
        <!--중복버튼 없앰  <button class="check_overlap_id">중복확인</button>-->
        <!--아이디 길이제한 텍스트-->
          <p id="id_txt"></p>
        <!--아이디 중복 알림 텍스트-->
          <p id="id_dup_txt">이미 존재하는 아이디입니다</p>
        </div>
        <!--비밀번호 입력-->
        <div class="pw_input">
          <label for="mem_password"class="join_title">비밀번호</label>
          <input id="mem_password" name="mem_password" type="password" placeholder="비밀번호 입력"onkeyup="check_pw()" required/>
          <p id="pw_txt"></p>
          <label for="cor_mem_password"class="join_title">비밀번호 확인</label>
          <input id="cor_mem_password" type="password" placeholder="비밀번호 재입력" onkeyup="check_cor_pw()" required/>
          <p id="cor_pw_txt"></p>
          <!--비밀번호 조건 js-->
          <!--https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=dme1004&logNo=220958840520-->
        </div>
        <!--이메일 입력-->
        <div class="email_input">
          <label for="mem_email"class="join_title">이메일</label>
          <input id="mem_email" name="mem_email" type="text" placeholder="이메일 입력" onkeyup="check_email()"/>
          <span>@sju.ac.kr<button type="button" onclick="email_certi(); mem_email_duplication_certification_check();" class="email_send_btn">인증요청</button></span>
          <p id="email_txt"></p>
          <input id="cor_mem_email" name="cor_mem_email" type="text" placeholder="인증번호 입력"/>
          <button type="button" class="email_cert_btn" onclick="mem_email_certification_check()">확인하기</button>
          <p id="timer"></p>
          <p id="junk">메일이 오지 않으면 정크메일을 확인해주세요.</p>
        </div>
        <!--닉네임 입력-->
        <div class="nickname_input">
          <label for="mem_nickname"class="join_title">닉네임</label>
          <input id="mem_nickname" name="mem_nickname" value="익명" type="text"onkeyup="nickname_length_test(); mem_nickname_duplication_check();" placeholder="닉네임 입력"/>
          <!-- <button class="check_overlap_nick">중복확인</button> -->
          <p id="nickname_txt"></p>
        </div>
        <!--학번 입력-->
        <div class="studentID_input">
          <label for="mem_studentID" class="join_title">학번</label>
          <select id="mem_studentID" name="mem_studentid">
            <option value="22">22학번</option>
            <option value="21">21학번</option>
            <option value="20">20학번</option>
            <option value="19">19학번</option>
            <option value="18">18학번</option>
            <option value="17">17학번</option>
            <option value="16">16학번</option>
            <option value="15">15학번</option>
            <option value="14">14학번</option>
            <option value="13">13학번</option>
            <option value="12">12학번</option>
            <option value="11">11학번</option>
            <option value="10">10학번 이하</option>
          </select>
          <p id="studentID_txt"></p>
        </div>
      </div>
      <!--제출 버튼-->
      <div class="submit_button">
        <input type="button"style="color:white" value="위세종 가입하기" class="submit_join_form" onclick="submit_joinform();"/>
      </div>
      <!--참고사이트:
      (부산대커뮤니티)https://mypnu.net/index.php?mid=blank&act=dispMemberSignUpForm#
      (카카오 고객센터)https://cs.kakao.com/helps?service=8-->
      <div class="prod">copyright © all rights reserved</div>
    </section>
    </form>
    
    </div>
  </div>
  <script>

  function timer(){//인증 시간 제한
    document.getElementById("timer").style.display="block";
    var time=300;
    var min='';
    var sec='';  var x;
    clearInterval(x);
    x=setInterval(function(){
      min=parseInt(time/60);
      sec=time%60;
      document.getElementById("timer").innerHTML=min+"분"+sec+"초";
      time--;

      if(time==-1){//제힌시간 초과 시 경고 뜨고 시간 카운트 다운 p 사라짐
        alert('인증시간을 초과하였습니다.\n다시 인증해주세요.')
        document.getElementById("timer").style.display="none";
        clearInterval(x);
      }
    /*  else if(time==3){//1분 남았을 때 시간 연장 가능
        document.querySelector(".email_send_btn").innerHTML="시간연장";
        document.querySelector(".email_send_btn").setAttribute("onClick", "extend_time(time)");
      }*/

    },1000);
      document.getElementById("timer").innerHTML="";
      return;
  }
/*
  function extend_time(time){
    time+=2;
      return time;
  }*/
</script>
</div>
</body>
</html>