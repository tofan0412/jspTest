<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<script type="text/javascript">
	$(function(){
		$('.radio').on('click',function(){
	 		type = $('input[name="selectType"]:checked').val();
	 		$('form').attr('method',type);
	 		
		})
	})
</script>
<title>GetRequestView</title>
</head>
<body>
	<%-- 파라미터 : client 서버로 요청을 보낼 때 추가적으로 보낸 값
					ex) 로그인 요청시 사용자의 id와 비밀번호
		파라미터는 내부적으로 Map<String, String[]> 객체로 관리를 한다. 
		=> 동일한 이름의 파라미터를 여러 개 보낼 수 있다.
		request 객체에 있는 파라미터 관련 메서드 4가지
		
		1. String getParameter(String param) : param에 해당하는 파라미터 값을 조회한다. 
			파라미터맵에서 첫번째 값을 반환한다.
			
		2. String[] getParameterValues(String param) : param에 해당하는 모든 파라미터 값을 반환한다.
		Map<String, String[]> getParamterMap() : request 객체에 생성된 파라미터 맵을 반환한다.
		
		3. Enumeration<String> getParameterNames() : request 객체에 담긴 모든 파라미터 이름을 반환 
	 --%>
	 
	 <%-- action : 요청을 보낼 경로를 의미한다. 
	 	method : 요청 방식으로, form 태그에서는 GET, POST 2가지만 가능하다. 
	 			DEFAULT는 GET이다.
	 			
	 			
	 한글 파라미터 설정
	 	get : server.xml <Connector URIEncoding="utf-8">
	 	post : request.setCharacterEncoding("utf-8");
	 			request.getParameter() 메서드를 호출하기 전에 설정을 해줘야 한다. 
	 --%>
	 
	 <form action="/jsp/request/getRequestResponse.jsp">
		 <label>user id</label>
		 <input type="text" id="id" name="userId" value="brown">
		 <br>
		 
		 <label>user id</label>
		 <input type="text" id="id" name="userId" value="sally">
		 <br>
		 
		 <label>password</label>
		 <input type="password" id="pass" name="password" value="pass1234">
		 <br>
		 <input type="submit" value="전송"/>
	 </form>
	 
	  <!--  GET POST 두 가지를 선택할 수 있는 라디오 버튼을 만들어서
 	  FORM 전송시 사용자가 GET, POST 방식을 지정할 수 있도록 설정한다.--> 
	 <label>전송방식 선택</label>
	 GET<input type="radio" class="radio" name="selectType" value="GET">
 	 POST<input type="radio" class="radio" name="selectType" value="POST">
	 <br>
</body>
</html>