<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@include file="../include/nav.jsp" %>


<link rel="stylesheet" type="text/css" href="../../../resources/css/member/info.css">
<script src="../../../resources/javascript/member/info.js"defer></script>

<title>mypage</title>

<main>
	<form role="form" name="mypageform">
    <div class="container" class="parallax_base_layer">
          <section id="cont_">
            <div class="profile">
                <div class="my_profile">
                  <label for="chooseFile"><img src="../../resources/img/profile.jpg" class="profile_img" /></label>
                    <input type="file" id="chooseFile" class="choose_file" accept="image/*" onchange="loadFile(this)" >
              </div>
                  <div class="private_info">
                    <!--닉네임 변경-->
                    <div class="name">
                      <%-- <textarea class="nickname" id="mem_nickname" rows="1" maxlength="12"><sec:authentication property="principal.member.mem_nickname"/></textarea><button class="check_nick" onclick="mem_nickname_duplication_check()">중복확인</button> --%>
                      <%-- <textarea class="nickname" name="mem_nickname" id="mem_nickname" onkeyup="nick_length_test()"><sec:authentication property="principal.member.mem_nickname"/></textarea> --%>
                      <textarea class="nickname" name="mem_nickname" id="mem_nickname" onkeyup="nick_length_test()"><c:out value="${membervo.mem_nickname}"/></textarea>
                      <!--닉네임 글자 수 제한-->
                      <p id="nickname_txt"></p>
                      <!--닉네임 중복확인-->
                      <!-- <p id="nick_dup_txt">이미 존재하는 닉네임입니다</p> -->
                      <!--alert로 중복 알림-->
                    </div>
                    <div class="info_list">
                      <label>아이디</label>
                      
                      <%-- <p class="id"><sec:authentication property="principal.member.mem_userid"/></p> --%>
                      <%-- <p class="id"><sec:authentication property="principal.member.mem_userid"/></p> --%>
                      <p class="id"><c:out value="${membervo.mem_userid}"/></p>
                    </div>
                    <div class="info_list">
                      <label id="pw_">비밀번호</label>
                      <input type="password" id="origin_mem_password" class="pw origin_pw" autocomplete="off"/>
                        <button onclick="mem_password_confirm_check();" type="button">변경하기</button>
<!--올바른 비밀번호 입력 후 버튼 클릭 시 아래 변경 폼 뜸-->
                        <div class="hidden_profile">
                          <label>새 비밀번호</label>
                          <input type="password" class="pw" name="mem_password" id="mem_password" onkeyup="check_pw()" autocomplete="off" disabled="disabled"/>
                          <p id="pw_txt"></p>
                          <label>새 비밀번호 확인</label>
                          <input type="password" class="pw" id="cor_mem_password" onkeyup="check_cor_pw()" autocomplete="off" disabled="disabled"/>
                          <p id="cor_pw_txt"></p>
                        </div>
                    </div>
                    <div class="info_list">
                      <label>이메일</label>
                      <%-- <p><sec:authentication property="principal.member.mem_email"/></p> --%>
                      <p><c:out value="${membervo.mem_email}"/></p>
                    </div>
                    <div class="info_list">
                      <label>학번</label>
                      <%-- <p class="std_num"><sec:authentication property="principal.member.mem_studentid"/></p> --%>
                      <p class="std_num"><c:out value="${membervo.mem_studentid}"/></p>
                    </div>
                    </div>
                <div class="modify_profile">
                <button onclick="mypageform_submit()" type="button" class="edit_profile">수정하기</button>
              </div>
              </div>
          </section>
          <!--탈퇴하기 버튼-->
          <section>
            <div class="secession"onclick="open_secession()">탈퇴하기</div>
          </section>
          </div>
	</form>
</main>

<%@include file="../include/footer.jsp" %>