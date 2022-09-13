package kr.or.iei.free.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.free.notice.model.service.FreeNoticeService;
import kr.or.iei.free.notice.model.vo.FreeNoticeComment;
import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.vo.NoticeComment;

/**
 * Servlet implementation class InsertFreeCommentServlet
 */
@WebServlet(name = "insertFreeComment", urlPatterns = { "/insertFreeComment.do" })
public class InsertFreeCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFreeCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      1. 인코딩
      request.setCharacterEncoding("utf-8");
//      2. 값 추출
      FreeNoticeComment fnc = new FreeNoticeComment();
      fnc.setNcWriter(request.getParameter("ncWriter"));
      fnc.setNoticeRef(Integer.parseInt(request.getParameter("noticeRef")));
      fnc.setNcRef(Integer.parseInt(request.getParameter("ncRef")));
      fnc.setNcContent(request.getParameter("ncContent"));   
//      3. 비지니스로직
      FreeNoticeService fservice = new FreeNoticeService();
      int result = fservice.insertNoticeComment(fnc);
//      4. 결과처리
      RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
      if(result>0) {
         request.setAttribute("title", "성공");
         request.setAttribute("msg", "댓글 작성 완료");
         request.setAttribute("icon", "success");
      }else {
         request.setAttribute("title", "실패");
         request.setAttribute("msg", "댓글 작성 실패");
         request.setAttribute("icon", "error");
      }
      request.setAttribute("loc", "/freeNoticeView.do?FreeNoticeNo="+fnc.getNoticeRef());
      view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
