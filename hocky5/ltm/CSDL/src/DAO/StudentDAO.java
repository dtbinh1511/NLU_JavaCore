package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBContext;
import model.Student;

public class StudentDAO {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public StudentDAO() {
	}

	public List<Student> findByName(String name) {
		List<Student> list = new ArrayList<>();
		String query = "select * from student where name = ?";
		try {
			conn = new DBContext().getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Student(rs.getInt("ID"), rs.getString("Name"), rs.getInt("Age"), rs.getDouble("Score")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Student> findByAge(int age) {
		List<Student> list = new ArrayList<>();
		String query = "select * from Student where age = ?";
		try {
			conn = new DBContext().getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(query);
			ps.setInt(1, age);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Student(rs.getInt("ID"), rs.getString("Name"), rs.getInt("Age"), rs.getDouble("Score")));
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Student> findByScore(double score) throws SQLException {
		List<Student> list = new ArrayList<>();
		String query = "select * from Student where score = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setDouble(1, score);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Student(rs.getInt("ID"), rs.getString("Name"), rs.getInt("Age"), rs.getDouble("Score")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
