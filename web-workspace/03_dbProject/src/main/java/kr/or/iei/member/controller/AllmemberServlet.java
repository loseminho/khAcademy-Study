package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	      out.println("<!DOCTYPE html>");
	      out.println("<html><head><title>전체회원조회결과</title></head>");
	      out.println("<style>");
	      out.println("th{");
	      out.println("color: lightgreen;");
	      out.println("font-size : 1.3em;");
	      out.println("}");
	      out.println("</style>");
	      out.println("<body>");
	      if(list.isEmpty()) {
	    	  out.println("<h2>회원 정보를 조회할 수 없습니다</h2>");
	      }else {
	    	  out.println("<h1>전체 회원 정보 </h1>");
	    	  out.println("<hr>");
	    	  out.println("<table border='1'>");
	    	  out.println("<tr>");
	    	  out.println("<th>회원번호</th>");
	    	  out.println("<th>아이디</th>");
	    	  out.println("<th>비밀번호</th>");
	    	  out.println("<th>이름</th>");
	    	  out.println("<th>전화번호</th>");
	    	  out.println("<th>주소</th>");
	    	  out.println("<th>회원등급</th>");
	    	  out.println("<th>가입일</th>");
	    	  out.println("</tr>");
	    	  
	    	  for(Member m : list) {
	    		  out.println("<tr>");
	    		  out.println("<td>"+m.getMemberNo()+"</td>");
	    		  out.println("<td>"+m.getMemberId()+"</td>");
	    		  out.println("<td>"+m.getMemberPw()+"</td>");
	    		  out.println("<td>"+m.getMemberName()+"</td>");
	    		  out.println("<td>"+m.getMemberPhone()+"</td>");
	    		  out.println("<td>"+m.getMemberAddr()+"</td>");
	    		  out.println("<td>"+m.getMemberLevel()+"</td>");
	    		  out.println("<td>"+m.getEnrollDate()+"</td>");
	    		  out.println("</tr>");
	    	  }
	    	  
	    	  out.println("</table>");
	      }
	      out.println("<hr>");
	      out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
