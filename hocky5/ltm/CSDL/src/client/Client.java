package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	static Socket socket;

	public static void main(String[] args) throws UnknownHostException, IOException {
		socket = new Socket("localhost", 12345);
		PrintWriter netOut = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println(netIn.readLine());
		System.out.println(netIn.readLine());

		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		String line;
		login: while (true) {
			try {
				line = userIn.readLine();
				if (line.equalsIgnoreCase("quit")) {
					netOut.println(line);
					socket.close();
					break login;
				}
				// send request to server
				netOut.println(line);

				// response
				String response = netIn.readLine();
				System.out.println(response);

				continue login;

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
