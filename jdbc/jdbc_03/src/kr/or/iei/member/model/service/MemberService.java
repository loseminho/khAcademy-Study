package kr.or.iei.member.model.service;

import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.vo.Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

public class MemberService {
    private MemberDao dao;

    public MemberService() {
        super();
        dao = new MemberDao();
    }

    public Member selectOneMember(Member m) {
        Connection conn = null;
        Member member = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
            member = dao.selectOneMember(conn, m);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return member;
    }

    public boolean selectOneMember(String memberId) {
        Connection conn = null;
        boolean check = false;
        boolean check2 = false;
        boolean check3 = false;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
            check = dao.selectOneMember(conn, memberId);
            check2 = dao.selectoneDelMember(conn, memberId);
            //true 일때는 이미 테이블에 값이 있는 경우,
            //false 인 경우엔 값이 없을 때, 따라서 중복이 아니려면 두개 다 값이 없는 둘 다 false 상황이여야함....
            //이 외의 값은 전부 true를 주어서 중복임을 처리

            if(check == false && check2 == false){
                check3 = false;
            }else{
                check3 = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return check3;
    }

    public int deleteMember(Member login) {
        // 쿼리문 두개 (delete, insert)를 수행하고
        // 두 수행 결과가 모두 성공이면 commit, 아니면 rollback
        // 최종 결과를 controller에 리턴
        //-> Connection을 서비스에서 생성하고 매개변수로 전달
        Connection conn = null;
        int result = 0;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
            System.out.println(login.getMemberId());
            result = dao.deleteMember(conn, login.getMemberId());
            if(result > 0){
                result = dao.insertDelMember(conn, login);
                if(result > 0){
                    conn.commit();
                }else {
                    conn.rollback();
                }
            }else{
                conn.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
