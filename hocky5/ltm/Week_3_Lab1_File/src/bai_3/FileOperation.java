package bai_3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {
	public static List<String> findAll(String path, String pattern) {
		File folder = new File(path);
		String[] splits = pattern.split("\\*");
		List<String> listString = new ArrayList<String>();

		if (!folder.exists())
			return null;
		if (folder != null) {
			File[] files = folder.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					for (int i = 0; i < splits.length; i++) {
						if (file.getName().startsWith(splits[0])) {
							listString.add(file.getName());
						}
						if (splits[0] == "" && file.getName().endsWith(splits[1])) {
							listString.add(file.getName());
						}
					}
				}
				if (file.isDirectory()) {
					findAll(file.getAbsolutePath(), pattern);
				}
			}
		}
		return listString;
	}

// way master
	private static boolean accept(String fileName, String pattern) {
		// 0: không chứa *
		// 1: * ở đầu
		// 2: * ở cuối
		// 3: chỉ có *

		String checkString = "";

		if (pattern.startsWith("*")) {
			checkString = pattern.substring(1);
			return fileName.endsWith(checkString);
		} else if (pattern.endsWith("*")) {
			checkString = pattern.substring(0,pattern.length() - 1);
			return fileName.startsWith(checkString);
		} else {// không chứa
			checkString = pattern;
			return fileName.equals(checkString);
		}
	}

	public static List<String> findAlls(String path, String pattern) {
		List<String> list = new ArrayList<String>();
		findHelper(list, path, pattern);
		return list;  
	}

	private static void findHelper(List<String> list, String path, String pattern) {
		File dir = new File(path);
		if (dir.isFile()) {
			if (accept(dir.getName(), pattern)) {
				list.add(dir.getName());
			}
		} else if (dir.isDirectory()) {
			File[] content = dir.listFiles();
			if (content != null)
				for (File file : content)
					findHelper(list, file.getAbsolutePath(), pattern);
		}
	}

	public static void main(String[] args) {
		String path = "D:\\01. document university\\01. FIT Store NLU\\CauTrucDuLieu";
		String pattern1 = "5 - Linked List.pdf";
		String pattern2 = "*f";
		String pattern3 = "5*";
		String pattern4 = "*";

		List<String> arrayList = new ArrayList<String>();
		arrayList.addAll(findAlls(path, pattern3));

		for (int i = 0; i < arrayList.size(); i++) {
			String string = arrayList.get(i);
			System.out.println(string);
		}
	}
}
