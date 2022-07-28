package kr.or.iei.member.controller;

import kr.or.iei.member.model.service.MemberService;
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
    public void main(){
        while(true){
            if(login == null){
                int sel = view.showMenu();
                switch (sel){
                    case 1:
                        login();
                        break;
                    case 2:
                        insertMember();
                        break;
                    case 0:
                        return;
                }
            }else{
                int sel = view.loginMenu(login.getMemberName());
                switch (sel){
                    case 1:
                        printMyInfo();
                        break;
                    case 2:
                        searchNameInfo();
                        break;
                    case 3:
                        myInfoChange();
                        break;
                    case 4:
                        break;
                    case 0:
                        login = null;
                        break;
                }
            }
        }
    }

    private void login() {
        Member m = view.getLoginInfo();
        Member loginMember = service.selectOneMember(m);
        if(loginMember == null){
            view.loginFail();
        }else{
            login = loginMember;
            view.loginSuccess();
        }

    }

    private void insertMember() {
        String memberId = null;
        while (true){
            memberId = view.getId();
            boolean check = service.selectOneMember(memberId);
            if(check==false){
                break;
            }else {
                view.dupId();
            }
        }
        Member m = view.getMember();
        m.setMemberId(memberId);
        int result = service.insertMember(m);
        if(result>0){
            view.insertSuccess();
        }else{
            view.insertFail();
        }
    }

    private void printMyInfo() {
        view.myInfo(login);
    }

    private void searchNameInfo() {
        String searchName = null;
        while (true) {
            searchName = view.searchName();
            boolean check = service.selectOneMember(searchName);
            if (check == false) {
                Member m = service.searchNameInfo(searchName);
                view.searchNameInfo(m);
                break;
            } else {
                view.nosearchName();
            }
        }
    }

    private void myInfoChange() {

    }

}
