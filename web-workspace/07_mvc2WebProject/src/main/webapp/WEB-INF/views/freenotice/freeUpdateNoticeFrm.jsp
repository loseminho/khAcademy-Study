<%@page import="kr.or.iei.free.notice.model.vo.FreeNotice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	FreeNotice fn = (FreeNotice)request.getAttribute("fn");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#noticeUpdateFrm td, #noticeUpdateFrm th{
		border: 1px solid #eee;
	}
	.file-box{
		display:flex;
		align-items: center;
		justify-content: center;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">공지사항 수정</div>
		<form action="/freeNoticeUpdate.do" method="post" enctype="multipart/form-data">
		<table class="tbl" id="noticeUpdateFrm">
				<th class="tr-3">제목</th>
				<td>
					<input type="hidden" name="noticeNo" value="<%=fn.getFreeNoticeNo() %>">
					<!-- 기존 파일을 지웠는지 체크하는 용도 -->
					<input type="hidden" name="status" value="stay">
					<input type="text" name="noticeTitle" class="input-form" value="<%=fn.getFreeNoticeTitle()%>">
				</td>
				<tr class="tr-1">
					<th class="td-3">첨부파일</th>
					<td>
						<%if(fn.getFreeFilepath() != null){ %>
							<!-- 화면에 보이는 값 -->
							<img src="/img/file.png" width="16px" class="delFile">
							<span class="delFile"><%=fn.getFreeFilename()%></span>
							<button type="button" class="btn bc1 delFile">삭제</button>
							
							
							<input type="file" name="upfile" style="display:none;">
							<input type="hidden" name="oldFilename" value="<%=fn.getFreeFilename() %>">
							<input type="hidden" name="oldFilepath" value="<%=fn.getFreeFilepath() %>">
						<%}else{ %>
							<input type="file" name="upfile">
						<%} %>
					</td>
				</tr>
				<tr class="tr-1">
					<th class="td-3">내용</th>
					<td>
						<textarea class="input-form" name="noticeContent"><%=fn.getFreeNoticeContent() %></textarea>
					</td>
				</tr>
				<tr class="tr-1">
					<th colspan="2">
						<button type="submit" class="btn bc4 bs4">수정 완료</button>
					</th>
				</tr>
		</table>
		</form>
	</div>
	
	<script>
		$("button.delFile").on("click",function(){
			$(".delFile").hide();
			$(this).next().show();
			$("[name=status]").val("delete");
			
		});
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>