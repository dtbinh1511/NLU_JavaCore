package echo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		int port = 7;
		ServerSocket server = new ServerSocket(port);
		while (true) {
			Socket socket = server.accept();
			OneConnection con = new OneConnection(socket);
			con.start();
		}
	}
}
