<%@page import="kr.or.iei.free.notice.model.vo.FreeNotice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<FreeNotice> flist = (ArrayList<FreeNotice>)request.getAttribute("flist");
    	String freePageNavi = (String)request.getAttribute("freePageNavi");
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
		
		<table class="tbl tbl-hover notice-tbl">
			<tr class="tr-2">
				<th style="width:10%">번호</th>
				<th style="width:45%">제목</th>
				<th style="width:15%">작성자</th>
				<th style="width:20%">작성일</th>
				<th style="width:10%">조회수</th>
			</tr>
			
			<%for(FreeNotice fn : flist) {%>
			<tr class="tr-1">
				<td><%=fn.getFreeNoticeNo() %></td>
				<td><a href="/freeNoticeView.do?FreeNoticeNo=<%=fn.getFreeNoticeNo()%>"><%=fn.getFreeNoticeTitle() %></a></td>
				<td><%=fn.getFreeNoticeWriter() %></td>
				<td><%=fn.getFreeRegDate()%></td>
				<td><%=fn.getFreeReadCount() %></td>
			</tr>
			<%} %>
		</table>
		<div id="freePageNavi"><%=freePageNavi %></div>
	</div>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>