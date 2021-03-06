package kr.or.iei.member.model.dao;

import kr.or.iei.member.kr.or.iei.member.model.vo.Member;

import java.sql.*;
import java.util.ArrayList;

public class MemberDao {

    public ArrayList<Member> selectAllMember() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        ArrayList<Member> list = new ArrayList<Member>();
        String query = "select * from member_tbl";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
            pstmt = conn.prepareStatement(query);
            rset = pstmt.executeQuery();

            while (rset.next()){
//                Member m = new Member();
//                m.setMemberId(rset.getString("member_id"));
//                m.setMemberPw(rset.getString("member_pw"));
//                m.setMemberName(rset.getString("member_name"));
//                m.setMemberAddr(rset.getString("member_addr"));
//                m.setMemberPhone(rset.getString("member_phone"));
//                m.setMemberAge(rset.getInt("member_age"));
//                m.setMemberGender(rset.getString("member_gender"));
//                m.setEnrollDate(rset.getDate("enroll_date"));
                String memberId = rset.getString("member_id");
                String memberPw = rset.getString("member_pw");
                String memberName = rset.getString("member_name");
                String memberAddr = rset.getString("member_addr");
                String memberPhone = rset.getString("member_phone");
                int memberAge = rset.getInt("member_age");
                String memberGender = rset.getString("member_gender");
                Date enrollDate = rset.getDate("enroll_date");
                Member m = new Member(memberId, memberPw, memberName, memberAddr, memberPhone, memberAge, memberGender, enrollDate);

                list.add(m);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                rset.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public Member searchIdMember(String memberId) {
        Connection conn = null;
//        Statement stmt = null;
        PreparedStatement pstmt = null; // ???????????? ???????????? ????????? ???????????? ??????.
        ResultSet rset = null;

        Member m = null;
//        String query = "select * from member_tbl where member_id = '"+memberId+"'";
        // PreparedStatement??? ????????? ????????? ?????? ?(????????????)??? ??????
        String query = "select * from member_tbl where member_id = ?";
        // ??????????????? ???????????? ??????(?????? ?????? ????????? ????????? ??????) -> ????????????, ?????????, ???????????? ?????? ??????.
        // ??????????????? ????????? ?????? ?????? ??? ???????????? ????????? ???????????? -> ?????? ????????? ?????? ???????????? ????????? ????????? ????????? ???.
        // ???????????? : SQL ????????? ???????????? ?????? , ?????? SQL ?????? ?????? ?????? ?????? ????????? ?????? ????????? ???
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
//            stmt = conn.createStatement();
            //PreparedStatement ?????? ?????? ??? ????????? ??????????????? ?????? -> ????????? ??????????????? ??????
            pstmt = conn.prepareStatement(query);
            //?????? ?????? ?????? ?????? ??????????????? ????????? ??????
            pstmt.setString(1,memberId);

            rset  = pstmt.executeQuery();
//            rset = stmt.executeQuery(query);
            if(rset.next()){
                m = new Member();
                m.setMemberId(rset.getString("member_id"));
                m.setMemberPw(rset.getString("member_pw"));
                m.setMemberName(rset.getString("member_name"));
                m.setMemberAddr(rset.getString("member_addr"));
                m.setMemberPhone(rset.getString("member_phone"));
                m.setMemberAge(rset.getInt("member_age"));
                m.setMemberGender(rset.getString("member_gender"));
                m.setEnrollDate(rset.getDate("enroll_date"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                rset.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return m;
    }

    public Member searchNameMember(String memberName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Member m = null;
        String query = "select * from member_tbl where member_name = ?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,memberName);

            rset = pstmt.executeQuery();
            if(rset.next()){
                m = new Member();
                m.setMemberId(rset.getString("member_id"));
                m.setMemberPw(rset.getString("member_pw"));
                m.setMemberName(rset.getString("member_name"));
                m.setMemberAddr(rset.getString("member_addr"));
                m.setMemberPhone(rset.getString("member_phone"));
                m.setMemberAge(rset.getInt("member_age"));
                m.setMemberGender(rset.getString("member_gender"));
                m.setEnrollDate(rset.getDate("enroll_date"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                rset.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return m;
    }

    public int insertMember(Member m) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        int result = 0;
        String query = "insert into member_tbl values(?,?,?,?,?,?,?,sysdate)";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");

            pstmt = conn.prepareStatement(query);

            pstmt.setString(1,m.getMemberId());
            pstmt.setString(2, m.getMemberPw());
            pstmt.setString(3, m.getMemberName());
            pstmt.setString(4, m.getMemberAddr());
            pstmt.setString(5, m.getMemberPhone());
            pstmt.setInt(6,m.getMemberAge());
            pstmt.setString(7,m.getMemberGender());
            result = pstmt.executeUpdate();
            if(result>0){
                conn.commit();
            }else{
                conn.rollback();
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public int updateMember(String getId, Member m) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        int result = 0;
        String query = "update member_tbl set member_pw = ?, member_addr = ?, member_phone = ? where member_id = ?";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, m.getMemberPw());
            pstmt.setString(2, m.getMemberAddr());
            pstmt.setString(3, m.getMemberPhone());
            pstmt.setString(4, getId);
            result = pstmt.executeUpdate();
            if(result>0){
                conn.commit();
            }else{
                conn.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public int deleteMember(String getId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        int result = 0;

        String query = "delete from member_tbl where member_id = ?";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,getId);
            result = pstmt.executeUpdate();
            if(result>0){
                conn.commit();
            }else{
                conn.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
