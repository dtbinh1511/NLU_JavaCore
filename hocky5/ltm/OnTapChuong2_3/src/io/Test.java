package io;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		BaiTap btchuong2 = new BaiTap();
		// copy file
//		String sFile = "E:\\Test\\Client2\\Test\\TS01CV.pdf";
//		String sFile = "E:\\Test\\TS01CV.pdf";
//		String destFile = "E:\\Test\\Client1\\Client2\\Test";
//		btchuong2.fileCopy(sFile, destFile, false);

		// copy folder

//		String sFolder = "E:\\Test\\Client2";
//		String destFolder = "E:\\Test\\Client1";
//		btchuong2.folderCopy(sFolder, destFolder, true);

		// split
//		String path ="E:\\Test\\Client\\Product.accdb";
//		btchuong2.spliter(path, 100000);

		// join
		String pathName = "E:\\Test\\Client\\Product.accdb.001";
		btchuong2.joiner(pathName);
	}
}
