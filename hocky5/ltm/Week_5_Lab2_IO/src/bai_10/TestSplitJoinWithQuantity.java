package bai_10;

import java.io.IOException;

public class TestSplitJoinWithQuantity {
	public static void main(String[] args) throws IOException {
//		String path = "E:\\java\\hocKy5\\visual1\\Scrum-Guide-US.pdf";
//		String partName = "E:\\java\\hocKy5\\visual1\\Scrum-Guide-US.pdf.002";
//
//		FileSplitJoin.splitFile(path, 2);
//		FileSplitJoin.joinner(partName);
		
		
		String srcPath = "E:\\java\\hocKy5\\visual1\\Scrum-Guide-US.pdf";
		String dePath = "E:\\java\\hocKy5\\visual\\";
		
		String partName2 = "E:\\java\\hocKy5\\visual\\Scrum-Guide-US.pdf.002";
		String desName = "E:\\java\\hocKy5\\visual1\\";

		FileSplitJoin.splitFile(srcPath, dePath, 10);
//		FileSplitJoin.joinner(partName2, desName);
		
//		giong giong size nhieu khi khong dung
	}
}
