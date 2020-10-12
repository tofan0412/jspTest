package kr.or.ddit.jobs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.jobs.dao.JobsDao;
import kr.or.ddit.jobs.model.JobsVo;
import kr.or.ddit.jobs.service.JobsService;
import kr.or.ddit.jobs.service.JobsServiceI;

/**
 * Servlet implementation class getJobsAll
 */
@WebServlet("/getJobsAll")
public class GetJobsAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JobsServiceI service = new JobsService();
		List<JobsVo> joblist = service.getJobsAll();
		
		request.setAttribute("joblist", joblist);
		request.getRequestDispatcher("jobs/jobs.jsp").forward(request, response);
	}

	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req,	resp);
		}
}
