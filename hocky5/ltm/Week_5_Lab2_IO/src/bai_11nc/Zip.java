package bai_11nc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Zip {

	public static void pack(String sfolder, String archiveName) throws IOException {
		List<FileEntry> header = new ArrayList<FileEntry>();

		RandomAccessFile raf = new RandomAccessFile(archiveName, "rw");

		long headerPosition = packHelper(header, raf, sfolder, archiveName);
		raf.writeInt(header.size());
		for (FileEntry fileEntry : header) {
			raf.writeUTF(fileEntry.name);
			raf.writeLong(fileEntry.position);
			raf.writeLong(fileEntry.size);
		}
		raf.writeLong(headerPosition);
		raf.close();

	}

	public static long packHelper(List<FileEntry> header, RandomAccessFile raf, String sfolder, String archiveName)
			throws IOException {
		File folder = new File(sfolder);
		if (!folder.exists() || folder.listFiles() == null)
			return 0;

		int byteread;
		byte[] data = new byte[102400];
		FileInputStream fis;
		// Data
		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				packHelper(header, raf, file.getAbsolutePath(), archiveName);
			} else {
				// create file entry
				header.add(new FileEntry(file.getName(), raf.getFilePointer(), file.length()));
				// store data
				fis = new FileInputStream(file);
				while ((byteread = fis.read(data)) != -1) {
					raf.write(data, 0, byteread);
				}
				fis.close();
			}
		}
		// Header
		long headerPosition = raf.getFilePointer();

		return headerPosition;
	}

	public static void unpack(String archiveName, String path, String fileName) throws IOException {
		File archive = new File(archiveName);
		if (!archive.exists())
			return;

		RandomAccessFile raf = new RandomAccessFile(archiveName, "rw");
		// load header
		long actPosition = raf.length() - 8;
		raf.seek(actPosition);
		long headerPosition = raf.readLong();
		raf.seek(headerPosition);

		int fileNum = raf.readInt();
		List<FileEntry> header = new ArrayList<FileEntry>();
		for (int i = 0; i < fileNum; i++) {
			header.add(new FileEntry(raf.readUTF(), raf.readLong(), raf.readLong()));
		}

		// find file

		for (FileEntry fileEntry : header) {
			if (fileName.equalsIgnoreCase(fileEntry.name)) {
				// extract file
				raf.seek(fileEntry.position);
				FileOutputStream fos = new FileOutputStream(path);
				if (fileTransfer(raf, fos, fileEntry.size)) {
					fos.close();
					break;
				}
			}
			System.out.println(fileEntry.name + fileEntry.position + fileEntry.size);
		}
		raf.close();
	}

	private static boolean fileTransfer(RandomAccessFile fis, OutputStream fos, long pSize) throws IOException {
		int byteRead;
		long remain = pSize;
		byte[] data = new byte[102400];
		int requestNumber = (int) (remain < data.length ? remain : data.length);

		while ((byteRead = fis.read(data, 0, requestNumber)) != -1) {
			fos.write(data, 0, byteRead);
			remain = remain - byteRead;
			requestNumber = (int) (remain < data.length ? remain : data.length);
			if (requestNumber < 1) {
				return true;
			}
		}

		return false;

	}

	public static void main(String[] args) throws IOException {
		String sFolder = "D:\\01. document university\\01. FIT Store NLU\\Lap Trinh Mang\\test";
		String archiveName = "D:\\01. document university\\01. FIT Store NLU\\Lap Trinh Mang\\test.pack";
		pack(sFolder, archiveName);

		String fileName = "2- Module 1 - IO.pptx";
		String path = "D:\\01. document university\\01. FIT Store NLU\\Lap Trinh Mang\\" + fileName;
		unpack(archiveName, path, fileName);
	}
}
