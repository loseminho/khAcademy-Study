// 배열을 선언해서 1,2,3 데이터 입력
// 1. 배열 선언 방법 1)
const arr1 = [1,2,3];
// 1. 배열 선언 방법 2)
const arr2 = new Array(1,2,3);
// 1. 배열 선언 방법 3)

console.log(arr1);
console.log(arr2);
console.log(arr1[0]);
console.log(arr1[1]);
console.log(arr1[2]);
console.log(arr1[3]); // 없는 배열 작성 시, undefined 출력
for(let i=0;i<arr2.length;i++){
    console.log(arr2[i]);
}
//자바스크립트 배열 내부 데이터는 자료형이 무관
const arr3 = ["진민호",100,true,[1,2,3]];
for(let i=0;i<arr3.length;i++){
    console.log(arr3[i], typeof arr3[i]);
}

const arr = [1,2,3,4];
console.log(arr.indexOf(3));// 3이 배열에 몇번 인덱스에 있는지 리턴
console.log(arr.indexOf(5));// 없는 값일 경우 -1 리턴

const fruit1 = ["사과","딸기","바나나"];
const fruit2 = ["복숭아","파인애플"];
const testArr1 = [100,20,15,50];
const testArr2 = [true,false,[1,2,3,4]];
const data1 = fruit1.concat(fruit2, testArr1, testArr2);
console.log(data1);
console.log(data1);
//원본 배열은 본인 데이터 유지
console.log(fruit1, fruit2, testArr1, testArr2);

//배열 내부 데이터를 매개변수로 연결하여 하나의 문자열로 리턴
const data2 = fruit1.join(",");
console.log(data2);
const data3 = fruit1.join(" ");
console.log(data3);
const data4 = fruit1.join(); //매개변수가 없을 시 기본 값인 ,로 연결됨
console.log(data4);
const data5 = fruit1.join("");
console.log(data5);

/* -join 활용법-
const data = [
    "<div class='navi'>",
    "<ul>",
    등등등..
].join("");
*/

console.log(testArr1);
// 정렬은 원본배열이 변경
// 매개변수가 없는 경우 문자열 오름차순 정렬(사전순)
testArr1.sort();
console.log(testArr1);

function sortASC(a,b){
    return a-b;
}
function sortDESC(a,b){
    return b-a;
}
const testArr3 = [1,3,2,7,10,9,8,5,4,6];
testArr3.sort(sortDESC);
console.log(testArr3);
testArr3.reverse(); // 배열 순서 반전(원본 배열이 변경)
console.log(testArr3);

//push, pop
const testArr4 = [1,2,"hi",true];
console.log(testArr4);
// push는 배열 맨 뒤에 추가
testArr4.push(100);
console.log(testArr4);
testArr4.push(500);
console.log(testArr4);
// pop : 배열 가장 뒷 객체 제거
testArr4.pop();
console.log(testArr4);

// unshift, shift
// unshift : 배열 제일 앞에 추가
testArr4.unshift("안녕");
console.log(testArr4);
testArr4.unshift([1,2,3]);
console.log(testArr4);

//shift : 배열 제일 앞 객체 제거
testArr4.shift();
console.log(testArr4);

// splice()
// 매개변수가 2개인 경우 (인덱스번호,부터 n 개 잘라서 리턴);
const testArr5 = testArr4.splice(2,2);
console.log(testArr4);//잘려서 없어짐
console.log(testArr5);//자른거 가져감

// 매개변수가 3개인 경우(첫번째부터, 여기매개변수까지 자르고 배열로 리턴하고, 그 자리에 이 매개변수 삽입);
const testArr6 = testArr4.splice(1,1,"bye");
console.log(testArr4);// 1 잘려서 없어지고 bye 추가
console.log(testArr6);// 1 가져감

// slice(첫번쨰 순서부터, 두번쨰 순서의 인덱스 앞까지 복사해서 리턴)
const testArr7 = testArr4.slice(1,2);
console.log(testArr4);
console.log(testArr7);
// 매개변수가 1개인 경우 첫번쨰 인덱스 번호부터 끝까지 복사
const testArr8 = testArr4.slice(1);
console.log(testArr8);
