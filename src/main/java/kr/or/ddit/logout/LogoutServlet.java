package kr.or.ddit.logout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Session에 있는 모든 속성을 제거한다. 
		request.getSession().invalidate();
		//request.getSession().setMaxInactiveInterval(0); 0으로 둔다는 건 session의 만료기한을 무한으로 둔다??
		// 실제 동작은 즉시 session 객체를 삭제하는 것이다. 
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
