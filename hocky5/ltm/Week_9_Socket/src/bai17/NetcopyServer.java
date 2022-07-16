package bai17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetcopyServer {
	public static int PORT = 12345;

	public static void startServer() throws IOException {
		ServerSocket server = new ServerSocket(PORT);
		Socket socket = server.accept();

		DataInputStream netIn = new DataInputStream(socket.getInputStream());
		DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());
		String dest = netIn.readUTF();
		FileOutputStream fos = new FileOutputStream(dest);

		int readByte;
		byte[] data = new byte[102400];
		while ((readByte = netIn.read(data)) != -1) {
			fos.write(data, 0, readByte);
		}
		fos.close();

	}

	public static void main(String[] args) throws IOException {
		startServer();
	}
}
