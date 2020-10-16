package kr.or.ddit.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.model.MemberVo;

public interface MemberDaoI {
	MemberVo getMember(String userId);
	
	List<MemberVo> getMemberAll();
	
	List<MemberVo> getMemberPage(SqlSession sqlSession , Map<String, Integer> page);

	int selectMemberTotalCnt(SqlSession sqlSession);
}
