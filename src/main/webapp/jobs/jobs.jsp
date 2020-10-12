<%@page import="kr.or.ddit.jobs.model.JobsVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JobsList 출력</title>
<style type="text/css">
table{
	border-collapse: collapse;
}

</style>
</head>
<body>
	<%
		List<JobsVo> joblist = (List<JobsVo>)request.getAttribute("joblist");
	%>
	<table border="1">
		<tr>
			<td><strong>JOB_ID</strong></td>
			<td><strong>JOB_TITLE</strong></td>
		</tr>
		<% for (JobsVo vo : joblist){%>		
		<tr>
			<td><%=vo.getJob_id()%></td>
			<td><%=vo.getJob_title() %></td>
		</tr>
		<%}%>
	</table>
</body>
</html>