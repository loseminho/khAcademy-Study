package kr.or.iei.free.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.free.notice.model.service.FreeNoticeService;
import kr.or.iei.free.notice.model.vo.FreeNotice;
import kr.or.iei.free.notice.model.vo.FreeNoticeComment;
import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.vo.NoticeComment;

/**
 * Servlet implementation class FreeNoticeCommentUpdateServlet
 */
@WebServlet(name = "freeNoticeCommentUpdate", urlPatterns = { "/freeNoticeCommentUpdate.do" })
public class FreeNoticeCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeNoticeCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//2. 값추출
		int ncNo = Integer.parseInt(request.getParameter("ncNo"));
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String ncContent = request.getParameter("ncContent");
		FreeNoticeComment fnc = new FreeNoticeComment();
		fnc.setNcContent(ncContent);
		fnc.setNcNo(ncNo);
		
		//3.비즈니스 로직
		FreeNoticeService fservice = new FreeNoticeService();
		int result = fservice.updateNoticeComment(fnc);
		
		//4.결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title","성공");
			request.setAttribute("msg","댓글이 수정되었습니다.");
			request.setAttribute("icon","success");
		}else {
			request.setAttribute("title","실패");
			request.setAttribute("msg","댓글 수정 실패.");
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
