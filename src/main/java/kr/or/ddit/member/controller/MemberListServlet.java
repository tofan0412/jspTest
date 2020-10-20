package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberServiceI memberService = new MemberService();
//		List<MemberVo> memberList = memberService.getMemberAll();
		Map<String, Integer> page = new HashMap<>();
		
		String page_str = request.getParameter("page");
		int pagenm = page_str == null? 1 : Integer.parseInt(page_str);
		
		String pageSize_str = request.getParameter("pageSize");
		int pageSize = pageSize_str == null? 5 : Integer.parseInt(pageSize_str);
		
		request.setAttribute("page", pagenm);
		request.setAttribute("pageSize", pageSize);
		
		// 필요한 페이지의 갯수
		page.put("page", pagenm);
		
		// 한 페이지 당 출력할 글의 갯수
		page.put("pageSize", pageSize);
		
		Map<String, Object> map = memberService.getMemberPage(page);
		
		request.setAttribute("memList", map.get("memList"));
		request.setAttribute("pages", map.get("pages"));
	
		request.getRequestDispatcher("/member/memberList.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
