package UDP_bai22;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		byte[] buff = new byte[256];
		int serverPort = 7;
		DatagramSocket socket = new DatagramSocket(serverPort);
		DatagramPacket packet = new DatagramPacket(buff, buff.length);

		while (true) {
			packet.setData(buff);
			packet.setLength(buff.length);
			socket.receive(packet);
			String received = new String(packet.getData(), 0, packet.getLength());
			if (received.equalsIgnoreCase("quit"))
				break;
			received = "Echo:" + received;
			byte[] data = received.getBytes();
			packet.setData(data);
			packet.setLength(data.length);
			socket.send(packet);
		}
		socket.close();
	}

}
