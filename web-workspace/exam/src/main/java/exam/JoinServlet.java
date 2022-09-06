package exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import exam.MemberDao;

import exam.Member;

/**

* Servlet implementation class JoinServlet

*/

@WebServlet("/join.do​")

public class JoinServlet extends HttpServlet {

private static final long serialVersionUID = 1L;

/**

* @see HttpServlet#HttpServlet()

*/

public JoinServlet() {

super();

// TODO Auto-generated constructor stub

}

/**

* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

*/

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");

String memberId = request.getParameter("memberId");
String memberPw = request.getParameter("memberPw");
String memberName = request.getParameter("memberName");
Member member= new Member();

member.setMemberId(memberId);
member.setMemberName(memberName);
member.setMemberPw(memberPw);

MemberDao dao = new MemberDao();

int result = dao.insertMember(member);
String msg = "";
if(result==0) {
msg = "회원가입 실패입니다.";
}else {
msg = "회원가입 성공입니다.";
}

RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/joinResult.jsp");
request.setAttribute("msg", msg);
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