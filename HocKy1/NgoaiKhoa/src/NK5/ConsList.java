package NK5;

public class ConsList implements IList{
	private Product first;
	private IList rest;
	public ConsList(Product first, IList rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	public String toString () {
		return this.first.toString() + this.rest.toString();
	}


	public double totalPrice() {
		return this.first.totalPrice() + this.rest.totalPrice();
	}
}
