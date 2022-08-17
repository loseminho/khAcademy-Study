const btn1 = document.getElementById("btn1");
// const btn1 = document.querySelector("#btn1");
btn1.onclick = function(){
    const d1 = document.querySelector("#d1");
    // <> </> 사이에 있는 내용(속성의 특성을 포함해서)을 가져오는 명령어
    const str1 = d1.innerHTML;
    // <> </> 사이에 있는 내용(속성이 아닌 텍스트로서)을 가져오는 명령어
    const str2 = d1.innerText;
    console.log(str1);
    console.log(str2);
    d1.innerHTML = "<a href='#'>이동</a>"
    
}

const btn2 = document.querySelector("#btn2");
btn2.onclick = function(){
    const dd1 = document.querySelectorAll(".dd1");
    dd1[0].innerHTML = "클래스로 변경";
    dd1[1].innerText = "클래스로 변경";
}

const btn3 = document.querySelector("#btn3");
btn3.onclick = function(){
    const name1 = document.getElementsByName("name1");
    // const name1 = document.querySelectorAll("[name=name1]");
    

    for(let i = 0; i<name1.length;i++){
        name1[i].style.color="red";
    }
}

const btn4 = document.querySelector("#btn4");
btn4.onclick = function(){
    const name1 = document.getElementsByName("name1");
    
    for(let i = 0; i<name1.length;i++){
        name1[i].style.backgroundColor="yellow";
    }
    // name1.forEach(function(item, index){
    //     item.style.backgroundColor="yellow";
    // });
}

const btn5 = document.querySelector("#btn5");
// 초기값 value로 설정되어있는 상태의 값을 저장하기 때문에 값을 변경해서 콘솔로 띄워도 결국 설정 value값이 표현
const inputValue = document.querySelector("#input1").value;
btn5.onclick = function(){
    const input1 = document.querySelector("#input1");
    const input2 = document.querySelector("#input2");
    // 닫힘 태그가 없는 input태그의 값을 가져올 땐, value를 통해서 값을 불러옴.
    const str1 = input1.value;
    const str2 = input2.value;
    console.log(str1);
    console.log(str2);
    console.log(inputValue);
}

const btn6 = document.querySelector("#btn6");
btn6.onclick = function(){
    const input1 = document.querySelector("#input1");
    const input2 = document.querySelector("#input2");
    input1.value="안녕하세요";
    input2.value="비밀번호입니다.";
}


const btn7 = document.querySelector("#btn7");
btn6.onclick = function(){
    const input1 = document.querySelector("#input1");
    const input2 = document.querySelector("#input2");
    input1.value="이제 더이상 변경 할 수 없습니다.";
    // input1에 readonly 기능을 부여.
    input1.setAttribute("readonly",true);
}


const checkBtn = document.querySelector("#change");
checkBtn.onclick = function(){
    const input2 = document.querySelector("#input2");
    const status = checkBtn.checked;
    input2.setAttribute("type","text");
    console.log(status);
    if(status){
        input2.setAttribute("type","text");
    }else{
        input2.setAttribute("type","password");
    }
}

const allCheck = document.querySelector("#allCheck");
allCheck.onclick = function(){
    const checks = document.querySelectorAll(".check");
    const status = allCheck.checked;
    checks[0].checked = status;
    checks[1].checked = status;
    // if(status){
    //     checks[0].checked = true;
    //     checks[1].checked = true;
    // }else{
    //     checks[0].checked = false;
    //     checks[1].checked = false;
    // }
}

const naverCheck = document.querySelector("#btn8");
naverCheck.onclick = function(){
    const a = document.querySelector("a");
    a.innerHTML = "네이버로 이동";
    a.href="http://www.naver.com";
}
const googleCheck = document.querySelector("#btn9");
googleCheck.onclick = function(){
    const link = document.querySelector("#link");
    link.setAttribute("href","http://www.google.com");
    link.innerText = "구글로 이동";
}


const btn10 = document.querySelector("#btn10");
btn10.onclick = function(){
    const testDiv = document.querySelectorAll(".test-div");
    console.log(testDiv.length);
    for(let i=0;i<testDiv.length;i++){
        testDiv[i].style.width = "200px";
        testDiv[i].style.height = "200px";
        testDiv[i].style.backgroundColor = "green";
    }
}
const btn11 = document.querySelector("#btn11");
btn11.onclick = function(){
    const testDiv = document.querySelectorAll(".test-div");
    for(let i=0;i<testDiv.length;i++){
        testDiv[i].style.width = "100px";
        testDiv[i].style.height = "100px";
        testDiv[i].style.backgroundColor = "darkseagreen";
    }
}
const btn102 = document.querySelector("#btn102");
btn102.onclick = function(){
    const testDiv = document.querySelectorAll(".test-div");
    testDiv.forEach(function(item,index){
        item.classList.add("pick");
    });
}
const btn112 = document.querySelector("#btn112");
btn112.onclick = function(){
    const testDiv = document.querySelectorAll(".test-div");
    testDiv.forEach(function(item,index){
        item.classList.remove("pick");
    });
}

const btn12 = document.querySelector("#btn12");
btn12.onclick = function(){
    const testDiv = document.querySelectorAll(".test-div");
    testDiv.forEach(function(item, index){
        item.classList.toggle("pick");
    });
}



const divTest = document.querySelectorAll(".test-div");
/* - 방법 1 -
divTest[0].onclick = function(){
    // divTest[0].classList.remove("pick");
    // divTest[1].classList.remove("pick");
    // divTest[2].classList.remove("pick");
    // divTest[3].classList.remove("pick");
    for(let i = 0; i<divTest.length;i++){
        divTest[i].classList.remove("pick");
    }
    divTest[0].classList.add("pick");
}
divTest[1].onclick = function(){
    for(let i = 0; i<divTest.length;i++){
        divTest[i].classList.remove("pick");
    }
    divTest[1].classList.add("pick");
}
divTest[2].onclick = function(){
    for(let i = 0; i<divTest.length;i++){
        divTest[i].classList.remove("pick");
    }
    divTest[2].classList.add("pick");
}
divTest[3].onclick = function(){
    for(let i = 0; i<divTest.length;i++){
        divTest[i].classList.remove("pick");
    }
    divTest[3].classList.add("pick");
}
*/

/* - 방법 2 -
for(let i=0; i<divTest.length;i++){
    divTest[i].onclick = funciton() {
        for(let j = 0; j<divTest.length;j++){
            divTest[j].classList.remove("pick");
        }
        divTest[i].classList.add("pick");
    }
}
*/

// 방법 3
divTest.forEach(function(item,index){
    item.onclick = function(){
        divTest.forEach(function(item1,index){
            item1.classList.remove("pick");
        });
        item.classList.add("pick");
    }
});
