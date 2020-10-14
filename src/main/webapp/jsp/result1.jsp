<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/sumCalculration">
	<label>시작</label>
	<input type="text" name="start"><br>
	
	<label>종료</label>
	<input type="text" name="end"><br>
	<br>
	<input type="submit" value="제출">
	</form>
</body>
</html>