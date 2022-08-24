const div = $("#div");
$("#btn1").on("click",function(){
    div.show(400);//display 속성을 원래 요소 속성대로
});
$("#btn2").on("click",function(){
    div.hide(400);//display 속성을 none
});
$("#btn3").on("click",function(){
    div.toggle(5*1000);//hide(),show() 반복
});
/** slideDown, slideUp, slideToggle은 시간을 지정하지 않으면 기본 0.4초 */
$("#btn4").on("click",function(){
    div.slideDown(10*1000);
});
$("#btn5").on("click",function(){
    div.slideUp();
});
$("#btn6").on("click",function(){
    div.slideToggle();
});

$("#btn7").on("click",function(){
    div.fadeIn();
});
$("#btn8").on("click",function(){
    div.fadeOut();
});
$("#btn9").on("click",function(){
    div.fadeToggle();
});
$("#btn10").on("click",function(){
    div.animate(
        //background-color는 적용 안됨.
        {
            "width" : "100px",
            "height" : "50px",
            "opacity" : "0.5",
            "background-color" : "red"
        },
        3*1000
    );
});