<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">
function go_floatingformm_search(){
	document.floatingformm.action = "/board/list";
	document.floatingformm.method = "get";
	document.floatingformm.submit();
}
</script>
                  
                  
       <!--내비(모바일 용) : 오른쪽 하단 글쓰기, 검색 버튼-->
       <nav class="floating">
         <div class="remote_control">
           <div><a href="<c:url value="/board/register?board_id=${boardmanage.board_id}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}"/>"><i class="fas fa-pencil-alt"></i></a></div>
             <div></div>
            </div>
              	<form name="floatingformm" class="search-bar">
              	<input type="search" name="keyword" pattern=".*\S.*" required>
              	<button class="search-btn" type="submit" onclick="go_floatingformm_search()">
              		<span>Search</span>
              	</button>
              	
              	<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
				<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
				<input type='hidden' name='board_id' value='${boardmanage.board_id}'>
				<input type='hidden' name='type' value='TCW'>
              	</form>
         </nav>
    </main>
      <footer id="footer">
        <div class="container">
          <ul>
            <li><a href="http://www.sejong.ac.kr/">세종대학교</a></li>
            <li>|</li>
            <li><a href="http://www.sejongstudent.com/xe/">총학생회</a></li>
            <li>|</li>
            <li><a href="#">이용약관</a></li>
          </ul>
          <div class="sns_link">
          <a href="mailto:wesejong@wesejong.cafe24.com"><img src="../../../resources/img/mail.PNG" /></a>
            <a href="https://m.blog.naver.com/PostList.nhn?blogId=sejong_univ"><img src="../../../resources/img/blog.png" /></a><a
              href="https://www.facebook.com/sejongpr/"><img src="../../../resources/img/FACEBOOK.png" /></a><a
              href="https://www.youtube.com/channel/UCWudhN8zaGEeiSd3z2B1ijw"><img src="../../../resources/img/youtube.png" /></a>
          </div>
          <i class="copyright">COPYRIGHTⓒ 2022 WESJU ADMINISTRATOR. ALL RIGHT RESERVED.</i>
        </div>
        <div class="black"></div>
      </footer>
    </div>
    <div class="parallax_back_layer"></div>
  </div>
</body>


</html>
