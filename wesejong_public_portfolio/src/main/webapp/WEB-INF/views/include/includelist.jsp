
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<link rel="stylesheet" type="text/css" href="../../resources/css/board/include/includeboardListcontainer.css">

<script type="text/javascript">

function go_search(){
	document.searchformm.action="/board/list";
	
}


</script>


<div id="container">

				<div id="boardSearching">

					<div id="boardSearchingInput">
					
						<form id="searchForm" name="searchformm" action="/board/list" method="get">
							<select name="type">
								<option value="T">title</option>
								<option value="C">content</option>
								<option value="W">writer</option>
							</select>
							<input type="text" name='keyword' placeholder="검색">		
							<input type="hidden" name="boardLocation" value=<c:out value='${boardmanage.boardLocation}'/>>
							<button>search</button>							
						</form>

					</div>
				</div>

				<div id="boardList">
					<table id="boardListTable" >
						<colgroup>
							<col width="50px">
							<col width="400px">
							<col width="150px">
							<col width="50px">
							<col width="50px">
							<col width="50px">
						</colgroup>
						




						<tr class="table_tr_th">
							<td class="table_th">번호</td>
							<td class="table_th">제목</td>
							<td class="table_th">작성자</td>
							<td class="table_th">날짜</td>
							<td class="table_th">조회수</td>
							<td class="table_th">추천수</td>
						</tr>
						
						<c:forEach items="${list}" var="board">
							<tr class="table_tr_td">
								<td class="table_td table_bno">
								    <c:out value="${board.bno}"/>
								</td>
								<td class="table_td table_title">
									<a href='/board/get?bno=<c:out value="${board.bno}"/>&boardLocation=<c:out value="${boardmanage.boardLocation}"/>'>
								   	 <c:out value="${board.title}"/>
								  	</a>
								</td>
								<td class="table_td table_writer">
								    <c:out value="${board.writer}"/>
								</td>
								<td class="table_td table_date">
									<fmt:formatDate pattern="yyyy-MM-dd" 
									value="${board.regdate}"/>
								    
								</td>
								<td class="table_td table_view">
									100
								</td>
								<td class="table_td table_like">
									15
								</td>
							</tr>
						</c:forEach>
																	
					</table>
				</div>

				<div id="boardMenu">
					<div id="boardMenuButton">
						<a href="<c:url value="/board/register?boardLocation="/><c:out value='${boardmanage.boardLocation}'/>">
							<button>글쓰기</button>
						</a>
					</div>

					
				</div>
				<div id="boardPaging">
					
				
						<c:if test="${pageMaker.prev}">
							<a href="${pageContext.request.contextPath}/board/list?pageNum=${pageMaker.startPage -1}&boardLocation=${boardmanage.boardLocation}">Previous</a>
						</c:if>
						
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<a href="${pageContext.request.contextPath}/board/list?pageNum=${num}&amount=10&boardLocation=${boardmanage.boardLocation}">${num}</a>
						</c:forEach>
	
						<c:if test="${pageMaker.next}">
							<a href="${pageContext.request.contextPath}/board/list?pageNum=${pageMaker.endPage +1}&boardLocation=${boardmanage.boardLocation}">Next</a>
						</c:if>		

				</div> 
<%-- 				<div id="boardPaging">
					
					
					<form id='actionForm' action="/board/list" method="get">
						<c:if test="${pageMaker.prev}">
							<a href="${pageMaker.startPage -1}">Previous</a>
						</c:if>
						
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<a href="${num}">${num}</a>
						</c:forEach>
	
						<c:if test="${pageMaker.next}">
							<a href="${pageMaker.endPage +1}">Next</a>
						</c:if>		
						
						<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
						<input type="hidden" name="amount" value="${pageMaker.cri.amount}">		
					</form>
					

				</div> --%>

			</div>
			

