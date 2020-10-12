package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

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
		
		assertEquals(answerMemberVo, mv);
		
	}
	
	
	@Test
	public void getMemberAllTest() {
		/***Given***/
		MemberDao dao = new MemberDao();

		/***When***/
		List<MemberVo> memlist = dao.getMemberAll();
		
		/***Then***/
		assertEquals(5, memlist.size());
		
		//assertEquals("brown", memlist.get(0).getUserid());
	}
}
