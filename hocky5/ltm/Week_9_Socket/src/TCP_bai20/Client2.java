package TCP_bai20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 12345);

		BufferedReader netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter netOut = new PrintWriter(socket.getOutputStream(), true);
		System.out.println(netIn.readLine());

		while (true) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String request = reader.readLine();
			netOut.println(request);

			if (request.equalsIgnoreCase("quit"))
				break;

			String response = netIn.readLine();
			System.out.println(response);
		}
		socket.close();
	}
}
