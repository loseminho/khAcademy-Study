const contentDetail = document.querySelectorAll(".contentDetail");
const tabsLi = document.querySelectorAll(".tabs li")
window.onload = function(){
    contentDetail[0].style.display = "block";
}

const allAgreement = document.querySelector("#allAgreement");
allAgreement.onclick = function(){
    const agreeCheck = document.querySelectorAll(".agreeCheck");
    const status = allAgreement.checked;
    agreeCheck[0].checked = status;
    agreeCheck[1].checked = status;
}

const nextBtn = document.querySelectorAll(".nextBtn");
nextBtn[0].onclick = function(){
    const agreeCheck = document.querySelectorAll(".agreeCheck");
    
    
    if(agreeCheck[0].checked == true){
        selectTab(0);
        // tabsLi[0].classList.remove("active-tab");
        // tabsLi[1].classList.add("active-tab");
        // contentDetail[0].style.display = "none";
        // contentDetail[1].style.display = "block";
    }
}

const memberId = new Array();
memberId.push("user01");
memberId.push("user02");
memberId.push("user03");
memberId.push("user04");

const id = document.querySelector("[name=id]");
const pw = document.querySelector("[name=pw]");
const pwre = document.querySelector("[name=pw_re]");
const name = document.querySelector("[name=name]");
const inputLong = document.querySelectorAll(".long"); 
let checkResult1;
let checkResult2;

id.addEventListener("keyup",function(){
    const inputId = id.value;
    const searchIndex = memberId.indexOf(inputId);
    const idChk = document.querySelector("#idChk"); 
    if(searchIndex == -1){
        idChk.innerText = "사용 가능한 아이디 입니다.";
        idChk.style.color = "#1f4787";
        idChk.style.fontWeight = "lighter";
        inputLong[0].style.border = "1px solid #1f4787";
        checkResult1 = 1;
    }else{
        idChk.innerText = "이미 사용중인 아이디 입니다.";
        idChk.style.color = "red";
        idChk.style.fontWeight = "bold";
        inputLong[0].style.border = "1px solid red";
        checkResult1 = 2;
    }
})

pwre.addEventListener("keyup",function(){
    const inputPw = pw.value;
    const inputPwre = pwre.value;
    const pwChk = document.querySelector("#pwChk");
    
    if(inputPw == inputPwre){
        pwChk.innerHTML = "사용 가능한 비밀번호입니다.";
        pwChk.style.color = "#1f4787";
        inputLong[2].style.border = "1px solid #1f4787";
        pwChk.style.fontWeight = "lighter";
        checkResult2 = 1;
    }else{
        pwChk.innerHTML = "패스워드가 일치하지 않습니다.";
        pwChk.style.color = "red";
        pwChk.style.fontWeight = "bold";
        inputLong[2].style.border = "1px solid red";
        checkResult2 = 2;
    }
})

nextBtn[1].onclick = function(){
    const inputName = name.value;
    if(!inputName){
        alert("이름을 입력하세요");
    }else{
        if(checkResult1 == 1 && checkResult2 == 1){
            contentDetail[1].style.display = "none";
            contentDetail[2].style.display = "block";
            tabsLi[1].classList.remove("active-tab");
            tabsLi[2].classList.add("active-tab");
        }else if(checkResult1 == 1 && checkResult2 != 1){
            alert("비밀번호가 틀렸습니다. 비밀번호를 확인하세요!");
        }else if(checkResult1 != 1 && checkResult2 == 1){
            alert("아이디가 틀렸습니다. 아이디를 확인하세요!");
        }else{
            alert("아이디와 비밀번호가 모두 틀렸습니다. 다시 작성해주세요");
        }
    }
}


const email = document.querySelector("#emailSelect");
email.addEventListener("change",function(){
    const selectMail = email.value;
    console.log(selectMail);
    const email2 = document.querySelector("[name=email2]");
    email2.value = selectMail;
});

nextBtn[2].addEventListener("click",function(){
    if(confirm("회원가입 하시겠습니까?")){
        selectTab(2);
        // const tabsLi = document.querySelectorAll(".tabs li");
        // tabsLi[2].classList.remove("active-tab");
        // tabsLi[3].classList.add("active-tab");
        // contentDetail[2].style.display = "none";
        // contentDetail[3].style.display = "block";
    }
});

function selectTab(param){
    const tabsLi = document.querySelectorAll(".tabs li");
    tabsLi[param].classList.remove("active-tab");
    tabsLi[param+1].classList.add("active-tab");
    contentDetail[param].style.display = "none";
    contentDetail[param+1].style.display = "block";
}
