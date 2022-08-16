// 기본적인 자료형 문자열, 숫자타입, 논리

// 자바스크립트 문자와 문자열을 구분하지 않고 사용
// 따옴표 사용시 "",'' 구분 없음
const str = "JavaScript";
console.log(typeof str);
console.log(str);
console.log(str.length);// 문자열 길이
console.log(str.toLowerCase());// 모두 소문자로 변환해서 리턴 
console.log(str); // 원본 문자열은 변화 없음
console.log(str.toUpperCase()); // 모두 대문자로 변환해서 리턴

console.log(str.indexOf("a"));//앞에서부터 매개변수로 전달한 문자열 위치를 찾아서 해당 위치 리턴
console.log(str.lastIndexOf("a"));//뒤에서부터 문자열 위치 찾아서 리턴
//indexOf, lastIndexOf 공통, 내부에 없는 문자열을을 검색 시 -1 리턴
console.log(str.substring(3,7));// 3번 인덱스부터 7번 인덱스 전까지 리턴
const study = "java,oracle,html,css,javascript";
const arr = study.split(","); // 매개변수로 전달한 값 기준으로 잘라서 배열로 리턴
console.log(arr);
console.log(typeof arr);

// 숫자타입 : 정수/실수 구분 없이 number
const num = 3.5;
console.log(num);
console.log(typeof num);
console.log(Math.abs(3.5)); // 절대값
console.log(Math.abs(-3.5)); // 절대값
console.log(Math.round(num)); // 반올림
console.log(Math.floor(num)); // 버림
console.log(Math.ceil(num)); // 올림
console.log(Math.random());// 0~1 사이 랜덤숫자 1개 리턴

//형변환
// 자동 형 변환 : 서로 다른 자료형을 연산할 때 자동으로 자료형이 변환되는 것
// +를 제외하면 산술 연산 문자열이나 숫자열은 x
const name = "진민호";
const age = 27;
const grade = "1";
console.log(name+age); // "name"+20 -> "name"+"20" -> name20
console.log(name+grade); // "name"+"1" -> name1
console.log(age+grade);// 201
console.log(age-name); // 숫자가 아니기 떄문에 연산이 안됨.
console.log(age-grade);

//제 이름은 진민호이고 나이는 27살 1학년 입니다.
console.log("제 이름은 "+name+"이고 나이는"+age+"살 "+grade+"학년 입니다.");
console.log(`제 이름은 ${name}이고 나이는 ${age}살 ${grade}학년 입니다.`);

// 수동 형변환
const test11 = "100";
console.log(typeof test11);
const test22 = Number(test11);
console.log(typeof test22);
const test33 = String(test22);
console.log(typeof test33);
console.log(test11, test22, test33);

//연산자
const oper1  = "1";
const oper2  = 1;
console.log(typeof oper1);
console.log(typeof oper2);
console.log(oper1 == oper2);//자료형이 달라도 데이터가 같으면 true
console.log(oper1 === oper2);// 자료형과 데이터가 모두 일치해야 true
if(oper1 == oper2){
    console.log("같습니다.")
}else{
    console.log("다릅니다.");
}
if(oper1 === oper2){
    console.log("같습니다.")
}else{
    console.log("다릅니다.");
}

// let이 아닌 const를 사용하면 값이 변경을 할 수 없기때문에 에러가ㅏ 남
for(let i = 0; i<5; i++){
    console.log(`${i+1}번째 출력`);
}

// 짧은 조건문
const testNum = 11;
//if 문을 이용해서 홀수/짝수 구분해서 출력
if(testNum%2 ==0){
    console.log("짝수입니다.")
}else{
    console.log("홀수입니다.")
}


//짧은 조건문
// &&연산 ||연산의 동작 방식을 이용한 조건문
testNum%2 ==0 || console.log("홀수");
testNum%2 ==0 && console.log("짝수");