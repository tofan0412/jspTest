package kr.or.ddit.jobs.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.jobs.model.JobsVo;

public class JobsServiceTest {

	@Test
	public void getJobsAllTest() {
		/***Given***/
		JobsServiceI service = new JobsService();

		/***When***/
		List<JobsVo> joblist = service.getJobsAll();
		/***Then***/
		assertNotNull(joblist);
	}

}
