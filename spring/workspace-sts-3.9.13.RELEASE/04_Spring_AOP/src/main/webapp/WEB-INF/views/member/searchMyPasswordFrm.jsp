<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>비밀번호를 까먹으셨나요?</h1>
	<hr>
	<form action="/searchMyPassword.do" method="post">
		<fieldset>
			<legend>본인인증하기</legend>
			아이디 입력 : <input type="text" name="memberId"><br> 
			이메일 입력 : <input type="text" name="email"><br>
			<input type="submit" value="확인하기">
		</fieldset>
	</form>
	
	
	
</body>
</html>