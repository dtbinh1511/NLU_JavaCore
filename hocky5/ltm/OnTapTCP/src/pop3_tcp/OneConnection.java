package pop3_tcp;

import java.net.Socket;

public class OneConnection extends Thread {
	public Socket socket;

	public OneConnection(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run() {
		
	}
}
