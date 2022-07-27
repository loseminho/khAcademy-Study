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
        PreparedStatement pstmt = null; // 쿼리문을 실행하고 결과를 가져오는 객체.
        ResultSet rset = null;

        Member m = null;
//        String query = "select * from member_tbl where member_id = '"+memberId+"'";
        // PreparedStatement는 변수로 대체할 값을 ?(위치홀더)로 대체
        String query = "select * from member_tbl where member_id = ?";
        // 위치홀더는 리터럴을 대체(값에 대한 부분만 처리가 가능) -> 테이블명, 컬럼명, 조건절은 사용 불가.
        // 위치홀더를 값으로 대체 했을 때 쿼리문이 완성이 되어야함 -> 위치 홀더를 뺀다 하더라도 문법상 문제가 없어야 함.
        // 위치홀더 : SQL 구문에 나타내는 토큰 , 실제 SQL 문이 실행 되기 전에 값으로 대체 되어야 함
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
//            stmt = conn.createStatement();
            //PreparedStatement 객체 생성 시 쿼리를 매개변수로 전달 -> 쿼리문 문법검사를 진행
            pstmt = conn.prepareStatement(query);
            //실제 쿼리 수행 전에 위치홀더를 값으로 대체
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
