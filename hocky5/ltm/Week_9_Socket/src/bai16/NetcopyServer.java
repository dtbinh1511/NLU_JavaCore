package bai16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetcopyServer {

	public static void startSever(String dest) {
		try {
			ServerSocket server = new ServerSocket(12345);
			Socket socket = server.accept();

			DataInputStream netIn = new DataInputStream(socket.getInputStream());
			DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());
			
			netOut.writeUTF("Connected");
			netOut.flush();
			FileOutputStream fos = new FileOutputStream(dest);
			int byteRead;
			byte[] data = new byte[102400];
			while ((byteRead = netIn.read(data)) != -1) {
				fos.write(data, 0, byteRead);
			}
			fos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {
		String dest = "E:\\Test\\Client2\\TS01CV.pdf";
		startSever(dest);
	}
}
