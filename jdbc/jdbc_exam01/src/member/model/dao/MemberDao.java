package member.model.dao;

import common.JDBCTemplate;
import member.model.vo.Board;
import member.model.vo.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class MemberDao {

    public Member login(Connection conn, Member m) {
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    Member member = null;
    String query = "select * from exam_member where member_id = ? and member_pw = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,m.getMemberId());
            pstmt.setString(2,m.getMemberPw());
            rset = pstmt.executeQuery();
            if(rset.next()){
                member = new Member();
                member.setMemberNo(rset.getInt("member_no"));
                member.setMemberId(rset.getString("member_id"));
                member.setMemberPw(rset.getString("member_pw"));
                member.setMemberName(rset.getString("member_name"));
                member.setMemberPhone(rset.getString("member_phone"));
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
        String query = "select * from exam_member where member_id = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,memberId);
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

    public int insertOneMember(Connection conn, Member m) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = "insert into exam_member values(seq_exam_member.nextval,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(query);
            int i = 1;
            pstmt.setString(i++,m.getMemberId());
            pstmt.setString(i++,m.getMemberPw());
            pstmt.setString(i++,m.getMemberName());
            pstmt.setString(i++,m.getMemberPhone());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }

        return result;
    }

    public Member searchMemberId(Connection conn, Member m) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        Member member = null;
        String query = "select * from exam_member where member_id =? and member_phone = ?";

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,m.getMemberId());
            pstmt.setString(2,m.getMemberPhone());
            rset = pstmt.executeQuery();
            if(rset.next()){
                member = new Member();
                member.setMemberId(rset.getString("member_id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        return member;
    }

    public int insertBoard(Connection conn, Board b, int loginNo) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = "insert into exam_board values(seq_exam_board.nextval,?,?,?,0,sysdate)";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1,b.getBoardTitle());
            pstmt.setString(2,b.getBoardContent());
            pstmt.setInt(3,loginNo);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
        }

        return result;
    }


    public ArrayList<Board> showAllBoard(Connection conn) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        ArrayList<Board> list = new ArrayList<>();
        String query = "select board_no, board_title, board_content, member_name, read_count,write_date from exam_board join exam_member on (board_writer = member_no)";
        try {
            pstmt = conn.prepareStatement(query);
            rset = pstmt.executeQuery();
            while(rset.next()){
                int boardNo = rset.getInt("board_no");
                String boardTitle = rset.getString("board_title");
                String boardContent = rset.getString("board_content");
                String memberName = rset.getString("member_name");
                int readCount = rset.getInt("read_count");
                Date writeDate = rset.getDate("write_date");
                Board b = new Board(boardNo,boardTitle,boardContent,memberName,readCount,writeDate);
                list.add(b);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rset);
        }
        return list;
    }

    public boolean showBoardDetailCheck(Connection conn, int sel) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        boolean check = true;
        String query = "select * from exam_board where board_no = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,sel);
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

    public Board showBoardDetail(Connection conn, int sel) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Board b = null;

        String query = "select board_no, board_title, board_content, member_name, read_count,write_date from exam_board join exam_member on (board_writer = member_no) where board_no = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,sel);
            rset = pstmt.executeQuery();
            if(rset.next()){
                b = new Board();
                b.setBoardNo(rset.getInt("board_no"));
                b.setBoardTitle(rset.getString("board_title"));
                b.setBoardContent(rset.getString("board_content"));
                b.setMemberName(rset.getString("member_name"));
                b.setReadConut(rset.getInt("read_count"));
                b.setWriteDate(rset.getDate("write_date"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rset);
        }
        return b;
    }
}


