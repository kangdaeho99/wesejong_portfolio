<!-- ## 👩🏻‍💻 프로젝트 소개
--- 
-->

### 🏫 **위세종(Wesju) , 세종대학교 웹커뮤니티 사이트**

**링크 : [https://wesejong.cafe24.com](https://wesejong.cafe24.com)     (Chrome 환경에서 접속)**

**깃허브소스코드 :** [https://github.com/kangdaeho99/wesejong_public_portfolio](https://github.com/kangdaeho99/wesejong_public_portfolio)

테스트 계정 ID/PW : test1 / test1

테스트 계정 ID/PW : test2 / test2 

![[https://wesejong.cafe24.com](https://wesejong.cafe24.com/)](https://user-images.githubusercontent.com/48047377/204066094-5732b691-0144-47f3-ae5d-ad451f13414f.png)

[https://wesejong.cafe24.com](https://wesejong.cafe24.com/)

**프로젝트 설명** 

- 세종대학교 학생들이 이용할 수 있는 학생 커뮤니티 사이트입니다.

- 개발 기간 : 2021-08-01 ~ 2022-03-01 

- 개발 인원 : 2명

- <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 

**프로젝트 기획의도**

- 세종대학교의 학생들만의 웹커뮤니티가 없는 점이 아쉬웠습니다. 학교의 특성을 잘 이해하고 있는 학생들이 제작한 커뮤니티가 학생들의 니즈를 만족시킬 수 있다고 생각하여 세종대 재학생들이 직접 웹커뮤니티를 만들어 보았습니다. 
- COVID-19로 인해 오랜 사회적 거리두기로 지친 학생들과 친구들을 사귀지 못한 신입생들을 위해 비대면으로 학생들 간 친목을 다질 수 있는 학생 간 랜덤 매칭 서비스를 구현해 보았습니다.

**개발목표**

- 실제로 배포를 목적으로 하여, 배포를 하여 약 70명정도의 회원이 가입하였고, 미팅매칭이벤트에 20명정도 지원하여 5팀이 매칭에 성공했습니다.
- PC버전과 모바일버전 두개 완성을 목표로 하였습니다.
- 대학생이 만든 사이트가 아닌 일반사이트처럼 보이도록 개발하기 위하여 일반사이트에서 지원하는 기능들을 모두 개발하는것을 목표로 했습니다.

**팀인원 및 역할**

- 프로젝트 리더, 백엔드 1명: 강대호
- 프론트엔드, 디자인 1명 : 강원지

**개발과정**

- 서비스의 기획부터 마무리까지 경험해보고 싶었습니다.
- 각 파트마다 1명만 담당을 하여 서비스의 처음부터 끝까지 직접 경험할 수 있었고, 이러한 작은 프로젝트에 사람이 많을 경우 오히려 의사소통의 비용, 기획과정에서의 결정비용이 증가한다고 생각하여 최소한의 인원으로 진행했습니다.

## 📜 기술 스택

---

### Front & Backend

- java 1.8
- Spring Framework 5.0.7
- MySQL 8.0.21
- HTML/CSS, JAVASCRIPT
- AJAX

### Maven Added Library

- **For Spring Security** : spring-security-web 5.0.7, spring-security-config 5.0.7, spring-security-core 5.0.7, spring-security-taglibs 5.0.7
- **For Checking log** : log4j 1.2.15, log4jdbc-log4j2-jdbc4 1.16, slf4j-api 1.6.6, jcl-over-slf4j 1.6.6, slf4j-log4j12 1.6.6
- **For Test** : junit 4.12, spring-test
- **For Connect databases with mybatis(SQL Mapper)** : mybatis 3.4.6, mybatis-spring 1.3.2, spring-jdbc, spring-tx(transaction), HikariCP 2.7.8, mysql-connector-java 8.0.21
- **For Board Image** : thumbnailator 0.4.8
- **For Develop Efficiency** : lombok 1.18.0,
- **For Chatting** : spring-websocket 5.0.7, spring-messaging 5.0.7, javax.websocket-api 1.1
- **For Mailing** : javax.mail 1.5.6
- **For Other things** : spring-context-support 5.0.7
- **For Changing DataFormat** : gson 2.8.2, jackson-databind 2.9.6, jackson-dataformat-xml 2.9.6

### Infrastructure

- Spring Framework with Github Actions
- CAFE24, PUTTY, FILEZILLA
- Apache Tomcat 9.0.30


### 📒DB구조

---
![DB ERD](https://user-images.githubusercontent.com/48047377/209076110-03a1741c-822a-48fa-a3ea-3b5538a85346.PNG)


<br/>
<br/>

**사이트접속방법 및 홍보방법**

- 구글에서 ‘wesejong’ 네이버에서 ‘wesejong’을 검색하면 접속가능합니다.
- 에브리타임 홍보게시판, 세종대학교 갤러리에 홍보

<!-- ![구글에서 ‘wesejong’을 검색한 그림](https://user-images.githubusercontent.com/48047377/204066102-9da07165-780b-4c7f-a554-907ebbfa7dfd.png) -->
<img src="https://user-images.githubusercontent.com/48047377/204066102-9da07165-780b-4c7f-a554-907ebbfa7dfd.png" height="400">
<!-- 구글에서 ‘wesejong’을 검색한 그림 -->

<!-- ![네이버에서 ‘wesejong’을 검색한 그림](https://user-images.githubusercontent.com/48047377/204066106-a17b1b7d-f7da-47fd-b52f-c32a2ec64b97.png) -->
<img src="https://user-images.githubusercontent.com/48047377/204066106-a17b1b7d-f7da-47fd-b52f-c32a2ec64b97.png" height="400">
<!-- 네이버에서 ‘wesejong’을 검색한 그림 -->

<img src="https://user-images.githubusercontent.com/48047377/204066117-b23ca6ee-b03f-4158-a7e5-c9fd026ace4c.jpg" height="400">

<details>
<summary><U>추가 홍보 이미지 클릭</U></summary>
<div markdown="1">
<!-- ![에브리타임에 홍보글1](https://user-images.githubusercontent.com/48047377/204066109-9b1f1c9d-a468-4ead-b9d6-f4134e42996e.jpg) -->
<img src="https://user-images.githubusercontent.com/48047377/204066109-9b1f1c9d-a468-4ead-b9d6-f4134e42996e.jpg" height="400">

<!-- ![에브리타임홍보글2](https://user-images.githubusercontent.com/48047377/204066114-7d5f5934-a63c-4e16-b91d-0b0317635ab0.jpg) -->
<img src="https://user-images.githubusercontent.com/48047377/204066114-7d5f5934-a63c-4e16-b91d-0b0317635ab0.jpg" height="400">
    

<!-- ![에브리타임홍보글3](https://user-images.githubusercontent.com/48047377/204066117-b23ca6ee-b03f-4158-a7e5-c9fd026ace4c.jpg) -->
<img src="https://user-images.githubusercontent.com/48047377/204066117-b23ca6ee-b03f-4158-a7e5-c9fd026ace4c.jpg" height="400">

<!-- ![세종대학교 갤러리 홍보글1](https://user-images.githubusercontent.com/48047377/204066118-b42fff6f-0a89-4416-ad3f-e114ee0557b9.png) -->
<img src="https://user-images.githubusercontent.com/48047377/204066118-b42fff6f-0a89-4416-ad3f-e114ee0557b9.png" height="400">

<!-- ![세종대학교 갤러리 홍보글2](https://user-images.githubusercontent.com/48047377/204066120-b002c426-1004-45bf-ad86-0ede8efd722d.png) -->
<img src="https://user-images.githubusercontent.com/48047377/204066120-b002c426-1004-45bf-ad86-0ede8efd722d.png" height="400">

</div>
</details>

<br/><br/>



**구현된기능**

1) 사용자 (Spring Security)

- 로그인
- 회원가입
- 회원탈퇴
- 회원 비밀번호 찾기
- 회원 비밀번호 수정
- 회원 닉네임 변경
- 회원정보확인(마이페이지)
- 사용자 간 채팅기능 ( 1:1 채팅, 단체채팅 )
- 알림쪽지기능( 새로 회원가입시, 글에 댓글이 달릴시, 이벤트에 당첨되었을시 .. )

2) 게시판 

- 게시글 작성 ( ckeditor 활용한 에디터사용, 이미지 파일 업로드 )
- 게시글 수정
- 게시글 삭제
- 게시글 작성자에게 채팅기능
- 게시글 좋아요 기능
- 게시글 싫어요 기능
- 댓글달기 기능
    - 대댓글 달기
    - 댓글 좋아요 기능

3) 채팅 (Spring Websocket with Stomp)

- 채팅기능
- 단체채팅기능
- 채팅방 나가기기능

4)관리자

- 게시판관리기능 (생성, 삭제)
- 채팅관리기능
- 회원관리기능
- 데이터베이스테이블 확인기능

---

PC화면

---

테스트 계정 ID/PW : test1 / test1  

테스트 계정 ID/PW : test2 / test2 

### 메인페이지입니다.

로그인을 한상태로만 사이트에 접속이 가능하니 위의 테스트계정으로 접속바랍니다.

![Untitled](https://user-images.githubusercontent.com/48047377/204066126-2b4bc0f4-2cb2-44e2-96ae-3d17cf44569b.png)

![Untitled](https://user-images.githubusercontent.com/48047377/204066128-e620e1d5-9a49-4c2a-8fe7-895ec9f82d78.png)

![Untitled](https://user-images.githubusercontent.com/48047377/204066130-67620195-160c-4609-af6f-a1242d98aedf.png)

![메인페이지 [https://wesejong.cafe24.com/](https://wesejong.cafe24.com/)](https://user-images.githubusercontent.com/48047377/204066134-5f76a35b-88e1-4155-8dae-6f8dacc09060.png)

메인페이지 [https://wesejong.cafe24.com/](https://wesejong.cafe24.com/)

### 로그인화면입니다.

spring security를 활용하여 관리자, 멤버별로 접근할 수 있는 페이지를 지정했습니다. 

관리자 권한(role = admin)이라면, 관리자페이지로 이동합니다.

일반회원 권한(role = member)이라면, 메인페이지로 이동합니다.

![Untitled](https://user-images.githubusercontent.com/48047377/204066138-e311cbda-5433-4ccc-b133-242b577b6bbc.png)

![위세종 로그인화면 [https://wesejong.cafe24.com/member/login](https://wesejong.cafe24.com/member/login)](https://user-images.githubusercontent.com/48047377/204066141-3134dbc0-1f06-454e-a82d-3dcebfdd6d1b.png)

위세종 로그인화면 [https://wesejong.cafe24.com/member/login](https://wesejong.cafe24.com/member/login)

### 회원가입화면입니다.

회원가입을 진행하면서 각각의 정보들을 입력하면서 자바스크립트로 유효성검사들을 처리해주고, 

세종대학교 재학생만 가지고 있는 이메일 주소인 @sju.ac.kr 을 통하여 재학생인증을 하도록 개발했습니다. 이메일 인증번호를 Spring Session에 저장하여 사용자가 이메일번호를 보지못하도록 개발하였습니다.

![Untitled](https://user-images.githubusercontent.com/48047377/204066144-6f7494b8-378d-48b8-bdf9-5df3c72d3115.png)

![회원가입화면 [https://wesejong.cafe24.com/member/join](https://wesejong.cafe24.com/member/join)](https://user-images.githubusercontent.com/48047377/204066145-e709b2f0-95e6-4506-84dd-5e62e597f9f3.png)

회원가입화면 [https://wesejong.cafe24.com/member/join](https://wesejong.cafe24.com/member/join)

### 인증번호발송화면입니다.

세종대학교 학생만 가입할 수 있게 세종대학생만이 가입가능한 학교이메일(@sju.ac.kr)로만 발송될 수 있게 처리했습니다.

또한 인증번호발송은 wesejong@[weseong.cafe24.com](http://weseong.cafe24.com)  구글 SMTP를 사용하여 메일을 발송하였습니다

![위세종 SMTP를 활용한 메일인증화면](https://user-images.githubusercontent.com/48047377/204066148-6a63f6ec-da3f-45a3-91bd-cbc755b97dcd.png)

위세종 SMTP를 활용한 메일인증화면

### 아이디찾기, 패스워드찾기 화면입니다.

위세종 아이디/비밀번호를 분실하였을때 이메일 인증번호를 통하여 아이디 찾기,패스워드 찾기 기능입니다.

<!-- ![아이디찾기 화면 [https://wesejong.cafe24.com/member/forgot](https://wesejong.cafe24.com/member/forgot)](https://user-images.githubusercontent.com/48047377/204066151-3a293d92-b84f-44de-b03e-46a8e19b6bf9.png) -->
<img src="https://wesejong.cafe24.com/member/forgot](https://wesejong.cafe24.com/member/forgot)](https://user-images.githubusercontent.com/48047377/204066151-3a293d92-b84f-44de-b03e-46a8e19b6bf9.png" width="200"/>

아이디찾기 화면 [https://wesejong.cafe24.com/member/forgot](https://wesejong.cafe24.com/member/forgot)

![패스워드찾기화면 [https://wesejong.cafe24.com/member/forgot](https://wesejong.cafe24.com/member/forgot)](https://user-images.githubusercontent.com/48047377/204066153-321772ba-109f-4faa-a391-03f15cd503e5.png)

패스워드찾기화면 [https://wesejong.cafe24.com/member/forgot](https://wesejong.cafe24.com/member/forgot)

### 마이페이지 화면입니다.

본인의 아이디, 닉네임, 이메일, 학번을 볼 수 있습니다.

또한, 사용자는 닉네임 변경, 탈퇴하기 기능, 비밀번호 변경을 할 수 있습니다.

Session을 통해 현재 로그인한 사용자 고유번호를 통해 정보를 가져옵니다.

![Untitled](https://user-images.githubusercontent.com/48047377/204066155-eea9d478-e385-4879-b58d-1464cc0ae064.png)

![마이페이지화면 [https://wesejong.cafe24.com/member/mypage#](https://wesejong.cafe24.com/member/mypage#)](https://user-images.githubusercontent.com/48047377/204066159-b7753a3c-b594-4e4a-bcf2-5f6fa31ccde0.png)

마이페이지화면 [https://wesejong.cafe24.com/member/mypage#](https://wesejong.cafe24.com/member/mypage#)

### 탈퇴하기화면입니다.

[마이페이지]-[탈퇴하기] 버튼을 눌렀을떄 화면입니다.

![탈퇴하기기능 화면 [https://wesejong.cafe24.com/member/secession](https://wesejong.cafe24.com/member/secession)](https://user-images.githubusercontent.com/48047377/204066160-fe92864b-874c-4a1c-b7b8-4a682539a240.png)

탈퇴하기기능 화면 [https://wesejong.cafe24.com/member/secession](https://wesejong.cafe24.com/member/secession)

### 알림내역화면입니다.

회원이 받은 알림을 확인할 수 있습니다.

회원가입을 완료하였을때, 미팅매칭에서 이벤트 신청이 완료되었을때 알림이 나오게 만들었습니다.

![알림내역 확인 [https://wesejong.cafe24.com/member/info/alarm#](https://wesejong.cafe24.com/member/info/alarm#)](https://user-images.githubusercontent.com/48047377/204066162-f0296b96-4336-4b3d-a3f9-bda5b7def092.png)

알림내역 확인 [https://wesejong.cafe24.com/member/info/alarm#](https://wesejong.cafe24.com/member/info/alarm#)

### 채팅내역화면입니다.

본인이 채팅하고 있는 채팅목록이 나옵니다.

채팅방에는 여러명의 사람들이 들어와 함께 채팅할 수 있습니다.

채팅같은경우, 게시글의 작성자, 댓글을 쓴 사람들에게 채팅을 걸 수 있습니다.

![채팅목록화면 [https://wesejong.cafe24.com/member/info/chatroomlist](https://wesejong.cafe24.com/member/info/chatroomlist)](https://user-images.githubusercontent.com/48047377/204066165-2e6560fe-b1b7-48ac-ab5b-489b5d89b022.png)

채팅목록화면 [https://wesejong.cafe24.com/member/info/chatroomlist](https://wesejong.cafe24.com/member/info/chatroomlist)

### 채팅방화면입니다.

Spring WebSocket with Stomp(스트리밍 텍스트 지향 프로토콜)를 통하여 채팅기능을 구현했습니다. 

채팅을 하는 모습입니다. 오른쪽 상단의 나가기버튼을 통해 채팅방에서 아예 나갈 수 있습니다.

![Spring Websocket With Stomp 채팅화면 , test1과 test2가 서로 채팅하는모습[https://wesejong.cafe24.com/socket/chat?chatroom_uuid=868e383c-1ffb-4f08-84c8-e15cca6f1864](https://wesejong.cafe24.com/socket/chat?chatroom_uuid=868e383c-1ffb-4f08-84c8-e15cca6f1864&new_board_id_999=1&new_board_id_101=0&new_board_id_102=0&new_board_id_103=0&new_board_id_104=0&new_board_id_105=0&new_board_id_106=0&new_board_id_201=0&new_board_id_202=0&new_board_id_203=0&new_board_id_204=0&new_board_id_205=0&new_board_id_206=0&new_board_id_301=0&new_board_id_302=0&new_board_id_303=0&new_board_id_304=1&new_board_id_305=0&new_board_id_306=0&new_board_id_401=0&new_board_id_402=0&new_board_id_403=0&new_board_id_404=0&new_board_id_405=0&new_board_id_406=0&new_board_id_501=0&new_board_id_502=1&new_board_id_503=0&new_board_id_504=0&new_board_id_505=0&new_board_id_506=0&new_alarm=3)](https://user-images.githubusercontent.com/48047377/204066168-1cde6aa4-efe9-4373-9a84-216e3f6566df.png)

Spring Websocket With Stomp 채팅화면 , test1과 test2가 서로 채팅하는모습[https://wesejong.cafe24.com/socket/chat?chatroom_uuid=868e383c-1ffb-4f08-84c8-e15cca6f1864](https://wesejong.cafe24.com/socket/chat?chatroom_uuid=868e383c-1ffb-4f08-84c8-e15cca6f1864&new_board_id_999=1&new_board_id_101=0&new_board_id_102=0&new_board_id_103=0&new_board_id_104=0&new_board_id_105=0&new_board_id_106=0&new_board_id_201=0&new_board_id_202=0&new_board_id_203=0&new_board_id_204=0&new_board_id_205=0&new_board_id_206=0&new_board_id_301=0&new_board_id_302=0&new_board_id_303=0&new_board_id_304=1&new_board_id_305=0&new_board_id_306=0&new_board_id_401=0&new_board_id_402=0&new_board_id_403=0&new_board_id_404=0&new_board_id_405=0&new_board_id_406=0&new_board_id_501=0&new_board_id_502=1&new_board_id_503=0&new_board_id_504=0&new_board_id_505=0&new_board_id_506=0&new_alarm=3)

### 게시글목록화면입니다.

게시글에서는 검색(제목 + 내용)이 가능합니다.

관리자는 관리자메뉴에서 공지글을 등록할 수 있습니다.

또한 이미지파일이 있을시 목록에 이미지파일 표시, 댓글표시 등이 나타납니다.

![Untitled](https://user-images.githubusercontent.com/48047377/204066172-6a9e0c37-3ec2-43df-b87d-a064dc322d08.png)

![게시판 목록화면 [https://wesejong.cafe24.com/board/list?board_id=103](https://wesejong.cafe24.com/board/list?board_id=103)](https://user-images.githubusercontent.com/48047377/204066174-3650a835-d75d-45af-97da-d3525bb72361.png)

게시판 목록화면 [https://wesejong.cafe24.com/board/list?board_id=103](https://wesejong.cafe24.com/board/list?board_id=103)

### 게시글 상세보기입니다.

게시글 좋아요, 싫어요기능

댓글 달기, 대댓글달기 기능이 있습니다.

<맛집게시판, 맛집게시판에 올려진 게시글상세보기입니다>

![Untitled](https://user-images.githubusercontent.com/48047377/204066176-d010f936-d727-4a04-b5c3-4521be6b7474.png)

![Untitled](https://user-images.githubusercontent.com/48047377/204066178-0bcb32e3-e2ec-445f-976e-7bfc05949cf9.png)

![Untitled](https://user-images.githubusercontent.com/48047377/204066179-1df9749b-b2f7-4a97-8458-244397a61f29.png)

![Untitled](https://user-images.githubusercontent.com/48047377/204066180-448ae8f3-0e9d-4195-a846-9e6501d9a676.png)

![Untitled](https://user-images.githubusercontent.com/48047377/204066182-b4d1a134-e97c-48de-bd4c-47404a05a636.png)

![Untitled](https://user-images.githubusercontent.com/48047377/204066185-3fc66e59-f812-45fd-aea6-fd5709c9e34c.png)

![Untitled](https://user-images.githubusercontent.com/48047377/204066186-538348e5-190c-4faa-a727-053f7f3485f2.png)

![게시판 상세보기 화면1 [https://wesejong.cafe24.com/board/get?bno=6](https://wesejong.cafe24.com/board/get?bno=6)](https://user-images.githubusercontent.com/48047377/204066189-72e6f968-5ba1-43bb-9c04-90fb4679d9b7.png)

게시판 상세보기 화면1 [https://wesejong.cafe24.com/board/get?bno=6](https://wesejong.cafe24.com/board/get?bno=6)

### <자유게시판 - 가입인사하는 상세글입니다.>

![Untitled](https://user-images.githubusercontent.com/48047377/204066194-193d866c-ee04-406a-bd54-40e4883cb97f.png)

![Untitled](https://user-images.githubusercontent.com/48047377/204066197-15fbc0f9-f118-469e-972d-b1b3110cf2f5.png)

![Untitled](https://user-images.githubusercontent.com/48047377/204066199-a4188a86-ab11-40ea-a639-8da74f941231.png)

![게시판 상세보기 화면2 [https://wesejong.cafe24.com/board/get?bno=8&board_id=103&pageNum=1&amount=20#](https://wesejong.cafe24.com/board/get?bno=8&board_id=103&pageNum=1&amount=20#)](https://user-images.githubusercontent.com/48047377/204066201-06a84099-bd34-4bb2-9f42-cd2278abd7eb.png)

게시판 상세보기 화면2 [https://wesejong.cafe24.com/board/get?bno=8&board_id=103&pageNum=1&amount=20#](https://wesejong.cafe24.com/board/get?bno=8&board_id=103&pageNum=1&amount=20#)

### 게시글 등록화면입니다.

CKEDITOR를 이미지 첨부, 글꼴 편집이 가능합니다.

CKEDITOR YOUTUBE Plugin을 통해 퍼오기가 가능합니다.

게시글 왼쪽상단에 게시판을 설정하여 원하는 게시판에 글을 작성할 수 있습니다.

![Untitled](https://user-images.githubusercontent.com/48047377/204066207-64f81bf4-dad7-42b9-b99a-4ed524680c25.png)

![게시글 등록화면](https://user-images.githubusercontent.com/48047377/204066211-61e8140f-6f13-46cb-ab2e-55e397b7430b.png)

게시글 등록화면

### 위의 작성한 글의 상세보기입니다.

![Untitled](https://user-images.githubusercontent.com/48047377/204066222-856d9048-19f6-4584-b16d-02e0eb3b6739.png)

![게시글 상세화면](https://user-images.githubusercontent.com/48047377/204066218-d3daec84-4308-424b-89e6-7a2d62cd5db3.png)

게시글 상세화면

## **미팅매칭설명페이지입니다.**

![미팅매칭 설명페이지1 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)](https://user-images.githubusercontent.com/48047377/204066231-ed92d324-a253-4b48-b5a0-1b883f0d02de.png)

미팅매칭 설명페이지1 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)

![미팅매칭 설명페이지2 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)](https://user-images.githubusercontent.com/48047377/204066234-2d2ea216-b84f-4712-a673-274ec87bbeb3.png)

미팅매칭 설명페이지2 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)

![미팅매칭 설명페이지3 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)](https://user-images.githubusercontent.com/48047377/204066235-76201c7c-2cb5-4f19-abfd-9f1349388f0f.png)

미팅매칭 설명페이지3 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)

![미팅매칭 설명페이지4 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)](https://user-images.githubusercontent.com/48047377/204066240-a9ed1130-d754-4363-82f5-1c6b15d7e7c7.png)

미팅매칭 설명페이지4 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)

![미팅매칭 설명페이지5 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)](https://user-images.githubusercontent.com/48047377/204066244-e1dffd2a-1123-4487-a5b9-4644c0dd8235.png)

미팅매칭 설명페이지5 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)

### 지원서작성화면입니다.

![미팅매칭 지원서 작성화면1 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)](https://user-images.githubusercontent.com/48047377/204066246-a1d6ae62-1dcb-4916-a634-555cc23c8043.png)

미팅매칭 지원서 작성화면1 [https://wesejong.cafe24.com/meetmatch/event/explanation](https://wesejong.cafe24.com/meetmatch/event/explanation)

### 지원서작성화면입니다.

인원은 1명, 2명, 4명이 존재합니다.

1명일때는 혼자서 지원하고, 2명이면 본인과 다른한명입니다.

인원은 관리자기능에서 유동적으로 변경할 수 있습니다.

지원방식은 같이 지원할 친구의 아이디를 적습니다. 

존재하는 아이디라면 초록색 ✅가 나오고, 존재하지 않다면 빨간색 ❌표시가 나옵니다.

![미팅매칭 지원서작성화면 2 [https://wesejong.cafe24.com/meetmatch/event/apply](https://wesejong.cafe24.com/meetmatch/event/apply)](https://user-images.githubusercontent.com/48047377/204066247-538846d6-804f-4255-af92-33f4080e6059.png)

미팅매칭 지원서작성화면 2 [https://wesejong.cafe24.com/meetmatch/event/apply](https://wesejong.cafe24.com/meetmatch/event/apply)

### 지원이 완료된 화면입니다.

지원이 완료되면, 알림 메세지가 가게되고 발표일까지 기다리게 됩니다.

![미팅매칭 지원완료페이지 [https://wesejong.cafe24.com/meetmatch/event/apply](https://wesejong.cafe24.com/meetmatch/event/apply)](https://user-images.githubusercontent.com/48047377/204066250-293377b0-7fd1-4e90-9fa5-089787ec6c47.png)

미팅매칭 지원완료페이지 [https://wesejong.cafe24.com/meetmatch/event/apply](https://wesejong.cafe24.com/meetmatch/event/apply)

### 지원 에러메시지화면입니다.

-중복지원할시, 서버단에서 검사하는 아이디유효성검사에서 오류가 나왔을시 에러가 발생합니다.

![미팅매칭 지원실패페이지 [https://wesejong.cafe24.com/meetmatch/event/apply](https://wesejong.cafe24.com/meetmatch/event/apply)](https://user-images.githubusercontent.com/48047377/204066253-26533d30-967f-4c87-89fa-cf177ece1414.png)

미팅매칭 지원실패페이지 [https://wesejong.cafe24.com/meetmatch/event/apply](https://wesejong.cafe24.com/meetmatch/event/apply)

### 지원내역화면입니다.

본인이 지원했던 이력을 볼 수 있습니다. 

![미팅매칭 지원목록페이지 [https://wesejong.cafe24.com/meetmatch/event/applicationhistory](https://wesejong.cafe24.com/meetmatch/event/applicationhistory)](https://user-images.githubusercontent.com/48047377/204066256-dc016f2d-b098-4023-a13c-abd6d72b955e.png)

미팅매칭 지원목록페이지 [https://wesejong.cafe24.com/meetmatch/event/applicationhistory](https://wesejong.cafe24.com/meetmatch/event/applicationhistory)

위의 지원목록을 하나 클릭하면 해당 지원의 상세정보가 나옵니다.

아래의 페이지에서 미팅 승인/취소를 할 수 있습니다.

두명 모두 승인이 되어야만 미팅팀에 매칭될 수 있습니다.

### 지원상세정보입니다.

만약 매칭된다면 자동으로 미팅매칭된 팀이 채팅방에 초대되며, 매칭결과는 성공으로 변하게 됩니다.

![미팅매칭 지원상세페이지 [https://wesejong.cafe24.com/meetmatch/event/applicationdetails?meetmatchteam_seq=20](https://wesejong.cafe24.com/meetmatch/event/applicationdetails?meetmatchteam_seq=20)](https://user-images.githubusercontent.com/48047377/204066257-3c9a7834-5999-49f6-85f8-4ebf82fe02b5.png)

미팅매칭 지원상세페이지 [https://wesejong.cafe24.com/meetmatch/event/applicationdetails?meetmatchteam_seq=20](https://wesejong.cafe24.com/meetmatch/event/applicationdetails?meetmatchteam_seq=20)

### 관리자페이지입니다.

Spring Security를 통해 role이 ‘admin’인 사용자는 로그인하자마자 바로 관리자페이지로 이동합니다.

1.회원관리메뉴

Spring Security의 PasswordEncoder로 모든 패스워드는 암호화된 상태에서만 입력됩니다.

2.테이블관리메뉴

게시판의 유연한 관리를 위해 게시판정보의 삽입,삭제,수정이 가능합니다.

3.사용자관리메뉴

alarm(알람) 목록, chatrom(채팅방) 목록, chatroomjoin(채팅에 들어가있는 사용자관리) 목록을 볼수 있습니다.

4.이벤트관리메뉴

meetmatchmanage : 미팅매칭 이벤트 시작, 종료 데이터를 만듭니다.

meetmatchpersonnelmanage : 미팅매칭 이벤트의 인원수를 결정합니다.(1:1, 2:2, 4:4 등등)

meetmatchdepartment : 과 선택을 위해 만들었지만 실제로 사용하지는 않았습니다.

meetmatchprofile : 프로필 저장을 위해 만들었지만 실제로 사용하지는 않았습니다.

meetmatchteam : 미팅매칭에 신청한 팀의 목록을 보여줍니다.

meematchteammate : 미팅매칭팀에 소속된 팀원들의 정보를 보여줍니다.

이벤트랜덤미팅프로그램실행으로 무작위로 신청한 팀원들을 묶어줍니다.

![관리자페이지](https://user-images.githubusercontent.com/48047377/204066258-b3b75699-02fe-49df-991f-ae7784fc8bc8.png)

관리자페이지

# 미팅매칭서비스 개발 후 아쉬웠던점

- 미팅매칭서비스 같은 경우, 모든 지원을 받은 후에 한꺼번에 매칭을 시켜주는 방식으로 프로그램을 만들었지만, 만들고 난 이후에 보니 일정기간동안 미팅매칭 이벤트를 자동으로 계속해서 연결되는 방식으로 만들어주는것이 사용자 입장에서 더 편하여 더 많은 사용자가 참여했을 것 같습니다. 또한 관리자 입장에서도 이것이 더 편할것같습니다.
- 처음에 위와 같이 개발했던 이유는  사람들이 미팅매칭이벤트에 좀더 신뢰감을 가지길 원하는 이유로 한꺼번에 매칭을 잡아주는 방법을 개발하였지만, 사람들이 불편함을 느꼈고 그로인해 20명정도 밖에 지원하지 않은 것 같다고 느꼈습니다.
- 또한 미팅매칭서비스 지원시 개인정보로 성별만 요구하였었는데, 개인정보를 많이 요구할경우 사용자들이 지원하지 않을것같아서 최대한 적은 정보로 지원을 진행했습니다. 그렇지만 지금 생각해보니 좀더 전화번호나 카카오아이디 같은 정보를 요구하여 확실히 매칭시켜준다는 신뢰감을 주는것이 더 좋았을 것 같습니다.
