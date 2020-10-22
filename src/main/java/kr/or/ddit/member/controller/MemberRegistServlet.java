package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileupload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/memberRegist")
@MultipartConfig
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MemberRegistServlet.class);
    MemberServiceI memberService;
    @Override
    public void init() throws ServletException {
    	memberService = new MemberService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/member/memberRegist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 필터를 이용하면 이 작업을 한 번만 해도 된다.
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String pass = request.getParameter("pass");
		String zipcode = request.getParameter("zipcode");
		logger.debug("parameter : {},{},{},{},{},{},{}", 
				userid,usernm,alias, addr1, addr2, pass, zipcode);
		
		// 사용자가 등록한 파일 정보 불러오기.
		Part profile = request.getPart("realFilename");
		// 파일 이름이 담겨져 있는 곳..
		logger.debug("file : {}", profile.getHeader("Content-Disposition"));
		String realFileName = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
		String fileName = UUID.randomUUID().toString();
		
		String filePath = "";
		if (profile.getSize() > 0) {
			// 확장자는 어떻게 추출하는가?
			String extension = FileUploadUtil.getExtension(realFileName);
			filePath = "D:\\profile\\" + fileName+ "." + extension;
			profile.write(filePath);
		}
		
		// 사용자 정보 등록
		MemberVo memberVo = new MemberVo(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, realFileName);
		
		int insertCnt = memberService.insertMember(memberVo);
		logger.debug("insertCnt : {}", insertCnt);
		
		// 1건이 입력되었을 때, 정상 -> memberList 페이지로 이동한다. 
		if (insertCnt == 1) {
			// request.getRequestDispatcher("/memberList").forward(request, response);
			// 위와 같이 서블릿으로 전송하면, 현재 서블릿에서 doPost를 통해 처리하였기 때문에 해당 서블릿에서도 doPost를
			// 통해 처리할 것이다.
			
			// 서버의 상태가 바뀔 때는 redirect를 이용한다.
			response.sendRedirect(request.getContextPath() + "/memberList");
		}
		// 정상적으로 회원가입이 진행되지 않은 경우
		else{	
			// 회원 가입 화면 요청
			doGet(request, response); 
		}
		
	}
}
