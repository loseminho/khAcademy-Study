<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">EMAIL-API</div>
		<h3>1. EMAIL 전송하기</h3>
		<form action="/mailSend1.do" method="post">
			<table class="tbl">
				<tr class="tr-1">
					<th class="td-2">제목</th>
					<td><input type="text" name="mailTitle" class="input-form"></td>
				</tr>
				<tr class="tr-1">
					<th class="td-2">수신자메일</th>
					<td>
						<input type="text" name="receiver" class="input-form">
					</td>
				</tr>
				<tr class="tr-1">
					<th class="td-2">내용</th>
					<td>
						<textarea name="mailContent" class="input-form"></textarea>
					</td>
				</tr>
				<tr class="tr-1">
					<th colspan="2">
						<button class="btn bc3 bs4" type="submit">전송</button>
					</th>
				</tr>
			</table>
		</form>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>