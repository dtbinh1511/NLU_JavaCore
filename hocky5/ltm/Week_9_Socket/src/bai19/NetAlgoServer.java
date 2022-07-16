package bai19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class NetAlgoServer {
	public static int PORT = 12345;

	public static void startServer() throws IOException {
		ServerSocket server = new ServerSocket(PORT);
		Socket socket = server.accept();
		DataInputStream netIn = new DataInputStream(socket.getInputStream());
		DataOutputStream netOut = new DataOutputStream(socket.getOutputStream());

		// receive command
		String command = netIn.readUTF();
		StringTokenizer token = new StringTokenizer(command);

		double num1 = Double.parseDouble(token.nextToken());
		String base = token.nextToken();
		double num2 = Double.parseDouble(token.nextToken());

		double result = 0;
		switch (base) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}

		command = num1 + " " + base + " " + num2 + " = " + result;

		// send client
		netOut.writeUTF(command);
		netOut.flush();

		server.close();
	}

	public static void main(String[] args) throws IOException {
		startServer();
	}
}
