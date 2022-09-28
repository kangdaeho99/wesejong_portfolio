/**
 * 
 */

//get.jsp에서 home.js로 인해 cont_right가 작동하지 않은 상황을 해결하기 위해 home.js를 제거해야함.그리하여 removeElement를 하기 위해서 익명함수를 -> 명명함수로 바꿔줍니다.

function addscrollevent_cont_right(){
    let scrollLocation = document.querySelector('.parallax_page').scrollTop; // 현재 스크롤바 위치
    let windowHeight = window.innerHeight; // 스크린 창
    let fullHeight = document.body.scrollHeight;
    let windowWidth = window.innerWidth;
    const nav = document.getElementById('cont_right');
    console.log(fullHeight+'창'+windowHeight);
    //content의 너비보다 창이 넓으면 cont_right가 스크롤 이동에 따라 움직임
    if (scrollLocation >= 469 && windowWidth >= 1162) {
        nav.style.position = "fixed";
        nav.style.right = "calc((101% - 1162px)/2)";
        nav.style.bottom = "0";
        //  alert('3');
    }
    //content의 너비보다 창이 좁으면cont_right가 스크롤 이동에 따라 움직임
    else if (scrollLocation >= 469 && windowWidth >= 768) {
        nav.style.position = "fixed";
        nav.style.left = "900px";
        nav.style.bottom = "0";
    }
    //상단으로 올라가거나 모바일 버전이면 원래 위치로 이동
    else {
        nav.style.position = "static";
    }
    if (scrollLocation >= 1360) {//cont_center높이
        nav.style.bottom = "60px";//1522+1588/2, footer높이 60
    }
    console.log(scrollLocation);
};

document.querySelector('.parallax_page').addEventListener('scroll',addscrollevent_cont_right);



function open_find_idpw(){//아이디찾기 창을 열어줌
    window.open('/member/forgot','_blank','width=570,  height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;alert('g');
  }




//home.html에만 적용
//스크롤 이벤트에 따른 cont_right의 이동
//document.querySelector('.parallax_page').addEventListener('scroll', function () {
//    let scrollLocation = document.querySelector('.parallax_page').scrollTop; // 현재 스크롤바 위치
//    let windowHeight = window.innerHeight; // 스크린 창
//    let fullHeight = document.body.scrollHeight;
//    let windowWidth = window.innerWidth;
//    const nav = document.getElementById('cont_right');
//    console.log(fullHeight+'창'+windowHeight);
//    //content의 너비보다 창이 넓으면 cont_right가 스크롤 이동에 따라 움직임
//    if (scrollLocation >= 469 && windowWidth >= 1162) {
//        nav.style.position = "fixed";
//        nav.style.right = "calc((101% - 1162px)/2)";
//        nav.style.bottom = "0";
//        //  alert('3');
//    }
//    //content의 너비보다 창이 좁으면cont_right가 스크롤 이동에 따라 움직임
//    else if (scrollLocation >= 469 && windowWidth >= 768) {
//        nav.style.position = "fixed";
//        nav.style.left = "900px";
//        nav.style.bottom = "0";
//    }
//    //상단으로 올라가거나 모바일 버전이면 원래 위치로 이동
//    else {
//        nav.style.position = "static";
//    }
//    if (scrollLocation >= 1360) {//cont_center높이
//        nav.style.bottom = "60px";//1522+1588/2, footer높이 60
//    }
//    console.log(scrollLocation);
//});
//

