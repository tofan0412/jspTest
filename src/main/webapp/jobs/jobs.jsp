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
table {
	border-collapse: collapse;
}
</style>
<%@ include file="/layout/commonlib.jsp"%>
</head>
<body>
	<%@ include file="/layout/header.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/layout/left.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="blog-header">
					<h2 class="sub-header">사용자</h2>
				</div>
				<div class="row">
					<div class="col-sm-8 blog-main">
						<div class="blog-post">
							<%
								List<JobsVo> joblist = 
								(List<JobsVo>) request.getAttribute("joblist");
							%>
							<table border="1">
								<tr>
									<td><strong>JOB_ID</strong></td>
									<td><strong>JOB_TITLE</strong></td>
								</tr>
								<%
									for (JobsVo vo : joblist) {
								%>
								<tr>
									<td><%=vo.getJob_id()%></td>
									<td><%=vo.getJob_title()%></td>
								</tr>
								<%
									}
								%>
							</table>
						</div>
					</div>
					<!-- /.blog-main -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>