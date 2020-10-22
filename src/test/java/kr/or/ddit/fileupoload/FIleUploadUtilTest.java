package kr.or.ddit.fileupoload;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileupload.FileUploadUtil;

public class FIleUploadUtilTest {
	private static final Logger logger = LoggerFactory.getLogger(FIleUploadUtilTest.class);
	
	@Test
	public void test() {
		/***Given***/
		String string = "form-data; name=\"img\"; filename=\"sally.png\"";
		/***When***/
		String result = FileUploadUtil.getFilename(string);
		/***Then***/
		assertEquals("sally.png", result);
	}
	
	@Test
	public void UUIDTest() {
		/***Given***/
		

		/***When***/
		String uuid = UUID.randomUUID().toString();
		logger.debug("uuid : {}", uuid);
		/***Then***/
		
	}
	
	@Test
	public void ExtensionTest() {
		/***Given***/
		String example = "form-data; name=\"img\"; filename=\"sally.png\"";

		/***When***/	
		String result = example.valueOf(".png");
		/***Then***/
		logger.debug("extract result : {}", result);
	}
	
}
