package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MyBatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDao implements MemberDaoI{
	private static MemberDao dao;
	
	public MemberDao() {
		
	}
	
	public static MemberDao getDao() {
		if (dao == null) {
			dao = new MemberDao();
		}
		return dao;
	}
	
	@Override
	public MemberVo getMember(String userId) {
		// 원래는 DB에서 데이터를 조회하는 로직이 있어야 하나
		// 우리는 controller 기능에 집중한다 -> 하드코딩을 통해 dao, service는 간략하게 넘어간다.
		// Mock(가짜)
		
		/*
		MemberVo memberVo = new MemberVo();
		memberVo.setUserId("brown");
		memberVo.setPassword("passbrown");
		 */
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		//select
		// 한 건 : selectOne
		// 여러 건 : selectList
		
		MemberVo memberVo = sqlSession.selectOne("member.getMember", userId);
		sqlSession.close();
		
		
		return memberVo;
		
	}

	@Override
	public List<MemberVo> getMemberAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<MemberVo> memlist = sqlSession.selectList("member.getMemberAll");
		
		sqlSession.close();
		
		return memlist;
	}
	
}
