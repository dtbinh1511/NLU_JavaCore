package bai_7;

import java.io.File;

public class Test {
	public static void check(String destFolder) {
		File file = new File(destFolder);
		if (!file.exists()) {
			file.mkdir();
		}
		if (file.isDirectory()) {
			System.out.println("directory");
		}
		System.out.println(file);
	}

	public static void main(String[] args) {
		String destFolder = "E:\\Test4";
		check(destFolder);
	}
}
