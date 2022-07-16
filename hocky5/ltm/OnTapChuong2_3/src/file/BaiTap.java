package file;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaiTap {

	// xóa tất cả file và thư mục từ đư�?ng dẫn
	public boolean delete(String path) {
		File dir = new File(path);
		if (!dir.exists())
			return true;
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			if (files != null) { // check io
				for (File file : files) {
					delete(file.getAbsolutePath());
				}
			}
		}

		return dir.delete();
	}

	// xóa chỉ file
	public boolean deleteFile(String path) {
		File dir = new File(path);
		if (!dir.exists())
			return true;
		if (dir.isDirectory()) {
			File[] list = dir.listFiles();
			for (File file : list)
				if (file != null) {
					deleteFile(file.getAbsolutePath());
				}
		} else if (dir.isFile())
			return dir.delete();
		return true;
	}

	// tìm kiếm với phần mở rộng
	public void findAll(String path, String... exts) {
		File dir = new File(path);
		if (!dir.exists())
			System.out.println("�?ư�?ng dẫn không tồn tại");
		if (dir.isDirectory()) {
			File[] list = dir.listFiles();
			for (File file : list) {
				if (file != null) {
					String fileName = file.getName();
					for (String ext : exts) {
						if (fileName.endsWith(ext)) {
							System.out.println(file.getAbsolutePath());
						}
					}
					findAll(file.getAbsolutePath(), exts);
				}
			}
		}
	}

	// tìm kiếm với 1 dấu *

	// th1 = không chứa *
	// th1 = * ở đầu
	// th2 = * ở cuối
	// th3 = chỉ có sao

	private boolean accept(String fileName, String pattern) {
		String check = "";
		if (pattern.equals("*")) {
			return true;
		} else if (pattern.startsWith("*")) {
			check = pattern.substring(1);
			return fileName.endsWith(check);
		} else if (pattern.endsWith("*")) {
			check = pattern.substring(0, pattern.length() - 1);
			return fileName.startsWith(check);
		} else {// không chứa *
			check = pattern;
			return fileName.equals(check);
		}
	}

	public List<String> findAll(String path, String pattern) {
		List<String> list = new ArrayList<String>();
		findHelper(list, path, pattern);
		return list;
	}

	public void findHelper(List<String> list, String path, String pattern) {
		File dir = new File(path);
		if (!dir.exists()) {
			System.out.println("�?ư�?ng dẫn không tồn tại");
		} else if (dir.isFile()) {
			if (accept(dir.getName(), pattern))
				list.add(dir.getAbsolutePath());
		} else if (dir.isDirectory()) {
			File[] contents = dir.listFiles();
			if (contents != null)
				for (File file : contents)
					findHelper(list, file.getAbsolutePath(), pattern);
		}
	}

	public void printList(List<String> list) {
		for (String item : list) {
			System.out.println(item);
		}
	}

	// hiển thị cấu trúc thư mục
	public void dirTree(String path) {
		printTree(0, new File(path));
		dirTree(0, path);
	}

	private void dirTree(int node, String path) {
		File dir = new File(path);
		if (!dir.exists())
			System.out.println("�?ư�?ng dẫn không tồn tại");

		if (dir.isDirectory()) {
			File[] contents = dir.listFiles();
			if (contents != null) {
				node++;
				for (File file : contents) {
					if (file.isFile()) {
						printTree(node, file);
					} else if (file.isDirectory()) {
						printTree(node, file);
						dirTree(node, file.getAbsolutePath());
					}
				}
			}
		}

	}

	private void printTree(int node, File file) {
		String character = createCharacter(node);
		System.out.println(character + file.getName());
	}

	private String createCharacter(int node) {
		String characters = "+-----";
		if (node > 0) {
			for (int i = 0; i < node; i++) {
				characters = "|     " + characters;
			}
		}
		return characters;
	}

	// delete vơi file mở rộng
	public void deleteAll(String path, String... exts) {
		List<String> list = new ArrayList<String>();

		findAll(list, path, exts);
		for (String string : list) {
			File file = new File(string);
			file.delete();
		}
	}

	public void findAll(List<String> res, String path, String... exts) {
		File dir = new File(path);
		if (!dir.exists())
			System.out.println("�?ư�?ng dẫn không tồn tại");
		if (dir.isDirectory()) {
			File[] list = dir.listFiles();
			for (File file : list) {
				if (file != null) {
					String fileName = file.getName();
					for (String ext : exts) {
						if (fileName.endsWith(ext)) {
							res.add(file.getAbsolutePath());
						}
					}
					findAll(res, file.getAbsolutePath(), exts);
				}
			}
		}
	}
}
