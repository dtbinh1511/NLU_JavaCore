package tinhtoan;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static int PORT = 12345;

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(PORT);
		while (true) {
			Socket socket = server.accept();
			OneConnection connect = new OneConnection(socket);
			connect.start();
		}
	}
}
