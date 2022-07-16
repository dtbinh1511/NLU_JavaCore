package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	public Connection getConnection() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://db\\Product.accdb;memory=true";

			return DriverManager.getConnection(url);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		DBContext c = new DBContext();
		if(c.getConnection()== null) {
			System.out.println("That bai");
		}else {
			System.out.println("Thanh Cong");
		}
	}
}
