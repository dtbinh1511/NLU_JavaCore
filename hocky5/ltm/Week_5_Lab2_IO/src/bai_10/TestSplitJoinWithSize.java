package bai_10;

import java.io.IOException;

public class TestSplitJoinWithSize {

	public static void main(String[] args) throws IOException {
		String path = "E:\\java\\hocKy5\\visual1\\Scrum-Guide-US.pdf";
		String partName = "E:\\java\\hocKy5\\visual1\\Scrum-Guide-US.pdf.002";
		FileSplitJoin.splitFile(path, 100000);
		FileSplitJoin.joinner(partName);


//		 test split file from a to b
		String srcPath = "E:\\java\\hocKy5\\visual1\\Scrum-Guide-US.pdf";
		String dePath = "E:\\java\\hocKy5\\visual\\";
		
		String partName2 = "E:\\java\\hocKy5\\visual\\Scrum-Guide-US.pdf.002";
		String desName = "E:\\java\\hocKy5\\visual1\\";

		FileSplitJoin.splitFile(srcPath, dePath, 100000);
		FileSplitJoin.joinner(partName2, desName);
	}
}
