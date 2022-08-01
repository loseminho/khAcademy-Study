package kr.or.iei.member.controller;

import kr.or.iei.member.model.dao.Dao;
import kr.or.iei.member.model.vo.Memo;

public class Controller {
    Dao dao;
    Memo m;

    public Controller() {
        super();
        m = new Memo();
        dao = new Dao();
    }

    public void main() {
        int no = 101;
        String name = "홍길동";
        Memo m = new Memo(no, name);
        int result = dao.update(m);
        if(result > 0) {
            System.out.println("변경 성공");
        }else {
            System.out.println("변경 실패");
        }
    }
}
