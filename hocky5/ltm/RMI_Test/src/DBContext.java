

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

	public Connection getConnection() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
			String url = "jdbc:ucanaccess://E:\\Test\\Student.accdb;memory=true";
//			String url = "jdbc:odbc:studentdb"; 

			return DriverManager.getConnection(url);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
