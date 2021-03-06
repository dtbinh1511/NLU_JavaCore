package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BaiTap {
	// Viết CT copy/move file dùng byte array kết hợp với BIS, BOS:
	public boolean fileCopy(String sFile, String destFile, boolean moved) throws IOException {
		if (moved) {
			fileCopy(sFile, destFile);
			return delete(sFile);
		} else {
			fileCopy(sFile, destFile);
			return true;
		}
	}

	public boolean delete(String path) {
		File dir = new File(path);
		if (!dir.exists())
			return false;
		if (dir.isDirectory()) {
			File[] contents = dir.listFiles();
			if (contents != null) {
				for (File file : contents) {
					delete(file.getAbsolutePath());
				}
			}
		}

		return dir.delete();
	}

	private void fileCopy(String sFile, String destFile) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

		byte[] buffers = new byte[100 * 1024];
		int count = 0;

		while ((count = bis.read(buffers)) != -1) {
			bos.write(buffers, 0, count);
		}
		bis.close();
		bos.close();
	}

	// mở rộng với thư mục

	public boolean folderCopy(String sFile, String destFile, boolean moved) throws IOException {
		File sDir = new File(sFile);
		if (!sDir.exists())
			return false;

		if (sDir.isDirectory()) {
			String path = destFile + "\\" + sDir.getName();
			File desDir = new File(path);
			if (!desDir.exists())
				desDir.mkdir();
			File[] contents = sDir.listFiles();
			for (File file : contents) {
				if (file.isFile())
					fileCopy(file.getAbsolutePath(), path + "\\" + file.getName());
				else
					folderCopy(file.getAbsolutePath(), path, moved);
			}
		}

		if (moved) {
			return delete(sFile);
		}
		return true;
	}

	// tách thành nhiều file nhỏ
	public boolean spliter(String path, long pSize) throws IOException, FileNotFoundException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
		String destName;
		int count = 0;
		boolean res;
		while (true) {
			count++;
			destName = path + extension(count);
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destName));
			res = fileTranfers(bis, bos, pSize);
			bos.close();
			if (!res)
				break;
		}
		bis.close();
		return true;
	}

	private boolean fileTranfers(BufferedInputStream bis, BufferedOutputStream bos, long pSize) throws IOException {
		int byteRead;
		long remain = pSize;
		byte[] buffers = new byte[100 * 1024];

		int requestNumber = (int) (buffers.length > remain ? remain : buffers.length);

		while ((byteRead = bis.read(buffers, 0, requestNumber)) != -1) {
			bos.write(buffers, 0, byteRead);
			remain = remain - byteRead;
			requestNumber = (int) (buffers.length > remain ? remain : buffers.length);
			if (requestNumber < 1)
				return true;
		}
		return false;
	}

	private String extension(int count) {
		String ext = "" + count;
		if (ext.length() == 1) {
			return ".00" + ext;
		} else if (ext.length() == 2) {
			return ".0" + ext;
		}
		return "." + ext;
	}

	// join các file nhỏ thành file
	public void joiner(String pathName) throws IOException {
		String path = pathName.substring(0, pathName.lastIndexOf("."));
		int count = 0;
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path));

		int byteRead;
		byte[] buffers = new byte[100 * 1024];
		while (true) {
			count++;
			String sName = path + extension(count);
			if (!new File(sName).exists())
				break;

			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sName));

			while ((byteRead = bis.read(buffers)) != -1)
				bos.write(buffers, 0, byteRead);
			bis.close();

		}
		bos.close();
	}
}
