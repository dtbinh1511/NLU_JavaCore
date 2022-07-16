package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import model.Student;

public class OneConnection extends Thread {
	Socket socket;
	PrintWriter netOut;
	BufferedReader netIn;
	DAO dao;

	String request, command, param;
	int intValue;
	double doubleValue;
	boolean isLogin = false;

	public OneConnection(Socket socket) throws IOException {
		super();
		this.socket = socket;
		dao = new DAO();
		netOut = new PrintWriter(socket.getOutputStream(), true);
		netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		netOut.println("Connected....");
		netOut.println("Enter username ....");
	}

	public void run() {
		List<Student> list = new ArrayList<>();
		try {
			// 1. login
			String username = "", password = "";

//			login: while (true) {
//				String request = netIn.readLine();
//				if (request.equalsIgnoreCase("quit"))
//					break;
//
//				try {
//					requestAnal(request);
//					switch (command) {
//					case "username":
//						if (dao.checkUserName(param)) {
//							username = param;
//							netOut.println("Enter password ....");
//							continue login;
//						} else {
//							netOut.println("Enter again username");
//							continue login;
//						}
//
//					case "password":
//						password = param;
//						if (dao.login(username, password)) {
//							isLogin = true;
//							netOut.println("Login Success");
//							break login;
//						} else {
//							netOut.println("Enter again Password");
//							continue login;
//						}
//					}
//				} catch (MyException e) {
//					System.out.println(e.getMessage());
//					continue;
//				}
//			}

			// 2. login -> ok, tìm kiếm
			while (isLogin) {
				String request = netIn.readLine();
				if (request.equalsIgnoreCase("quit"))
					break;

				try {
					requestAnal(request);

					switch (command) {
					case "findbyname":
						list = dao.findByName(param);
						break;
					case "findbyage":
						list = dao.findByAge(intValue);
						break;
					case "findbyscore":
						list = dao.findByScore(doubleValue);
						break;
					}

					if (list.isEmpty())
						netOut.println("Not found");
					else
						netOut.println(list);
				} catch (MyException e) {
					System.out.println(e.getMessage());
					continue;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// request anal
	public void requestAnal(String request) throws MyException {
		try {
			StringTokenizer st = new StringTokenizer(request);
			command = st.nextToken().trim().toLowerCase();
			param = request.substring(command.length()).trim();
		} catch (NoSuchElementException e) {
			throw new MyException("wrong sytax");
		}
		switch (command) {
		case "username":
			break;
		case "password":
			break;
		case "findbyname":
			break;
		case "findbyage":
			try {
				intValue = Integer.parseInt(param);
			} catch (NumberFormatException e) {
				throw new MyException("Param age isn't available");
			}
			break;
		case "findbyscore":
			try {
				doubleValue = Double.parseDouble(param);
			} catch (NumberFormatException e) {
				throw new MyException("Param score isn't available");
			}
			break;
		default:
			throw new MyException("Command isn't available");
		}
	}

}
