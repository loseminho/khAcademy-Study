package kr.or.iei.member.model.dao;

import kr.or.iei.member.model.vo.Memo;

import java.sql.*;

public class Dao {
    public int update(Memo m) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int result = 0;

        String query = "update memo set name = ? where no = ?";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, m.getName());
            pstmt.setInt(2,m.getNo());
            result = pstmt.executeUpdate();
            if (result>0){
                conn.commit();
            }else{
                conn.rollback();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
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
