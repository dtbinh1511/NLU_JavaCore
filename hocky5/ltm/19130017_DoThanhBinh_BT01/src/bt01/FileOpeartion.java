package bt01;

import java.io.*;

public class FileOpeartion {
	public static void dirTree(String path) {
		print(0, new File(path));
		dirTree(path, 0);
	}

	public static void dirTree(String path, int level) {
		File dir = new File(path);
		if (!dir.exists())
			System.err.println("Not find path");
		File[] files = dir.listFiles();
		if (files != null) {
			level++;
			for (File file : files) {
				if (file.isFile()) {
					print(level, file);
				} else if (file.isDirectory()) {
					print(level, file);
					dirTree(file.getAbsolutePath(), level);
				}
			}
		}

	}

	public static void print(int level, File file) {
		String character = createCharacter(level);
		if (level == 0)
			System.out.println(character + file.getName() + ": " + getSize(file.getAbsolutePath(), 0) + " bytes");
		if (level > 0)
			System.out.println(character + file.getName() + ": " + getSize(file.getAbsolutePath(), 0) + " bytes");
	}

	public static String createCharacter(int level) {
		String characters = "+-------";
		if (level > 0) {
			for (int i = 0; i < level; i++) {
				characters = "|        " + characters;
			}
		}
		return characters;
	}

	public static long getSize(String path, long size) {
		File dir = new File(path);
		if (!dir.exists())
			return 0;
		File[] files = dir.listFiles();
		if (files == null)
			return dir.length();
		for (File file : files) {
			if (file.isFile()) {
				size += file.length();
			} else if (file.isDirectory()) {
				 getSize(file.getAbsolutePath(), size);
			}
		}

		return size;
	}

	public static void main(String[] args) {
		String path = "E:\\Test\\Client1";
		dirTree(path);

	}
}
