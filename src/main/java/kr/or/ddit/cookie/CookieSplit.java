package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieSplit{
	private static final Logger logger = LoggerFactory.getLogger(CookieSplit.class);
	
	//coolieString 문자열 변수에 담긴 값은
	//쿠키이름1=쿠키값; 쿠키이름2=쿠키값; .... 형태로 구성됨
	//구성된 쿠키 이름과 값은 상황에 따라 변경될 수 있음
	private String cookieString = "USERNM=brown; REMEMBERME=Y; TEST=T; ";
	
	public static void main(String[] args){
		CookieSplit cookieSplit = new CookieSplit();
		logger.debug(cookieSplit.getCookieValue("USERNM"));	// 기대되는 값 : brown
		logger.debug(cookieSplit.getCookieValue("TEST"));	// 기대되는 값 : T
		logger.debug(cookieSplit.getCookieValue("XXXX"));	// 기대되는 값 : ""(공백)
	}
	
	// cookieString 필드를 분석하여 메서드 인자로 넘어온 cookieName에 해당하는 쿠키가 있을 경우 
	// 해당 쿠키의 값을 반환하는 메서드
    public String getCookieValue(String cookieName){
    	String[] cookies = cookieString.split("; ");
    	String result = "";
    	for (int i = 0 ; i < cookies.length ; i++) {
    		String[] cookie = cookies[i].split("=");
    		if (cookie[0].equals(cookieName)) {
    			result = cookie[1];
    		}else {
    		}
    	}
    	return result;
    }
}