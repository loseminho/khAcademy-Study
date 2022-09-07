<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.page-content h1{
		margin: auto;
		text-align: center;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<% System.out.println("메인페이지 접속!!!!!!!!!!!ㅁㄴㅇㄻㄴㅇㄻㄴㅇㄹ"); %>
	<div class="page-content">
		<h1>릴리 기요워</h1>
		<img src="/img/dog14.jpg" width="500px">
		<video src="/video/liry.mp4" id="videos" type="video/mp4" width="500px" controls autoplay>릴리</video>
		
	</div>

	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>