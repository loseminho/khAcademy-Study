package kr.or.iei.free.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.free.notice.model.service.FreeNoticeService;
import kr.or.iei.notice.model.service.NoticeService;

/**
 * Servlet implementation class DeleteFreeNoticeCommentServlet
 */
@WebServlet(name = "deleteFreeNoticeComment", urlPatterns = { "/deleteFreeNoticeComment.do" })
public class DeleteFreeNoticeCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFreeNoticeCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값 추출
		int ncNo = Integer.parseInt(request.getParameter("ncNo"));
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		//3.비즈니스로직
		FreeNoticeService fservice = new FreeNoticeService();
		int result = fservice.deleteNoticeComment(ncNo);
		
		//4. 결과
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title","삭제 성공");
			request.setAttribute("msg","댓글이 삭제되었습니다.");
			request.setAttribute("icon","success");
		}else {
			request.setAttribute("title","실패");
			request.setAttribute("msg","댓글 삭제 실패.");
			request.setAttribute("icon","error");
		}
		request.setAttribute("loc", "/freeNoticeView.do?FreeNoticeNo="+noticeNo);
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
