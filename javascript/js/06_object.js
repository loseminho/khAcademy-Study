// 자바스크립트 객체, JAVA의 MAP과 유사한 형태(key:value,key:value)
const obj1 = {a : 100, b : "hello", c:true, d:[1,2,3,4]};
console.log(obj1);
console.log(obj1.a);
console.log(obj1.b);
console.log(obj1["c"]);
console.log(obj1["d"]);
obj1.a = 200;
console.log(obj1.a);
obj1["b"]= "hi";
console.log(obj1.b);

const obj2 = {
    a : 100,
    b : 200,
    c : function(){
        console.log("객체 내부 함수");
        return "hihi";
    }
}
console.log(obj2);
console.log(obj2.b);
console.log(obj2.c());
// in : 객체 안에 해당 키가 있는지 확인하는 키워드
console.log("a" in obj2);
console.log("b" in obj2);
console.log("c" in obj2);
console.log("d" in obj2);

// with : 해당 범위 내에서 객체 이름 생략 가능
with(obj2){
    console.log(a);
    console.log(b);
    console.log(c());
}
console.log(obj2);
// 값 추가 가능, function 함수도 추가 가능함.
obj2.d = "안녕";
console.log(obj2);

// 객체 에서 속성 삭제 가능
delete obj1.d;
console.log(obj2);

//배열 안에 객체가 들어가는 것도 가능함
const stu1 = {name : "진민호1", age : 20, addr : "인천"};
const stu2 = {name : "진민호2", age : 30, addr : "인천"};
const arr = new Array();
arr.push(stu1);
arr.push(stu2);
console.log(arr);
console.log(arr[1].addr);

// 함수를 이용한 객체 생성
// 1. 리턴사용
function makeObj(param1, param2, param3){
    const obj = {
        name : param1,
        age : param2,
        addr : param3
    }
    return obj;
}
const obj3 = makeObj("진민호3",27,"인천");
console.log(obj3);

// 2.생성자 사용
function Student(param1, param2, param3){
    this.name = param1;
    this.age = param2;
    this.addr = param3;
}
const obj4 = new Student("진민호4", 72,"인천");
console.log(obj4);
console.log(obj4.name);