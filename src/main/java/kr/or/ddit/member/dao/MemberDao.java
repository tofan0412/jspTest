package kr.or.ddit.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public MemberVo getMember(SqlSession sqlSession , String userId) {
		MemberVo memberVo = sqlSession.selectOne("member.getMember", userId);
		return memberVo;
	}

	@Override
	public List<MemberVo> getMemberAll(SqlSession sqlSession) {
		List<MemberVo> memlist = sqlSession.selectList("member.getMemberAll");
		return memlist;
	}

	@Override
	public List<MemberVo> getMemberPage(SqlSession sqlSession, Map<String, Integer> page) {
		return sqlSession.selectList("member.getMemberPage", page);
	}

	@Override
	public int selectMemberTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("member.selectMemberTotalCnt");
	}
}
