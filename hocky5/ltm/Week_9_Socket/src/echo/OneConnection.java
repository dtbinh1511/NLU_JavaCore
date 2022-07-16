package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class OneConnection extends Thread {
	Socket socket;
	BufferedReader netIn;
	PrintWriter netOut;

	public OneConnection(Socket socket) throws IOException {
		this.socket = socket;
		netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		netOut = new PrintWriter(socket.getOutputStream(), true);
	}

	public void run() {
		try {
			netOut.println("Hello");
			String line;
			while (true) {
				line = netIn.readLine();
				if (line.equalsIgnoreCase("quit"))
					break;
				netOut.println("Echo: " + line);
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
