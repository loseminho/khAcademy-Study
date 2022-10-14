package kr.or.dm.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.or.dm.model.vo.DirectMessage;

@Repository
public class DirectMessageDao {
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	public int insertDm(DirectMessage dm) {
		int result = sqlSession.insert("dm.insertDm",dm);
		return result;
	}

	public ArrayList<DirectMessage> myDmList(DirectMessage dm) {
		List list = sqlSession.selectList("dm.myDmList",dm);
		return (ArrayList<DirectMessage>)list;
	}

	public DirectMessage selectOenDm(int dmNo) {
		return sqlSession.selectOne("dm.selectOneDm",dmNo);
	}

	public void updateReadCheck(int dmNo) {
		sqlSession.update("dm.updateReadCheck",dmNo);
		
	}

	public int dmCount(String memberId) {
		return sqlSession.selectOne("dm.dmCount",memberId);
	}
	
}
