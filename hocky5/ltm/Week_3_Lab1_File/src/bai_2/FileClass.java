package bai_2;

import java.io.File;

public class FileClass {

	public static void findAll(String path, String... exts) {
		File dir = new File(path);
		if (!dir.exists())
			System.err.println("Path is not find");
		else {
			File[] files = dir.listFiles();
			if (files != null) {
				for (File file : files) {
					for (int i = exts.length - 1; i >= 0; i--) {
						if (file.getAbsolutePath().endsWith(exts[i])) {
							System.out.println(file.getAbsolutePath());
						}
					}
					findAll(file.getAbsolutePath(), exts);
				}
			}
		}
	}

	public static void main(String[] args) {
		String path = "D:\\01. document university";
		findAll(path, "pptx", "docx", "txt" );
	}
}
