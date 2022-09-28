<%@include file="../include/header.jsp" %>
<%@include file="../include/nav.jsp" %>


<title>자유게시판</title>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="${pageContext.request.contextPath}/../../../../resources/ckeditor/ckeditor.js"></script>
<script src="../../../resources/javascript/board/board_list.js"defer></script>


<link rel="stylesheet" type="text/css" href="../../../resources/css/board/board_list.css">
<link rel="stylesheet" type="text/css" href="../../../resources/css/index/home.css">
<link rel="stylesheet" type="text/css" href="../../../resources/css/board/editor.css">

<script>
function go_postmapping_register(){
	document.registerform.action = "/board/register";
	document.registerform.method = "post";
	document.registerform.submit();
}
function go_behind(){
	document.registerform.action = "/board/list";
	document.registerform.method = 'get';
	document.registerform.submit();
}
</script>


<%-- 루트폴더 : <%=request.getRealPath("/") %> --%>
<form role="form" name="registerform" action="/board/register" method="post">

	<main>
        <section id="contents">
            <div class="container">
              <div class="wrapper">
<!--제목 및 본문 정보-->
              <section id="post_header" onclick="select_category()">
                  <ul class="post_category">
                    <li>
                      <select onchange="option_change()" class="upper_cate" name="board_id" style="height:30px;">
                      
                      	<c:forEach items="${boardmanagelist}" var="boardmanagelist">
                      		<c:choose>
                      		<c:when test="${boardmanage.board_id eq boardmanagelist.board_id}">
                      			<option value="${boardmanagelist.board_id}" selected>${boardmanagelist.board_name}</option>
                      		</c:when>
                      		<c:otherwise>
                      			<option value="${boardmanagelist.board_id}">${boardmanagelist.board_name}</option>
                      		</c:otherwise>
                      		</c:choose>
                      	</c:forEach>
                      </select>
                    </li>
                  <button class="submit_post" onclick="go_postmapping_register()" type="button">제출하기</button>
                  <!-- <button class="preview_post" type="button">미리보기</button> -->
                  <button class="backward" type="button" onclick="go_behind()">목록</button>
                  </ul>
				  <br/>
                  <div class="post_title">
                    <input type="text" name="title" id="post_main_title" placeholder="제목을 입력하세요 (30자 제한)" maxlength = "30" style="width:95%;"/>
                  </div>
               	  <div class="writer_chk">
               	 	<input type="checkbox" name="anonymous" value="1" checked="checked"/>
               	 	<label>익명</label>
               	 	<!-- <input  type="text" name="writer" value="writer" /> -->
               	  </div>	
                  </section>	
                  <hr/>
<!--본문-->
          <section class="editor">
					<textarea id="textarea1" class="ckeditor" placeholder="내용입니다." autofocus required wrap="hard" rows="" cols="" name="content"></textarea>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>                
          </section>
          	
        </div>
        </div>
       </section>
      
          
         	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
         	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
         	<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
         	<input type="hidden" name="type" value="TCW">
         	<%-- <input type="hidden" name="board_id" value="${boardmanage.board_id}">    --%>   
	</main>
</form>
<%-- <%@include file="include/include_board_register.jsp" %> --%>
<%@include file="../include/footer.jsp" %>

<%-- <!-- 
<%=request.getRealPath("/") %>+"/src/main/webapp/resources/upload"
/sjucomme/tomcat/webapps/ROOT/+"/src/main/webapp/resources/upload"
-->
 --%>