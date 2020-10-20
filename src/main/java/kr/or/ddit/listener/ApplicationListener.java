package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext(); 
		String cp = sc.getContextPath();
		// 경로를 application 객체의 attribute로 저장한다. 
		sc.setAttribute("cp", cp);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
	
}
