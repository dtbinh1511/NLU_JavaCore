package NK7;

public abstract class Product {
	protected String id;
	protected int price;
	protected String name;
	protected Date productDate;

	public Product(String id, int price, String name, Date productDate) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.productDate = productDate;
	}

	public abstract String toString();

	public int getPrice() {
		return this.price;
	}

	public boolean same(String productName) {
		return this.name.equals(productName);
	}

}
