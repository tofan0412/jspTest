package kr.or.ddit.jobs.dao;

import java.util.List;

import kr.or.ddit.jobs.model.JobsVo;

public interface JobsDaoI {
	public List<JobsVo> getJobsAll();
}
