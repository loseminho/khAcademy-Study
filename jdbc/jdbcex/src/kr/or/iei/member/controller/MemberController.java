package kr.or.iei.member.controller;

import java.util.ArrayList;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Board;
import kr.or.iei.member.model.vo.Member;
import kr.or.iei.member.view.MemberView;

public class MemberController {
	private MemberView view;
	private MemberService service;
	private Member login;
	
	public MemberController() {
		super();
		view = new MemberView();
		service = new MemberService();
	}

	public void main() {
		while(true) {
			if(login == null) {
				int sel = view.showMenu();
				switch(sel) {
				case 1:
					login();
					break;
				case 2:
					insertMember();
					break;
				case 3:
					searchId();
					break;
				case 0:
					break;
				}
			}else {
				int sel = view.loginMenu();
				switch(sel) {
				case 1:
					selectAllboard();
					break;
				case 2:
					selectOneBoard();
					break;
				case 3:
					insertBoard();
					break;
				case 4:
					updateBoard();
					break;
				case 5:
					
					break;
				case 6:
					
					break;
				case 7:
					
					break;
				case 8:
					
					break;
				case 0:
					login = null;
					break;
				}
			}
		}
	}
	public void updateBoard() {
		int boardNo = view.getBoardNo();
		int boardWriter = service.getBoardWriter(boardNo);
		if(boardWriter == login.getMemberNo()) {
			Board b = view.updateBoard();
			b.setBoardNo(boardNo);
			int result = service.updateBoard(b);
			if(result>0) {
				view.printMsg("게시글 수정 성공!");
			}else {
				view.printMsg("게시글 수정 실패");
			}
		}else {
			view.printMsg("작성자만 수정이 가능합니다.");
		}
		
	}

	public void selectOneBoard() {
		int boardNo = view.getBoardNo();
		Board b = service.selectOneBoard(boardNo);
		if(b != null) {			
			view.printOneBoard(b);
		}else {
			view.printMsg("조회에 실패했습니다.");
		}
		
	}
	public void selectAllboard() {
		// TODO Auto-generated method stub
		ArrayList<Board> list = service.selectAllBoard();
		view.printAllBoard(list);		
		
	}

	public void insertBoard() {
		// TODO Auto-generated method stub
		Board b = view.insertBoard();
		b.setBoardWriter(login.getMemberNo());
		int result = service.insertBoard(b);
		if(result>0) {
			view.printMsg("게시글 등록 성공!!");
		}else {
			view.printMsg("게시글 등록 실패");
		}
	}

	public void login() {
		Member m = view.getLoginInfo();
		login = service.selectOneMember(m);
		if(login == null) {
			view.printMsg("로그인 실패");
		}else {			
			view.printMsg("로그인성공");
		}
	}
	public void insertMember() {
		Member m = view.insertMember();
		int result = service.insertMember(m);
		if(result>0) {
			view.printMsg("회원가입 성공");
		}else {
			view.printMsg("회원가입 실패");
		}
	}
	public void searchId() {
		Member m = view.searchIdInfo();
		String memberId = service.searchId(m);
		if(memberId == null) {
			view.printMsg("일치하는 정보가 없습니다");
		}else {
			view.printMsg("아이디는 ["+memberId+"] 입니다.");
		}
	}
}
