package bai_5;

import java.io.File;

public class FileOperation {
	public static void dirStat(String path) {
		System.out.println("Total data by bytes: "+ dirStat(path, 0) +" bytes");
	}

	public static long dirStat(String path, long sum) {
		File folder = new File(path);
		if (!folder.exists()) {
			System.err.println("Path is not find");
		}

		if (folder != null) {
			File[] files = folder.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					sum += file.length();
				}
				if (file.isDirectory()) {

					sum = dirStat(file.getAbsolutePath(), sum);
				}

			}
		}
		return sum;

	}

	public static void main(String[] args) {
		String path = "D:\\01. document university\\01. FIT Store NLU\\CauTrucDuLieu";
		dirStat(path);
	}
}
