package kr.or.member.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.member.model.service.MemberService;
import kr.or.member.model.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="/login.do")
	public String login(Member member, HttpSession session) {
		Member m = service.selectOneMember(member);
		if(m!=null) {
			session.setAttribute("m", m);
		}
		return "redirect:/";
	}
	@RequestMapping(value="/selectAllMember.do")
	public String selectAllMember(Model model) {
		//결과를 화면에 띄워야 하기 때문에 model이 필요함.
		ArrayList<Member> list = service.selectAllMember();
		model.addAttribute("list",list);
		return "member/memberList";
	}
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "member/joinFrm";
	}
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value="/join.do")
	public String join(Member m) {
		int result = service.insertMember(m);
		if(result>0) {
			return "redirect:/";
		}else {
			return "member/joinFrm";
		}
	}
	@RequestMapping(value="/searchMemberId.do")
	public String searchMemberId(String memberId, Model model) {
		Member m = service.selectOneMember(memberId);
		if(m!=null) {
			model.addAttribute("m",m);
			return "member/searchMember";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping(value="/mypage.do")
	public String myPage() {
		return "member/mypage";
	}
	@RequestMapping(value="/deleteMember.do")
	public String deleteMember(String memberId) {
		int result = service.deleteMember(memberId);
		return "redirect:/logout.do";
	}
	@RequestMapping(value="/updateInfo.do")
	public String updateInfo(Member member,HttpSession session ) {
		Member m = service.updateInfo(member);
		if(m != null) {
			session.setAttribute("m", m);
			return "redirect:/mypage.do";
		}else {
			return "redirect:/";
		}
	}
	@RequestMapping(value="/sarchMemberName.do")
	public String searchMemberName(String memberName, Model model) {
		ArrayList<Member> list = service.searchMemberName(memberName);
		model.addAttribute("list",list);
		return "member/searchMemberNameList";
	}
	
	@RequestMapping(value = "/searchMember1.do")
	   public String searchMember(String type, String keyword, Model model) {
	      ArrayList<Member> list = service.searchMember1(type, keyword);
	      model.addAttribute("list", list);
	      return "member/memberList";
	   }
	@RequestMapping(value="/searchMember2.do")
	public String searchMember2(Member m, Model model) {
		ArrayList<Member> list = service.searchMember2(m);
		model.addAttribute("list", list);
		return "member/searchMember2";
	}
	@RequestMapping(value="/idList.do")
	public String idList(Model model) {
		ArrayList<Member> list = service.selectAllMember();
		model.addAttribute("list",list);
		return "member/idList";
	}
	@RequestMapping(value="/searchMember3.do")
	public String searchMember3(String[] memberId,Model model) {
		ArrayList<Member> list = service.searchMember3(memberId);
		model.addAttribute("list",list);
		return "member/memberList";
	}
	@RequestMapping(value="/searchMember4.do")
	public String searchMember4(Model model) {
		ArrayList<Member> list = service.searchMember4();
		model.addAttribute("list",list);
		return "member/memberList";
	}
}
