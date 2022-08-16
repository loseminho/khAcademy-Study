// var : 과거에 사용하던 변수 선언 타입
// 위치에 상관없이 사용이 가능하여 소스가 많으면 불편
var name1 = "진민호";
var age1 = 20;
var chk1 = true;
console.log(name1, age1, chk1);
{var test1 = "test1";}
console.log(test1); // 괄호 범위를 넘어도 출력이 됨;;

// let
let name2 = "진민호2";
let age2 = 30;
let chk2 = false;
console.log(name2, age2, chk2);
{let test2 = "test2";}
// console.log(test2); // 괄호 범위를 넘으면 호출이 안됨.
console.log(typeof name2); // 해당 변수의 타입을 띄우는 명령어
name2 = 1000; // 선언 된 변수의 값을 변경하는 것 도 가능
console.log(typeof name2); // 값이 변경이 되면 변수의 타입도 변경이 됨.


// const - 한번 선언된 변수의 타입이 안바뀜
const name3 = "진민호3";
const age3 = 27;
const chk3 = true;
console.log(name3, age3, chk3);
// age3 = 1000; // 상수형 변수는 한번 대입된 값을 변경 할 수 없음
// console.log(age3); // 상수형 변수이기 때문에 숫자가 들어가면 에러가 남

