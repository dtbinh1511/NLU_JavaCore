package bai_10;

import java.io.*;
import java.util.Iterator;

public class FileSplitTutorial {

	public void spliter(String path, long pSize) throws IOException {

		FileInputStream fis = new FileInputStream(path);
		String destName;
		int count = 0;
		int data;
		boolean res;
		while (true) {
			count++;
			destName = path + extension(count);
			FileOutputStream fos = new FileOutputStream(destName);
			res = writeRead(fis, fos, pSize); // copy pSize
			fos.close();
			if (!res)
				break; // het data ket thuc
		}

		fis.close();

	}

	private boolean writeRead(InputStream is, OutputStream os, long pSize) throws IOException {
		int data;
		for (int i = 0; i < pSize; i++) {
			data = is.read();
			if (data == -1) {
				return false;
			}
			os.write(data);
		}
		return true;
	}

	private String extension(int count) {
		String extension = "" + count;
		if (extension.length() == 1)
			return ".00" + extension;
		else if (extension.length() == 2)
			return ".0" + extension;
		return "." + extension;
	}

	public void joinner(String partName) throws IOException {
		String path = partName.substring(0, partName.lastIndexOf("."));
		int count = 0;
		byte[] data = new byte[100 * 1024];
		int byteRead;
		FileOutputStream fos = new FileOutputStream(path);
		while (true) {
			count++;
			String sourceName = path + extension(count);
			File test = new File(sourceName);
			if (!test.exists())
				break;
			FileInputStream fis = new FileInputStream(sourceName);
			while ((byteRead = fis.read(data)) != -1)
				fos.write(data, 0, byteRead);
			fis.close();
		}
		fos.close();
	}

	public void main(String[] args) throws IOException {
		String sFile = "E:\\java\\hocKy5\\visual1\\te.docx";

		spliter(sFile, 100000);
	}
}
