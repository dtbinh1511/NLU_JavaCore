package tinhtoan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client2 {
	public static void main(String[] args) {
		run();
	}

	private static void run() {
		try {
			// kết nối server
			Socket socket = new Socket("localhost", 12345);

			// khai báo I/O Stream
			BufferedReader netin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter netout = new PrintWriter(socket.getOutputStream(), true);
			System.out.println(netin.readLine());

			while (true) {
				// lấy dữ liệu từ người dùng
				BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
				String line = userIn.readLine();
				if (line.equalsIgnoreCase("quit")) {
					netout.println("quit");
					break;
				}
				// gửi dữ liệu lên server
				netout.println(line);

				// nhận dữ liệu
				String respone = netin.readLine();
				System.out.println(respone);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
