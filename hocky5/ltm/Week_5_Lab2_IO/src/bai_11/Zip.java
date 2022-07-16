package bai_11;

import java.io.*;
import java.util.zip.DataFormatException;

public class Zip {
	public static void pack(String pathFolder, String archiveName) throws IOException {
		File dir = new File(pathFolder);
		if (!dir.exists())
			return;
		if (dir.isFile())
			return;

		File[] files = dir.listFiles();
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(archiveName));
		dos.writeInt(files.length);

		for (File file : files) {
			dos.writeUTF(file.getName());
			dos.writeLong(file.length());

			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

			int count;
			byte[] data = new byte[102400];
			while ((count = bis.read(data)) != -1)
				dos.write(data, 0, count);
			bis.close();
		}
		dos.close();
	}

	public static void unPack(String pathFolder, String archiveName) throws IOException {
		File dir = new File(pathFolder);
		if (!dir.exists())
			return;
		if (dir.isFile())
			return;

		DataInputStream dis = new DataInputStream(new FileInputStream(archiveName));
		int quantity = dis.readInt();

		for (int i = 0; i < quantity; i++) {
			String fName = dis.readUTF();
			long size = dis.readLong();

			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(pathFolder + "//unpack-" + fName));

			if (!writable(dis, bos, size))
				break;

			bos.close();
		}
		dis.close();
	}

	private static boolean writable(DataInputStream dis, BufferedOutputStream bos, long size) throws IOException {
		byte[] data = new byte[102400];
		int readByte;
		long remain = size;
		int requestNumber = (int) (remain < data.length ? remain : data.length);

		while ((readByte = dis.read(data, 0, requestNumber)) != -1) {
			bos.write(data, 0, readByte);
			remain -= readByte;
			requestNumber = (int) (remain < data.length ? remain : data.length);
			if (requestNumber < 1)
				return true;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		String sFolder = "E:\\Test\\Client";
		String archiveName = "E:\\Test\\Client.dat";
//		String fileName = "0 - Net.Programming - CourseInfo.pptx";
		long st = System.currentTimeMillis();
		pack(sFolder, archiveName);
		long et = System.currentTimeMillis();
		System.out.println("Time run: " + (et - st) + "ms");

//		st = System.currentTimeMillis();
//		unPack(pathFolder, archiveName);
//		et = System.currentTimeMillis();
//		System.out.println("Time run: " + (et - st) + "ms");
	}
}
