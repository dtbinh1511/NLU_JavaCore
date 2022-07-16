package TCP_bai18;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 12345);
			DataInputStream netIn = new DataInputStream(socket.getInputStream());
			DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());
			System.out.println(netIn.readUTF());
			while (true) {
				System.out.println("Nhập: get source dest");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String line = reader.readLine();
				if (line.equalsIgnoreCase("quit")) {
					netOut.writeUTF(line);
					netOut.flush();
					break;
				}
				StringTokenizer token = new StringTokenizer(line);
				String command = token.nextToken();
				if (!command.equalsIgnoreCase("get")) {
					System.out.println("Sai cú pháp");
					continue;
				}
				String source = token.nextToken();
				netOut.writeUTF(source);
				netOut.flush();
				String dest = token.nextToken();

				FileOutputStream fos = new FileOutputStream(dest);
				int readByte;
				byte[] data = new byte[102400];
				while ((readByte = netIn.read(data)) != -1) {
					fos.write(data, 0, readByte);
					if (readByte < data.length)
						break;
				}
				fos.close();
			}

			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
