let kang; //선택한 8강 또는 4강 값 저장용 변수
const startBtn = document.querySelector("#start-btn"); // 월드컵 시작버튼
const left = document.querySelector(".left"); //왼쪽 아이스크림 이미지 정보 요소
const right = document.querySelector(".right"); //오른쪽 아이스크림 이미지 정보 요소
const roundInfo = document.querySelector(".round-info"); // 라운드 정보 요소

let round; //라운드 진행용 변수
let playArr = new Array(); // 랜덤으로 섞인 allIce를 저장 받을 배열(게임 진행용 숫자 관리)
let pickArr = new Array(); // 내가 선택한 값을 저장 받을 배열

const allIce = new Array();// 전체 아이스크림 정보를 저장할 배열
allIce.push({img:"img/ice1.png", name:"엄마는 외계인"});
allIce.push({img:"img/ice2.png", name:"아몬드 봉봉"});
allIce.push({img:"img/ice3.png", name:"민트 초콜릿 칩"});
allIce.push({img:"img/ice4.png", name:"베리베리 스트로베리"});
allIce.push({img:"img/ice5.png", name:"사랑에 빠진 딸기"});
allIce.push({img:"img/ice6.png", name:"슈팅스타"});
allIce.push({img:"img/ice7.png", name:"뉴욕 치즈 케잌"});
allIce.push({img:"img/ice8.png", name:"체리 쥬빌레"});
console.log(allIce);

startBtn.addEventListener("click",function(){
    const select = document.querySelector("[name=kang]");
    kang = select.value; // 선택한 8강 또는 4강의 값을 kang 변수에 저장
    console.log(kang);
    const startMenu = document.querySelector(".start-menu");
    startMenu.remove();
    init();
});

// 이상형 월드컵 시작할 때, 필요한 데이터를 초기화
function init(){
    //시작은 항상 1라운드부터
    round = 1;
    changeRoundInfo();
    // 게임 시작을 위해 사용할 번호 추출
    while(playArr.length != kang){
        const randomNum = Math.floor(Math.random()*allIce.length); // 0~7 랜덤 수 추출
        if(playArr.indexOf(randomNum) == -1){ // playArr에 중복되지 않는 경우에만 push
            playArr.push(randomNum);
        }
    }
    console.log(playArr);
    showImg();
}

// 라운드 정보 출력 변경 함수
function changeRoundInfo(){
    roundInfo.innerText = `아이스크림 이상형 월드컵 ${kang}강 ${round}/${kang/2}`;
}
// 라운드 별 이미지를 화면에 출력하는 함수
function showImg(){
    const iceImg = document.querySelectorAll(".img-box>img");
    const iceName = document.querySelectorAll(".ice-name");
    const iceContent = document.querySelectorAll(".ice-content");
    
    let playArrNo = 2*round - 2;
    let iceNo = playArr[playArrNo];
    iceImg[0].src = allIce[iceNo].img;
    iceName[0].innerText = allIce[iceNo].name;
    iceContent[0].setAttribute("value",playArr[playArrNo]);
    playArrNo++;
    iceNo = playArr[playArrNo];
    iceImg[1].src = allIce[iceNo].img;
    iceName[1].innerText = allIce[iceNo].name;
    iceContent[1].setAttribute("value",playArr[playArrNo]);
}




