package kr.or.iei.member.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.vo.Member;

public class MemberService {
   private MemberDao dao;
   
   public MemberService() {
      super();
      dao = new MemberDao();
   }

   public int insertMember(Member m) {
      Connection conn =JDBCTemplate.getConnection();
      int result = dao.insertMember(conn,m);
      if(result>0) {
         JDBCTemplate.commit(conn);
      }else {
         JDBCTemplate.rollback(conn);
      }
      JDBCTemplate.close(conn);
      return result;
   }

public ArrayList<Member> selectAllMember() {
	Connection conn = JDBCTemplate.getConnection();
	ArrayList<Member> list = dao.selectAllMember(conn);
	JDBCTemplate.close(conn);
	return list;
}

public Member searchMemberId(String memberId) {
	Connection conn = JDBCTemplate.getConnection();
	Member m = dao.searchMemberId(conn, memberId);
	JDBCTemplate.close(conn);
	return m;
}

}