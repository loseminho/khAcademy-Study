package kr.or.member.model.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.member.model.dao.MemberDao;
import kr.or.member.model.vo.Member;

@Service
public class MemberService {
	
	//autowired : 스프링이 만든 객체중에 선언된 변수와 이름이 일치하는 타입을 찾아서 값을 대입
	@Autowired
	private MemberDao dao;
	public MemberService() {
		super();
		System.out.println("Service 생성!");
	}
	public int insertMember(Member m) {
		int result = dao.insertMember(m);
		System.out.println(m);
		return result;
	}
	public Member selectOneMember(Member m) {
		Member member = dao.selectOneMember(m);
		return member;
	}
	public Member selectOneMember(String searchId) {
		return dao.selectOenMember(searchId);
	}
	public ArrayList<Member> selectAllMember() {
		ArrayList<Member> list = dao.selectAllMember();
		
		return list;
	}
	public int updateMyPage(Member m) {
		int result = dao.updateMypage(m);
		return result;
	}
	public int deleteMember(int memberNo) {
		int result = dao.deleteMember(memberNo);
		return result;
	}

}
