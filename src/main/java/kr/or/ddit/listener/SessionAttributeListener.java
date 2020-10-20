package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.member.model.MemberVo;

public class SessionAttributeListener implements HttpSessionAttributeListener {
	private static final Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	private Map<String, MemberVo> userMap = new HashMap<>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// attribute가 추가될 때, 만약 해당 속성명이 "S_MEMBER"와 같다면 
		if("S_MEMBER".equals(event.getName())) {
			
			/* 방법 1.
			HttpSession session = event.getSession();
			MemberVo memberVo = (MemberVo) session.getAttribute("S_MEMBER");
			*/
			
			// 방법 2.
			MemberVo memberVo = (MemberVo)event.getValue();	// Session에 추가된 속성의 값을 가져온다. 
			
			logger.debug("사용자 로그인 : {}", memberVo.getUserid());
			
			userMap.put(memberVo.getUserid(), memberVo);
			
			ServletContext sc = event.getSession().getServletContext();	// application 객체를 가져온다.
			sc.setAttribute("userMap", userMap);
		}
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
		if ("S_MEMBER".equals(event.getName())) {
			MemberVo memberVo = (MemberVo)event.getValue();
			logger.debug("사용자 로그아웃 : {}", memberVo.getUserid());
			userMap.remove(memberVo.getUserid());
		}
		// 동일한 객체를 바라보고 있기 때문에 (Heap 영역의 userMap이라는 객체..) 아래의 작업을 해 줄 필요가 없다.
//		ServletContext sc = event.getSession().getServletContext();	// application 객체를 가져온다.
//		sc.setAttribute("userMap", userMap);
	}
	
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
	}
}
