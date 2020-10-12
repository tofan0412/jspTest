package kr.or.ddit.jobs.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.model.JobsVo;

public class JobsDaoTest {

	@Test
	public void getJobsAllTest() {
		/***Given***/
		JobsDaoI dao = new JobsDao();

		/***When***/
		List<JobsVo> joblist = dao.getJobsAll();
		/***Then***/
		assertNotNull(joblist);
	}

}
