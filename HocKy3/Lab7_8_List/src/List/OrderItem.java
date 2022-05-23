package List;

public class OrderItem {
	private Product product;
	private int n;

	public OrderItem(Product product, int n) {
		super();
		this.product = product;
		this.n = n;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public double cost() {
		return product.getPrice() * n;
	}

	public boolean isProduct(OrderItem other) {
		return this.product.equals(other.product);
	}

	@Override
	public String toString() {
		return "OrderItem [product=" + product + ", n=" + n + "\n";
	}

}
