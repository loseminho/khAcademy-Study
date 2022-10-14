<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이메일 인증 중입니다!</h1>
	<hr>
	<form action="/email.do" method="post">
		<fieldset>
			<legend>이메일 인증하기</legend>
			회원가입 하신 이메일 주소로 랜덤 코드를 전송하였습니다.<br> 
			인증코드 입력 : <input type="text" name="email">
			<input type="submit" value="입력">
		</fieldset>
	</form>
</body>
</html>