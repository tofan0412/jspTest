<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- 응답을 엑셀 파일로 만들기 
    	1. jsp : contentType 수정, header 정보를 통해 파일명을 설정
    			주의점은 -> xls만 가능, xlsx는 html코드를 인식을 못함.
    			엑셀 파일 다운로드 기능을 빠르게 구현하고자 할 때 적당하다.
    	2. poi 라이브러리 : xls, xlsx 상관 없이 응답을 생성해 내는 것이 가능하다.
    			단점 -> 위의 방식에 비해 손이 많이 간다. 
    	3. itext 라이브러리 ... (스프링 최근 버전에서 지원이 중단되었다.)
    --%>
<% response.setHeader("Content-Disposition", "attachment; filename=excel.xls"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>excelResponse</title>
<style type="text/css">
	table{
		border-collapse : collapse;
	}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
		</tr>
		
		<tr>
			<th>brown</th>
			<th>브라운</th>
		</tr>
		
		<tr>
			<th>cony</th>
			<th>코니</th>
		</tr>
		
		<tr>
			<th>sally</th>
			<th>샐리</th>
		</tr>
	</table>
</body>
</html>