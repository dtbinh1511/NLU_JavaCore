package server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	// them sp
	public int addProduct(Product p) throws SQLException {
		String query = "INSERT INTO Product(id, name, price) VALUES(?,?,?)";
//		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getId());
			ps.setString(2, p.getName());
			ps.setDouble(3, p.getPrice());
			return ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return 0;
//		}
	}

	// sua sp
	public int updateProduct(Product p) {
		String query = "UPDATE Product SET price = ? WHERE id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setDouble(1, p.getPrice());
			ps.setString(2, p.getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// xoa sp
	public int deleteProduct(Product p) {
		String query = "DELETE Product WHERE id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, p.getId());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	// tim kiem bang ten
	public List<Product> findByName(String name) {
		List<Product> list = new ArrayList<Product>();
		String query = "SELECT * FROM Product WHERE name LIKE ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + name + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getString("id"), rs.getString("name"), rs.getLong("price")));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	// tim kiem bang id
	public Product findById(String id) {
		String query = "SELECT * FROM Product WHERE id = ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getString("id"), rs.getString("name"), rs.getLong("price"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		System.out.println(productDAO.updateProduct(new Product("SP02","Book1", 1000)));
		
	}
}
