<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>요청 헤더 정보 출력(헤더정보 빼내기)</h4><br>
	<%
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()){
			String header = headers.nextElement();
			%>
			
			<%=header%> : <%= request.getHeader(header) %> <br> 
	<%		
		}
	%>
</body>
</html>