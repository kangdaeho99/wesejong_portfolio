<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>게시글</title>

<link rel="stylesheet" type="text/css" href="../../../../resources/css/board/board_list.css">
<link rel="stylesheet" type="text/css" href="../../../../resources/css/board/editor.css">

<script src="${pageContext.request.contextPath}/../../../../resources/ckeditor/ckeditor.js"></script>
<script src="../../../../resources/javascript/board/board_list.js"></script>
<script src="../../../../resources/javascript/board/post.js"></script>
    

    
<script>

function go_postmapping_register(){
	document.registerform.action = "/board/register";
	document.registerform.method = "post";
	document.registerform.submit();
}


</script>
<main>
	<form role="form" name="registerform" action="/board/register" method="post">
        <section id="contents">
            <div class="container">
              <div class="wrapper">
<!--제목 및 본문 정보-->
              <section id="post_header">
                  <ul class="post_category">
                    <li>
                      <select >
                        <option>자유게시판</option>
                        <option>질문게시판</option>
                        <option>정보게시판</option>
                      </select>
                    </li>
                    <li></li>
                    <li>
                      <select>
                        <option>#후기</option>
                        <option>#이벤트</option>
                        <option>#ㅋㅋ</option>
                      </select>
                    </li>
                  <button type="button" class="submit_post" onclick="go_postmapping_register()">제출하기</button>
                  <button type="button" class="preview_post">미리보기</button>
                  </ul>
				  <br/>
                  <div class="post_title">
                    <input  type="text" name="writer" value="제목을 입력하세요" onfocus="this.value=''; return true" />
                    <input  type="text" name="title" id="post_main_title" value="제목을 입력하세요" onfocus="this.value=''; return true" />
                  </div>
                </section>
				<hr/>

<!--본문-->
          <section class="editor">
                <div id="summernote">
					<textarea id="textarea1" class="ckeditor" placeholder="내용입니다." autofocus required wrap="hard" rows="" cols="" name="content"></textarea>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>                
                </div>
          </section>
          	
          
         	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
         	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
         	<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
         	<input type="hidden" name="type" value="TCW">
         	<input type="hidden" name="board_id" value="${boardmanage.board_id}">
          </form>      
      
                  
                  