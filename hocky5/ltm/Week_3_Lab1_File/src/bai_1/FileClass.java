package bai_1;

import java.io.*;

public class FileClass {
	// xoa toan bo nhung gi co the
	public static boolean delete(String path) {
		File dir = new File(path); // lấy file
		if (!dir.exists())
			return true; // nếu không tồn tại -> đã xóa

		// nếu là thư mục
		if (dir.isDirectory()) {
			// lấy các file, thư mục trong thư mục
			File[] files = dir.listFiles();
			// kiểm tra null
			if (files != null) {
				for (File file : files) {
					// nếu là file
					if (file.isFile()) {
						file.delete();
					}
					delete(file.getAbsolutePath());
				}
			}
		}
		return dir.delete();
	}

	public static boolean deleteFile(String path) {
		File dir = new File(path);
		if (!dir.exists())
			return true;
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile() && file.getName().equals("Cloud_Cocoon_Mattress_78_x_60_x_8_00_LP2.jpg")) {
						file.delete();
					}
					deleteFile(file.getAbsolutePath());
				}
			}
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String path = "E:\\java\\hocKy5\\ltw\\images";

		System.out.println(deleteFile(path));
	}
}
