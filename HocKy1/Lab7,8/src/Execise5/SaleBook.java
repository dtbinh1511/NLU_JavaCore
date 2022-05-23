package Execise5;

public class SaleBook extends ABook{

	protected SaleBook(String title, String authorName, int price, int pubYear) {
		super(title, authorName, price, pubYear);
	}

	@Override
	public double salePrice() {
		return this.price * 0.5;
	}

}
