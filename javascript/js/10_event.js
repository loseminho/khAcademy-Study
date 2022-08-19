const btn1 = document.querySelector("#btn1");
console.log(btn1.onclick);
btn1.onclick  = function(){
    console.log("고전 이벤트 모델1");
}
console.log(btn1.onclick);
const btn2 = document.querySelector("#btn2");
btn2.onclick = function(){
    console.log("고전 이벤트 모델2");
    btn1.onclick = null;
}

function func1(){
    console.log("인라인 이벤트2");
    console.log("인라인 이벤트2");
    console.log("인라인 이벤트2");
    console.log("인라인 이벤트2");
    console.log("인라인 이벤트2");
    console.log("인라인 이벤트2");
}

function func2(param){
    console.log(param.innerText);
}

const btn5 = document.querySelector("#btn5");
const btn6 = document.querySelector("#btn6");

btn5.addEventListener("click",function(){
    console.log("표준 이벤트 모델");
});

btn6.onclick = function(){
    console.log("비교용");
}
// 표준 이벤트 모델은 중복 function해도 전부 실행
btn5.addEventListener("click",function(){
    console.log("표준 이벤트 모델 플러스");
});
// 가장 아래에 있는 function 코드만 적용이 되서 변경 되어 실행
btn6.onclick = function(){
    console.log("비교용 플러스");
}

const a = document.querySelector("#a");
a.addEventListener("click",function(){
    const check = confirm("네이버로 이동하시겠습니까?");
    if(check){
        location.href="http://www.naver.com";
    }else{
        console.log("이동 취소");
    }
});


const memberId = new Array();
memberId.push("user01");
memberId.push("user02");
memberId.push("user03");

function checkValue(){
    const input = document.querySelector("#id1");
    const inputValue = input.value;
    console.log(input.value);   
    // indexOf(값) : 매개변수로 주어진 값이 배열에 몇번쨰 존재하는지 리턴
    // 존재하지 않으면 -1 리턴
    const searchIndex = memberId.indexOf(inputValue);
    console.log(searchIndex);
    if(searchIndex == -1){
        // 사용 중인 경우
    }else{
        // 사용 중인 아이디
        const checkMsg = document.querySelector("#chkMsg1");
        checkMsg.innerText = "이미 사용 중인 아이디 입니다.";
        checkMsg.style.color = "red";
        return false;
    }
}
const divs = document.querySelectorAll(".div-test");
for(let i=0; i<divs.length; i++){
    divs[i].addEventListener("click", function(){
        const text = this.innerText;
        alert(text);
        window.event.stopPropagation();// 이벤트 버블링을 막는 메소드
    });
}

const div1 = document.querySelector("#div1");
const div2 = document.querySelector("#div2");
const div3 = document.querySelector("#div3");

div1.addEventListener("click",function(){
    console.log("클릭 이벤트 동작!");
});
div2.addEventListener("dblclick",function(){
    console.log("더블클릭 이벤트 동작!");
});
div3.addEventListener("mouseenter",function(){
    this.style.backgroundColor= "black";
});
div3.addEventListener("mouseleave",function(){
    this.style.backgroundColor= "transparent";
});

const id2 = document.querySelector("#id2");
id2.addEventListener("focusin",function(){
    // focusin : 해당하는 영역에 커서가 들어갔을 때
    this.style.backgroundColor = "yellow";
});
id2.addEventListener("focusout",function(){
    // focusout : 해당하는 영역에서 커서가 나왔을때
    this.style.backgroundColor = "white";
    console.log("focusout");
});

//input 값이 변함이 생겨야만 function 함수가 돔.
id2.addEventListener("change",function(){
    console.log("change");
    /*
    const inputId = this.value;
    const searchIndex = memberId.indexOf(inputId);
    const checkMsg = document.querySelector("#chkMsg2");
    if(searchIndex == -1){
        checkMsg.innerHTML = "사용 가능한 아이디 입니다.";
        checkMsg.style.color = "blue";
    }else{
        checkMsg.innerHTML = "이미 사용 중인 아이디 입니다.";
        checkMsg.style.color = "red";
    }
    */
});

// input에 값이 하나하나 들어올 때마다 중복검사.
id2.addEventListener("keyup",function(){
    const inputId = id2.value;
    const searchIndex = memberId.indexOf(inputId);
    const checkMsg = document.querySelector("#chkMsg2");
    if(searchIndex == -1){
        checkMsg.innerHTML = "사용 가능한 아이디 입니다.";
        checkMsg.style.color = "blue";
    }else{
        checkMsg.innerHTML = "이미 사용 중인 아이디 입니다.";
        checkMsg.style.color = "red";
    }
})