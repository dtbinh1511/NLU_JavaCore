package bai16;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetcopyClient {

	public static void run(String source) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 12345);

		DataInputStream netIn = new DataInputStream(socket.getInputStream());
		DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());

		System.out.println(netIn.readUTF());
		FileInputStream fis = new FileInputStream(source);

		int byteRead;
		byte[] data = new byte[102400];
		while ((byteRead = fis.read(data)) != -1) {
			netOut.write(data, 0, byteRead);
		}
		fis.close();
		socket.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		String source = "E:\\Test\\TS01CV.pdf";
		run(source);
	}
}
