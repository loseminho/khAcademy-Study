package kr.or.iei.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		//사용자가 요청한 컨트롤러 주소를 확인
		
		String uri = request.getRequestURI();
		System.out.println("사용자 요청 uri : " + uri);
		
//		if(uri.equals("/login.do")) {
//			LoginController controller = new LoginController();
//		}else if(uri.equals("/search.do")) {
//			SearchController controller = new SearchController();
//		}......
		HandlerMapping mapping = new HandlerMapping();
		Controller controller = mapping.getController(uri);
		String result = controller.request(request);
		System.out.println(result);
		ViewResolver resolver = new ViewResolver();
		String view = resolver.getView(result);
		response.sendRedirect(view);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
