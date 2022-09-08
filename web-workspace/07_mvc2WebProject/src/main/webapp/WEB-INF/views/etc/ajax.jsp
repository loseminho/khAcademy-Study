<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.ajaxResult{
		min-height: 100px;
		border: 2px solid #ccc;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">AJAX</div>
		<h3>1. 서버 호출하기</h3>
		<button class="btn bc11" id="js">JS방식</button>
		<button class="btn bc11" id="jQ1">JQuery방식</button>
		
		<h3>2. 서버로 값 전송하기</h3>
		<input type="text" placeholder="본인을 밝혀주신 뒤 전송해주세요">
		<button class="btn bc11" id="jQ2" >전송</button>
		
		<h3>3. 서버로 데이터 전송하고 서버에서 데이터받기(기본형데이터 받기)</h3>
		<input type="text" id="su1">
		<input type="text" id="su2">
		<button class="btn bc11" id="jQ3">더하기</button>
		<p class="ajaxResult" id="result1"></p>
		
		<h3>4. 서버로 데이터 전송하고 서버에서 객체 데이터 받기</h3>
		<input type="text" id="input4">
		<button class="btn bc11" id="jQ4">회원정보조회</button>
		<p class="ajaxResult" id="result4"></p>
		
		<h3>5. 서버에서 데이터 리스트 받기</h3>
		<button class="btn bc11" id="jQ5">전체회원조회</button>
		<p class="ajaxResult" id="result5"></p>
		
		<h3>6. 서버로 데이터 전송하고 서버에서 객체 데이터 받기(GSON)</h3>
		<input type="text" id="input6">
		<button class="btn bc11" id="jQ6">회원정보조회</button>
		<p class="ajaxResult" id="result6"></p>
		
		<h3>7. 서버에서 데이터 리스트 받기(GSON)</h3>
		<button class="btn bc11" id="jQ7">전체회원조회</button>
		<p class="ajaxResult" id="result7"></p>
		
		<h3>8. 비동기 테스트</h3>
		<button class="btn bc11" id="jQ8">비동기 호출 테스트</button>
		
	</div>
	
	
	
	<script>
		$("#js").on("click",function(){
			//javascript방식으로 ajax 호출
			//1. XMLHttpRequest 객체 생성
			const xhttp = new XMLHttpRequest();
			//2. 요청 정보 설정
			xhttp.open("GET","/ajaxTest1.do",true);
			//3. 서버요청 처리에 따른 동작 함수를 설정
			xhttp.onreadystatechange = function(){
				if(this.readyState == 4 && this.status == 200){
					//요청이 다 끝나고 정상 인경우
					console.log("서버 요청 완료!!");
				}else if(this.readyState == 4 && this.status == 404){
					//요청이 다 끝나고 결과가 페이지를 찾을 수 없는 경우
					console.log("주소를 찾을 수 없습니다.");
				}
			}
			//4. 서버에 요청
			xhttp.send();
		});
		$("#jQ1").on("click",function(){
			$.ajax({
				url : "/ajaxTest1.do",
				type : "get",
				success : function(){
					//요청 성공시 동작할 함수
					console.log("서버 호출 완료~");
				},
				error : function(){
					//요청 실패시(에러일때) 동작할 함수
					console.log("에러 발생");
				},
				complete : function(){
					//그냥 무조건 동작할 함수
					console.log("무조건 호출");
				}
			});
		});
		$("#jQ2").on("click",function(){
			const input = $(this).prev();
			const inputValue = input.val();
			console.log(inputValue);
			$.ajax({
				url : "/ajaxTest2.do",
				type : "get",
				data : {input1 : inputValue},
				success : function(){
					console.log("서버로 전송 완료");
				},
				error : function(){
					console.log("에러 발생");
				}
			});
		});
		$("#jQ3").on("click",function(){
			const su1 = $("#su1").val();
			const su2 = $("#su2").val();
			const result = $("#result1");
			$.ajax({
				url : "/ajaxTest3.do",
				type : "get",
				data : {num1:su1, num2:su2},
				success : function(data){
					result.text(data);
					console.log("서버호출성공");
				},
				error : function(){
					console.log("서버호출실패");
				}
			});
		});
		$("#jQ4").on("click",function(){
			const input4 = $("#input4").val();
			const result = $("#result4");
			result.empty();
			$.ajax({
				url : "/ajaxTest4.do",
				type: "get",
				data : {memberId: input4},
				dataType:"json",
				success : function(data){
					if(data == null){
						result.append("회원 정보를 조회할 수 없습니다.")
					}else{
						result.append("아이디 : "+data.memberId+"<br>")
						result.append("이름 : "+data.memberName+"<br>")
						result.append("전화번호 : "+data.memberPhone+"<br>")
						result.append("주소 : "+data.memberAddr+"<br>")
					}
				}
			});
		});
		$("#jQ5").on("click",function(){
			const result = $("#result5");
			result.empty();
			$.ajax({
				url : "/ajaxTest5.do",
				dataType:"json",
				success : function(data){
					console.log(data);
					for(let i=0;i<data.length;i++){
						const div = $("<div></div>");
						div.append(data[i].memberId);
						div.append("/");
						div.append(data[i].memberName);
						div.append("/");
						div.append(data[i].memberAddr);
						result.append(div);
					}
				}
			});
		});
		$("#jQ6").on("click",function(){
			const input4 = $("#input6").val();
			const result = $("#result6");
			result.empty();
			$.ajax({
				url : "/ajaxTest6.do",
				type: "get",
				data : {memberId: input4},
				dataType:"json",
				success : function(data){
					if(data == null){
						result.append("회원 정보를 조회할 수 없습니다.")
					}else{
						result.append("아이디 : "+data.memberId+"<br>")
						result.append("이름 : "+data.memberName+"<br>")
						result.append("전화번호 : "+data.memberPhone+"<br>")
						result.append("주소 : "+data.memberAddr+"<br>")
					}
				}
			});
		});
		$("#jQ7").on("click",function(){
			const result = $("#result7");
			result.empty();
			$.ajax({
				url : "/ajaxTest7.do",
				dataType:"json",
				success : function(data){
					console.log(data);
					for(let i=0;i<data.length;i++){
						const div = $("<div></div>");
						div.append(data[i].memberId);
						div.append("/");
						div.append(data[i].memberName);
						div.append("/");
						div.append(data[i].memberAddr);
						result.append(div);
					}
				}
			});
		});
		$("#jQ8").on("click",function(){
			let test =10;
			console.log("이벤트 시작 : "+test);
			$.ajax({
				url : "/ajaxTest8.do",
				success : function(data){
					//성공 시 내부를 실행되지만, 이 function이 처리되는 동안 아래 이벤트 끝이 담긴 콘솔이 돌아버림.
					//따라서 해당 방법을 방지하기 위해서는 모든 작업을 ajax 함수 내에서 실행해도 되며, 혹은 .then(function(){내부})에 담아주어도 됨. 
					test = data;
					console.log("ajax 내부 : "+test)
				}
			}).then(function(){
			console.log("이벤트 끝 : "+test);				
			});
		});
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>