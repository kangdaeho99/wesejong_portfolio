<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Insert title here</title>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="https://kit.fontawesome.com/69fe52bc75.js" crossorigin="anonymous"></script>
   <link rel="stylesheet" type="text/css" href="/../../resources/css/member/login.css">
</head>
<body>
<h1>Custom Login Page</h1>
<h2><c:out value="${error}"/></h2>
<h2><c:out value="${logout}"/></h2>

<body>
    <!-- desktop header -->
    <div class="overlay"></div>
    <header id="header">
        <div class="container">
            <div class="header">
                <h1><a href="#" class="">WESJU</a></h1>
            </div>
        </div>
    </header>

    <!-- mobile header -->
    <header id="mobile_header">
        <div class="mobile_container">
            <div class="mobile_header">
                
            </div>
        </div>
    </header>


    <main>
        <section id="contents">
            <div class="container">
                <section id="cont_center">
                    <article class="login">
                        <h2 class=""></h2>
                        <form method='post' action="/login">
	                        <ul>
	                            <li><input type="text" name="username" placeholder="아이디" title="아이디입력"></li>
	                            <li><input type="password" name="password" placeholder="아이디" title="아이디입력"></li>
	                            <!-- <li><input type="checkbox" id="chk_id"><label for="chk_id">아이디저장</label></li> -->
	                            <li><button>로그인</button></li>
	                        </ul>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                        <div>
                            <h3 class="ir_su">로그인외기능</h3>
                            <ul>
                                <li><a href="#">아이디 찾기</a></li>
                                <li><a href="#">비밀번호 찾기</a></li>
                                <li><a href="#">회원가입</a></li>
                            </ul>
                        </div>
                    </article>

                    <article class="imgbox">
                        <a href="#"><img src="https://via.placeholder.com/410x150"></a>
                    </article>

                    <article class="sitemap_intro">
                        <h2 class="ir_su">사이트소개 공지사항 사이트이용약관 개인정보처리방침 </h2>
                        <ul>
                            <li><a href="#">사이트소개</a></li>
                            <li><a href="#">공지사항</a></li>
                            <li><a href="#">사이트이용약관</a></li>
                            <li><a href="#">개인정보처리방침</a></li>
                        </ul>
                    </article>

                </section>  
            </div>
       </section>
    </main>
    <footer id="footer">
        <div class="container">
            <h2>Footer</h2>
        </div>
    </footer>
</body>
</html>