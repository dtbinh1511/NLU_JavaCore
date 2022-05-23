package Execise5;

public class PaperBackBook extends ABook{

	protected PaperBackBook(String title, String authorName, int price, int pubYear) {
		super(title, authorName, price, pubYear);
	}

	@Override
	public double salePrice() {
		return this.price;
	}

}
