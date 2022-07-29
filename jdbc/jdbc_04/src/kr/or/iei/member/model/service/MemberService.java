package kr.or.iei.member.model.service;

import common.JDBCTemplate;
import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.vo.Member;

import java.sql.Connection;

public class MemberService {
    private MemberDao dao;

    public MemberService() {
        super();
        dao = new MemberDao();
    }

    public Member selectOneMember(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        Member member = dao.selectOneMember(conn,m);
        JDBCTemplate.close(conn);
        return member;
    }

    public boolean selectOneMember(String memberId) {
        Connection conn = JDBCTemplate.getConnection();
        boolean check = dao.selectOneMember(conn, memberId);
        JDBCTemplate.close(conn);
        return check;
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

    public Member searchNameInfo(String searchName) {
        Connection conn = JDBCTemplate.getConnection();
        Member m = dao.searchNameInfo(conn, searchName);
        return m;
    }

    public int myInfoChange(Member m) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.myInfoChange(conn, m);
        if(result > 0){
            JDBCTemplate.commit(conn);
        }else{
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }

    public int deleteMember(Member login) {
        Connection conn = JDBCTemplate.getConnection();
        int result = dao.delMember(conn, login.getMemberId());
        if(result > 0 ){
            result = 0;
            result = dao.insertDelMember(conn,login);
            if (result > 0) {
                JDBCTemplate.commit(conn);
            }else{
                JDBCTemplate.rollback(conn);
            }
        }else{
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result;
    }
}
