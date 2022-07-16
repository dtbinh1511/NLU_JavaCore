package bai_7;

import java.io.*;

public class copyExtension {
	public static void copyAll(String sDir, String dDir, String... exts) throws IOException {
		File srcFile = new File(sDir);

		File[] sourceFiles = srcFile.listFiles();
		if (sourceFiles != null) {
			for (String ext : exts) {
				for (File file : sourceFiles) {
					if (file.isFile() && file.getAbsolutePath().endsWith(ext)) {
						copyFile(file.getAbsolutePath(), dDir + "\\" + file.getName());
					}
					copyAll(file.getAbsolutePath(), dDir, exts);
				}
			}
		}

	}

	public static void copyFile(String sDir, String dDir) throws IOException {
		FileInputStream fis = new FileInputStream(sDir);
		FileOutputStream fos = new FileOutputStream(dDir);
		byte[] data = new byte[100 * 1024];
		int count = 0;

		while ((count = fis.read(data)) != -1)
			fos.write(data, 0, count);

		fis.close();
		fos.close();
	}

	public static void main(String[] args) throws IOException {
		String path_src = "E:\\java\\hocKy5\\visual1";
		String path_de = "E:\\java\\hocKy5\\visual";

		copyAll(path_src, path_de, ".docx", ".txt", ".pptx");
	}
}
