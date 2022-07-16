package TCP_bai17;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class OneConnection {

	Socket socket;
	DataInputStream netIn;
	DataOutputStream netOut;

	public OneConnection(Socket socket) throws IOException {
		super();
		this.socket = socket;
		netIn = new DataInputStream(socket.getInputStream());
		netOut = new DataOutputStream(socket.getOutputStream());
	}

	public void run() {
		try {
			netOut.writeUTF("Connected");
			netOut.flush();
			while (true) {
				String line = netIn.readUTF();
				if (line.equalsIgnoreCase("quit"))
					break;

				FileOutputStream fos = new FileOutputStream(line);
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
