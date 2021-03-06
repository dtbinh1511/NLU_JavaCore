package netcopy;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		run();
	}

	public static void run() {
		try {
			// kết nối server qua socket
			Socket socket = new Socket("localhost", 12345);

			// tạo I/O Stream thao tác với text & binary
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

			// in ra thông báo đã kết nối
			System.out.println(dis.readUTF());

			while (true) {
				// lấy dữ liệu nhập vào từ client
				System.out.println("nhập copy source dest: copy source_file dest_file");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String line = reader.readLine();

				if (line.equalsIgnoreCase("quit")) {
					dos.writeUTF("quit");
					dos.flush();
					break;
				}

				StringTokenizer token = new StringTokenizer(line);
				String command = token.nextToken();
				if (!command.equalsIgnoreCase("copy"))
					continue;

				String sourceFile = token.nextToken();
				String destFile = token.nextToken();

				// mở file
				FileInputStream fis = new FileInputStream(sourceFile);

				// gửi filename đến server
				dos.writeUTF(destFile);
				dos.flush();

				// đọc file nguồn và gửi dữ liệu lên server
				byte[] buffers = new byte[102400];
				int byteRead;
				while ((byteRead = fis.read(buffers)) != -1) {
					// gửi dữ liệu lên server
					dos.write(buffers, 0, byteRead);
				}

				fis.close();
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
