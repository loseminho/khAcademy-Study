const ul = $(".slide-wrap>ul");
const lastImg = ul.children().last().clone();
ul.prepend(lastImg);

const firstImg = ul.children().eq(1).clone();
ul.append(firstImg);

const imgCount = ul.children().length;
const width = 1200;
ul.css("width",(width*imgCount)+"px");
let imgNo = 1;

ul.css("transform","translateX("+(imgNo*-1200)+"px)");

let intervalId;

// 이전버튼
$(".prev").on("click",function(){
    if(imgNo != 0){
        // 버튼을 누르면 함수 초기화를 시키고 다시 autoslide()
        clearInterval(intervalId);
        imgNo--;
        const move = -imgNo*width; // 원래 위치를 기준으로 움직이므로 역시 -
        ul.css("transform","translateX("+move+"px)").css("transition-duration","1s");
        if(imgNo == 0){
            imgNo = imgCount-2;
            setTimeout(function(){
                const move = -imgNo*width;
                ul.css("transform","translateX("+move+"px)").css("transition-duration","0s");
            },1000);
        }
        // 3초 다시 진행
        autoSlide();
    }
});

// 다음버튼
$(".next").on("click",function(){
    if(imgNo != imgCount-1){
        clearInterval(intervalId);
        imgNo++;
        const move = -imgNo*width; // 왼쪽으로 움직여야하므로 -
        ul.css("transform","translateX("+move+"px)").css("transition-duration","1s");
        if(imgNo == imgCount-1){
            imgNo = 1;
            setTimeout(function(){
                const move = -imgNo*width;
                ul.css("transform","translateX("+move+"px)").css("transition-duration","0s");
            },1000);
        }
        autoSlide();
    }
});

function autoSlide(){
    intervalId = setInterval(function(){
        $(".next").click();
    },3*1000);
}
autoSlide();