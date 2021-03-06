package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	// tcp, line, pop3
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		while (true) {
			Socket socket = server.accept();
			OneConnection conn = new OneConnection(socket);
			conn.start();
		}
	}
}
