package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.db.MyBatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {

	@Test
	public void getMembertest() {
		/***Given***/
		MemberDao dao = new MemberDao();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		/***When***/
		MemberVo mv = dao.getMember(userId);
		/***Then***/
//		assertEquals("brown", mv.getUserId());
//		assertEquals("passbrown", mv.getPassword());
		
		assertEquals(answerMemberVo.getUserid(), mv.getUserid());
	}
	
	@Test
	public void getMemberAllTest() {
		/***Given***/
		MemberDao dao = new MemberDao();

		/***When***/
		List<MemberVo> memlist = dao.getMemberAll();
		
		/***Then***/
		assertEquals(15, memlist.size());
		
		//assertEquals("brown", memlist.get(0).getUserid());
	}
	
	@Test
	public void getMemberPageTest() {
		/***Given***/
		MemberDao dao = new MemberDao();
		Map<String, Integer> map = new HashMap<>();
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		String page_str = null;
		int pagenm = page_str == null? 1 : Integer.parseInt(page_str);
		map.put("page", pagenm);
		map.put("pageSize", 7);
		
		/***When***/
		List<MemberVo> memList = dao.getMemberPage(sqlSession, map);

		/***Then***/
		assertEquals(7, memList.size());
	}
}
