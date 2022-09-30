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
	<form action="/update.do" method="post">
		<fieldset>
			<legend>마이페이지(현재 나의 정보)</legend>
			회원번호 : <input type="text" name="memberNo" value="${sessionScope.m.memberNo }" disabled><br>
			아이디 : <input type="text" name="memberId" value="${sessionScope.m.memberId }" readonly><br> 
			이름: <input type="text" name="memberName" value="${sessionScope.m.memberName }" disabled><br>
			비밀번호 : <input type="text" name="memberPw" placeholder = "현재 비밀번호 : ${sessionScope.m.memberPw }" value="${sessionScope.m.memberPw }"><br> 
			전화번호 : <input type="text" name="phone" placeholder = "현재 전화번호 : ${sessionScope.m.phone }" value="${sessionScope.m.phone }"><br>
			이메일 : <input type="text" name="email" placeholder = "현재 이메일 : ${sessionScope.m.email }" value="${sessionScope.m.email }"><br>
			<input type="submit" value="변경하기">
		</fieldset>
	</form>
</body>
</html>