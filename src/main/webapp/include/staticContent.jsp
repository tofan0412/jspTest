<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 여기에 include를 두면 html 태그가 2개 존재한다. 
	정적 include는 
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<%@include file="/include/header.jsp" %>
	</h1>
	staticContent.jsp
	param : : <%= request.getParameter("param") %>
</body>
</html>