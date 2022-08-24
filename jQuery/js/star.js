const stars = $(".star-wrap1>span");
stars.on("mouseover",function(){
    stars.css("color","lightgray")
    const index = stars.index(this);
    console.log(index);
    for(let i=0;i<=index;i++){
        stars.eq(i).css("color","gold");
    }
});
stars.on("click",function(){
    const index = stars.index(this);
    $("#star-result").text(index+1);
});

const stars2 = $(".star-wrap2>span");
// const btn = $("#btn");
// btn.on("click",function(){
//     stars2.css("color","lightgray")
//     const inputVal = $("[name=star-score]").val();
//     for(let i=0;i<inputVal;i++){
//         stars2.eq(i).css("color","gold");
//     }
// });
$("#btn").on("click",function(){
    const starScore = $(this).prev().val();
    const width = starScore*30;//star-on에 적용할 너비로 환산(별점 1점 당 30px임)
    // $(".star-on").css("width",width+"px");
    $(".star-on").animate({"width":width+"px"},2*1000)

    // for(let i=0; i<starScore;i++){
    //     stars2.eq(i).css("color","gold");
    // }
});

$(".real-score").show();
const stars3 = $(".star-wrap3>span");
stars3.on("mouseover",function(){
    $(".real-score").hide();
    $(".show-score").show();
    const idx = stars3.index(this);
    stars3.each(function(index, item){
        if(idx>=index){
            $(item).css("color","gold");
        }else{
            $(item).css("color","lightgray");
        }
    });
    $(".show-score").text(idx+1);
});

stars3.on("mouseleave",function(){
    $(".real-score").show();
    $(".show-score").hide();
    const realScore = Number($(".real-score").text());
    stars3.each(function(index, item){
        if(realScore>index){
            $(item).css("color","gold");
        }else{
            $(item).css("color","lightgray");
        }
    });
});

stars3.on("click",function(){
    const idx = stars3.index(this);
    $(".real-score").text(idx+1);
});