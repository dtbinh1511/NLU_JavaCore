package NK7;

public class OrderItem {
	private Product product;
	private int amount;

	public OrderItem(Product product, int amount) {
		super();
		this.product = product;
		this.amount = amount;
	}

	public String toString() {
		return  this.product + "\n" + "   AMOUNT: " + this.amount +"\n" + "\n";
	}
	public double totalPrice() {
		return  this.product.getPrice();
	}
	public boolean same(String productName) {
		return this.product.same(productName);
	}
}