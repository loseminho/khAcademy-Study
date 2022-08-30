package kr.or.iei.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendData3Servlet
 */
@WebServlet(name = "SendData3", urlPatterns = { "/sendData3.do" })
public class SendData3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendData3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sendData3 호출");
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		String data1 = request.getParameter("str");
		int data2 = Integer.parseInt(request.getParameter("num"));
		String data3 = request.getParameter("gender");
		//동일한 이름으로 여러개의 데이터가 넘어오는 경우 배열로 처리
		String[] data4 = request.getParameterValues("hobby");
		int data5 = Integer.parseInt(request.getParameter("age"));
		String data6 = request.getParameter("hiddenData");
		String data7 = request.getParameter("input1");
		String data8 = request.getParameter("input2");
		String data9 = request.getParameter("test3");
		String data10 = request.getParameter("input3");
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		for(int i=0; i<data4.length;i++) {
			System.out.println(data4[i]);			
		}
		System.out.println(data5);
		System.out.println(data6);
		System.out.println(data7);
		System.out.println(data8);
		System.out.println(data9);
		System.out.println(data10);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
