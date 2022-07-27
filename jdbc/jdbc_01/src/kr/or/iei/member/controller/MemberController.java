package kr.or.iei.member.controller;

import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.view.MemberView;
import kr.or.iei.member.vo.Member;

import java.util.ArrayList;

public class MemberController {

    private MemberView view;
    private MemberDao dao;
    public MemberController(){
        super();
        view = new MemberView();
        dao = new MemberDao();
    }
    public void main(){
        while(true){
            int sel = view.showMenu();
            switch (sel){
                case 1://전체 회원 조회
                    selectAllMember();
                    break;
                case 2://아이디로 회원 조회
                    searchIdMember();
                    break;
                case 3://이름으로 회원 조회
                    searchNameMember();
                    break;
                case 4://회원 정보 변경
                    insertMember();
                    break;
                case 5://회원 정보 변경
                    updateMember();
                    break;
                case 6://회원 탈퇴
                    deleteMember();
                    break;
                case 0://선택
                    return;
            }
        }
    }

    private void deleteMember() {
        String getId = view.getId();
        int result = dao.deleteMember(getId);
        if(result > 0){
            view.deleteSuccess();
        }else {
            view.deleteFail();
        }
    }

    private void updateMember() {
        String getId = view.getId();
        Member m = view.getUpdateInfo();
        int result = dao.updateMember(getId, m);
        if(result > 0){
            view.updateSuccess();
        }else {
            view.updateFail();
        }
    }

    //회원정보를 입력 받아 가입하는 메ㅔ소드
    private void insertMember() {
        //insert into member_tbl values(..........);
        Member m = view.getMember();
        int result = dao.insertMember(m);
        if(result > 0){
            view.insertSuccess();
        }else {
            view.insertFail();
        }
    }//insertMember() 메소드 종료

    //이름으로 회원을 조회하는 메소드
    private void searchNameMember() {
        //입력 받은 이름이 포함된 모든 회원 조회
        //조회 결과가 있으면 해당 회원 전체 출력
        //조회 결과가 없으면 '조회 할 수 없습니다' 출력
        String memberName = view.getName();
        ArrayList<Member> list = dao.searchNameMember(memberName);
        if(list.isEmpty()){
            view.noSearchMember();
        }else{
            view.selectAllMember(list);
        }
    }//searchNameMember() 메소드 종료

    //아이디로 회원을 조회하는 메소드
    private void searchIdMember() {
    //select * from member_tbl where member_id='입력받은아이디';
    //사용자에게 아이디를 입력 받아야함 -> view를 통해서
        String memberId = view.getId();
        //사용자한테 입력 받은 아이디를 전달하면서 회원정보를 조회
        Member m = dao.searchIdMember(memberId);
        if(m != null){
            view.printOneMember(m);
        }else{
            view.noSearchMember();
        }

    }//searchIdMember()메소드 종료

    private void selectAllMember() {
        //전체회원을 조회하는 메소드
        //    private void selectAllMember() {
        //        //select * from member_tbl;
        //        //사용자한테 받아올 데이터가 없음 -> view를 호출
        //        //dao를 통해서 데이터를 받아옴
        ArrayList<Member> list = dao.selectAllMember();
        System.out.println(list.size());
        view.selectAllMember(list);
    }//selectAllMember() 메소드 종료
}
