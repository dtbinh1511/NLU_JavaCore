package bai_10;

import java.io.*;

public class FileSplitJoin {

//	chia 1 file thành nhiều phần theo dung lượng start
	// split file same path
	public static void splitFile(String path, long pSize) throws IOException {
		FileInputStream fis = new FileInputStream(path);

		String destName;
		int count = 0;
		boolean res;

		while (true) {
			count++;
			destName = path + extension(count); // ".00"

			FileOutputStream fos = new FileOutputStream(destName);
			res = fileTransfer(fis, fos, pSize);

			fos.close();
			if (!res)
				break;
		}

		fis.close();
	}

	// split file from a to b
	public static void splitFile(String srcPath, String dePath, long pSize) throws IOException {
		FileInputStream fis = new FileInputStream(srcPath);
		int count = 0;
		int data;
		String desName;
		boolean res;

		File sFile = new File(srcPath);
		while (true) {
			count++;
			desName = dePath + sFile.getName() + extension(count);
			FileOutputStream fos = new FileOutputStream(desName);
			res = fileTransfer(fis, fos, pSize);
			fos.close();
			if (!res)
				break;
		}
		fis.close();

	}

//	private static boolean fileTransfer(InputStream fis, OutputStream fos, long pSize) throws IOException {
//		int data;
//
//		for (int i = 0; i < pSize; i++) {
//			data = fis.read();
//			if (data == -1) {
//				return false;
//			}
//			fos.write(data);
//		}
//		return true;
//	}

	private static boolean fileTransfer(InputStream fis, OutputStream fos, long pSize) throws IOException {
		int byteRead;
		long remain = pSize;
		byte[] data = new byte[102400];
		int requestNumber = (int) (remain < data.length ? remain : data.length);

		while ((byteRead = fis.read(data, 0, requestNumber)) != -1) {
			fos.write(data, 0, byteRead);
			remain = remain - byteRead;
			requestNumber = (int) (remain < data.length ? remain : data.length);
			if (requestNumber < 1) {
				return true;
			}
		}

		return false;

	}

	private static String extension(int count) {
		// chay toi 999
		String ext = "" + count;
		if (ext.length() == 1)
			return ".00" + ext;
		if (ext.length() == 2)
			return ".0" + ext;
		return "." + ext;
	}

	public static void joinner(String partName) throws IOException {
		int count = 0;
		byte[] data = new byte[102400];
		int byteRead;
		String sourceName;
		String path = partName.substring(0, partName.lastIndexOf("."));

		FileOutputStream fos = new FileOutputStream(path);
		while (true) {
			count++;
			sourceName = path + extension(count);

			if (!new File(sourceName).exists())
				break;

			FileInputStream fis = new FileInputStream(sourceName);
			while ((byteRead = fis.read(data)) != -1)
				fos.write(data, 0, byteRead);
			fis.close();
		}
		fos.close();
	}

	public static void joinner(String partName, String desName) throws IOException {
		String path = partName.substring(0, partName.lastIndexOf("."));
		String sourceName;
		byte[] data = new byte[102400];
		int count = 0;
		int byteRead;
		File file = new File(path);

		FileOutputStream fos = new FileOutputStream(desName + file.getName());

		while (true) {
			count++;
			sourceName = path + extension(count);
			if (!new File(sourceName).exists())
				break;
			FileInputStream fis = new FileInputStream(sourceName);
			while ((byteRead = fis.read(data)) != -1)
				fos.write(data, 0, byteRead);
			fis.close();
		}
		fos.close();
	}

//	chia 1 file thành nhiều phần theo dung lượng end

//	chia 1 file thành nhiều phần theo số lượng start
	public static void splitFile(String path, int quantity) throws IOException {
		FileInputStream fis = new FileInputStream(path);

		File file = new File(path);
		long size = file.length() / quantity;
		int count = 0;
		String desName;
		boolean res;

		while (true) {
			count++;
			desName = path + extension(count);
			FileOutputStream fos = new FileOutputStream(desName);
			res = fileTransfer(fis, fos, size);
			fos.close();
			if (!res)
				break;
		}

		fis.close();
	}

	public static void splitFile(String srcPath, String dePath, int quantity) throws IOException {
		FileInputStream fis = new FileInputStream(srcPath);

		File file = new File(srcPath);
		long size = file.length() / quantity;
		int count = 0;
		String desName;
		boolean res;

		while (true) {
			count++;
			desName = dePath + file.getName() + extension(count);
			FileOutputStream fos = new FileOutputStream(desName);
			res = fileTransfer(fis, fos, size);
			fos.close();
			if (!res)
				break;
		}

		fis.close();
	}

//	chia 1 file thành nhiều phần theo dung lượng end

}
