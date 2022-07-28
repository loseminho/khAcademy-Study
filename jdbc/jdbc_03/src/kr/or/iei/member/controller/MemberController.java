package kr.or.iei.member.controller;

import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.view.MemberView;
import kr.or.iei.member.model.vo.Member;

public class MemberController {
    private MemberView view;
    private MemberService service;
    private MemberDao dao;
    private Member login;//null이면 비로그인, 값이 있으면 로그인

    public MemberController() {
        super();
        view = new MemberView();
        service = new MemberService();
        dao = new MemberDao();
    }
    public void main(){
        while (true){
            if(login == null){
                int sel = view.showMenu();
                switch(sel){
                    case 1:
                        login();
                        break;
                    case 2:
                        insertMember();
                        break;
                    case 0:
                        break;
                }
            }else{
                int sel = view.showLoginMenu(login.getMemberName());
                switch (sel){
                    case 1:
                        break;
                    case 2:
                        login = null;
                        break;
                    case 3:
                        break;
                    case 4:
                        deleteMember();
                        break;
                }
            }

        }
    }

    private void login() {
        //select * from member_tbl where member_id=? and member_pw=?;
        Member m = view.login();
        Member loginMember = service.selectOneMember(m);
        if(loginMember == null){
            view.loginFail();
        }else {
            login = loginMember;
            view.loginSuccess();
        }
    }

    private void insertMember() {
        while(true){
            String memberId = view.getMemberId();
            boolean check = service.selectOneMember(memberId);
            if(!check){
                System.out.println("안중복");
                break;
            }else{
                System.out.println("중복");
                view.dupId();
            }
        }
    }

    private void deleteMember() {
        /*
        1. delete from member_tbl where member_id = ?;
        2. insert into del_member values(?,?,?,?,?,sysdate);
         */
        int result = service.deleteMember(login);
        if(result >0){
            login = null;
            view.deleteSuccess();
        }else {
            view.deleteFail();
        }
    }
}
