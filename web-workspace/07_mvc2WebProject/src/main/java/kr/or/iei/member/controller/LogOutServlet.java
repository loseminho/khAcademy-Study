package kr.or.iei.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet(name = "logOut", urlPatterns = { "/logOut.do" })
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getSession() : 현재 사용중인 세션을 가져온다
		// -> 현재 존재하는 세션이 없으면 세션을 새로 만들어서 가지고 옴
		// request.getSession(false) : 현재 사용중인 세션을 가져온다.
		// -> 현재 존재하는 세션이 없으면 null 리턴
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();//현재 세션을 파기하는 메소드
		}
		//메인페이지로 이동
		//메인페이지에 전달한 데이ㅏ터가 없으므로 redirect 방식으로 페이지 이동
		response.sendRedirect("/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
