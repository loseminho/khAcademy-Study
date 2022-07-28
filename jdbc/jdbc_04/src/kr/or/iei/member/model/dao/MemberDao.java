package kr.or.iei.member.model.dao;

import common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
    public Member selectOneMember(Connection conn, Member m) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Member member = null;
        String query = "select * from member_tbl where member_id = ? and member_pw= ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, m.getMemberId());
            pstmt.setString(2, m.getMemberPw());
            rset = pstmt.executeQuery();
            if(rset.next()){
                member = new Member();
                member.setMemberId(rset.getString("member_id"));
                member.setMemberPw(rset.getString("member_pw"));
                member.setMemberName(rset.getString("member_name"));
                member.setMemberPhone(rset.getString("member_phone"));
                member.setMemberAddr(rset.getString("member_addr"));
                member.setMemberAge(rset.getInt("member_age"));
                member.setMemberGender(rset.getString("member_gender"));
                member.setEnrollDate(rset.getDate("enroll_date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return member;
    }

    public boolean selectOneMember(Connection conn, String memberId) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        boolean check = true;
        String query = "select member_id from member_tbl where member_id = ?"+
                " union "+
                "select member_id from del_member where member_id = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,memberId);
            pstmt.setString(2,memberId);
            rset = pstmt.executeQuery();
            check = rset.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return check;
    }

    public int insertMember(Connection conn, Member m) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = "insert into member_tbl values(?,?,?,?,?,?,?,sysdate)";

        try {
            pstmt = conn.prepareStatement(query);
            int i = 1;
            pstmt.setString(i++,m.getMemberId());
            pstmt.setString(i++,m.getMemberPw());
            pstmt.setString(i++,m.getMemberName());
            pstmt.setString(i++,m.getMemberAddr());
            pstmt.setString(i++,m.getMemberPhone());
            pstmt.setInt(i++,m.getMemberAge());
            pstmt.setString(i ,m.getMemberGender());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }

    public Member searchNameInfo(Connection conn, String searchName) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Member m = null;

        String query = "select * from member_tbl where member_name = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,searchName);
            rset = pstmt.executeQuery();
            if(rset.next()){
                m = new Member();
                m.setMemberId(rset.getString("member_id"));
                m.setMemberPw(rset.getString("member_pw"));
                m.setMemberName(rset.getString("member_name"));
                m.setMemberPhone(rset.getString("member_phone"));
                m.setMemberAddr(rset.getString("member_addr"));
                m.setMemberAge(rset.getInt("member_age"));
                m.setMemberGender(rset.getString("member_gender"));
                m.setEnrollDate(rset.getDate("enroll_date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rset);
        }
        return m;
    }
}
