package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		assertEquals("brown", mv.getUserid());
		assertEquals("brownPass", mv.getPass());
		
//		assertEquals(answerMemberVo, mv);
		
	}
	
	public void getMemberPageTest() {
		/***Given***/
		MemberServiceI memberService = new MemberService();
		int page = 1;
		Map<String, Integer> pageInfo = new HashMap<>();
		pageInfo.put("page", page);
		pageInfo.put("pageSize", 7);
		/***When***/
		Map<String, Object> map = memberService.getMemberPage(pageInfo);
		
		// 생성해야 할 페이지 수
		int pages = (int)map.get("pages");
		List<MemberVo> memList = (List<MemberVo>) map.get("memList");
		
		/***Then***/
		assertEquals(3, pages);
		assertEquals(15, memList.size());
	}
	
	
	
	
}
