<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="<%=request.getContextPath()%>/scopeServlet">
		<input type="text" name="param"/><br>
		<input type="submit" value="제출">
	</form>
	
	
	request : <%= request.getAttribute("requestAttr") %><br>
	session : <%= session.getAttribute("sessionAttr") %><br>
	application : <%= application.getAttribute("applicationAttr") %> <br>
	
</body>
</html>