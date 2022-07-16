package bai19;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class NetAlgoClient {
	public static String ADDRESS_IP = "127.0.0.1";

	public static void run() throws UnknownHostException, IOException {
		Socket socket = new Socket(ADDRESS_IP, NetAlgoServer.PORT);

		DataInputStream netIn = new DataInputStream(socket.getInputStream());
		DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());

		System.out.println("Nhập biểu thức: a + b");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();

		// send server
		netOut.writeUTF(line);
		netOut.flush();

		// receive from server
		String result = netIn.readUTF();
		System.out.println(result);

		socket.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		run();
	}
}
