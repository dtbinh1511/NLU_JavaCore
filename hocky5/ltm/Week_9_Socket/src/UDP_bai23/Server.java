package UDP_bai23;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {

	public static void main(String[] args) {
		Dao.createData();
		try {
			// 1. receive request
			int serverPort = 2000;
			byte[] buff = new byte[102400];
			DatagramSocket socket = new DatagramSocket(serverPort);
			DatagramPacket packet = new DatagramPacket(buff, buff.length);

			String command, name;
			int age;
			double score;
			List<Student> list = null;
			loop: while (true) {
				packet.setData(buff);
				packet.setLength(buff.length);
				socket.receive(packet);

				// 2. request anal
				ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
				DataInputStream dis = new DataInputStream(bais);
				command = dis.readUTF();

				// 3. request proc(dao)
				switch (command) {
				case "quit":
					break loop;
				case "findbyname":
					name = dis.readUTF();
					list = Dao.findByName(name);
					break;
				case "findbyage":
					age = (int) dis.readDouble();
					list = Dao.findByAge(age);
					break;
				case "findbyscore":
					score = (int) dis.readDouble();
					list = Dao.findByScore(score);
					break;
				}
				// 4. response
				if (list != null)
					send(packet, socket, list);
			}
			socket.close();
			System.out.println("Server quit");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void send(DatagramPacket packet, DatagramSocket socket, List<Student> list) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		// dung vong lap xu ly ko dung object
		oos.writeObject(list);

		byte[] data = baos.toByteArray();
		packet.setData(data);
		packet.setLength(data.length);
		socket.send(packet);

	}
}
