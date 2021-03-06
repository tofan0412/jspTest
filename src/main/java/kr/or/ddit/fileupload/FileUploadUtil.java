package kr.or.ddit.fileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUploadUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtil.class);
	//form-data; name="img"; filename="sally.png"
	// ==> sally.png
	
	//FileUploadUtilTest
	public static String getFilename(String contentDisposition) {
		String filename = "";
		String[] values = contentDisposition.split("; ");
		
		logger.debug("values : {}", values);
		
		for (String index : values) {
			String[] value = index.split("=");
			if (value[0].equals("filename")){
//				filename = value[1];
				return value[1].replaceAll("\"", "");
			}
		}
		return filename;
	}
	
	//filename : sally.png => png
	public static String getExtension(String filename) {
//		String extension = "null";
//		
//		if (extension.equals("null")) {
//			extension = filename.valueOf(".jpg");
//		}
//		if (extension.equals("null")) {
//			extension = filename.valueOf(".jpeg");
//		}
//		if (extension.equals("null")) {
//			extension = filename.valueOf(".png");
//		}
//		return extension;
		
		if(filename == null || filename.indexOf(".") == -1) {
			return "";
		}else {
			return filename.split("\\.")[1];
		}
	}
	
	
	
	
}
