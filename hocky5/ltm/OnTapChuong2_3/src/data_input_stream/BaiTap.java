package data_input_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class BaiTap {
// pack
	public boolean pack(String sFolder, String archiveName) throws IOException {
		File dir = new File(sFolder);
		if (!dir.exists())
			return false;
		if (dir.isDirectory()) {
			File[] contents = dir.listFiles();
			if (contents != null) {

				DataOutputStream dos = new DataOutputStream(new FileOutputStream(archiveName));
				int byteRead;
				byte[] data = new byte[102400];

				dos.writeInt(contents.length);

				for (File file : contents) {
					if (file.isFile()) {
						dos.writeUTF(file.getName());
						dos.writeLong(file.length());
						BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

						while ((byteRead = bis.read(data)) != -1)
							dos.write(data, 0, byteRead);
						bis.close();
					} else
						dos.writeUTF(file.getName());
				}
				dos.close();
			}

		}

		return true;
	}

	// unpack
	public boolean unpack(String destFolder, String archiveName) throws IOException {
		File file = new File(archiveName);
		if (!file.exists())
			return false;
		File dir = new File(destFolder);
		if (!dir.exists())
			dir.mkdir();
		DataInputStream dis = new DataInputStream(new FileInputStream(archiveName));

		int quantity = dis.readInt();
		for (int i = 0; i < quantity; i++) {
			String name = dis.readUTF();
			long size = dis.readLong();

			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFolder + "\\unpack-" + name));
			if (!writable(dis, bos, size))
				break;
			bos.close();
		}
		dis.close();
		return true;
	}

	private boolean writable(DataInputStream dis, BufferedOutputStream bos, long size) throws IOException {
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

}
