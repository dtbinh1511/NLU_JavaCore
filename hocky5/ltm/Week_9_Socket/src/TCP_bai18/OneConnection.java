package TCP_bai18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class OneConnection extends Thread {
	Socket socket;

	public OneConnection(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run() {
		try {
			DataInputStream netIn = new DataInputStream(socket.getInputStream());
			DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());

			netOut.writeUTF("Connected");
			netOut.flush();
			while (true) {
				String line = netIn.readUTF();

				if (line.equalsIgnoreCase("quit"))
					break;

				FileInputStream fis = new FileInputStream(line);

				int readByte;
				byte[] data = new byte[102400];
				while ((readByte = fis.read(data)) != -1) {
					netOut.write(data, 0, readByte);
					if (readByte < data.length)
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
