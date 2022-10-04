package kr.or.board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardRowmapper;
import kr.or.board.model.vo.FileVO;
import kr.or.member.model.vo.MemberRowmapper;

@Repository
public class BoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public BoardDao() {
		super();
		System.out.println("board dao 생성");
	}
	public ArrayList<Board> selectAllBoard() {
		String query="SELECT * FROM BOARD";
		List list = jdbcTemplate.query(query, new BoardRowmapper());
		return (ArrayList<Board>)list;
	}
	public int insertBoard(Board b) {
		String query = "insert into board values(member_seq.nextval,?,?,?,to_char(sysdate,'yyyy-mm-dd'))";
		Object[] params = {b.getBoardTitle(),b.getBoardWriter(),b.getBoardContent()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}
	public int selectBoardNo() {
		String query = "select max(board_no) from board";
		int boardNo = jdbcTemplate.queryForObject(query, int.class);
		return boardNo;
	}
	public Board boardView(int boardNo) {
		String query = "select * from board where board_no=? ";
		Object[] params = {boardNo};
		List list = jdbcTemplate.query(query,params,new BoardRowmapper());
		if(list.isEmpty()) {
			return null;
		}else {
			Board b = (Board)list.get(0);
			return b;
		}
	}
	public int insertFile(FileVO fileVO) {
		String query = "insert into file_tbl values(file_seq.nextval,?,?,?)";
		Object[] params = {fileVO.getBoardNo(),fileVO.getFilename(),fileVO.getFilepath()};
		int result = jdbcTemplate.update(query,params);
		return result;
	}
	
}
