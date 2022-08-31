package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class AllmemberServlet
 */
@WebServlet(name = "allmember", urlPatterns = { "/allMember.do" })
public class AllmemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllmemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 값 추출
		// 화면에서 전송한 값이 없으므로 2번 생략
		
		// 3. 비즈니스로직
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selectAllMember();
		
		// 4. 결과처리
		// 4-1. 결과를 처리할 jsp 지정
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/allMember.jsp");
		
		// 4-2. 화면 구성에 필요한 데이터 등록
		request.setAttribute("list", list);
		
		// 4-3. jsp 페이지로 이동
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
