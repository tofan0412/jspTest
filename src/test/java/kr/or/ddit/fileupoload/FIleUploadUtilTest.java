package kr.or.ddit.fileupoload;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileupload.FileUploadUtil;

public class FIleUploadUtilTest {
	@Test
	public void test() {
		/***Given***/
		String string = "form-data; name=\"img\"; filename=\"sally.png\"";
		/***When***/
		String result = FileUploadUtil.getFilename(string);
		/***Then***/
		assertEquals("sally.png", result);
	}
}
