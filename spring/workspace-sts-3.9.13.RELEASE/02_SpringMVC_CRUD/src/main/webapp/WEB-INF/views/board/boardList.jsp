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
	<h1>게시물 전체 조회</h1>
	<hr>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${list }" var="b">
			<tr>
				<td>${b.boardNo }</td>
				<td><a href="/boardView.do?boardNo=${b.boardNo }">${b.boardTitle }</a></td>
				<td>${b.boardWriter }</td>
				<td>${b.boardDate }</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" action="/boardWriteFrm.do" value="글쓰기"  onClick="location.href='/boardWriteFrm.do'"></input>
	<input type="button" action="/boardWriteFrm2.do" value="글쓰기(파일첨부)"  onClick="location.href='/boardWriteFrm2.do'"></input>
</body>
</html>