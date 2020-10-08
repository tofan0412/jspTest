package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {

	@Test
	public void getMembertest() {
		/***Given***/
		MemberDao dao = new MemberDao();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setPassword("passbrown");
		answerMemberVo.setUserId("brown");
		
		/***When***/
		MemberVo mv = dao.getMember(userId);
		/***Then***/
//		assertEquals("brown", mv.getUserId());
//		assertEquals("passbrown", mv.getPassword());
		
		assertEquals(answerMemberVo, mv);
		
	}
}
