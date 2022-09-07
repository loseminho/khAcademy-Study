<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.photoWrite td, .photoWrite th{
		border : 1px solid #eee;
	}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">사진게시판 작성</div>
		<form action="/photoWrite.do" method="post" enctype="multipart/form-data">
			<table class="tbl photoWrite">
				<tr class="tr-1">
					<th class="td-2">제목</th>
					<td colspan="3">
						<input type="text" name="photoTitle" class="input-form">
					</td>
				</tr>
				<tr class="tr-1">
					<th class="td-2">작성자</th>
					<td>
						<%=m.getMemberId() %>
						<input type="hidden" name="photoWriter" value="<%=m.getMemberId() %>">
					</td>
					<th class="td-2">이미지</th>
					<td>
						<input type="file" name="imageFile" accept=".jpg, .png, .jpeg" onchange="loadImg(this);">
					</td>
				</tr>
				<tr class="tr-1">
					<th class="td-2">이미지 미리보기</th>
					<td colspan="3">
						<div id="img-viewer">
							<img id="img-view" width="500px">
						</div>
					</td>
				</tr>
				<tr class="tr-1">
					<th class="tr-2">내용</th>
					<td colspan="3">
						<textarea name="photoContent" class="input-form"></textarea>
					</td>
				</tr>
				<tr class="tr-1">
					<th colspan="4">
						<button type="submit" class="btn bc22 bs4">등록</button>
					</th>
				</tr>
			</table>
		</form>
	</div>
	<script>
		function loadImg(f){
			// f = load 해놓은 파일
			// 첨부 파일이 여러개 일 수 있기 떄문에, 항상 배열로 처리함.
			console.log(f.files); // 변수.files = input에서 file을 선택했을때, 해당 파일이 들어있는 배열
			if(f.files.lengh != 0 && f.files[0] != 0){
				//배열길이가 0이 아니면서 첫번째 파일의 데이터가 0이 아닐때
				const reader = new FileReader(); // 파일 정보를 읽어올 수 있는 객체
				reader.readAsDataURL(f.files[0]);//선택한 파일 정보 읽어옴
				//파일 리더가 파일을 다 읽어오면 동작할 함수 작성
				reader.onload = function(e){
					//reader가 파일을 다 읽어온 경우 function함수를 동작.
					$("#img-view").attr("src",e.target.result);
				}
			}else{
				$("#img-view").attr("src","");
			}
		}
	</script>
	
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>