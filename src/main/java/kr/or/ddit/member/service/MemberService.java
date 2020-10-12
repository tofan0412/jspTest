package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.MemberDao;
import kr.or.ddit.member.dao.MemberDaoI;
import kr.or.ddit.member.model.MemberVo;

public class MemberService implements MemberServiceI {
	MemberDaoI memberDao = new MemberDao();
	
	@Override
	public MemberVo getMember(String userId) {
		return memberDao.getMember(userId);
	}

	@Override
	public List<MemberVo> getMemberAll() {
		return memberDao.getMemberAll();
	}
	

}
