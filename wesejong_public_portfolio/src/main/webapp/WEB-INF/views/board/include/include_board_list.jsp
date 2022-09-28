<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta name="viewport" content="width=device-width,initial-scale=1">

 <link rel="stylesheet" type="text/css" href="/../../../../resources/css/board/board_list.css">

 <script src="../../../../resources/javascript/board/board_list.js"defer></script>
 <script type="text/javascript">

function go_register(){
	
}
 
function go_search(){
	document.searchformm.action="/board/list";
}


</script>
 
    <main>
        <section id="contents">
            <div class="container">
                <!-- ir_su는 그냥 주석임 -->
                <h2 class="ir_su">Responsive Site Content</h2>
                <section id="cont_center">
                  <!--게시판 헤더-->
                  <div class="board_list_header">
                    <!--게시판 제목-->
                    <h1 class="board_list_title">공지게시판</h1>
                    <ul class="board_list_keyword">
                    <!--클릭 시 키워드에 해당하는 목록 나열-->
                      <li>keyword</li>
                      <li><a href="#">#전체</a></li>
                      <li><a href="#">#공지</a></li>
                      <li><a href="#">#이벤트</a></li>
                      <li><a href="#">#후기</a></li>
                      <li><a href="#">#ㅋㅋ</a></li>
                    </ul>

                  </div>
                    <!--       게시판 목록:15줄        -->
                <div class="board_list_table">
                  <table class="board_list_form"style="table-layout:fixed" >
                     <thead>
                       <tr>
                         <th>번호</th>
                         <th>분류</th>
                         <th style="width:40%; text-overflow:ellipsis; overflow:hidden; white-space:nowrap">제목</th>
                         <th>작성자</th>
                         <th>날짜</th>
                         <th>조회수</th>
                       </tr>
                     </thead>
                     <tbody>
                       <tr class="top_notice">
                          <td>223010</td>
                          <td>공지</td>
                          <td><a href="post.html">게시글 제목입니다</a>&nbsp<a href="#">(<span class="comment_num">5</span>)</a>&nbsp&nbsp<i class="far fa-images"></i></td>
                          <td>관리자</td>
                          <td>2022.02.22</td>
                          <td>0</td>
                        </tr>
                        <tr class="top_notice">
                           <td>223010</td>
                           <td>공지</td>
                           <td><a href="#">게시글 제목입니다게시글 제목입니다게시글 제목입니다게시글 제목입니다게시글 제목입니다게시글 제목입니다</a>&nbsp<a href="#">(<span class="comment_num">5</span>)</a></td>
                           <td>관리자</td>
                           <td>2022.02.22</td>
                           <td>0</td>
                         </tr>
                     	<c:forEach items="${list}" var="board" varStatus="status">
	                       <tr>
	                          <td><c:out value="${pageMaker.total- ((pageMaker.cri.pageNum-1)*pageMaker.cri.amount) - status.index}" /></td>
	                          <td>공지</td>
	                          <td>
		                          <a href='${pageContext.request.contextPath}/board/get?bno=<c:out value="${board.bno}"/>&board_id=${boardmanage.board_id}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}'><c:out value="${board.title}"/></a>&nbsp
		                       	   <a href="#">(<span class="comment_num">5</span>)</a>
	                          </td>
	                          <td><c:out value="${board.writer}"/></td>
	                          <td><fmt:formatDate pattern="MM-dd mm:ss" value="${board.regdate}"/></td>
	                          <td><c:out value="${board.viewcount}"/></td>
	                        </tr>                     		
                     	</c:forEach>
                       </tbody>
                   </table>
              </div>
              
              <!--새글쓰기(모니터)-->
              <div class="board_list_bottom">
                <%-- <a href="<c:url value="/board/register"/>"><span class="new_post_btn">글쓰기</span></a> --%>
               <a href="<c:url value="/board/register?board_id=${boardmanage.board_id}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}"/>"><span class="new_post_btn">글쓰기</span></a>
               <!-- <button class="new_post_btn">글쓰기</button> -->
                <!--검색-(모니터)-->
              	<form id="searchForm" name="searchformm" action="/board/list" method="get">

					<span class="find_post">

						<input type="text" name='keyword' class="board_list_search"onfocusin="focus_on_search_box()" onfocusout="focus_out_search_box()" />
						<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
						<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
						<input type='hidden' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>'>
						<input type='hidden' name='board_id' value='${boardmanage.board_id}'>
						
						<input type='hidden' name='type' value='TCW'>
						<%-- <input type="hidden" name="boardLocation" value=<c:out value='${boardmanage.boardLocation}'/>> --%>
						<input type="button" value="search" class="board_list_search_btn" onclick="go_search()"/>	
					</span>				
				</form>

              </div>
              <!--페이지 이동-->
                <table class="board_list_page_idx">
                  <tr>
        			<td>
	        			<c:if test="${pageMaker.prev}">
							<a href="${pageContext.request.contextPath}/board/list?board_id=${boardmanage.board_id}&pageNum=${pageMaker.startPage -1}">이전</a>
						</c:if>
					</td>
					
					<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
						<td>
							<a href="${pageContext.request.contextPath}/board/list?board_id=${boardmanage.board_id}&pageNum=${num}&amount=15">${num}</a>
						</td>
					</c:forEach>
					
					<td>
						<c:if test="${pageMaker.next}">
							<a href="${pageContext.request.contextPath}/board/list?board_id=${boardmanage.board_id}&pageNum=${pageMaker.endPage +1}">다음</a>
						</c:if>		
                    </td>
                  </tr>
                  </table>
                    </section>