package kr.or.iei.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.vo.Board;
import kr.or.iei.member.model.vo.Member;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		super();
		dao = new MemberDao();
	}

	public Member selectOneMember(Member m) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		Member member = dao.selectOneMember(conn,m);
		JDBCTemplate.close(conn);
		return member;
	}

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertMember(conn,m);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public String searchId(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		String memberId = dao.searchId(conn,m);
		JDBCTemplate.close(conn);
		return memberId;
	}

	public int insertBoard(Board b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertBoard(conn,b);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Board> selectAllBoard() {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = dao.selectAllBoard(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public Board selectOneBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		Board b = null;
		int result = dao.updateReadCount(conn,boardNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
			b = dao.selectOneBoard(conn,boardNo);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return b;
	}

	public int getBoardWriter(int boardNo) {
		// TODO Auto-generated method stub
		Connection conn = JDBCTemplate.getConnection();
		int boardWriter = dao.selectBoardWriter(conn,boardNo);
		JDBCTemplate.close(conn);
		return boardWriter;
	}

	public int updateBoard(Board b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateBoard(conn,b);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
}
