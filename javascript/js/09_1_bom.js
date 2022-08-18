
window.onload = function(){
    console.log("HTML요소 로드 완료");
    const btn1 = document.querySelector("#btn1");
    console.log(btn1);


    const btn6 = document.querySelector("#btn6");
    btn6.onclick = function(){
        console.log("화면 높이 값 : " + screen.height);
        console.log("화면 너비 값 : " + screen.width);
        console.log("사용 가능한 높이 : " + screen.availHeight);
        console.log("사용 가능한 너비 : " + screen.availWidth);
        console.log("사용 가능한 색상 수 : " + screen.colorDepth);
        console.log("한 픽셀당 비트 수 : " + screen.pixelDepth);
    }
    const btn7 = document.querySelector("#btn7");
    btn7.onclick  = function(){
        location.href = "http://naver.com";
    }
    const btn8 = document.querySelector("#btn8");
    btn8.onclick  = function(){
        location.reload();
    }
    // 화면 로드가 완료되면 현 위치의 위도 / 경도를 구해서 변수에 저장
    navigator.geolocation.getCurrentPosition(saveLocation);
    const btn9 = document.querySelector("#btn9");
    btn9.onclick  = function(){
        console.log(lat);
        console.log(lng);
    }
}
let lat;
let lng;
function saveLocation(position){
    lat = position.coords.latitude;
    lng = position.coords.longitude;
}