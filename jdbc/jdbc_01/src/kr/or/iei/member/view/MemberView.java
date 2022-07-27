package kr.or.iei.member.view;
import kr.or.iei.member.vo.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberView {
    private Scanner sc = new Scanner(System.in);


    public int showMenu() {
        System.out.println("\n-------회원 관리 프로그램 ------\n");
        System.out.println("1. 전체 회원 조회");          //SELECT
        System.out.println("2. 아이디로 회원 조회");      //SELECT
        System.out.println("3. 이름으로 회원 조회");      //SELECT
        System.out.println("4. 회원 가입");              //INSERT
        System.out.println("5. 회원 정보 변경");          //UPDATE
        System.out.println("6. 회원 탈퇴");              //DELETE
        System.out.println("0. 프로그램 종료");
        System.out.println("선택 >>");
        int sel = sc.nextInt();
        return sel;
    }

    public void selectAllMember(ArrayList<Member> list) {
        System.out.println("\n----- 전체 회원 정보 -----\n");
        System.out.println("아이디\t비밀번호\t이름\t주소\t\t전화번호\t나이\t성별\t가입일");
        for(Member m : list) {
            System.out.print(m.getMemberId() + "\t");
            System.out.print(m.getMemberPw() + "\t");
            System.out.print(m.getMemberName() + "\t");
            System.out.print(m.getMemberAddr() + "\t");
            System.out.print(m.getMemberPhone() + "\t");
            System.out.print(m.getMemberAge() + "\t");
            System.out.print(m.getMemberGender() + "\t");
            System.out.println(m.getEnrollDate() + "\t");
        }
    }

    public String getId() {
        System.out.println("아이디 입력 : ");
        return sc.next();
    }

    public void printOneMember(Member m) {
        System.out.println("----- 회원 정보 -----");
        System.out.println("아이디 : "+m.getMemberId());
        System.out.println("비밀번호 : "+m.getMemberPw());
        System.out.println("이름 : "+m.getMemberName());
        System.out.println("주소 : "+m.getMemberAddr());
        System.out.println("전화번호 : "+m.getMemberPhone());
        System.out.println("나이 : "+m.getMemberAge());
        System.out.println("성별 : "+m.getMemberGender());
        System.out.println("가입일 : "+m.getEnrollDate());
    }

    public void noSearchMember() {
        System.out.println("회원 정보를 조회 할 수 없습니다.");
    }

    public String getName() {
        System.out.println("이름 입력 : ");
        String memberName = sc.next();
        return memberName;
    }

    public Member getMember() {
        System.out.println("\n------회원가입 -------\n");
        System.out.print("아이디 입력 : ");
        String memberId = sc.next();
        System.out.print("비밀번호 입력 : ");
        String memberPw = sc.next();
        System.out.print("이름 입력 : ");
        String memberName = sc.next();
        System.out.print("주소 입력 :" );
        sc.nextLine();
        String memberAddr = sc.nextLine();
        System.out.print("전화번호 입력 [010-0000-0000] : ");
        String memberPhone = sc.next();
        System.out.print("나이 입력 : ");
        int memberAge = sc.nextInt();
        System.out.print("성별 입력 [남/여] : ");
        char memberGender = sc.next().charAt(0);
        Member m = new Member(memberId, memberPw,memberName,memberAddr,memberPhone,memberAge,memberGender,null);
        return m;


    }

    public void insertSuccess() {
        System.out.println("회원가입 성공!");
    }

    public void insertFail() {
        System.out.println("회원가입 실패~");
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

    public void updateSuccess() {
        System.out.println("업데이트 성공!");
    }

    public void updateFail() {
        System.out.println("업데이트 실패!");
    }

    public void deleteSuccess() {
        System.out.println("삭제 성공!");
    }

    public void deleteFail() {
        System.out.println("삭제 실패!");
    }
}
