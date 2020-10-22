package kr.or.ddit.member.service;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	MemberServiceI memberService;
	
	@Before
	public void setup() {
		memberService = new MemberService();
		memberService.deleteMember("test");
	}
	
	@Test
	public void getMembertest() {
		/***Given***/
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
	
	@Test
	public void localeListTest() {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale locale : locales) {
			logger.debug("{}", locale);
		}
	}
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo("test", "test1234", "testnm", "testalias", 
				"testaddr1", "testaddr2", "1234", "testfilename", "testRealfilename");
		
		/***When***/
		int insertCnt = memberService.insertMember(memberVo);
		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	
}
