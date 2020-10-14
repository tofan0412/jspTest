package kr.or.ddit.el;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/el")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ElServlet.class);
	private MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/el/el.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String scope = req.getParameter("scope");
		logger.debug("scope : {}", scope);
		
		if (scope.equals("requestValue")) {
			req.setAttribute("attr", scope);
		}
		else if (scope.equals("sessionValue")) {
			req.setAttribute("attr", scope);
			req.getSession().setAttribute("attr", scope);
		}
		else if(scope.equals("applicationValue")){
			req.setAttribute("attr", scope);
			req.getSession().setAttribute("attr", scope);
			req.getServletContext().setAttribute("attr", scope);
		}
		
		// Map 객체 생성하여 request 속성에 넣어주기
		Map<String, String> map = new HashMap<>();
		map.put("brown", "브라운");
		map.put("sally", "샐리");
		req.setAttribute("rangers", map);
		
		// list 객체를 request 속성에 넣어주기
		req.setAttribute("rangersList", memberService.getMemberAll());
		
		req.getRequestDispatcher("/el/el.jsp").forward(req, resp);
	}
}
