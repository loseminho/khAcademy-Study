package member.controller;


import member.model.service.MemberService;
import member.model.vo.Board;
import member.model.vo.Member;
import member.view.MemberView;

import java.util.ArrayList;

public class MemberController {
    private MemberView view;;
    private MemberService service;
    private Member login;
    private Board board;

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
                    case 1:// 로그인 하기
                        login();
                        break;
                    case 2:// 회원가입
                        insertMember();
                        break;
                    case 3:// 아이디 찾기
                        searchMemberId();
                        break;
                    case 0:// 프로그램 종료
                        return;
                }
            }else{
                int sel = view.loginMenu();
                switch (sel){
                    case 1:// 게시물 목록 보기
                        showAllBoard();
                        break;
                    case 2:// 게시물 상세 보기
                        showBoardDetail();
                        break;
                    case 3:// 게시물 등록
                        insertBoard();
                        break;
                    case 4:// 게시물 수정
                        return;
                    case 5:// 게시물 삭제

                        break;
                    case 6:// 내 정보 보기

                        break;
                    case 7:// 내 정보 변경

                        break;
                    case 8:// 회원 탈퇴

                        break;
                    case 0:// 로그아웃
                        return;
                }
            }
        }
    }

    private void login() {
        Member m = view.getLoginInfo();
        Member loginMember = service.login(m);
        if(loginMember == null){
            view.loginFail();
        }else{
            login = loginMember;
            view.loginSuccess();
        }
    }

    private void insertMember() {
        String memberId = null;
        while(true){
            memberId = view.getId();
            boolean check = service.selectOneMember(memberId);
            if(!check){
                break;
            }else {
                view.dupId();
            }
        }
        Member m =view.insertMember();
        m.setMemberId(memberId);
        int result = service.insertMember(m);
        if(result>0){
            view.insertSuccess();
        }else{
            view.insertFail();
        }
    }

    private void searchMemberId() {
        Member m = view.searchMemberId();
        Member searchMemberId = service.searchMemberId(m);
        if(searchMemberId == null){
            view.searchFail();
        }else{
            view.searchSuccess(searchMemberId);
        }
    }

    private void showAllBoard() {
        ArrayList<Board> list = service.showAllBoard(login);
        view.showAllBoard(list);
    }

    private void insertBoard() {
        Board b = view.insertBoard();
        int result = service.insertBoard(b,login);
        if(result>0){
            view.insertBoardSuccess();
        }else{
            view.insertBoardFail();
        }
    }

    private void showBoardDetail() {
        int sel = 0;
        while(true){
            sel = view.showBoardDetailsel();
            boolean check = service.showBoardDetailCheck(sel);
            if(!check){
                Board b = service.showBoardDetail(sel);
                view.showBoardDetail(b);
                break;
            }else{
                view.noBoard();
            }
        }
    }

}
