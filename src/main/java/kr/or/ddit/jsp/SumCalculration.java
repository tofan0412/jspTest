package kr.or.ddit.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class SumCalculration
 */
@WebServlet("/sumCalculration")
public class SumCalculration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(SumCalculration.class);
	// 화면 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/result1.jsp").forward(request, response);
	}
	
	// 결과 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		int sum = 0;
		for (int i = start ; i <= end ; i++) {
			sum += i;
		}
		// logger로 출력하기
		logger.debug("{} {}", "숫자의 합 :", sum);
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sum);
		
		request.getRequestDispatcher("jsp/sumResult.jsp").forward(request, response);
	}

}
