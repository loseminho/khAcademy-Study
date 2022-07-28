package kr.or.iei.member.model.dao;

import kr.or.iei.member.model.vo.Member;

import java.sql.*;

public class MemberDao {
    public Member selectOneMember(Connection conn , Member m) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Member member = null;

        String query = "select * from member_tbl where member_id = ? and member_pw = ?";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, m.getMemberId());
            pstmt.setString(2,m.getMemberPw());
            rset = pstmt.executeQuery();

            if(rset.next()){
                member = new Member();
                member.setMemberId(rset.getString("member_id"));
                member.setMemberPw(rset.getString("member_pw"));
                member.setMemberName(rset.getString("member_name"));
                member.setMemberAddr(rset.getString("member_addr"));
                member.setMemberPhone(rset.getString("member_phone"));
                member.setMemberAge(rset.getInt("member_age"));
                member.setMemberGender(rset.getString("member_gender"));
                member.setEnrollDate(rset.getDate("enroll_date"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                rset.close();
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return member;
    }

    public int deleteMember(Connection conn,String memberId) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = "delete from member_tbl where member_id = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, memberId);
            result = pstmt.executeUpdate();
        } catch ( SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public int insertDelMember(Connection conn, Member login) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = "insert into del_member values(?,?,?,?,?,sysdate)";


        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, login.getMemberId());
            pstmt.setString(2, login.getMemberName());
            pstmt.setString(3, login.getMemberPhone());
            pstmt.setInt(4,login.getMemberAge());
            pstmt.setString(5, login.getMemberGender());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public boolean selectOneMember(Connection conn, String memberId) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        boolean check = false;

        String query = "select * from member_tbl where member_id = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,memberId);
            rset = pstmt.executeQuery();

            check = rset.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pstmt.close();
                rset.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return check;
    }

    public boolean selectoneDelMember(Connection conn, String memberId) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        boolean check = false;

        String query = "select * from del_member where member_id = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,memberId);
            rset = pstmt.executeQuery();

            check = rset.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pstmt.close();
                rset.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return check;
    }
}
