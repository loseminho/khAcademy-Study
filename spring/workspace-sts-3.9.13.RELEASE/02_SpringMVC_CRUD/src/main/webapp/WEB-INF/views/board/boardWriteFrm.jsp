<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성 페이지</h1>
	<hr>
	<form action="/boardWrite.do" method="post">
		<fieldset>
			<legend>게시글 작성</legend>
			작성자 : <input type="text" name="boardWriter" value="${sessionScope.m.memberId }" readonly>
			<br>
			글 제목 : <input type="text" name="boardTitle" placeholder = "제목을 입력해주세요">
			<br> 
			글 내용 : <textarea name="boardContent"></textarea> 
			<!-- 
			<input type="text" name="boardContent" placeholder = "내용을 입력해주세요">
			 -->
			<input type="submit" value="게시글 작성">
		</fieldset>
	</form>
</body>
</html>