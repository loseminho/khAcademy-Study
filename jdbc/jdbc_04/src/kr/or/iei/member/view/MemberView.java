package kr.or.iei.member.view;

import kr.or.iei.member.model.vo.Member;

import java.util.Scanner;

public class MemberView {
    private Scanner sc;

    public MemberView() {
        super();
        sc = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("\n ----- 회원 관리 프로그램 v4 ----- \n");
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
        System.out.println("0. 프로그램 종료");
        System.out.println("선택 >>");
        int sel = sc.nextInt();
        return sel;
    }

    public Member getLoginInfo() {
        Member m = new Member();
        System.out.print("로그인 할 아이디 입력 :");
        m.setMemberId(sc.next());
        System.out.print("로그인 할 비밀번호 입력 : ");
        m.setMemberPw(sc.next());
        return m;

    }

    public void loginFail() {
        System.out.println("아이디 또는 비밀번호를 확인하세요.");
    }

    public void loginSuccess() {
        System.out.println("로그인에 성공 하였습니다.");
    }



    public int loginMenu(String memberName) {
        System.out.println("----- ["+memberName+"] -----");
        System.out.println("1. 내 정보 조회");
        System.out.println("2. 이름으로 회원 조회");
        System.out.println("3. 내 정보 수정");
        System.out.println("4. 회원 탈퇴");
        System.out.println("0. 로그아웃");
        System.out.print("선택 > ");
        int sel = sc.nextInt();
        return sel;
    }

    public String getId() {
        System.out.println("회원 아이디 입력 : ");
        String memberId = sc.next();
        return memberId;
    }

    public Member getMember() {
        Member m = new Member();
        System.out.print("회원 비밀번호 입력 : ");
        m.setMemberPw(sc.next());
        System.out.print("회원 이름 입력 : ");
        m.setMemberName(sc.next());
        System.out.print("회원 주소 입력 : ");
        sc.nextLine();
        m.setMemberAddr(sc.nextLine());
        System.out.print("회원 번호 입력[010-0000-0000] : ");
        m.setMemberPhone(sc.next());
        System.out.println("회원 나이 입력 : ");
        m.setMemberAge(sc.nextInt());
        System.out.print("회원 성별 입력 :" );
        m.setMemberGender(sc.next());
        return m;
    }

    public void dupId() {
        System.out.println("중복된 아이디입니다.");
    }

    public void insertSuccess() {
        System.out.println("회원가입 성공!");
    }

    public void insertFail() {
        System.out.println("회원가입 실패");
    }

    public void myInfo(Member login) {
        System.out.println("\n----- 내 정보 조회 -----\n");
        System.out.println("이름\t\t비밀번호\t\t이름\t\t주소\t\t\t연락처\t\t나이\t\t성별\t\t생성일");
        System.out.println(login.getMemberId()+"\t"+
                login.getMemberPw()+"\t"+
                login.getMemberName()+"\t"+
                login.getMemberAddr()+"\t"+
                login.getMemberPhone()+"\t"+
                login.getMemberAge()+"\t"+
                login.getMemberGender()+"\t"+
                login.getEnrollDate());
    }

    public String searchName() {
        System.out.println("조회 할 이름 입력 : ");
        return sc.next();
    }

    public void searchNameInfo(Member m) {
            System.out.println("\n----- 조회 결과 -----\n");
            System.out.println("이름\t\t비밀번호\t\t이름\t\t주소\t\t\t연락처\t\t나이\t\t성별\t\t생성일");
            System.out.println(m.getMemberId()+"\t"+
                    m.getMemberPw()+"\t"+
                    m.getMemberName()+"\t"+
                    m.getMemberAddr()+"\t"+
                    m.getMemberPhone()+"\t"+
                    m.getMemberAge()+"\t"+
                    m.getMemberGender()+"\t"+
                    m.getEnrollDate());
    }

    public void nosearchName() {
        System.out.println("없는 회원입니다.");
    }

    public Member myInfoChange() {
        Member m = new Member();
        System.out.print("수정할 비밀 번호 입력 : ");
        m.setMemberPw(sc.next());
        System.out.print("수정할 주소 입력 : ");
        sc.nextLine();
        m.setMemberAddr(sc.nextLine());
        System.out.print("수정 할 전화번호 입력 : ");
        m.setMemberPhone(sc.next());
        return m;
    }

    public void myInfoChangeSuccess() {
        System.out.println("정보 변경 성공!");
    }

    public void myInfoChangeFail() {
        System.out.println("정보 변경에 실패하였습니다.");
    }

    public String deleteCheck() {
        System.out.println("정말 삭제 하시겠습니까? [y/n] : ");
        String check = sc.next();
        return check;
    }

    public void deleteSuccess() {
        System.out.println("삭제가 완료되었습니다.");
    }

    public void deleteFail() {
        System.out.println("삭제가 실패하였습니다.");
    }
}
