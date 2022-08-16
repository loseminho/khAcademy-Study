// 1. 선언적 함수
// 자바스크립트 코드 구현 시 선언적 함수가 제일 먼저 만들어짐
// function 생성 코드 위치는 중요하지 않음.
function func1(){
    console.log("func1 함수 동작");
} 

// 선언적 함수 실행
const test1 = func1();
console.log(test1);
let test2;
console.log(test2);

const str = func2(); // function 함수 선언 전에 사용해도 사용 가능.
console.log(str);
function func2(){
    console.log("func2 함수 동작");
    return "func2 리턴";
} 

function func3(a,b){
    console.log(a, typeof a);
    console.log(b, typeof b);
}
func3("안녕",100);
func3(100,"안녕");
func3(true,[1,2,3]);
// 매개변수가 모자란 경우 전달한 만큼만 사용하고 나머지 매개변수는 undefined 처리가 됨
func3(100);

//선언한 매개 변수보다 매개변수를 많이 전달하는 경우,. 선언된 부분까지만 사용
func3(100,200,300,400);

function func4(){
    console.log("func4 호출");
    console.log(arguments);
    for(let i=0;i<arguments.length;i++){
        console.log(i,arguments[i]);
    }
} 
func4();
func4("bye",100,[1,2,3]);

// 2. 익명함수1(변수에 저장해두는 함수)
// test11(); // 익명 함수는 반드시 선언 한 이후에 사용 가능
const test11 = function(){
    console.log("익명함수1");
}
// 익명함수 실행
test11();


const test22 = function(a,b){
    console.log(a, typeof a);
    console.log(b, typeof b);
    return "익명함수2 리턴";
}
const test33 = test22(100,"hi");
console.log(test33);

// 3. 익명함수(스스로 동작하는 함수 ): 스크립트 코드 동작 시 스스로 1번 동작하는 함수
// 스스로 동작하기 떄문에 매개변수 사용 불가능
(function () {  
    console.log("스스로 동작하는 익명함수");
})();


// 클로저 : 함수를 리턴하는 형태

// 동작시, 항상 값은 1이 나오는 형태
function increment(){
    let count = 0;
    count++;
    return count;
}
function incEvent1(){
    console.log(increment());
}
incEvent1();

// 원하는 값 형태는 나오지만, 외부에서 count에 접근이 가능한 형태
let cnt = 0;
function increment2(){
    cnt++
    return cnt;
}
function incEvent2(){
    console.log(increment2());
}
incEvent2();
incEvent2();
incEvent2(); 


function increment3(){
    let count = 0;
    const returnFunc = function(){
        count++;
        return count;
    }
    return returnFunc;
}
const incFunc = increment3();
function incEvent3(){
    console.log(incFunc());
}
incEvent3();
incEvent3();
incEvent3();


const url = "http://iei.or.kr?msg=안녕하세요";
const enc1 = encodeURI(url);
console.log(enc1);
const dec1 = decodeURI(enc1);
console.log(dec1);
const enc2 = encodeURIComponent(url);
console.log(enc2);
const dec2 = decodeURIComponent(enc2);
console.log(dec2);

const num1 = 10;
const num2 = "a";
// 안의 값이 숫자일 경우 True,
console.log(isFinite(num1));
console.log(isFinite(num2));

// 숫자가 아니면 True
console.log(isNaN(num1));
console.log(isNaN(num2));
if(isFinite(num1) && isFinite(num2)){
    console.log(num1 - num2);
}else{
    console.log("숫자만 연산이 가능합니다.");
}

//eval(문자열) : 문자열을 자바스크립트코드로 실행하는 함수
const num3 = 100;
const num4 = 200;
console.log(num3 + num4);
console.log("num3 + num4");
console.log(eval("num3 + num4"));
