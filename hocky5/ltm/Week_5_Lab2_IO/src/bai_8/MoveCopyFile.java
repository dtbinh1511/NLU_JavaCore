package bai_8;

import java.io.*;

public class MoveCopyFile {
	public static void fileCopy(String sFile, String destFile) throws IOException {
		FileInputStream fis = new FileInputStream(sFile);
		FileOutputStream fos = new FileOutputStream(destFile);

		byte[] data = new byte[100 * 1024];
		int count = 0;
		long st = System.nanoTime();
		while ((count = fis.read(data)) != -1)
			fos.write(data, 0, count);

		long et = System.nanoTime();
		System.out.println(" Time: " + (et - st) + "ms");
		fis.close();
		fos.close();
	}

	public static boolean fileCopy(String sFile, String destFile, boolean moved) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		byte[] data = new byte[100 * 1024];

		long startTime = System.nanoTime();
		int count = 0;
		if (!moved) {// copy
			while ((count = bis.read(data)) != -1)
				bos.write(data, 0, count);
		} else {// moved
			while ((count = bis.read(data)) != -1) {
				bos.write(data, 0, count);
			}
			File file = new File(sFile);
			if (file.isFile()) {
				file.delete();
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Time: " + (endTime - startTime) + "ns");
		bis.close();
		bos.close();
		return true;
	}

	public static void main(String[] args) throws IOException {
		String sFile = "E:\\Test\\Client2\\TS01CV.pdf";
		String destFile = "E:\\Test\\Client1\\TS01CV-copy.pdf";
		fileCopy(destFile, sFile, true);
	}
}
