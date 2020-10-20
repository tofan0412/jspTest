<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.model.MemberVo"%>
<%@page import="kr.or.ddit.member.service.MemberService"%>
<%@page import="kr.or.ddit.member.service.MemberServiceI"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table{
border-collapse : collapse;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<strong>users 테이블의 모든 데이터를 화면에 출력한다. </strong><br>
	
	<strong>MemberService 객체를 통해 DB에서 데이터를 조회하고 
	request 객체에 memberList라는 이름으로 저장한다. </strong><br><br>
	<%	MemberServiceI memberService = new MemberService();
		request.setAttribute("memberList", memberService.getMemberAll());
	%>
	<table border="1">
	<tr><th>사용자ID</th><th>비밀번호</th></tr>
	<c:forEach items="${memberList }" var="member">
		<tr>
		<td>${member.userid }</td>
		<td>${member.pass }</td>
		</tr>
	</c:forEach>
	</table>
	
	<h3>위의 로직을 스크립틀릿과 표현식을 통해 재작성한다면 다음과 같다.</h3>
	<table border="1">
	<tr><th>사용자ID</th><th>비밀번호</th></tr>
	<% 
	List<MemberVo> memberList = (List<MemberVo>)request.getAttribute("memberList"); 
	for(MemberVo member : memberList){
	%>
		<tr>
			<td><%=member.getUserid()%></td>
			<td><%=member.getPass() %></td>
		</tr>	
	<%}%>
	</table>
	
	<h3>forEach 태그의 일반 for문 작성</h3>
	<c:forEach var="i" begin="0" end="10" step="1" varStatus="status">
		i : ${i } / ${status.index }, ${status.count } <br>
	</c:forEach>
	
	
	<h3>forEach를 통해 map에 담긴 데이터 또한 출력 가능하다.</h3>
	<% Map<String, String> map = new HashMap<String, String>(); 
		map.put("name", "브라운");
		map.put("id", "brown");
		map.put("alias", "곰");
		request.setAttribute("map", map);
		
		Set<String> keys = map.keySet();	// key값을 모아놓은 집합 객체..
		
		Iterator<String> iterator = keys.iterator();	// iterator : 반복자
		while(iterator.hasNext()){
			String key = iterator.next();
			out.print(key + "<br>");
		}
	%>
	<br><br>
	
	<c:forEach items="${map }" var="m">
		${m.key } / ${m.value } <br>
	</c:forEach>
	
	<br><br><br><br><br><br><br><br><br><br>
	
</body>
</html>