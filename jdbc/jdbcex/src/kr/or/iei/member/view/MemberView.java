package kr.or.iei.member.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.or.iei.member.model.vo.Board;
import kr.or.iei.member.model.vo.Member;

public class MemberView {
	private Scanner sc;

	public MemberView() {
		super();
		sc = new Scanner(System.in);
	}
	public int showMenu() {
		System.out.println("----- KH커뮤니티 -----");
		System.out.println("1. 로그인하기");
		System.out.println("2. 회원가입");
		System.out.println("3. 아이디찾기");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 > ");		
		return sc.nextInt();
	}
	public Member getLoginInfo() {
		// TODO Auto-generated method stub
		Member m = new Member();
		System.out.print("ID 입력 : ");
		m.setMemberId(sc.next());
		System.out.print("PW 입력 : ");
		m.setMemberPw(sc.next());
		return m;
		
	}
	public Member insertMember() {
		// TODO Auto-generated method stub
		Member m = new Member();
		System.out.print("ID 입력 : ");
		m.setMemberId(sc.next());
		System.out.print("PW 입력 : ");
		m.setMemberPw(sc.next());
		System.out.print("이름 입력 : ");
		m.setMemberName(sc.next());
		System.out.print("전화번호 입력(ex.01011112222) : ");
		m.setMemberPhone(sc.next());
		return m;
	}
	public Member searchIdInfo() {
		// TODO Auto-generated method stub
		Member m = new Member();
		System.out.print("이름 입력 : ");
		m.setMemberName(sc.next());
		System.out.print("전화번호 입력 : ");
		m.setMemberPhone(sc.next());
		return m;
	}
	public void printMsg(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}
	public int loginMenu() {
		System.out.println("----- KH커뮤니티 -----");
		System.out.println("1. 게시물 목록 보기");
		System.out.println("2. 게시물 상세 보기");
		System.out.println("3. 게시물 등록");
		System.out.println("4. 게시물 수정");
		System.out.println("5. 게시물 삭제");
		System.out.println("6. 내정보 보기");
		System.out.println("7. 내 정보 변경");
		System.out.println("8. 회원 탈퇴");
		System.out.println("0. 로그아웃");
		System.out.print("선택 > ");		
		return sc.nextInt();
	}
	public Board insertBoard() {
		Board b = new Board();
		System.out.print("제목 입력 : ");
		sc.nextLine();
		b.setBoardTitle(sc.nextLine());
		System.out.print("내용 입력 : ");
		b.setBoardContent(sc.nextLine());
		return b;
	}
	public int getBoardNo() {
		System.out.print("게시물 번호 입력 : ");
		int boardNo = sc.nextInt();
		return boardNo;
	}
	public void printAllBoard(ArrayList<Board> list) {
		// TODO Auto-generated method stub
		System.out.println("---- 게시물 목록 -----");
		System.out.println("글번호\t제목\t작성자\t조회수\t작성일");
		for(Board b : list) {
			System.out.println(b.getBoardNo()+"\t"+b.getBoardTitle()+"\t"
								+b.getBoardWriterName()+"\t"+b.getReadCount()
								+"\t"+b.getWriteDate());
		}
		
	}
	public void printOneBoard(Board b) {
		System.out.println("---- 게시물 정보 -----");
		System.out.println("게시물 번호 : "+b.getBoardNo());
		System.out.println("게시물 제목 : "+b.getBoardTitle());
		System.out.println("게시물 내용 : "+b.getBoardContent());
		System.out.println("게시물 작성자 : "+b.getBoardWriterName());
		System.out.println("게시물 조회수 : "+b.getReadCount());
		System.out.println("게시물 작성일 : "+b.getWriteDate());		
	}
	public Board updateBoard() {
		Board b = new Board();
		System.out.print("제목 입력 : ");
		sc.nextLine();
		b.setBoardTitle(sc.nextLine());
		System.out.print("내용 입력 : ");
		b.setBoardContent(sc.nextLine());
		return b;
	}
}
