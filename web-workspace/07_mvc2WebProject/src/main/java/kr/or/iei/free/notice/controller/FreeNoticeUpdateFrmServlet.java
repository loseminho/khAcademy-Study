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
import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.vo.Notice;

/**
 * Servlet implementation class FreeNoticeUpdateFrmServlet
 */
@WebServlet(name = "freeNoticeUpdateFrm", urlPatterns = { "/freeNoticeUpdateFrm.do" })
public class FreeNoticeUpdateFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeNoticeUpdateFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		FreeNoticeService fservice = new FreeNoticeService();
		FreeNotice fn = fservice.getNotice(noticeNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/freenotice/freeUpdateNoticeFrm.jsp");
		request.setAttribute("fn", fn);
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
