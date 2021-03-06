
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// YÊU CẦU TOÀN BỘ TIẾN TRÌNH CÓ 1 LỚP DAO
public class DAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public DAO() {
		conn = new DBContext().getConnection();
	}

	public boolean checkUserName(String name) throws MyException {
		String query = "select * from user where userName = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			throw new MyException("Error database");
		}

	}

	public boolean login(String name, String password) {
		String query = "select * from user where userName = ? and password = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Student> findByName(String name) {
		List<Student> list = new ArrayList<>();
		String query = "select * from student where name like ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Student(rs.getInt("ID"), rs.getString("Name"), rs.getInt("Age"), rs.getDouble("Score")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<Student> findByAge(int age) {
		List<Student> list = new ArrayList<>();
		String query = "select * from Student where age = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, age);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Student(rs.getInt("ID"), rs.getString("Name"), rs.getInt("Age"), rs.getDouble("Score")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Student> findByScore(double score) {
		List<Student> list = new ArrayList<>();
		String query = "select * from Student where score = ?";
		try {
			ps = conn.prepareStatement(query);
			ps.setDouble(1, score);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Student(rs.getInt("ID"), rs.getString("Name"), rs.getInt("Age"), rs.getDouble("Score")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
