package member.model.service;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Board;
import member.model.vo.Member;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;

public class MemberService {
    private MemberDao dao;

    public MemberService() {
        super();
        dao = new MemberDao();
    }

    public Member login(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        Member member = dao.login(conn, m);
        JDBCTemplate.close(conn);
        return member;
    }

    public boolean selectOneMember(String memberId) {
        Connection conn = JDBCTemplate.getConnection();
        boolean check = dao.selectOneMember(conn, memberId);
        return false;
    }

    public int insertMember(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.insertOneMember(conn,m);
        if(result>0){
            JDBCTemplate.commit(conn);
        }else{
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }


    public Member searchMemberId(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        Member member = dao.searchMemberId(conn, m);
        JDBCTemplate.close(conn);
        return member;
    }

    public int insertBoard(Board b, Member login) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.insertBoard(conn, b, login.getMemberNo());
        if(result>0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    public ArrayList<Board> showAllBoard(Member login) {
        Connection conn = JDBCTemplate.getConnection();

        ArrayList<Board> list = dao.showAllBoard(conn);
        JDBCTemplate.close(conn);
        return list;
    }


    public boolean showBoardDetailCheck(int sel) {
        Connection conn = JDBCTemplate.getConnection();
        boolean check = dao.showBoardDetailCheck(conn, sel);
        JDBCTemplate.close(conn);
        return check;
    }

    public Board showBoardDetail(int sel) {
        Connection conn = JDBCTemplate.getConnection();
        Board b = dao.showBoardDetail(conn,sel);
        return null;
    }
}
