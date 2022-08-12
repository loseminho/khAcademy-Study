// 1. console.log()
// 개발자가 확인을 위해 브라우저 콘솔에 메세지를 띄우는것
// 자바의 System.out.println()의 역할
/*
console.log("Hello Javascript"); //글자열 검은색 출력
console.log(100);//숫자 형태 가능(파란색 출력)
console.log(100+200);//연산 가능
console.log("test : "+100);// 문자열로 합쳐져서 출력
console.log(100,200,300);//,로 구분하면 출력 시 띄어쓰기로 구분

// 2. alert
// 사용자에게 확인용 메세지를 전달하기 위해 사용
// 개발 시 값 확인 하는 용도로 사용가능. 단, 클라이언트에게 노출 가능성이 있음
// 개발 완료 시에는 모두 삭제
alert("1234");// 사용자에게 1234 경고창 출력

console.log("확인1");//위의 alert가 진행 완료가 되야 코드가 실행됨.
alert(12345);
alert(100+200);// 연산도 가능
alert(100,200,300);//,를 사용한 출력은 가장 앞 데이터만 출력이 됨 
*/
// 3. confirm
// 사용자에게 질문을 하고 그 결과를 논리형(true/false)로 받아옴
console.log(confirm("자바스크립트는 어때요?"));

// 4. prompt
// 사용자에게 질문 하고 키보드 입력값을 문자열로 가져옴
console.log(prompt("당신의 이름은?"));