<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%System.out.println("접속이 들어왔습니다!");%>
	<h1>Spring MVC</h1>
	<hr>
	<form action="/login.do" method="post">
		아이디 : <input type="text" name="memberId"><br>
		비밀번호 : <input type="password" name="memberPw">
		<input type="submit">
	</form>
	<hr>
	<form action="/search.do" method="get">
		조회 할 아이디 : <input type="text" name="memberId">
		<input type="submit" value="조회"> 
	</form>
</body>
</html>