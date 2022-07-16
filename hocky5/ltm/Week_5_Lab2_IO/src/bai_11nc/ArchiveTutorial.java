package bai_11nc;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArchiveTutorial {
	public static void pack(String folder, String archive) throws IOException {
		List<FileEntry> header = new ArrayList<FileEntry>();
		long headerPosition;
//		long actPosition=0;
		RandomAccessFile raf = new RandomAccessFile(archive, "rw");

		File dir = new File(folder);
		if (!dir.exists() || dir.isFile())
			return;
		File[] files = dir.listFiles();
		if (files != null) {
			// Data
			for (File file : files) {
				// create file entry int header
				header.add(new FileEntry(file.getName(), raf.getFilePointer(), file.length()));
				// store data to archive
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				byte[] data = new byte[102400];
				int count;
				while ((count = bis.read(data)) != -1)
					raf.write(data, 0, count);
				bis.close();
			}
			// header
			headerPosition = raf.getFilePointer();
			raf.writeInt(header.size());
			for (FileEntry fileEntry : header) {
				raf.writeUTF(fileEntry.name);
				raf.writeLong(fileEntry.position);
				raf.writeLong(fileEntry.size);
			}
			raf.writeLong(headerPosition);
		}
		raf.close();
	}

	public static void unpack(String archive, String path, String extFile) throws IOException {
		List<FileEntry> header = new ArrayList<FileEntry>();
		long headerPosition;

		RandomAccessFile raf = new RandomAccessFile(archive, "rw");
		// load header
		long actPosition= raf.length() - 8;
		raf.seek(actPosition);
		headerPosition = raf.readLong();
		raf.seek(headerPosition);
		int fileNum = raf.readInt();
		for (int i = 0; i < fileNum; i++) {
			header.add(new FileEntry(raf.readUTF(), raf.readLong(), raf.readLong()));
		}
		
		// find file
		for (FileEntry fileEntry : header) {
		System.out.println(fileEntry.name);
		System.out.println(fileEntry.position);
		System.out.println(fileEntry.size);
		}

	}

	public static boolean fileTransfer(InputStream fis, RandomAccessFile raf, long pSize) throws IOException {
		int byteRead;
		long remain = pSize;
		byte[] data = new byte[102400];
		int requestNumber = (int) (remain < data.length ? remain : data.length);

		while ((byteRead = fis.read(data, 0, requestNumber)) != -1) {
			raf.write(data, 0, byteRead);
			remain = remain - byteRead;
			requestNumber = (int) (remain < data.length ? remain : data.length);
			if (requestNumber < 1) {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		String folder = "D:\\01. document university\\01. FIT Store NLU\\Lap Trinh Mang\\slide_2018";
		String archive = "D:\\01. document university\\01. FIT Store NLU\\Lap Trinh Mang\\slide_2018\\test.pack";
		pack(folder, archive);

//		String extFile = "file_api.docx";
//		String path = "D:\\01. document university\\01. FIT Store NLU\\Lap Trinh Mang\\slide_2018\\unpack--" + extFile;
//		unpack(archive, path, extFile);
	}
}
