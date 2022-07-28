package common;

import java.sql.*;

public class JDBCTemplate {
    //Connection 객체를 생성해서 리턴하는 메소드
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jdbc","1234");
            conn.setAutoCommit(false);//자동으로 commit 하는 기능을 비활성화

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    public static void commit(Connection conn){
        try {
            //만약 널이 아니고 닫혀있지 않으면
            if(conn != null && !conn.isClosed()){
                conn.commit();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  static void rollback(Connection conn){
        try {
            if(conn != null && !conn.isClosed()){
                conn.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection conn){
        try {
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Statement pstmt){
        try {
            if(pstmt != null && !pstmt.isClosed()){
                pstmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset){
        try {
            if(rset != null && !rset.isClosed()){
                rset.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
