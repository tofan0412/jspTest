package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest {

	@Test
	public void getMembertest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setPass("brownPass");
		answerMemberVo.setUserid("brown");
		
		/***When***/
		MemberVo mv = memberService.getMember(userId);
		/***Then***/
//		assertEquals("brown", mv.getUserId());
//		assertEquals("passbrown", mv.getPassword());
		
		assertEquals(answerMemberVo, mv);
		
	}
}
