package Execise5;

public abstract class ABook {
	protected String title;
	protected String authorName;
	protected int price;
	protected int pubYear;

	protected ABook(String title, String authorName, int price, int pubYear) {
		super();
		this.title = title;
		this.authorName = authorName;
		this.price = price;
		this.pubYear = pubYear;
	}

	public abstract double salePrice();

	public boolean cheaperThan(ABook other) {
		return this.price < other.price;
	}

	public boolean sameAuthor(ABook other) {
		return this.authorName.equals(other.authorName);
	}
}
