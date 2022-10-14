/**
 * 
 */
 
 function sendDmModal(){
 	$.ajax({
 		url : "/selectAllMemberId.do",
 		success : function(list){
 			$("[name=receiver]").empty();
 			for(let i=0; i<list.length; i++){
 				const option = $("<option>");
 				option.val(list[i]);
 				option.text(list[i]);
 				$("[name=receiver]").append(option);
 			}
			$("#sendDm-modal").css("display","flex");
 		}
 	});
 }
 
 function closeModal(){
 	$("#sendDm-modal").hide();
 	$("textarea[name=dmContent]").val("");
 }
 
 function dmSend(){
	const receiver = $("[name=receiver]").val();
	const dmContent = $("[name=dmContent]").val();
	const sender = $("#sender").val();
	
	$.ajax({
		url : "/insertDm.do",
		data : {receiver : receiver,
				dmContent : dmContent,
				sender : sender
				},
		success : function(data){
			if(data == "1"){
				closeModal();
			}else{
				alert("쪽지 보내기 실패~");
			}
		}		
	});
}

function getReceiveDm(){
	const receiver = $("#sender").val();
	$.ajax({
		url: "/myDmList.do",
		data : {receiver : receiver},
		success : function(list){
				const tbody = $(".receiveDmTbl>tbody");
				tbody.empty();
				for(let i=0; i<list.length; i++){
					const dm = list[i];
					const tr = $("<tr>");
					//받은 사람,내용,시간,읽음 여부
					const senderTd = $("<td>");
					senderTd.text(dm.sender);
					const contentTd = $("<td>");
					contentTd.text(dm.dmContent);
					contentTd.attr("onclick","dmDetail("+dm.dmNo+")");
					const dmDateTd = $("<td>");
					dmDateTd.text(dm.dmDate);
					const readTd = $("<td>");
					if(dm.readCheck == 0){
							tr.addClass("bold");
							readTd.text("읽지않음");
						}else{
							tr.removeClass("bold");
							readTd.text("읽음");
						}
					tr.append(senderTd).append(contentTd).append(dmDateTd).append(readTd);
					tbody.append(tr);
				}
			}
	});
}
function getSendDm(){
	const sender = $("#sender").val();
	$.ajax({
		url: "/myDmList.do",
		data : {sender : sender},
		success : function(list){
				const tbody = $(".sendDmTbl>tbody");
				tbody.empty();
				for(let i=0; i<list.length; i++){
					const dm = list[i];
					const tr = $("<tr>");
					//보낸 사람,내용,시간,읽음 여부
					const receiverTd = $("<td>");
					receiverTd.text(dm.receiver);
					const contentTd = $("<td>");
					contentTd.text(dm.dmContent);
					
					contentTd.attr("onclick","dmDetail("+dm.dmNo+")");
					
					const dmDateTd = $("<td>");
					dmDateTd.text(dm.dmDate);
					const readTd = $("<td>");
					if(dm.readCheck == 0){
							tr.addClass("bold");
							readTd.text("읽지않음");
						}else{
							tr.removeClass("bold");
							readTd.text("읽음");
						}
					tr.append(receiverTd).append(contentTd).append(dmDateTd).append(readTd);
					tbody.append(tr);
				}
			}
	});
}

function dmDetail(dmNo){
	$.ajax({
		url : "/dmDetail.do",
		data : {dmNo : dmNo},
		success : function(data){
			$("#detailSender").text(data.sender);
			$("#detailDate").text(data.dmDate);
			$("#detailContent").text(data.dmContent);
			if(data.readCheck ==0){
				getReceiveDm();
			}
			$("#dmDetail").css("display","flex");
		}
	});
	
}
function closeDetail(){
	$("#dmDetail").hide();
}

$(function(){
	getReceiveDm();
	getSendDm();
})






