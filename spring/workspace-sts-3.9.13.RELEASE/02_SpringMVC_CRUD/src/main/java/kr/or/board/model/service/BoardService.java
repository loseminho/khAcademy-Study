package kr.or.board.model.service;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import kr.or.board.model.dao.BoardDao;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.BoardViewData;
import kr.or.board.model.vo.FileVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	public BoardService() {
		super();
		System.out.println("board 서비스 생성");
	}
	public ArrayList<Board> selectAllBoard() {
		ArrayList<Board> list = dao.selectAllBoard();
		return list;
	}
	public int insertBoard(Board b) {
		int result = dao.insertBoard(b);
		return result;
	}
	public int insertBoard2(Board b, ArrayList<FileVO> list) {
		int result = dao.insertBoard(b);
		//insert가 성공한 경우 파일을 insert
		//이때, 파일이 없으면 file table에 insert 안함.
		if(result>0) {
			int boardNo = 0;
			if(!list.isEmpty()) {
				//가장 최근에 들어간 boardNo를 조회
				boardNo = dao.selectBoardNo();
				for(FileVO fileVO : list) {
					//board테이블의 가장 insert한 최근 boardNo를 참조
					fileVO.setBoardNo(boardNo);
					result += dao.insertFile(fileVO);
				}
			}
		}
		return result;
	}
	public Board selectOneBoard(int boardNo) {
		Board b = dao.boardView(boardNo);
		ArrayList<FileVO> fileList = dao.selectFileList(boardNo);
		b.setFileList(fileList);
		return b;
	}
	public FileVO boardFilePath(int fileNo) {
		FileVO fv = dao.boardFilePath(fileNo); 
		return fv;
	}
	public int boardUpdate(Board b, int[] fileNoList) {
		//1. board 테이블 수정(제목, 내용)
		int result = dao.updateBoard(b);
		if(result >0) {
			//2. 새 첨부 파일이 있으면 insert
			for(FileVO fv : b.getFileList()) {
				fv.setBoardNo(b.getBoardNo());
				result += dao.insertFile(fv);
			}
			//3. 삭제한 파일이 있으면 delete
			if(fileNoList != null) {
				for(int fileNo : fileNoList) {
					result += dao.deleteFile(fileNo);
				}				
			}
		}
		
		return result;
	}
	public ArrayList<FileVO> boardDelete(int boardNo) {
		ArrayList<FileVO> fileList = dao.selectFileList(boardNo);
		//만약 fileTBL 조건에 종속 조건을 달지 않은 경우에는,
		//fileTBL에서 해당하는 파일을  삭제 하거나,
		//board테이블에서 삭제 해야 함
		int result  = dao.deleteBoard(boardNo);
		if(result>0) {
			return fileList;
		}else {
			return null;
		}
	}

}