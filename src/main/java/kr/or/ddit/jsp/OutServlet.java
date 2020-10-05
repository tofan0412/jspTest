package kr.or.ddit.jsp;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.ranger.service.RangerService;
import kr.or.ddit.ranger.service.RangerServiceI;

@WebServlet("/outServlet")
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ranger 정보 조회
		RangerServiceI rangerService = new RangerService();
		
		// newArrayList<>(); 를 통해 미리 객체를 생성하는 방법은 지양
		List<String> rangers = rangerService.getRangers();
		
		request.setAttribute("rangers", rangers);
		
		// 다음과 같이 해도 된다.
//		RequestDispatcher rd = request.getRequestDispatcher("path");
//		rd.forward(request, response);
		
		request.getRequestDispatcher("jsp/out.jsp").forward(request, response);
		// ranger 정보를 화면에 표현해줄 out.jsp 파일로 응답 생성을 위임
		// ranger 정보가 어딘가 담겨야 함
		// serlvet 에서는 3가지 scope가 사용가능하다.
		// request < session < application
		// 해당 요청은 일회성으로만 처리해주면 레인저 이름 정보를 보관할 필요가 없고
		// 다른 요청과 관련이 없으므로 request 객체가 적당하다.
		
		// serlvet 상에서 작성할 코드 
		// request 객체에 rangers라는 속성 이름으로 레인저 정보를 저장
		// out.jsp ( 아직 안 만듬 webapp/jsp/out.jsp에 생성 )로 요청 위임 (forward)
		// webapp은 ROOT로 인식하므로 그 이하의 주소만 작성하면 된다.
		
		// out.jsp에서는 rangers라는 속성을 꺼내서 loop를 돌며 화면에 출력
		// out 객체를 이용한다.
	}

	
}
