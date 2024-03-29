package kr.or.dm.model.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.dm.model.dao.DirectMessageDao;
import kr.or.dm.model.vo.DirectMessage;

@Service
public class DirectMessageService {
	@Autowired
	private DirectMessageDao dao;
	
	//커밋 롤백을 해야 하는 상황일때는 트랜젝션을 붙여주어야 함.
	@Transactional
	public int insertDm(DirectMessage dm) {
		return dao.insertDm(dm);
	}

	public ArrayList<DirectMessage> myDmList(DirectMessage dm) {
		return dao.myDmList(dm);
	}

	@Transactional
	public DirectMessage selectOneDm(int dmNo) {
		DirectMessage dm = dao.selectOenDm(dmNo);
		if(dm.getReadCheck() == 0) {
			dao.updateReadCheck(dmNo);
		}
		return dm;
	}

	public int dmCount(String memberId) {
		return dao.dmCount(memberId);
	}
}
