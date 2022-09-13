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

/**
 * Servlet implementation class FreeNoticeListServlet
 */
@WebServlet(name = "freeNoticeList", urlPatterns = { "/freeNoticeList.do" })
public class FreeNoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeNoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		
		FreeNoticeService fservice = new FreeNoticeService();
		FreeNoticePageData fnpd = fservice.selectFreeNoticeList(reqPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/freenotice/freeNoticeList.jsp");
		request.setAttribute("flist", fnpd.getFlist());
		request.setAttribute("freePageNavi", fnpd.getFreePageNavi());
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
