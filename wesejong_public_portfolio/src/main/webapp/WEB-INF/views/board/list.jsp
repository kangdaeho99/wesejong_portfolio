<%@include file="../include/header.jsp" %>
<%@include file="../include/nav.jsp" %>
<%-- <%@include file="include/include_board_list.jsp" %> --%>

<title><c:out value="${boardmanage.board_name}"/>게시판</title>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="javascript/board.js"defer></script>
<link rel="stylesheet" type="text/css" href="../../../resources/css/board/board_list.css">
<script src="../../../resources/javascript/board/board_list.js"defer></script>
<script type="text/javascript">
function go_search(){
	document.searchformm.action = "/board/list";
	document.searchformm.method = "get";
	document.searchformm.submit();
}

function go_listformm(formm){
	
	document.listformm.action = "/board/list";
	document.listformm.method = "get";
	document.querySelector('input[name="pagenum"]').value = formm.getAttribute("data-value"); 
	document.listformm.submit();
}
</script>

    <main>
        <section id="contents">
            <div class="container">
                <!-- ir_su는 그냥 주석임 -->
                <h2 class="ir_su">게시판</h2>
                <section id="cont_center">
                  <!--게시판 헤더-->
                  <div class="board_list_header">
                    <!--게시판 제목-->
                    <h1 class="board_list_title"><c:out value="${boardmanage.board_name}"/></h1>
					<span class="board_description"><c:out value="${boardmanage.board_desc}"/><!-- wesju 이용에 관한 <span>안내사항</span>과 이용자가 지켜야 할 <span>공지사항</span>을 게시합니다.</span> --></span>
                    <!--클릭 시 키워드에 해당하는 목록 나열-->
                    <!--<ul class="board_list<_keyword">
                      <li>keyword</li>
                      <li><a href="#">#전체</a></li>
                      <li><a href="#">#공지</a></li>
                      <li><a href="#">#이벤트</a></li>
                      <li><a href="#">#후기</a></li>
                      <li><a href="#">#ㅋㅋ</a></li>
                    </ul>-->

                  </div>
                  <!------------------------------------------------->
                  <!--                                             -->
                  <!--                                             -->
                  <!--           monitor.ver 게시판1               -->
                  <!--                                             -->
                  <!--                                             -->
                  <!------------------------------------------------->
                    <!--       게시판 목록:15줄        -->
                <div class="board_list_table">
                  <table class="board_list_form"style="table-layout:fixed" height="60" >
                     <thead>
                       <tr>
                         <th>번호</th>
                         <th style="width:40%; text-overflow:ellipsis; overflow:hidden; white-space:nowrap">제목</th>
                         <th>조회수</th>
                         <th style="width:25px;">추천</th>
                         <th>작성자</th>
                         <th>날짜</th>
                       </tr>
                     </thead>
                     <tbody>
                     

                     	<c:forEach items="${list}" var="board" varStatus="status">
                     	<c:choose>
                     	
                     	<c:when test="${board.notice eq 1}">
	                       <tr class="top_notice">
	                       
	                          <td><span class="color_notice">공지</span></td>
	                          <td>
	                          	<span class="title_ellipsis">
									  <a href='${pageContext.request.contextPath}/board/get?bno=<c:out value="${board.bno}"/>&board_id=${boardmanage.board_id}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}'>
									 	 <c:out value="${board.title}"/>
									  </a>
							    </span>&nbsp
							    <c:if test="${board.boardreply_count ne 0}">
		                       		<a href="#">(<span class="comment_num"><c:out value="${board.boardreply_count}"/></span>)</a>	
		                       	</c:if>
		                       	&nbsp&nbsp
								<c:if test="${not empty board.boardattachimagefilelist[0].boardattachimage_seq}">
    		                       	<i class="far fa-images"></i>
								</c:if>
	                          </td>
	                          <td><c:out value="${board.viewcount}"/></td>
	                          <td><c:out value="${board.boardlikecount}"/></td>
	                          <td>관리자</td>
	                          <td><fmt:formatDate pattern="MM/dd HH:mm" value="${board.regdate}"/></td>
	                        </tr>
	                        <tr>                     	
                     	</c:when>	                    
                     	 	
						<c:when test="${board.notice eq 0}">
	                       <tr>
	                          <td><c:out value="${pageMaker.total- ((pageMaker.cri.pageNum-1)*pageMaker.cri.amount) - status.index}" /></td>
	                          <td>
	                          	<span class="title_ellipsis">
									  <a href='${pageContext.request.contextPath}/board/get?bno=<c:out value="${board.bno}"/>&board_id=${boardmanage.board_id}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}'>
									 	 <c:out value="${board.title}"/>
									  </a>
							    </span>&nbsp
							    <c:if test="${board.boardreply_count ne 0}">
		                       		<a href="#">(<span class="comment_num"><c:out value="${board.boardreply_count}"/></span>)</a>	
		                       	</c:if>
		                       	&nbsp&nbsp
								<c:if test="${not empty board.boardattachimagefilelist[0].boardattachimage_seq}">
    		                       	<i class="far fa-images"></i>
								</c:if>
	                          </td>
	                          <td><c:out value="${board.viewcount}"/></td>
	                          <td><c:out value="${board.boardlikecount}"/></td>
	                          <td><c:if test="${board.anonymous == 1}">익명</c:if><c:if test="${board.anonymous eq 0}"><c:out value="${board.writer}"/></c:if></td>
	                          <td><fmt:formatDate pattern="MM/dd HH:mm" value="${board.regdate}"/></td>
	                        </tr>						
						</c:when> 
						    					
	                    </c:choose>                   		
                     	</c:forEach>
                       </tbody>
                   </table>
              </div>
              
              <!------------------------------------------------->
              <!--                                             -->
              <!--                                             -->
              <!--            mobile.ver 게시판2               -->
              <!--                                             -->
              <!--                                             -->
              <!------------------------------------------------->
              <div class="mb_board_list_table">
                <table class="mb_board_list_form">
                   <tbody>
                   <c:forEach items="${list}" var="board" varStatus="status">
                   
                   <c:choose>
                   
                   <c:when test="${empty board.boardattachimagefilelist[0].boardattachimage_seq && board.notice eq 1}">
                    <!--공지o, 이미지 없는 버전-->
                    <tr class="board_list_elem">
                      <td colspan="2">
                        <!--제목-->
                        <div class="mb_board_title">
                          <span class="mb_category">공지</span><a href="${pageContext.request.contextPath}/board/get?bno=<c:out value="${board.bno}"/>&board_id=${boardmanage.board_id}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}"><c:out value="${board.title}"/></a>
                        </div>
                        <!--닉네임, 게시일자, 조회수 순-->
                        <div class="mb_board_title_bottom">
                          <span class="nickname">관리자</span>
                          <span class="views"><i class="fas fa-eye"></i>&nbsp<c:out value="${board.viewcount}"/></span>
                          <span class="comments"><i class="far fa-comments"></i>&nbsp<c:out value="${board.boardreply_count}"/></span>
                          <span class="thumb"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i>&nbsp<c:out value="${board.boardlikecount}"/></span>
                          <span class="date"><fmt:formatDate pattern="MM-dd HH:mm" value="${board.regdate}"/></span>
                        </div>
                      </td>
                    </tr>
                    </c:when>
                    
                    <c:when test="${not empty board.boardattachimagefilelist[0].boardattachimage_seq && board.notice eq 1}">
                    <!--공지o,이미지 있는 버전-->
                    <tr class=board_list_elem>
                      <td>
                        <!--제목-->
                        <div class="mb_board_title">
							<span class="mb_category">공지</span><a href="${pageContext.request.contextPath}/board/get?bno=<c:out value="${board.bno}"/>&board_id=${boardmanage.board_id}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}"><c:out value="${board.title}"/></a>
                        </div>
                        <!--닉네임, 게시일자, 조회수 순-->
                        <div class="mb_board_title_bottom">
                          <span class="nickname">관리자</span>
                          <span class="views"><i class="fas fa-eye"></i>&nbsp<c:out value="${board.viewcount}"/></span>
                          <span class="comments"><i class="far fa-comments"></i>&nbsp<c:out value="${board.boardreply_count}"/></span>
                          <span class="thumb"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i>&nbsp<c:out value="${board.boardlikecount}"/></span>
                          <span class="date"><fmt:formatDate pattern="MM-dd HH:mm" value="${board.regdate}"/></span>
                        </div>
                      </td>
                      <!--이미지-->
                      <td colspan="2">
                        <span class="table_img"><img src="<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uploadpath}"/>/s_<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uuid}"/>" width="120" height="60"></span>
                      </td>
                    </tr>
                    </c:when>
                   
                	<c:when test="${empty board.boardattachimagefilelist[0].boardattachimage_seq && board.notice eq 0}">
                    <!--공지x,이미지 없는 버전-->
                    <tr class="board_list_elem">
                      <td colspan="2">
                        <!--제목-->
                        <div class="mb_board_title">
                          <a href="${pageContext.request.contextPath}/board/get?bno=<c:out value="${board.bno}"/>&board_id=${boardmanage.board_id}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}"><c:out value="${board.title}"/> </a>
                        </div>
                        <!--닉네임, 게시일자, 조회수 순-->
                        <div class="mb_board_title_bottom">
                          <span class="nickname"><c:out value="${board.writer}"/></span>
                          <span class="views"><i class="fas fa-eye"></i>&nbsp<c:out value="${board.viewcount}"/></span>
                          <span class="comments"><i class="far fa-comments"></i>&nbsp<c:out value="${board.boardreply_count}"/></span>
                          <span class="thumb"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i>&nbsp<c:out value="${board.boardlikecount}"/></span>
                          <span class="date"><fmt:formatDate pattern="MM-dd HH:mm" value="${board.regdate}"/></span>
                        </div>
                      </td>
                     </tr>                   	
                   	</c:when>
                   
                   
					<c:when test="${not empty board.boardattachimagefilelist[0].boardattachimage_seq && board.notice eq 0}">
                   <!--공지x,이미지 있는 버전-->
                    <tr class="board_list_elem">
                      <td>
                        <!--제목-->
                        <div class="mb_board_title">
                          <a href="${pageContext.request.contextPath}/board/get?bno=<c:out value="${board.bno}"/>&board_id=${boardmanage.board_id}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}"><c:out value="${board.title}"/></a>
                        </div>
                        <!--닉네임, 게시일자, 조회수 순-->
                        <div class="mb_board_title_bottom">
                          <span class="nickname"><c:out value="${board.writer}"/></span>
                          <span class="views"><i class="fas fa-eye"></i>&nbsp<c:out value="${board.viewcount}"/></span>
                          <span class="comments"><i class="far fa-comments"></i>&nbsp<c:out value="${board.boardreply_count}"/></span>
                          <span class="thumb"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i>&nbsp<c:out value="${board.boardlikecount}"/></span>
                          <span class="date"><fmt:formatDate pattern="MM-dd HH:mm" value="${board.regdate}"/></span>
                        </div>
                      </td>
                      <!--이미지-->
                      <td colspan="2">
                        <span class="table_img"><img src="<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uploadpath}"/>/s_<c:out value="${board.boardattachimagefilelist[0].boardattachimage_uuid}"/>" width="120" height="60"></span>
                      </td>
                    </tr>
					</c:when>
                   
                   </c:choose>

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
						<%-- <input type='hidden' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>'> --%>
						<input type='hidden' name='board_id' value='${boardmanage.board_id}'>
						
						<input type='hidden' name='type' value='TCW'>
						<%-- <input type="hidden" name="boardLocation" value=<c:out value='${boardmanage.boardLocation}'/>> --%>
						<input type="submit" value="search" class="board_list_search_btn" onclick="go_search()"/>	
					</span>				
				</form>
              </div>
              
              <!--페이지 이동-->
              
              <form name="listformm" action="/board/list" method="get">
                <table class="board_list_page_idx">
                  <tr>
        			<td style="width:30px">
	        			<c:if test="${pageMaker.prev}">
							<a href="${pageContext.request.contextPath}/board/list?keyword=${pageMaker.cri.keyword}&board_id=${boardmanage.board_id}&pageNum=${pageMaker.startPage -1}">이전</a>
						</c:if>
					</td>
					
					<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
						<td style="width:20px">
							<a href="${pageContext.request.contextPath}/board/list?board_id=${boardmanage.board_id}&pageNum=${num}&keyword=${pageMaker.cri.keyword}&type='TCW'">${num}</a>
							<%-- <a href="#" onclick="go_listformm(this)" data-value="${num}">${num}</a> --%>
							
						</td>
					</c:forEach>
					
					<td style="width:30px">
						<c:if test="${pageMaker.next}">
							<a href="${pageContext.request.contextPath}/board/list?keyword=${pageMaker.cri.keyword}&board_id=${boardmanage.board_id}&pageNum=${pageMaker.endPage +1}">다음</a>
						</c:if>		
                    </td>
                  </tr>
                  </table>
                  		<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
						<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
						<input type='hidden' name='keyword' value='<c:out value="${pageMaker.cri.keyword}"/>'>
						<input type='hidden' name='board_id' value='${boardmanage.board_id}'>
						<input type='hidden' name='type' value='TCW'>
                </form>
                </section>




<%@include file="../include/content_right.jsp" %>
<%@include file="include/include_board_footer.jsp" %>