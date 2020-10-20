package kr.or.ddit.filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class UnitHttpServletRequestWrapper extends HttpServletRequestWrapper{
	private Map<String, String[]> parameterMap;
	
	public UnitHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		parameterMap = new HashMap<String, String[]>(request.getParameterMap());
	}

	// ServletRequest의 Parameter와 관련된 메서드를 모두 override 해줘야 한다.
	
	@Override
	public String getParameter(String name) {
		// 만약 name에 해당하는 key값이 없으면 null의 [0]번째 인덱스에 해당하는 값을 찾는다 => 말이 안된다.
		
		String[] values = parameterMap.get(name);
		if (values != null && values.length >= 1) {
			return values[0];
		}else {
			return null;
		}
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		// super.~ 가 아닌, 우리가 만든 map 객체를 반환한다. 
		return parameterMap;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		// map 객체의 key값을 Enumeration type 으로 반환해야 한다. 
		return Collections.enumeration(parameterMap.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		// 우리가 만든 Map 객체에 대해 Key값(name)을 입력하면 해당하는 value를 반환한다.
		return parameterMap.get(name);
	}
	
	public void setUnit() {
		// 파라미터로 UNT_CD가 있는지 조사
		// 만약 있다면 별다른 작업을 하지 않는다. 
		// 만약 해당 파라미터가 없으면 UNT_CD 파라미터로 DDIT라는 문자열 값을 파라미터로 추가한다.
		if(parameterMap.get("UNT_CD") == null) {
			parameterMap.put("UNT_CD", new String[] {"DDIT"});
		}
	}
}
