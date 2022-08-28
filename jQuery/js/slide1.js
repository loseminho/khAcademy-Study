// 현재 화면에 보이는 이미지번호
let imgNo = 0;

const ul = $(".slide-wrap>ul");
const imgCount = ul.children().length; // 사용하는 이미지 개수(li태그의 길이)
const width = 1200;
ul.css("width",(imgCount*width)+"px");

// 이전버튼
$(".prev").on("click",function(){
    if(imgNo != 0){
        imgNo--;
        const move = -imgNo*width; // 원래 위치를 기준으로 움직이므로 역시 -
        ul.css("transform","translateX("+move+"px)").css("transition-duration","1s");
    }
});

// 다음버튼
$(".next").on("click",function(){
    if(imgNo != imgCount-1){
        imgNo++;
        const move = -imgNo*width; // 왼쪽으로 움직여야하므로 -
        ul.css("transform","translateX("+move+"px)").css("transition-duration","1s");
    }
});
