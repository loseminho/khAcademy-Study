package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class SerchMemberIdServlet
 */
@WebServlet(name = "searchMemberId", urlPatterns = { "/searchMemberId.do" })
public class SerchMemberIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerchMemberIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memberId = request.getParameter("memberId");
		
		MemberService service = new MemberService();
		Member m = service.serchMemberId(memberId);
		
		//4.결과처리
		//4-1. 결과를 처리할 jsp처리 지정
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/searchMemberId.jsp");
		
		//4-2. 화면 구성에 필요한 데이터를 등록
		//(key값,value값)
		request.setAttribute("m", m);
		
		//4-3. 페이지 이동
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
