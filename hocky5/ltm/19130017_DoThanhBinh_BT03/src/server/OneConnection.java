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

import org.hsqldb.HsqlException;

import net.ucanaccess.jdbc.UcanaccessSQLException;

public class OneConnection extends Thread {
	Socket socket;
	PrintWriter netOut;
	BufferedReader netIn;
	ProductDAO dao;

	String command, param;
	String id, name;
	double doubleValue;

	public OneConnection(Socket socket) throws IOException {
		this.socket = socket;
		dao = new ProductDAO();
		netOut = new PrintWriter(socket.getOutputStream(), true);
		netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		netOut.println("Connected....");
	}

	public void run() {
		Product p = new Product();
		List<Product> list = new ArrayList<>();
		try {
			while (true) {
				String request = netIn.readLine();
				if (request.equalsIgnoreCase("quit"))
					break;

				try {
					requestAnal(request);

					switch (command) {
					case "saveproduct":
						try {
							dao.addProduct(new Product(id, name, doubleValue));
							netOut.println("Add product success");
						} catch (SQLException e) {
							throw new MyException("Duplicate id");
						}
						break;

					case "deletebyid":
						p = dao.findById(param);
						try {
							dao.deleteProduct(p);
							netOut.println("Delete product success");
						} catch (NullPointerException e) {
							throw new MyException("ID Product isn't exist");
						}
						break;

					case "findbyid":
						p = dao.findById(param);
						if (p == null) {
							netOut.println("Not find");
						} else {
							netOut.println(p);
						}
						break;

					case "findbyname":
						list = dao.findByName(param);
						if (list.isEmpty()) {
							netOut.println("Not find");
						} else {
							netOut.println(list);
						}
						break;
					case "editprice":
						p = dao.findById(id);
						try {
							p.setPrice(doubleValue);
							dao.updateProduct(p);
							netOut.println("Edit price success");
						} catch (NullPointerException e) {
							throw new MyException("ID Product isn't exist");
						}
						break;
					}

				} catch (MyException e) {
					netOut.println(e.getMessage());
					continue;
				}
			}

			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void requestAnal(String request) throws MyException {
		StringTokenizer st = new StringTokenizer(request);
		command = st.nextToken().trim();
		param = request.substring(command.length()).trim();
		StringTokenizer token;

		switch (command) {
		case "saveproduct":
			try {
				token = new StringTokenizer(param);
				id = token.nextToken().trim();
				name = token.nextToken().trim();
				try {
					doubleValue = Double.parseDouble(token.nextToken().trim());
				} catch (NumberFormatException e) {
					throw new MyException("Param price isn't available");
				}
			} catch (NoSuchElementException e) {
				throw new MyException("Param isn't enough");
			}

			break;
		case "deletebyid":
			break;
		case "findbyid":
			break;
		case "findbyname":
			break;
		case "editprice":
			try {
				token = new StringTokenizer(param);
				id = token.nextToken().trim();
				try {
					doubleValue = Double.parseDouble(token.nextToken().trim());
				} catch (NumberFormatException e) {
					throw new MyException("Param price isn't available");
				}
			} catch (NoSuchElementException e) {
				throw new MyException("Param isn't enough");
			}

			break;
		default:
			throw new MyException("Command isn't available");
		}
	}

}
