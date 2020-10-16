package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.member.model.MemberVo;

public interface MemberServiceI {
	MemberVo getMember(String userId);
	
	List<MemberVo> getMemberAll();
	
	Map<String, Object> getMemberPage(Map<String, Integer> page);
	
}
