package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVo;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceI;

@WebServlet("/profileDownload")
public class ProfileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemberServiceI memberService;
    
    @Override
    public void init() throws ServletException {
    	memberService= new MemberService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 아이디 파라미터 확인하고
		String userid = request.getParameter("userid");
		
		// db에서 사용자 filename 확인
		MemberVo memberVo = memberService.getMember(userid);

		// response의 content-type 설정
		response.setHeader("Content-Disposition", "attachment; filename=\"\""+ memberVo.getRealFilename() + "\"");
		response.setContentType("application/octet-stream");
		
		// 경로 확인 후 파일 입출력을 통해 응답 생성
		// 파일 읽기
		// 응답 생성
		memberVo.getFilename();	// 파일 경로
		FileInputStream fis = new FileInputStream(memberVo.getFilename());
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while( fis.read(buffer) != -1) {	// 읽을 수 있는게 존재하는 동안..
			sos.write(buffer);
		}
		fis.close();
		sos.flush();	// 버퍼에 남아있는걸 전송
		sos.close();

	}
}