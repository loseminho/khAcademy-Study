<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시물 수정의 공간</h1>
	<hr>
	
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>글쓴이</th>
			<th>작성시간</th>
		</tr>
		<tr>
			<td>${board.boardNo }</td>
			<td>${board.boardWriter }</td>
			<td>${board.boardDate }</td>
		</tr>
		<tr>
			<th colspan="3">글 제목</th>
		</tr>
		<tr>
			<td colspan="3"><input type="text" value="${board.boardTitle }"></td>
		</tr>
		<tr>
			<th colspan="3">내용</th>
		</tr>
		<tr>
			<td colspan="3">${board.boardContent }</td>
		</tr>
	</table>
	
</body>
</html>