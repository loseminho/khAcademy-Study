package kr.or.iei.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class AjaxTest5Servlet
 */
@WebServlet(name = "ajaxTest5", urlPatterns = { "/ajaxTest5.do" })
public class AjaxTest5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selectAllMember();
		
		JSONArray memberList = new JSONArray();
		// = 리스트가 비어있지 않으면
		if(!list.isEmpty()) {
			for(Member m : list) {
				JSONObject obj = new JSONObject();
				obj.put("memberNo", m.getMemberNo());
				obj.put("memberId", m.getMemberId());
				obj.put("memberName", m.getMemberName());
				obj.put("memberPhone", m.getMemberPhone());
				obj.put("memberAddr", m.getMemberAddr());
				obj.put("memberLevel", m.getMemberLevel());
				obj.put("enrollDate", m.getEnrollDate());
				memberList.add(obj);
			}
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(memberList);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
