<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">결제모듈</div>
		<input type="text" id="price">
		<button id="payBtn">결제하기</button>
	</div>
	<script>
		$("#payBtn").on("click",function(){
			const price = $("#price").val();
			const d = new Date();
			const date = d.getFullYear()+""+(d.getMonth()+1)+""+d.getDate()+""+d.getHours()+""+d.getMinutes()+""+d.getSeconds();
			
			IMP.init("imp43256257");
			IMP.request_pay({
				merchat_uid : "상품코드_"+date, 		// 거래ID
				name : "결제 테스트 ",					//결제 이름
				amount : price,						//결제금액
				buyer_email : "loseminhos@gmail.com",//구매자
				buyer_name : "구매자",					//구매자 이름
				buyer_tel : "010-3267-7800",		//구매자 연락처
				buyer_addr : "인천",					//구매자 주소
				buyer_postcode : "12345" 			//우편번호
			},function(rsp){
				if(rsp.success){
					alert("결제 성공");
				}else{
					alert("결제 실패");
				}
			})
		});
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>