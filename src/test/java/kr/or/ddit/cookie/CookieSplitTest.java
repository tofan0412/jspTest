package kr.or.ddit.cookie;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieSplitTest {
	private static final Logger logger = LoggerFactory.getLogger(CookieSplit.class);
	private String cookieString = "USERNM=brown; REMEMBERME=Y; TEST=T; ";
	@Test
	public void test() {
		/***Given***/
		CookieSplit cookieSplit = new CookieSplit();
		
		/***When***/
		// value를 반환한다. 입력값이 존재하는 cookie일 경우 해당 cookie의 value를 반환하고
		// 존재하지 않는 경우 공백 ""을 반환한다.
		String test1 = cookieSplit.getCookieValue("USERNM");
		String test2 = cookieSplit.getCookieValue("TEST");
		String test3 = cookieSplit.getCookieValue("XXXX");
		/***Then***/
		// 동일하면 통과한다. 
		assertEquals("brown", test1);
		assertEquals("T", test2);
		assertEquals("", test3);
		
	}
}
