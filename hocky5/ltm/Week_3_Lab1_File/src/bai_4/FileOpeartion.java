package bai_4;

import java.io.*;

public class FileOpeartion {
	public static void dirTree(String path) {
		dirTree(path, -1);
	}

	public static void dirTree(String path, int level) {
		File dir = new File(path);
		String space = "";

		if (dir.exists() && dir.listFiles() != null) {
			File[] files = dir.listFiles();
			level++;
			for (File file : files) {
				if (file.isDirectory()) {
					for (int i = 0; i < level; i++)
						space += "     ";
					if (level > 0) {
						if (file.isDirectory()) {
							System.out.println("" + space + "+--- " + file.getName());
							space = "";
						}
					} else {
						System.out.println("+--- " + file.getName());
						space = "";
					}
					dirTree(file.getAbsolutePath(), level);
				} else if (file.isFile()) {
					for (int i = 0; i < level; i++)
						space += "    ";
					if (level > 0) {
						System.out.println("|" + space + "+--- " + file.getName());
						space = "";
					} else {
						System.out.println("+--- " + file.getName());
						space = "";
					}

				}
			}
		}

	}

	public static void main(String[] args) {
		String path = "D:\\01. document university\\01. FIT Store NLU\\CauTrucDuLieu";
		dirTree(path);
	}
}
