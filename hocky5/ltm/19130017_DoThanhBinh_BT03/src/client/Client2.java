package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 12345);
		PrintWriter netOut = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		String line;
		System.out.println(netIn.readLine());
		while (true) {
			try {
				line = userIn.readLine();
				if (line.equalsIgnoreCase("quit")) {
					netOut.println(line);
					break;
				}
				// send request to server
				netOut.println(line);

				// response
				String response = netIn.readLine();
				System.out.println(response);

			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
		socket.close();
	}
}
