package kr.or.iei.free.notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.free.notice.model.vo.FreeNotice;
import kr.or.iei.free.notice.model.vo.FreeNoticeComment;
import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.notice.model.vo.NoticeComment;

public class FreeNoticeDao {

	public ArrayList<FreeNotice> selectNoticeList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<FreeNotice> flist = new ArrayList<FreeNotice>();
		String query = "select * from(select rownum as rnum, n.* from (SELECT * FROM FREE_NOTICE ORDER BY FREE_NOTICE_NO DESC)n) where rnum between ? and ?";
	
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()){
				FreeNotice fn = new FreeNotice();
				fn.setFreeNoticeNo(rset.getInt("free_notice_no"));
				fn.setFreeNoticeTitle(rset.getString("free_notice_title"));
				fn.setFreeNoticeWriter(rset.getString("free_notice_writer"));
				fn.setFreeNoticeContent(rset.getString("free_notice_content"));
				fn.setFreeReadCount(rset.getInt("free_read_count"));
				fn.setFreeRegDate(rset.getString("free_reg_date"));
				fn.setFreeFilename(rset.getString("free_filename"));
				fn.setFreeFilepath(rset.getString("free_filepath"));
				flist.add(fn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return flist;
	}

	public int selectNoticeCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from free_notice";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				//일반적인 방법으로는 cnt의 값을 읽어올 수 없기 때문에 as cnt로 별칭을 주어 읽어올 수 있도록 만듬.
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}

	public FreeNotice selectOneNotice(Connection conn, int freeNoticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		FreeNotice fn = null;
		String query = "select * from free_notice where free_notice_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, freeNoticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				fn = new FreeNotice();
				fn.setFreeFilename(rset.getString("free_filename"));
				fn.setFreeFilepath(rset.getString("free_filepath"));
				fn.setFreeNoticeContent(rset.getString("free_notice_content"));
				fn.setFreeNoticeNo(rset.getInt("free_notice_no"));
				fn.setFreeNoticeTitle(rset.getString("free_notice_title"));
				fn.setFreeNoticeWriter(rset.getString("free_notice_writer"));
				fn.setFreeReadCount(rset.getInt("free_read_count"));
				fn.setFreeRegDate(rset.getString("free_reg_date"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return fn;
	}
	
	
	public int updateReadCount(Connection conn, int freeNoticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update free_notice set free_read_count = free_read_count+1 where free_notice_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,freeNoticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<FreeNoticeComment> selectNoticeCommentList(Connection conn, int freeNoticeNo) {
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      ArrayList<FreeNoticeComment> flist = new ArrayList<FreeNoticeComment>();
      String query = "select * from free_notice_comment where notice_ref=? and nc_ref is null order by 1";
      
      try {
		pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, freeNoticeNo);
        rset=pstmt.executeQuery();
        while(rset.next()) {
            FreeNoticeComment fnc = new FreeNoticeComment();
            fnc.setNcContent(rset.getString("nc_content"));
            fnc.setNcDate(rset.getString("nc_date"));
            fnc.setNcNo(rset.getInt("nc_no"));
            fnc.setNcRef(rset.getInt("nc_ref"));
            fnc.setNcWriter(rset.getString("nc_writer"));
            fnc.setNoticeRef(rset.getInt("notice_ref"));
            flist.add(fnc);
         }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
        JDBCTemplate.close(rset);
        JDBCTemplate.close(pstmt);
     }
     return flist;
	}

	public ArrayList<FreeNoticeComment> selectNoticeReCommentList(Connection conn, int freeNoticeNo) {
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      ArrayList<FreeNoticeComment> flist = new ArrayList<FreeNoticeComment>();
	      String query = "select * from free_notice_comment where notice_ref=? and nc_ref is not null order by 1";
	      
	      try {
			pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, freeNoticeNo);
	        rset=pstmt.executeQuery();
	        while(rset.next()) {
	            FreeNoticeComment fnc = new FreeNoticeComment();
	            fnc.setNcContent(rset.getString("nc_content"));
	            fnc.setNcDate(rset.getString("nc_date"));
	            fnc.setNcNo(rset.getInt("nc_no"));
	            fnc.setNcRef(rset.getInt("nc_ref"));
	            fnc.setNcWriter(rset.getString("nc_writer"));
	            fnc.setNoticeRef(rset.getInt("notice_ref"));
	            flist.add(fnc);
	         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
	        JDBCTemplate.close(rset);
	        JDBCTemplate.close(pstmt);
	     }
	     return flist;
	}

	public int deleteNoticeComment(Connection conn, int ncNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from free_notice_comment where nc_no=?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, ncNo);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertNoticeComment(Connection conn, FreeNoticeComment fnc) {
	      PreparedStatement pstmt = null;
	      int result = 0;
	      String query = "insert into free_notice_comment values(nc_seq.nextval,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?)";
	      try {
	         pstmt = conn.prepareStatement(query);
	         pstmt.setString(1, fnc.getNcWriter());
	         pstmt.setString(2, fnc.getNcContent());
	         pstmt.setInt(3, fnc.getNoticeRef());
	         pstmt.setString(4, (fnc.getNcRef()==0)?null:String.valueOf(fnc.getNcRef()));
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         JDBCTemplate.close(pstmt);
	      }
	      return result;
	}

	public int updateNoticeComment(Connection conn, FreeNoticeComment fnc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update free_notice_comment set nc_content=? where nc_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fnc.getNcContent());
			pstmt.setInt(2, fnc.getNcNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from free_notice where free_notice_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateNotice(Connection conn, FreeNotice fn) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update free_notice set free_notice_title=?, free_notice_content=?, free_filename=?, free_filepath=? where free_notice_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fn.getFreeNoticeTitle());
			pstmt.setString(2, fn.getFreeNoticeContent());
			pstmt.setString(3, fn.getFreeFilename());
			pstmt.setString(4, fn.getFreeFilepath());
			pstmt.setInt(5, fn.getFreeNoticeNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public int insertNotice(Connection conn, FreeNotice fn) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into free_notice values(free_notice_seq.nextval,?,?,?,0,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fn.getFreeNoticeTitle());
			pstmt.setString(2, fn.getFreeNoticeWriter());
			pstmt.setString(3, fn.getFreeNoticeContent());
			pstmt.setString(4, fn.getFreeFilename());
			pstmt.setString(5, fn.getFreeFilepath());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
}
