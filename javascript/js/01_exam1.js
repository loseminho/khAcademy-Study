

const q1 = document.querySelector("#q1");
q1.onclick = function(){
    const chName = prompt("변경할 이름은?");
    const chAge = prompt("변경할 나이는?");
    const chAddr = prompt("변경할 주소는?");

    const name = document.getElementById("name");
    const age = document.getElementById("age");
    const addr = document.getElementById("addr");

    name.innerHTML = chName;
    age.innerHTML = chAge;
    addr.innerHTML = chAddr;   
}

const q2 = document.querySelector("#q2");
q2.onclick = function(){
    const input1 = document.querySelector("#input1");
    const num1 = input1.value;
    const result = document.querySelector(".result");

    if(num1%2 ==0){
        result.innerHTML="짝수입니다.";

    }else if(num1%2==1){
        result.innerHTML="홀수입니다.";
    }else{
        result.innerHTML="숫자가 아닙니다.";
    }

}

const img = document.querySelector("img");
img.onclick = function(){
    img.src="img/angel.png";
}

const q4 = document.querySelector("#q4");
q4.onclick = function(){
    const result = document.querySelector("#result");
    result.style.color="navy";
}

