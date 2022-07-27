package kr.or.iei.member.kr.or.iei.member.view;

import kr.or.iei.member.kr.or.iei.member.model.vo.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberView {
    Scanner sc;

    public MemberView() {
        super();
        sc = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("\n----- 회원 관리 프로그램v2 ------\n");
        System.out.println("1. 전체 회원 조회");
        System.out.println("2. 아이디로 회원 조회");
        System.out.println("3. 이름으로 회원 조회");
        System.out.println("4. 회원가입");
        System.out.println("5. 회원 정보 수정");
        System.out.println("6. 회원 정보 삭제");
        System.out.println("0. 프로그램 종료");
        System.out.print("선택 >>>>>");
        int sel = sc.nextInt();
        return sel;
    }

    public void selectAllMember(ArrayList<Member> list) {
        System.out.println("\n----- 전체 회원 정보 -----\n");
        System.out.println("아이디\t비밀번호\t이름\t주소\t\t번호\t나이\t성별\t가입일");
        for(Member m : list){
            System.out.print(m.getMemberId()+"\t");
            System.out.print(m.getMemberPw()+"\t");
            System.out.print(m.getMemberName()+"\t");
            System.out.print(m.getMemberAddr()+"\t");
            System.out.print(m.getMemberPhone()+"\t");
            System.out.print(m.getMemberAge()+"\t");
            System.out.print(m.getMemberGender()+"\t");
            System.out.println(m.getEnrollDate()+"\t");
        }
    }

    public void printOneMember(Member m) {
        System.out.println("아이디 : "+m.getMemberId());
        System.out.println("비밀번호 : "+m.getMemberPw());
        System.out.println("이름 : "+m.getMemberName());
        System.out.println("주소 : "+m.getMemberAddr());
        System.out.println("번호 : "+m.getMemberPhone());
        System.out.println("나이 : "+m.getMemberAge());
        System.out.println("성별 : "+m.getMemberGender());
        System.out.println("가입일 : "+m.getEnrollDate());
    }

    public Member getInsertMember() {
        System.out.println("\n----- 회원가입 -----\n");
        Member m = new Member();
        System.out.print("아이디 입력 : ");
        String memberId = sc.next();
        m.setMemberId(memberId);
        System.out.print("비밀번호 입력 : ");
        String memberPw = sc.next();
        m.setMemberPw(memberPw);
        System.out.print("이름 입력 : ");
        m.setMemberName(sc.next());
        System.out.print("주소 입력 : ");
        sc.nextLine();
        m.setMemberAddr(sc.nextLine());
        System.out.print("전화번호 입력[010-0000-0000] : ");
        m.setMemberPhone(sc.next());
        System.out.print("나이 입력 : ");
        m.setMemberAge(sc.nextInt());
        System.out.print("성별 입력 : ");
        m.setMemberGender(sc.next());
        return m;
    }

    public String getName(String string) {
        System.out.println("\n----- 회원 정보 "+string+"-----\n");
        System.out.println(string+"할 회원 이름 입력 :");
        String memberName = sc.next();
        return  memberName;
    }

    public String getId(String string) {
        System.out.println("\n----- 회원 정보 "+string+"-----\n");
        System.out.print(string+"할 회원 아이디 입력 :");
        String memberId = sc.next();
        return memberId;
    }

    public void successMsg(String string) {
        System.out.println(string+"이 완료 되었습니다.");
    }

    public void failMsg(String string) {
        System.out.println(string+"이 실패하셨습니다.");
    }

    public Member getUpdateInfo() {
        System.out.println("\n------회원 정보 변경 -------\n");
        System.out.print("비밀번호 입력 : ");
        String memberPw = sc.next();
        System.out.print("주소 입력 :" );
        sc.nextLine();
        String memberAddr = sc.nextLine();
        System.out.print("전화번호 입력 [010-0000-0000] : ");
        String memberPhone = sc.next();
        Member m = new Member(memberPw,memberAddr,memberPhone);
        return m;
    }
}
