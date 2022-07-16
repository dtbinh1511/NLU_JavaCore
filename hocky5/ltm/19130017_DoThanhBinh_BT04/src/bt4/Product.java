package bt4;


import java.io.Serializable;
import java.util.StringTokenizer;

public class Product implements Serializable {
	private String id;
	private String name;
	private double price;

	public Product() {
	}

	public Product(String id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return "Ma SP: " + id + ", Ten SP: " + name + ",Gia: " + price;
	}

	public String save(String delimited) {
		return id + delimited + name + delimited + price + "\n";
	}

	public void read(String line, String delimited) {
		StringTokenizer token = new StringTokenizer(line, delimited);
		id = token.nextToken();
		name = token.nextToken();
		price = Double.parseDouble(token.nextToken());
	}
}
