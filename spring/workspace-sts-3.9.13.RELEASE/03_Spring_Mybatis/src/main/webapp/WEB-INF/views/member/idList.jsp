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
	<h1>회원정보조회</h1>
	<hr>
	<table border="1">
		<tr>
			<th>아이디</th>
		</tr>
		<form action="/searchMember3.do" method="post">			
		<c:forEach items="${list }" var="m">
			<tr>
				<td><input type="checkbox" name="memberId" value="${m.memberId }">${m.memberId }</td>
			</tr>
		</c:forEach>
		<tr>
			<td><input type="submit" value="전송하기"></td>		
		</tr>
		</form>
	</table>
	<a href="/">메인페이지로</a>
</body>
</html>