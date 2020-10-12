package kr.or.ddit.jobs.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MyBatisUtil;
import kr.or.ddit.jobs.model.JobsVo;

public class JobsDao implements JobsDaoI {

	@Override
	public List<JobsVo> getJobsAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		List<JobsVo> joblist = sqlSession.selectList("jobs.getJobsAll");
		
		return joblist;
	}
	
}
