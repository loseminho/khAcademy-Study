package kr.or.board.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.board.model.dao.BoardDao;
import kr.or.board.model.vo.Board;

@Service
public class BoardService {
	@Autowired
	private BoardDao dao;

	public ArrayList<Board> selectBoardList(int reqPage) {
		//한 페이지당 보여줄 게시물 수
		int numPerPage = 5;
		//reqPage 1 -> 1~5번
		//reqPage 2 -> 6~10번
		int end = reqPage * numPerPage;
		int start = end-numPerPage + 1;
		//계산한 start, end 이용하여 게시물 목록 조회
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start",start);
		map.put("end",end);
		ArrayList<Board> list = dao.selectBoardList(map);
		
		//pageNavi 시작
		//전체 페이지 수 계산 필요 -> 전체 게시물 수 조회
		int totalCount = dao.selectBoardCount();
		//전체 페이지 수 계산
		int totalPage = 0;
		if(totalPage%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage+1;
		}
		
		return null;
	}
}
