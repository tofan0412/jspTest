<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getRequestResponse</title>
</head>
<body>
	<h1><%=request.getMethod()%></h1>
	
	<% request.setCharacterEncoding("utf-8"); %>
	userId 파라미터는 brown, sally 2개를 보내지만 gerParameter를 호출하면
	첫번째 파라미터 값을 반환한다. <br>
	request.getParameter("userId") : 
	<%= request.getParameter("userId")%>
	<br><br>
	<%-- 현재 userId param이 2개 이므로, 첫번째 값을 출력한다. --%>
	
	String[]을 반환한다.
	request.getParameterValues("userId") : 
	<%=request.getParameterValues("userId")%>
	<%-- 위와 같이 그대로 작성하면, String 주소값만을 반환한다. --%>
	<%
		String[] userIds = request.getParameterValues("userId");
		for(String userId : userIds){
	%>
		(<%=userId%>)
		<br><br>
	<% 	
		}
	%>
	parameterMap : Map<String, String[]>
	request.getParameterMap() : <%= request.getParameterMap() %><br><br>
	
	요청에 존재하는 파라미터 이름 출력하기
	<%
		Map<String, String[]> params = request.getParameterMap();
		Set<String> keyset = params.keySet();
		for (String key : keyset){
	%>
		<%=key%>
	<%
		}
	%>
</body>
</html>