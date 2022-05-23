package payment;

public class Product {
	private String id;
	private String name;
	private int price;

	public Product(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}
