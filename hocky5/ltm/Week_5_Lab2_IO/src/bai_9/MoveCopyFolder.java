package bai_9;

import java.io.*;

public class MoveCopyFolder {
	public static boolean folderCopy(String sFolder, String destFolder, boolean moved) throws IOException {
		File sourceDir = new File(sFolder);
		String path = destFolder + "\\" + sourceDir.getName();

		if (!sourceDir.exists())
			return false;

		if (sourceDir.isDirectory()) {
			new File(path).mkdir();
		}

		File[] sFiles = sourceDir.listFiles();
		if (sFiles != null) {
			for (File sFile : sFiles) {
				if (sFile.isFile()) {
					copyFiles(sFile.getAbsolutePath(), path + "\\" + sFile.getName());
				} else {
					folderCopy(sFile.getAbsolutePath(), path, moved);
				}
			}
		}
		if (moved) {
			deleteFolder(sFolder);
		}
		return true;

	}

	public static void copyFiles(String sFile, String destFile) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		byte[] data = new byte[100 * 1024];

		int count = 0;

		while ((count = bis.read(data)) != -1)
			bos.write(data, 0, count);

		bis.close();
		bos.close();
	}

	public static void deleteFolder(String sFolder) {
		File dir = new File(sFolder);
		if (!dir.exists())
			System.err.println("Method delete not find path");
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile())
						file.deleteOnExit();
					deleteFolder(file.getAbsolutePath());
				}
			}
		}
		dir.delete();
	}

	public static void main(String[] args) throws IOException {
		String source = "E:\\java\\hocKy5\\visual1";
		String dest = "E:\\java\\hocKy5\\visual";

		folderCopy(source, dest, true);
	}
}
