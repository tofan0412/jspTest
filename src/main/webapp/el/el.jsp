<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language example page</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/el">
	
	<% 
	   String scope = request.getParameter("scope");
	   String requestParam = "";
	   String sessionParam = "";
	   String applicationParam = "";
		
	   if (scope != null){
		   if(scope.equals("requestValue")){
				requestParam = "checked";
			}else if (scope.equals("sessionValue")){
				sessionParam = "checked";
			}else if (scope.equals("applicationValue")){
				applicationParam = "checked";
			}else{
				requestParam ="checked";
			}
	   }
	%>
	request(request)	: <input type="radio" name="scope" value="requestValue" <%=requestParam %>/><br> 
	session(request, session) 	: <input type="radio" name="scope" value="sessionValue" <%=sessionParam %>/><br>
	application(request, session, application) : <input type="radio" name="scope" value="applicationValue" <%=applicationParam%>/><br>
	<button type="sumbint">전송</button>
	</form>
	
	attr : ${attr } (page -> request -> session -> application 순으로 검색) <br>
	requestScope : ${requestScope.attr } <br>
	sessionScope : ${sessionScope.attr } <br>
	aplicationScope : ${applicationScope.attr } <br><br>
	scope parameter : <%=request.getParameter("scope") %>
	scope parameter : ${param.scope }<br><br>
	
	cookie : <%= request.getCookies() %> <br>
	cookie : ${cookie.userid.value }<br>
	
	<strong>Map</strong><br>
	rangers.brown : ${rangers.brown }<br>
	rangers.sally : ${rangers.sally }<br><br>
	
	<strong>list[0] => MemberVo / list[인덱스].필드</strong><br>
	rangersList[0].userid : ${rangersList[0].userid }<br>
	rangersList[1].pass : ${rangersList[0].pass}<br>
	
	
</body>
</html>