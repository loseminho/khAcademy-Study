<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		//이럴 경우 비즈니스로직과 결과처리를 내부에서 진행을 해도 됨.
	%>
	<h2><%=data1 %></h2>
	<h2><%=data2 %></h2>
</body>
</html>
