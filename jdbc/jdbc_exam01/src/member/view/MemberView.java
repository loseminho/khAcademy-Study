package member.view;

import member.model.vo.Board;
import member.model.vo.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberView {
    Scanner sc;

    public MemberView() {
        super();
        sc = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("\n------ KH 커뮤니티 -----\n");
        System.out.println("1. 로그인하기");
        System.out.println("2. 회원가입");
        System.out.println("3. 아이디 찾기");
        System.out.println("0. 프로그램 종료");
        System.out.print("선택 >");
        int sel = sc.nextInt();
        return sel;
    }

    public int loginMenu() {
        System.out.println("\n------ KH 커뮤니티 -----\n");
        System.out.println("1. 게시물 목록 보기");
        System.out.println("2. 게시물 상세 보기");
        System.out.println("3. 게시물 등록");
        System.out.println("4. 게시물 수정");
        System.out.println("5. 게시물 삭제");
        System.out.println("6. 내 정보 보기");
        System.out.println("7. 내 정보 변경");
        System.out.println("8. 회원 탈퇴");
        System.out.println("0. 로그아웃");
        System.out.print("선택 >");
        int sel = sc.nextInt();
        return sel;
    }


    public Member getLoginInfo() {
        Member m = new Member();
        System.out.println("\n------ 로그인 -----\n");
        System.out.print("ID 입력 : ");
        m.setMemberId(sc.next());
        System.out.print("PW 입력 : ");
        m.setMemberPw(sc.next());
        return m;
    }

    public void loginFail() {
        System.out.println("아이디 또는 비밀번호를 확인하세요.");
    }

    public void loginSuccess() {
        System.out.println("로그인 성공!!!");
    }

    public String getId() {
        System.out.println("\n------ 회원 가입 -----\n");
        System.out.print("ID 입력 : ");
        String getId = sc.next();
        return getId;
    }

    public void dupId() {
        System.out.println("중복된 아이디입니다.");
    }

    public Member insertMember() {
        Member m = new Member();
        System.out.print("PW 입력 : ");
        m.setMemberPw(sc.next());
        System.out.print("이름 입력 : ");
        m.setMemberName(sc.next());
        System.out.print("전화번호 입력(ex.01011112222) : ");
        m.setMemberPhone(sc.next());
        return m;
    }

    public void insertSuccess() {
        System.out.println("회원 가입이 완료 되었습니다.");
    }

    public void insertFail() {
        System.out.println("회원 가입이 실패 하였습니다.");
    }

    public Member searchMemberId() {
        Member m = new Member();
        System.out.println("\n------ 아이디 찾기 -----\n");
        System.out.print("이름 입력 : ");
        m.setMemberName(sc.next());
        System.out.print("전화번호 입력 : ");
        m.setMemberPhone(sc.next());
        return m;
    }

    public void searchFail() {
        System.out.println("일치하는 정보가 없습니다.");
    }

    public void searchSuccess(Member searchMemberId) {
        System.out.println("아이디는 ["+searchMemberId.getMemberId()+"] 입니다.");
    }

    public Board insertBoard() {
        Board b = new Board();
        System.out.print("제목 입력 : ");
        b.setBoardTitle(sc.next());
        System.out.print("내용 입력 : ");
        sc.nextLine();
        b.setBoardContent(sc.nextLine());
        return b;
    }

    public void insertBoardSuccess() {
        System.out.println("게시물 등록 성공!!");
    }

    public void insertBoardFail() {
        System.out.println("게시물 등록 실패!!");
    }

    public void showAllBoard(ArrayList<Board> list) {
        System.out.println("\n------ 게시물 목록 -----\n");
        System.out.println("번호\t제목\t작성자\t조회수\t작성시간");
        for(Board b : list){
            System.out.print(b.getBoardNo()+"\t");
            System.out.print(b.getBoardTitle()+"\t");
            System.out.print(b.getMemberName()+"\t");
            System.out.print(b.getReadConut()+"\t");
            System.out.println(b.getWriteDate()+"\t");
        }
    }

    public int showBoardDetailsel() {
        System.out.print("게시물 번호 입력 : ");
        return sc.nextInt();
    }

    public void showBoardDetail(Board b) {
    }

    public void noBoard() {
    }
}
