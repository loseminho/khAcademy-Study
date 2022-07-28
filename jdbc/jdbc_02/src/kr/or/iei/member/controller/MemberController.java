package kr.or.iei.member.controller;

import kr.or.iei.member.kr.or.iei.member.model.vo.Member;
import kr.or.iei.member.kr.or.iei.member.view.MemberView;
import kr.or.iei.member.model.dao.MemberDao;

import java.util.ArrayList;

public class MemberController {
    private MemberView view;
    private MemberDao dao;

    public MemberController() {
        super();
        view = new MemberView();
        dao = new MemberDao();
    }
    public void main(){
        while(true){
            int sel = view.showMenu();
            switch (sel){
                case 1:// 전체 회원 조회
                    searchAllMember();
                    break;
                case 2://아이디로 회원 조회
                    searchIdMember();
                    break;
                case 3://이름으로 회원 조회
                    searchNameMember();
                    break;
                case 4://회원가입
                    insertMember();
                    break;
                case 5://회원 정보 수정
                    updateMember();
                    break;
                case 6://회원 정보 삭제
                    deleteMember();
                    break;
                case 0:

                    return;
            }
        }
    }

    private void searchAllMember() {
        ArrayList<Member> list = dao.selectAllMember();
        view.selectAllMember(list);
    }

    private void searchIdMember() {
        String memberId = view.getId("조회");
        Member m = dao.searchIdMember(memberId);
        if( m != null) {
            view.printOneMember(m);
        }else{
            view.failMsg("조회");
        }
    }

    private void searchNameMember() {
        String memberName = view.getName("조회");
        Member m = dao.searchNameMember(memberName);
        if(m != null){
            view.printOneMember(m);
        }else{
            view.failMsg("조회");
        }
    }

    private void insertMember() {
        Member m = view.getInsertMember();
        int result = dao.insertMember(m);
        if(result>0){
            view.successMsg("가입");
        }else{
            view.failMsg("가입");
        }
    }
    private void updateMember() {
        String getId = view.getId("수정");
        Member m = view.getUpdateInfo();
        int result = dao.updateMember(getId,m);
        if(result > 0){
            view.successMsg("수정");
        }else {
            view.failMsg("수정");
        }
    }

    private void deleteMember() {
        String getId = view.getId("삭제");
        int result = dao.deleteMember(getId);
        if(result > 0){
            view.successMsg("삭제");
        }else {
            view.failMsg("삭제");
        }
    }
}
