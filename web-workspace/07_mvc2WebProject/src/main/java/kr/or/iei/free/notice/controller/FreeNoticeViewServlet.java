package kr.or.iei.free.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.free.notice.model.service.FreeNoticeService;
import kr.or.iei.free.notice.model.vo.FreeNoticePageData;
import kr.or.iei.free.notice.model.vo.FreeNoticeViewData;

/**
 * Servlet implementation class FreeNoticeViewServlet
 */
@WebServlet(name = "freeNoticeView", urlPatterns = { "/freeNoticeView.do" })
public class FreeNoticeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeNoticeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int freeNoticeNo = Integer.parseInt(request.getParameter("FreeNoticeNo"));
		
		FreeNoticeService fservice = new FreeNoticeService();
		FreeNoticeViewData fnvd = fservice.selectOneNotice(freeNoticeNo);
		
		//4. 결과처리
		if(fnvd == null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "조회실패");
			request.setAttribute("msg", "게시글이 존재하지 않습니다.");
			request.setAttribute("icon", "info");
			request.setAttribute("loc", "/freeNoticeList.do?reqPage=1");
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/freenotice/freeNoticeView.jsp");
			request.setAttribute("fn", fnvd.getFn());
			request.setAttribute("fCommentList", fnvd.getfCommentList());
			request.setAttribute("fRecommentList", fnvd.getfReCommentList());
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
