package kr.or.iei.member.dao;
import kr.or.iei.member.vo.Member;

import java.sql.*;
import java.util.ArrayList;

public class MemberDao {
    public ArrayList<Member> selectAllMember() {
        //0. 자원 반환 할 객체 미리 선언
        Connection conn = null;     //2번에서 사용할 객체
        Statement stmt = null;      //3번에서 사용할 객체
        ResultSet rset = null;      //SELECT 하는 경우에만 선언

        //결과를 반환할 변수
        ArrayList<Member> list = new ArrayList<Member>();
        //사용할 쿼리문 변수(문자열 작성 시 ; 반드시 제거)
        String query = "select * from member_tbl";


        try {
            //1. 드라이버 등록(연결 시 사용할 클래스 등록(ojdbc6이 제공))
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //2. 커넥션 생성(1에서 등록한 드라이버 이용)
            //접속에 문제가 없으면 Connection객체 리턴, 실패하면 null
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc", "1234");

            //3. 쿼리문을 실행하고 결과를 받을 객체 생성(2번에서 생성한 커넥션으로)
            stmt = conn.createStatement();


            //4. 쿼리문 실행(stmt.executeQuery(query);
            //5. 쿼리문 실행 결과를 저장.(rset)
            rset = stmt.executeQuery(query);//SELECT를 실행하는 메소드 (executeQuery)

            //  5-1. 실행 결과를 사용하기 위한 형태로 편집
            while (rset.next()) {
                String memberId = rset.getString("member_id");
                String memberPw = rset.getString("member_pw");
                String memberName = rset.getString("member_name");
                String memberAddr = rset.getString("member_addr");
                String memberPhone = rset.getString("member_phone");
                int memberAge = rset.getInt("member_age");
                char memberGender = rset.getString("member_gender").charAt(0);
                Date enrollDate = rset.getDate("enroll_date");
                Member m = new Member(memberId, memberPw, memberName, memberAddr, memberPhone, memberAge, memberGender, enrollDate);
                list.add(m);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert rset != null;
                rset.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public Member searchIdMember(String memberId) {
        //0. 자원 반환 할 객체 선언
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        Member m = null;
        String query = "select * from member_tbl where member_id ='" + memberId + "'";
        try {
            //1. 드라이버 등록
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //2. Connection 객체 생성
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc", "1234");
            //3. Statement 객체 생성
            stmt = conn.createStatement();
            //4,5. 쿼리문 수행하고 결과를 저장
            rset = stmt.executeQuery(query);

            if (rset.next()) {
                m = new Member();
                m.setMemberId(rset.getString("member_id"));
                m.setMemberPw(rset.getString("member_pw"));
                m.setMemberName(rset.getString("member_name"));
                m.setMemberAddr(rset.getString("member_addr"));
                m.setMemberPhone(rset.getString("member_phone"));
                m.setMemberAge(rset.getInt("member_age"));
                m.setMemberGender(rset.getString("member_gender").charAt(0));
                m.setEnrollDate(rset.getDate("enroll_date"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert rset != null;
                rset.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return m;
    }

    public ArrayList<Member> searchNameMember(String memberName) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        ArrayList<Member> list = new ArrayList<Member>();
        String query = "select * from member_tbl where member_name like '%" + memberName + "%'";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc", "1234");
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);

            while (rset.next()) {
                Member m = new Member();
                m.setMemberId(rset.getString(1));
                m.setMemberPw(rset.getString(2));
                m.setMemberName(rset.getString("member_name"));
                m.setMemberAddr(rset.getString("member_addr"));
                m.setMemberPhone(rset.getString(5));
                m.setMemberAge(rset.getInt(6));
                m.setMemberGender(rset.getString(7).charAt(0));
                m.setEnrollDate(rset.getDate(8));
                list.add(m);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rset.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public int insertMember(Member m) {
        //0. 반환할 객체 선언
        Connection conn = null;
        Statement stmt = null;

        int result = 0;
        String query = "insert into member_tbl values(" +
                "'" + m.getMemberId() + "'," +
                "'" + m.getMemberPw() + "'," +
                "'" + m.getMemberName() + "'," +
                "'" + m.getMemberAddr() + "'," +
                "'" + m.getMemberPhone() + "'," +
                +m.getMemberAge() + "," +
                "'" + m.getMemberGender() + "'," +
                "sysdate)";
        System.out.println(query);//지울 예정

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc", "1234");
            stmt = conn.createStatement();
            result = stmt.executeUpdate(query);//insert,update,delete의 경우는 업데이트 사용
            if (result > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public int updateMember(String getId, Member m) {
        Connection conn = null;
        Statement stmt = null;

        int result = 0;
        String query = "update member_tbl set member_pw = '" + m.getMemberPw() +
                "', member_addr = '" + m.getMemberAddr() +
                "', member_phone = '" + m.getMemberPhone() +
                "' where member_id = '" + getId + "'";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
            stmt = conn.createStatement();
            result = stmt.executeUpdate(query);
            if(result >0 ){
                conn.commit();
            }else {
                conn.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int deleteMember(String getId) {
        Connection conn = null;
        Statement stmt = null;
        int result = 0;

        String query = "delete from member_tbl where member_id = '"+getId+"'";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
            stmt = conn.createStatement();
            result = stmt.executeUpdate(query);
            if(result > 0){
                conn.commit();
            }else {
                conn.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}












