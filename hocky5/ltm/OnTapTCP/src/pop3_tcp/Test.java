package pop3_tcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		
		String url = "jdbc:odbc:Sach"; 
		
		Connection conn = DriverManager.getConnection(url);
		
		Statement stat = conn.createStatement();
	}
}
