package kr.or.iei.member.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.vo.Member;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		super();
		dao = new MemberDao();
	}

	public Member selectOneMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.selectOneMember(conn, member);
		JDBCTemplate.close(conn);
		return m;
	}

	public Member selectOneMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.selectOneMember(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}


	public int insertMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertMember(conn, member);
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateMember(Member member) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateMember(conn, member);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteMember(conn, memberId);
		JDBCTemplate.close(conn);
		return result;
	}
	
	
}
