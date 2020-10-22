package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.db.MyBatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {
	// 테스트 코드는 다른 테스트 코드의 영향을 받지 않는다.
	
	// JUnit(하나 하나의 테스트 메서드 마다)의 life Cycle : @Before -> @Test -> @After
	// @BeforeClass : 모든 테스트 코드의 실행 전 한번만 실행된다.
	// @AfterClass(static) : 모든 테스트 코드 메서드의 진행 후에 한번만 실행된다.
	
	MemberDaoI dao;
	SqlSession sqlSession;
	
	@Before
	// @Test 실행 전에 항상 먼저 실행된다.
	public void setup() {
		dao = new MemberDao();
		sqlSession = MyBatisUtil.getSqlSession();
		dao.deleteMember(sqlSession, "test");
	}
	
	@Test
	public void getMembertest() {
		/***Given***/
		String userId = "brown";
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");
		
		/***When***/
		MemberVo mv = dao.getMember(sqlSession, userId);
		/***Then***/
//		assertEquals("brown", mv.getUserId());
//		assertEquals("passbrown", mv.getPassword());
		
		assertEquals(answerMemberVo.getUserid(), mv.getUserid());
	}
	
	@Test
	public void getMemberAllTest() {
		/***Given***/
		
		/***When***/
		List<MemberVo> memlist = dao.getMemberAll(sqlSession);
		
		/***Then***/
		assertEquals(15, memlist.size());
		
		//assertEquals("brown", memlist.get(0).getUserid());
	}
	
	@Test
	public void getMemberPageTest() {
		/***Given***/
		Map<String, Integer> map = new HashMap<>();
		
		String page_str = null;
		int pagenm = page_str == null? 1 : Integer.parseInt(page_str);
		map.put("page", pagenm);
		map.put("pageSize", 7);
		
		/***When***/
		List<MemberVo> memList = dao.getMemberPage(sqlSession, map);

		/***Then***/
		assertEquals(7, memList.size());
	}
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo("test", "test1234", "testnm", "testalias", 
				"testaddr1", "testaddr2", "1234", "testfilename", "testRealfilename");
		/***When***/
		int insertCnt = dao.insertMember(sqlSession, memberVo);
		/***Then***/
		assertEquals(1, insertCnt);
	}
}
