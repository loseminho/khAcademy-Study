<%@page import="kr.or.iei.member.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //서블릿에서 전송한 값을 읽어오는 코드
    ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전체 회원 정보</h1>
	<hr>
	<%if(list.isEmpty()) {%>
		<h3>회원 정보를 조회할 수 없습니다.</h3>
	<%}else{ %>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
		</tr>
		<%for(Member m : list){ %>
			<tr>
				<td><%=m.getMemberId() %></td>
				<td><%=m.getMemberName() %></td>
				<td><%=m.getMemberPhone() %></td>
				<td><%=m.getMemberAddr() %></td>
			</tr>
		<%}%>
	</table>
	<%} %>
</body>
</html>