package kr.or.ddit.jobs.service;

import java.util.List;

import kr.or.ddit.jobs.dao.JobsDao;
import kr.or.ddit.jobs.dao.JobsDaoI;
import kr.or.ddit.jobs.model.JobsVo;

public class JobsService implements JobsServiceI{
	JobsDaoI dao = new JobsDao();
	@Override
	public List<JobsVo> getJobsAll() {
		return dao.getJobsAll();
	}
}
