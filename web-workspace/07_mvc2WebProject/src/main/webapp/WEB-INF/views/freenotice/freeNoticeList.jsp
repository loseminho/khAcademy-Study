<%@page import="kr.or.iei.free.notice.model.vo.FreeNotice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<FreeNotice> flist = (ArrayList<FreeNotice>)request.getAttribute("flist");
    	String pageNavi = (String)request.getAttribute("pageNavi");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">자유 게시판</div>
		
		
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>