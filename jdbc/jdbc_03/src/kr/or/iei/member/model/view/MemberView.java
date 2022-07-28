package kr.or.iei.member.model.view;

import kr.or.iei.member.model.vo.Member;

import java.util.Scanner;

public class MemberView {
    private Scanner sc;

    public MemberView() {
        super();
        sc = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("\n----- 회원 관리 프로그램 v3 -----\n");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("0. 프로그램 종료");
        System.out.print("선택 > ");
        int sel = sc.nextInt();
        return sel;
    }

    public Member login() {
        System.out.println("----- 로그인 -----");
        Member m = new Member();
        System.out.print("로그인 아이디 입력 : ");
        m.setMemberId(sc.next());
        System.out.print("로그인 비밀번호 입력 : ");
        m.setMemberPw(sc.next());
        return m;
    }

    public void loginFail() {
        System.out.println("로그인 실패");
        System.out.println("아이디 또는 비밀번호를 확인하세요.");
    }

    public void loginSuccess() {
        System.out.println("로그인 성공!");
    }

    public String getMemberId() {
        System.out.println("아이디 입력 : ");
        String memberId = sc.next();
        return memberId;
    }

    public void dupId() {
        System.out.println("아이디가 중복 되었습니다.");
    }

    public int showLoginMenu(String memberName) {
        System.out.println("----- ["+memberName+"] -----");
        System.out.println("1. 내 정보보기");
        System.out.println("2. 로그아웃");
        System.out.println("3. 내 정보 수정");
        System.out.println("4. 회원 탈퇴");
        System.out.println("선택 > ");
        int sel = sc.nextInt();
        return sel;
    }

    public void deleteSuccess() {
        System.out.println("삭제 완료!");
    }

    public void deleteFail() {
        System.out.println("삭제 실패");
    }
}
