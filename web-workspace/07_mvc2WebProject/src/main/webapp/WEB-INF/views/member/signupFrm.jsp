<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<style>
	.input-wrap{
		padding: 15px;
	}
	.input-wrap > label{
		font-size : 1.1em;
		margin-bottom: 10px;
		display: block;
	}
	.submit-btn{
		padding: 15px;
		margin: 20px 0px;
	}
	.input-wrap>.id-wrap{
		display: flex;
	}
	.input-wrap>.id-wrap>#memberId{
		width: 80%;
	}
	.input-wrap>.id-wrap>#idChkBtn{
		width: 20%;
	}
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">회원가입</div>
		<form name="checkIdFrm" action="/checkId.do">
			<input type="hidden" name="checkId">
		</form>
		<form action="/signUp.do" method="post">
			<div class="input-wrap">
				<label for="memberId">아이디<span id="ajaxCheckId"></span></label>
				<div class="id-wrap">
					<input type="text" name="memberId" id="memberId" class="input-form">
					<button type="button" id="idChkBtn" class="btn bc2">중복체크</button>
				</div>
			</div>
			<div class="input-wrap">
				<label for="memberPw">비밀번호</label>
				<input type="password" name="memberPw" id="memberPw" class="input-form">
			</div>
			<div class="input-wrap">
				<label for="memberName">이름</label>
				<input type="text" name="memberName" id="memberName" class="input-form">
			</div>
			<div class="input-wrap">
				<label for="memberPhone">전화번호</label>
				<input type="text" name="memberPhone" id="memberPhone" class="input-form" placeholder="010-0000-0000">
			</div>
			<div class="input-wrap">
				<label for="memberAddr">주소</label>
				<input type="text" name="memberAddr" id="memberAddr" class="input-form">
			</div>
			<div class="submit-btn">
				<button type="submit" class="btn bc66 bs4">회원가입</button>
			</div>
		</form>
	</div>
	<script>
		$("[name=memberId]").on("keyup",function(){
			const memberId = $(this).val();
			// 유효성 검사 먼저 수행
			// 유효성 검사를 통화하면 중복 체크
			$.ajax({
				url : "/ajaxCheckId.do",
				type: "get",
				data: {memberId : memberId},
				success : function(data){
					if(data == "1"){
						$("#ajaxCheckId").text("이미 사용중인 아이디입니다.");
						$("#ajaxCheckId").css("color","red");
					}else if(data == "0"){
						$("#ajaxCheckId").text("사용 가능한 아이디입니다.");
						$("#ajaxCheckId").css("color","blue");
					}
				}
			});
		});
		
		$("#idChkBtn").on("click",function(){
			const memberId = $(this).prev().val();
			if(memberId == ""){
				alert("아이디를 입력하세요");
				return;
			}
			$("[name=checkId]").val(memberId);
			const popup = window.open("","checkId","left=900px, top=500px, width=300px, height=200px, menubar=no, status=no, scrollbars=yes");
			//새 창에서 form을 전송하기 위한 연결작업(저 이름 Frm이라는 폼태그를 checkId에서 처리를 하겠다)
			$("[name=checkIdFrm]").attr("target","checkId");
			$("[name=checkIdFrm]").submit();
		});
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>