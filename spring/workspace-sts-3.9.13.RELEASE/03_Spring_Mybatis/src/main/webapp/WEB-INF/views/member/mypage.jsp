<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<hr>
	<form action="/updateInfo.do" method="post">
		<fieldset>
			<legend>마이페이지</legend>
				<table border="1">
					<tr>
						<th>아이디</th>
						<td><input type="text" name="memberId" value="${sessionScope.m.memberId }"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="memberPw" value="${sessionScope.m.memberPw }"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="memberName" value="${sessionScope.m.memberName }"  readonly></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="text" name="phone" value="${sessionScope.m.phone }"></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input type="text" name="email" value="${sessionScope.m.email }"></td>
					</tr>
				</table>
				<input type="submit" value="정보수정">
				<input type="button" onclick="location.href='/'" value="메인으로가기">
		</fieldset>
	</form>
</body>
</html>