package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/memberUpdate")
@MultipartConfig
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(MemberUpdateServlet.class);
    MemberServiceI memberService;
    @Override
	public void init() throws ServletException {
    	memberService = new MemberService();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Update 페이지에 해당 회원의 정보를 불러와야 하므로, 먼저 id에 해당하는 MemberVo 객체를 불러와야 한다.
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		MemberVo memberVo = memberService.getMember(userid);
		request.setAttribute("memberVo", memberVo);
		
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		Part profile = request.getPart("realFilename");
		
		String realFileName = "";
		String fileName = "";
		String filePath = "";
		
		logger.debug("file : {}", profile.getHeader("Content-Disposition"));
		realFileName = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
		fileName = UUID.randomUUID().toString();
		
		logger.debug("realFileName : {} / fileName : {} ",realFileName, fileName);
		// 사용자가 사진을 변경하지 않았을 경우..
		if (realFileName.length() < 1) {
			filePath = request.getParameter("filename");  
			realFileName = request.getParameter("realFilename");
		
		// 사용자가 사진을 변경한 경우 ...
		}else {
			if (profile.getSize() > 0) {
				// 확장자는 어떻게 추출하는가?
				String extension = FileUploadUtil.getExtension(realFileName);
				filePath = "D:\\profile\\" + fileName+ "." + extension;
				profile.write(filePath);
			}
		}
		
		MemberVo memberVo = new MemberVo(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, realFileName);
		
		int updateCnt = memberService.updateMember(memberVo);
		
		if (updateCnt == 1) {
			response.sendRedirect(request.getContextPath() + "/member?userid="+userid);
		}
		// 정상적으로 회원가입이 진행되지 않은 경우
		else{	
			// 회원 가입 화면 요청
			doGet(request, response); 
		}
	}

}
