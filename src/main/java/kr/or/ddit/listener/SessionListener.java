package kr.or.ddit.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// life Cycle와 관련된 event handler의 등록
public class SessionListener implements HttpSessionListener {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);
	// 서버에 새로운 Session이 생성될 때 or session의 속성값이 변경될 때 ???
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.debug("session Created");
	}
	
	// 서버에 있는 session이 소멸될 때
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}
}
