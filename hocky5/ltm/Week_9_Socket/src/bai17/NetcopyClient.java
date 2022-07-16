package bai17;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NetcopyClient {
	public static String ADDRESS_IP = "127.0.0.1";

	public static void run() throws UnknownHostException, IOException {
		Socket socket = new Socket(ADDRESS_IP, NetcopyServer.PORT);

		DataInputStream netIn = new DataInputStream(socket.getInputStream());
		DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());

		String source, dest, command;
		while (true) {
			System.out.println("Nhập copy source dest");
			BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
			String line = userIn.readLine();

			if (line.equalsIgnoreCase("quit"))
				break;
			
			StringTokenizer token = new StringTokenizer(line);
			command = token.nextToken();
			source = token.nextToken();
			dest = token.nextToken();
			netOut.writeUTF(dest);
			netOut.flush();

			FileInputStream fis = new FileInputStream(source);
			int readByte;
			byte[] data = new byte[102400];
			while ((readByte = fis.read(data)) != -1) {
				netOut.write(data, 0, readByte);
				netOut.flush();
			}
			fis.close();
		}

		socket.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		run();
	}
}
