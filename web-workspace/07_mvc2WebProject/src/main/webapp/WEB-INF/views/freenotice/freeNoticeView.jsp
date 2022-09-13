<%@page import="kr.or.iei.free.notice.model.vo.FreeNoticeComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.free.notice.model.vo.FreeNotice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	FreeNotice fn = (FreeNotice)request.getAttribute("fn");
    	ArrayList<FreeNoticeComment> fCommentList = (ArrayList<FreeNoticeComment>)request.getAttribute("fCommentList");
    	ArrayList<FreeNoticeComment> fRecommentList = (ArrayList<FreeNoticeComment>)request.getAttribute("fRecommentList");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   #noticeView th, #noticeView td{
      border: 1px solid #eee;
   }
   #noticeContent{
      min-height: 300px;
      text-align: left;
      font-family: ns-light;
   }
   .inputCommentBox{
      margin: 50px;
   }
   .inputCommentBox>form>ul{
      list-style-type: none;
      display: flex;
   }
   .inputCommentBox>form>ul>li:first-child{
      width: 15%;
      display: flex;
      justify-content: center;
      align-items: center;
   }
   .inputCommentBox>form>ul>li:first-child>span{
      font-size: 80px;
      color: #ccc;
   }
   .inputCommentBox>form>ul>li:nth-child(2){
      width: 75%;
   }
   .inputCommentBox>form>ul>li:nth-child(2)>textarea.input-form{
      height: 96px;
      min-height: 96px;
   }
   .inputCommentBox>form>ul>li:last-child{
      width: 10%;
   }
   .inputRecommentBox{
      margin: 30px 0px;
      display: none;
   }
   .inputRecommentBox>form>ul{
      list-style-type: none;
      display: flex;
   }
   .inputRecommentBox>form>ul>li:first-child{
      width: 15%;
      display: flex;
      justify-content: center;
      align-items: center;
   }
   .inputRecommentBox>form>ul>li:first-child>span{
      font-size: 50px;
      color: #ccc;
   }
   .inputRecommentBox>form>ul>li:nth-child(2){
      width: 75%;
   }
   .inputRecommentBox>form>ul>li:nth-child(2)>textarea{
      height: 96px;
      min-height: 96px;
   }
   .inputRecommentBox>form>ul>li:last-child{
      width: 10%;
   }
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">자유게시판</div>
		<table class="tbl" id = "noticeView">
			<tr class="tr-3">
				<th colspan = "6"><%=fn.getFreeNoticeTitle() %></th>
			</tr>
			<tr class="tr-1">
				<th class = "td-3">작성자</th>
	            <td><%=fn.getFreeNoticeWriter()%></td>
	            <th class = "td-3">조회수</th>
	            <td><%=fn.getFreeReadCount()%></td>
	            <th class ="td-3">작성일</th>
	            <td><%=fn.getFreeRegDate()%></td>
			</tr>
			<tr class="tr-1">
				<th class="td-3">첨부파일</th>
				<td colspan="5">
					<%if(fn.getFreeFilename()!=null){ %>
					<img src="/img/file.png" width = "16px">
					<a href="/noticeFileDown.do?noticeNo=<%=fn.getFreeNoticeNo()%>"><%=fn.getFreeFilename() %></a>
					<%} %>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<div id="noticeContent"><%=fn.getFreeNoticeContentBr() %></div>
				</td>
			</tr>
			<%if(m!=null && fn.getFreeNoticeWriter().equals(m.getMemberId()) ){ %>
			<tr class="tr-1">
				<th colspan="6">
					<a class="btn bc44" href="/freeNoticeUpdateFrm.do?noticeNo=<%=fn.getFreeNoticeNo()%>">수정</a>
					<button class="btn bc44" onclick="noticeDelete(<%=fn.getFreeNoticeNo()%>);">삭제</button>
				</th>
			</tr>
			<%} %>
		</table>
		
      <!-- 댓글 입력 양식 -->
      <%if(m!=null){ %>
      <div class="inputCommentBox">
         <form action="/insertFreeComment.do" method="post">
            <ul>
               <li>
                  <span class="material-icons">account_box</span>
               </li>
               <li>
                  <input type="hidden" name="ncWriter" value="<%=m.getMemberId() %>">
                  <input type="hidden" name="noticeRef" value="<%=fn.getFreeNoticeNo() %>">
                  <input type="hidden" name="ncRef" value="0">
                  <textarea class="input-form" name="ncContent"></textarea>
               </li>
               <li>
                  <button type="submit" class="btn bc1 bs4">등록</button>
               </li>
            </ul>
         </form>
      </div>   
      <%} %>
      
      <div class="commentBox">
      	<%for(FreeNoticeComment fnc : fCommentList) {%>
      	<ul class="posting-comment">
      		<li>
      			<span class ="material-icons">account_box</span>
      		</li>
            <li>
               <p class="comment-info">
                  <span><%=fnc.getNcWriter() %></span>
                  <span><%=fnc.getNcDate() %></span>
               </p>
               <p class="comment-content"><%=fnc.getNcContent() %></p>
               <textarea name="ncContent" class="input-form" style="min-height: 96px; display:none;"><%=fnc.getNcContent() %></textarea>
               <p class="comment-link">
                  <%if(m!=null){ %>
                     <%if(m.getMemberId().equals(fnc.getNcWriter()) || m.getMemberLevel() == 1){ %>
                        <a href="javascript:void(0)" onclick="modifyComment(this, <%=fnc.getNcNo()%>,<%=fn.getFreeNoticeNo()%>);">수정</a>
                        <a href="javascript:void(0)" onclick="deleteComment(this, <%=fnc.getNcNo()%>,<%=fn.getFreeNoticeNo()%>);">삭제</a>
                     <%} %>
                  <a href="javascript:void(0)" class="recShow">답글 달기</a>
                  <%}//답글조건 if문(로그인체크) %>
               </p>
            </li>
         </ul>
         
         <%for(FreeNoticeComment fncc : fRecommentList){ %>
            <%if(fncc.getNcRef()==fnc.getNcNo()){ %>
               <ul class="posting-comment reply">
                  <li>
                     <span class="material-icons">subdirectory_arrow_right</span>
                     <span class="material-icons">account_box</span>
                  </li>
                  <li>
                     <p class="comment-info">
                        <span><%=fncc.getNcWriter() %></span>
                        <span><%=fncc.getNcDate() %></span>
                     </p>
                     <p class="comment-content"><%=fncc.getNcContent() %></p>
                     <textarea name="ncContent" class="input-form" style="min-height: 96px; display:none;"><%=fncc.getNcContent() %></textarea>
                     <p class="comment-link">
                     	<%if(m!=null){ %>
		                     <%if(m.getMemberId().equals(fncc.getNcWriter()) || m.getMemberLevel()==1){ %>
		                        <a href="javascript:void(0)" onclick="modifyComment(this, <%=fncc.getNcNo()%>,<%=fn.getFreeNoticeNo()%>);">수정</a>
		                        <a href="javascript:void(0)" onclick="deleteComment(this, <%=fncc.getNcNo()%>,<%=fn.getFreeNoticeNo()%>);">삭제</a>
		                     <%} %>
		                  <a href="javascript:void(0)" class="recShow">답글 달기</a>
                  		<%}//답글조건 if문(로그인체크) %>
                     </p>
                  </li>
               </ul>
            <%} //해당 댓글의 대댓글인지 체크하는 if문 종료%>
         <%}//대댓글 출력 for문 종료 %>
         
         
            <%if(m!=null){ %>
            <div class="inputRecommentBox">
               <form action="/insertFreeComment.do" method="post">
                  <ul>
                     <li>
                        <span class="material-icons">subdirectory_arrow_right</span>
                     </li>
                     <li>
                        <input type = "hidden" name = "ncWriter" value = "<%=m.getMemberId()%>">
                        <input type="hidden" name="noticeRef" value="<%=fn.getFreeNoticeNo() %>">
                        <input type = "hidden" name = "ncRef" value = "<%=fnc.getNcNo() %>">
                        <textarea class="input-form" name="ncContent"></textarea>
                     </li>
                     <li>
                     <button type="submit" class="btn bc1 bs4">등록</button>
                     </li>
                  </ul>
               </form>
            </div>
            <%} //대댓글 달기 form 조건문%>
         <%}//댓글 반복문 종료 %>
      </div>
      
	</div>
	
	<script>
      function noticeDelete(noticeNo){
         if(confirm("공지사항을 삭제하시겠습니까?")){
            location.href="/FreeNoticeDelete.do?noticeNo="+noticeNo;
         }
      }
      $(".recShow").on("click",function(){
         const idx = $(".recShow").index(this);
         $(".inputRecommentBox").eq(idx).toggle();
         $(".inputRecommentBox").eq(idx).find("textarea").focus();
         if($(this).text()=="답글 달기"){
            $(this).text("취소");
         }else{
            $(this).text("답글 달기")
         }
      });
      function modifyComment(obj, ncNo, noticeNo){
         $(obj).parent().prev().show(); // textare화면에 보여줌
         $(obj).parent().prev().prev().hide(); //내용을 보여주던 p태근
         //수정 -> 수정완료
         $(obj).text("수정완료");
         $(obj).attr("onclick","modifyComplete(this,"+ncNo+","+noticeNo+")");
         //삭제 -> 수정취소
         $(obj).next().text("수정취소");
         $(obj).next().attr("onclick","modifyCancel(this,"+ncNo+","+noticeNo+")");
         // 답글달기버튼 숨김
         $(obj).next().next().hide();
      }
      function modifyCancel(obj, ncNo, noticeNo){
         $(obj).parent().prev().hide(); // textarea 숨김
         $(obj).parent().prev().prev().show(); // 기존댓글 보여줌
         //수정완료 -> 수정
         $(obj).prev().text("수정");
         $(obj).prev().attr("onclick","modifyComment(this,"+ncNo+","+noticeNo+")");
         //수정취소 -> 삭제
         $(obj).text("삭제");
         $(obj).attr("onclick","deleteComment(this,"+ncNo+","+noticeNo+")");
         //답글달기 버튼 보여줌
         $(obj).next().show();   
      }
      function modifyComplete(obj,ncNo,noticeNo){
    	  //form 태그를 생성해서 전송
    	  //1. form 태그 생성
    	  const form = $("<form action='/freeNoticeCommentUpdate.do' method='post'></form> ");
    	  //2. input 태그 생성 (ncNo)
    	  const ncInput = $("<input type='text' name='ncNo'>");
    	  //ncNo 값 세팅
    	  ncInput.val(ncNo);
    	  //form태그에 추가
    	  form.append(ncInput);
    	  //3. input 태그 생성(noticeNo)
    	  const noticeInput = $("<input type='text' name='noticeNo'>");
    	  noticeInput.val(noticeNo);
    	  form.append(noticeInput);
    	  //4. textarea
    	  const ncContent = $(obj).parent().prev();
    	  form.append(ncContent);
    	  //body태그에 생성한 form 태그를 추가
    	  $("body").append(form);
    	  //form태그 전송
    	  form.submit();
      }
      function deleteComment(obj,ncNo,noticeNo){
    	  if(confirm("댓글을 삭제하시겠습니까?")){
    		  location.href="/deleteFreeNoticeComment.do?ncNo="+ncNo+"&noticeNo="+noticeNo;
    	  }
      }
   </script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>