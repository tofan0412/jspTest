<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// No modifications are allowed to a locked ParameterMap라는 메시지와 함께 500에러 출력
		Map<String, String[]> map = request.getParameterMap();
		map.put("newParameter", new String[]{"sally"});
		out.print(request.getParameter("newParameter"));
	%>
</body>
</html>