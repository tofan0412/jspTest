package kr.or.ddit.db;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class ConnectionServlet
 */

public class ConnectionPoolServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(ConnectionPoolServlet.class);
	@Override
	public void init() throws ServletException {
		logger.debug("ConnectionPoolServlet init()");
		
		// ConnectionPollServlet을 초기화할 때 커넥션 풀을 생성해서
		// application 영역에 저장
		// 다른 jsp, servlet에서는 application 영역을 통해 커넥션 풀에 접근
		
		// 커넥션 pool 생성
		BasicDataSource bd = new BasicDataSource();
		bd.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bd.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		bd.setUsername("WHC");
		bd.setPassword("java");
		bd.setInitialSize(20);
		
		ServletContext sc = getServletContext();
		sc.setAttribute("bd", bd);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
