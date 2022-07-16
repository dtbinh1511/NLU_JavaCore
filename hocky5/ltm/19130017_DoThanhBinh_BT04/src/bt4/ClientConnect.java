package bt4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ClientConnect {
	String command, param;
	String id, name;
	double doubleValue;

	BufferedReader userIn;
	IProduct dao;

	public ClientConnect() throws RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 54321);
		dao = (IProduct) reg.lookup("TOOL");
		System.out.println("Connect");
		userIn = new BufferedReader(new InputStreamReader(System.in));
	}

	public void run() {

		try {
			while (true) {
				String request = userIn.readLine();
				if (request.equalsIgnoreCase("quit"))
					break;

				try {
					requestAnal(request);

					switch (command) {
					case "saveproduct":
						dao.saveProduct(new Product(id, name, doubleValue));
						System.out.println("Add product success");
						break;

					case "deletebyid":
						dao.deleteById(param);
						System.out.println("Delete product success");
						break;

					case "findbyid":
						Product p = dao.findById(param);
						if (p == null) {
							System.out.println("Not find");
						} else {
							System.out.println(p);
						}
						break;
					case "editprice":
						dao.editPrice(id, doubleValue);
						System.out.println("Edit price success");
						break;
					}

				} catch (MyException e) {
					System.out.println(e.getMessage());
				}
			}

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
