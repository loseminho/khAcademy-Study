// html에 sub메뉴 이전 코드에 + 추가
$(".sub-menu").prev().append("<span class='more'>+</span>");

$(".more").on("click",function(event){

    // +버튼을 누를 시 회전
    $(this).toggleClass("active");

    // +버튼을 누르면 sub메뉴가 아래로 등장
    $(this).parent().next().slideToggle();

    // 객체의 버블링 제거
    event.stopPropagation();
});

// +버튼뿐 아니라 메뉴버튼을 누를 시에도 위의 기능들이 실행
// -> 이대로만 실행하면 버블링이 생겨 위 함수에 event 설정
$(".more").parent().on("click",function(){
    $(this).children().click();
});