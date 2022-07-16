package TCP_bai17;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class NetClient {

	public static void main(String[] args) {
		run();
	}

	public static void run() {
		try {
			Socket socket = new Socket("localhost", 12345);
			DataInputStream netIn = new DataInputStream(socket.getInputStream());
			DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());
			System.out.println(netIn.readUTF());
			while (true) {
				System.out.println("nhập copy source dest");

				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String line = reader.readLine();

				if (line.equalsIgnoreCase("quit")) {
					netOut.writeUTF(line);
					netOut.flush();
					break;
				}

				StringTokenizer token = new StringTokenizer(line);
				String command = token.nextToken();
				if (!command.equalsIgnoreCase("copy"))
					continue;

				String source = token.nextToken();
				String dest = token.nextToken();

				netOut.writeUTF(dest);
				netOut.flush();

				FileInputStream fis = new FileInputStream(source);
				int read;
				byte[] data = new byte[102400];

				while ((read = fis.read(data)) != -1) {
					netOut.write(data, 0, read);
					if (read < data.length)
						break;
				}
				fis.close();
			}
			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
