package Execise5;

public class HardCover extends ABook {

	protected HardCover(String title, String authorName, int price, int pubYear) {
		super(title, authorName, price, pubYear);
	}

	@Override
	public double salePrice() {
		return this.price * 0.2;
	}

	

}
