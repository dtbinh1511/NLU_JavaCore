package bai_6;

import java.io.File;

public class deleteExtension {
	public static void deleteAll(String path, String... exts) {
		File folder = new File(path);
		if (folder.exists() && folder != null) {
			File[] files = folder.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					deleteAll(file.getAbsolutePath(), exts);
				} else {
					for (int i = 0; i < exts.length; i++) {
						if (file.getAbsolutePath().endsWith(exts[i])) {
							file.delete();
						}
					}
				}
			}
		}
//		System.err.println("Path is not find");
	}

	public static void main(String[] args) {
		String path = "E:\\java\\hocKy5\\visual";

		deleteAll(path, ".txt", ".docx" ,".pptx" ,".pub",".xlsx");
	}
}
