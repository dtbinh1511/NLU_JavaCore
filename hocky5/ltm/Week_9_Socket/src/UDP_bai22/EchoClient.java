package UDP_bai22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoClient {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		InetAddress address = InetAddress.getByName("localhost");
		int serverPort = 7;
		byte[] buff = new byte[256];
		DatagramPacket packet = new DatagramPacket(buff, buff.length, address, serverPort);
		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = userIn.readLine()) != null) {
			byte[] data = line.getBytes();
			packet.setData(data);
			packet.setLength(data.length);
			socket.send(packet);
			if (line.equalsIgnoreCase("quit"))
				break;
			packet.setData(buff);
			packet.setLength(buff.length);
			socket.receive(packet);
			String received = new String(packet.getData(), 0, packet.getLength());
			System.out.println(received);
		}
		socket.close();
	}

}
