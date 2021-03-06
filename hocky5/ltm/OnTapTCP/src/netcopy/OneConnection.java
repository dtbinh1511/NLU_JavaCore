package netcopy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class OneConnection extends Thread {

	DataInputStream dis;
	DataOutputStream dos;
	Socket socket;

	public OneConnection(Socket socket) throws IOException {
		this.socket = socket;
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("Connected");
	}

	public void run() {
		try {
			while (true) {
				// 1, nhận file name
				String receive = dis.readUTF();
				if (receive.equalsIgnoreCase("quit")) {
					break;
				}
				// 2, tạo file đích
				FileOutputStream fos = new FileOutputStream(receive);
				// 3, nhận dữ liệu từ client
				// 4, đọc ghi dữ liệu
				int byteRead;
				byte[] buffers = new byte[100 * 1024];
				while ((byteRead = dis.read(buffers)) != -1) {
					fos.write(buffers, 0, byteRead);
					if (byteRead < buffers.length) // ??
						break;
				}
				// 5, đóng file đích
				fos.close();
			}
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
