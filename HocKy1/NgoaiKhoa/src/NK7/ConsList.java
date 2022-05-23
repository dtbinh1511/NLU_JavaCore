package NK7;

public class ConsList implements IList {
	private OrderItem first;
	private IList rest;

	public ConsList(OrderItem first, IList rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	public String toString() {
		return this.first.toString() + this.rest.toString();
	}

	@Override
	public double totalPrice() {
		return this.first.totalPrice() + this.rest.totalPrice();
	}

	@Override
	public boolean contains(String productName) {
		return this.first.same(productName) || this.rest.contains(productName);
	}

}
