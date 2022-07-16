package UDP_bai23;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Client {
	static String command, param;
	static double doubleValue;
	static int intValue;
	static String request;

	public static void requestAnal(String request) throws MyException {
		try {
			StringTokenizer st = new StringTokenizer(request);
			command = st.nextToken().trim().toLowerCase();
			param = st.nextToken();
		} catch (NoSuchElementException e) {
			throw new MyException("Sai cu phap");
		}
		switch (command) {
		case "findbyname":
			break;
		case "findbyage":
			try {
				intValue = Integer.parseInt(param);
				break;
			} catch (NumberFormatException e) {
				throw new MyException("Tham so tuoi khong hop le");
			}

		case "findbyscore":
			try {
				doubleValue = Double.parseDouble(param);
				break;
			} catch (NumberFormatException e) {
				throw new MyException("Tham so diem khong hop le");
			}
		default:
			throw new MyException("Lenh khong hop le");
		}
	}

	public static void send(DatagramPacket packet, DatagramSocket socket, String command) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeUTF(command);
		dos.flush();
		byte[] data = baos.toByteArray();
		packet.setData(data);
		packet.setLength(data.length);
		socket.send(packet);

	}

	public static void send(DatagramPacket packet, DatagramSocket socket, String command, String param)
			throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeUTF(command);
		dos.writeUTF(param);
		dos.flush();
		byte[] data = baos.toByteArray();
		packet.setData(data);
		packet.setLength(data.length);
		socket.send(packet);

	}

	public static void send(DatagramPacket packet, DatagramSocket socket, String command, double param)
			throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeUTF(command);
		dos.writeDouble(param);
		dos.flush();
		byte[] data = baos.toByteArray();
		packet.setData(data);
		packet.setLength(data.length);
		socket.send(packet);

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		byte[] buff = new byte[102400];
		DatagramSocket socket = new DatagramSocket();
		InetAddress address = InetAddress.getByName("localhost");
		int serverPort = 2000;
		DatagramPacket packet = new DatagramPacket(buff, buff.length, address, serverPort);

		BufferedReader userIn = new BufferedReader(new InputStreamReader(System.in));
		String line;
		System.out.println("findbyname name....");
		while (true) {
			try {
				line = userIn.readLine();
				if (line.equalsIgnoreCase("quit")) {
					// send request to server
					send(packet, socket, "quit");
					break;
				}
				try {
					// request anal
					requestAnal(line);
					// send request
					switch (command) {
					case "findbyname":
						send(packet, socket, command, param);
						break;
					case "findbyage":
						send(packet, socket, command, intValue);
						break;
					case "findbyscore":
						send(packet, socket, command, doubleValue);
						break;
					}

					// receive response
					packet.setData(buff);
					packet.setLength(buff.length);
					socket.receive(packet);
					display(packet);

				} catch (MyException e) {
					System.out.println(e.getMessage());
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		socket.close();
	}

	private static void display(DatagramPacket packet) {
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(packet.getData());
			ObjectInputStream ois = new ObjectInputStream(bais);
			List<Student> list = (List<Student>) ois.readObject();
			if (list.isEmpty())
				System.out.println("Khong tim thay");
			for (Student student : list) {
				System.out.println(student.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
