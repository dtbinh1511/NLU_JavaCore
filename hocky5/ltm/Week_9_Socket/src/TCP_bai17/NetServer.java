package TCP_bai17;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServer {
	// upload
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(12345);
		Socket socket = server.accept();

		OneConnection con = new OneConnection(socket);
		con.run();
	}
}
