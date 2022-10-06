<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table {
    width: 75%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
    padding: 3px;
    font-size: 17px;
  }
  .tableContent{
  	height: 300px;
  }
</style>
</head>
<body>
	<h1>게시판 상세보기</h1>
	<hr>
	<table>
		<tr>
			<th>글 번호</th>
			<th>글쓴이</th>
			<th>글제목</th>
			<th>첨부파일</th>
			<th>작성시간</th>
		</tr>
		<tr>
			<td>${b.boardNo }</td>
			<td>${b.boardWriter }</td>
			<td><input type="text" value="${b.boardTitle }"></td>
			<td><c:forEach items="${b.fileList }" var="f">
               <p>
                  <a href="/boardFileDown.do?fileNo=${f.fileNo }">${f.filename }</a>
               </p>
            </c:forEach></td>
			<td>${b.boardDate }</td>
		</tr>
		<tr>
			<th colspan="5">내용</th>
		</tr>
		<tr>
			<td colspan="5"  class="tableContent">${b.boardContent }</td>
		</tr>
	</table>
	<c:choose>
	<c:when test="${sessionScope.m.memberId == b.boardWriter}">
		<input type="button" action="/boardUpdateFrm.do?boardNo=${b.boardNo }" value="수정하기"  onClick="location.href='/boardUpdateFrm.do?boardNo=${b.boardNo }'"></input>
		<input type="button" action="/boardDelete.do?boardNo=${b.boardNo }" value="삭제하기"  onClick="location.href='/boardDelete.do?boardNo=${b.boardNo }'"></input>
	</c:when>
	<c:otherwise>
		<h1>힝 접속자 다르지 수정 못하지</h1>	
	</c:otherwise>
	</c:choose>
	
	</body>
</html>