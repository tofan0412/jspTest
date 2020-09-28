<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- jsp 스크립트 : 서버에서 실행된다.
		<% %>, <%=%> 등...
		서버 쪽 변수에 클라이언트의 변수값을 대입하는 것은 불가능하다.
	 --%>
	 <%String str = "message"; %>
	 <%String str2 = ""; %>
	 <%String str3 = "Hello"; %>
	 
<script type="text/javascript">
	/* 서버 사이드 변수에 클라이언트 사이드 값을 대입하는 경우 (X)
	서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 안된다. */
	<%=str%> = 'test';
	//<%=str2%> = 'test';
	<%-- 서버 쪽 주석이다.. 개발자 도구 통해 확인하면 한 줄의 공백이 생김을 알 수 있다.--%>
	/* 클라이언트 사이드 변수에 서버 사이드 변수 값을 대입하는 경우.. 
		클라이언트가 나중에 실행되므로 가능하다. */
	
	var msg = '<%=str3%>';
	
</script>	
</body>
</html>