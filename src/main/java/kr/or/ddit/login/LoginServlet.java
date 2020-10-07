package kr.or.ddit.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	
	// login 화면을 클라이언트에게 응답으로 생성한다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
	// login 화면에서 사용자가 보낸 아이디 , 비밀번호를 사용하여 로그인 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		logger.debug("userId : {} , password : {}",userId, password);
		// 쿠키 정보
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			logger.debug("name : {}, value : {}", 
					cookie.getName(), cookie.getValue());
		}
		
		Cookie cookie = new Cookie("SERVERCOOKIE", "COOKIEVALUE");
		cookie.setMaxAge(60*60*24);	// 쿠키의 수명 설정. 
		// 서버에서 만든 쿠키를 response 객체에 담는다.
		response.addCookie(cookie);
	}
}
