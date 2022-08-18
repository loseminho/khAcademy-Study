const btn1 = document.querySelector("#btn1");
btn1.onclick = function(){
    // window.open(param1, param2, param3);
    // param1 : 주소(새 창에 로드할 html 파일 위치)
    // param2 : 열릴 방식 or 이름
    // param3 : 옵션(창의 크기, 위치 등등)
    windeow.open("http://naver.com","_blank","width=500, height=500");
}

const btn2 = document.querySelector("#btn2");
let timeoutId;
btn2.onclick = function(){
    timeoutId = window.setTimeout(function(){
        alert("짠!");
    },5*1000);
}

const btn3 = document.querySelector("#btn3");
btn3.onclick = function(){
    window.clearTimeout(timeoutId);
}


const btn4 = document.querySelector("#btn4");
let intervalId;
btn4.onclick = function(){
    intervalId = window.setInterval(function(){
        const timeZone = document.querySelector("#time-zone");
        const date = new Date();
        const currentTime = date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
        timeZone.innerText=currentTime; 
    },1000)
}


const btn5 = document.querySelector("#btn5");
btn5.onclick = function(){
    window.clearInterval(intervalId);
}