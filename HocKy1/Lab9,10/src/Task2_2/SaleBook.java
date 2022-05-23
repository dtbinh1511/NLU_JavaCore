package Task2_2;

public class SaleBook extends ABook {

	protected SaleBook(String title, String authorName, int price, int pubYear) {
		super(title, authorName, price, pubYear);
	}

	@Override
	public String toString() {
		return "\n" + "Title: " + this.title + "\n" + "Name Author: " + this.authorName + "\n" + "Price: " + this.price
				+ "\n" + "Pub Year: " + this.pubYear + "\n";
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof SaleBook))
			return false;
		else {
			SaleBook other = (SaleBook) obj;
			return this.title.equals(other.title) && this.authorName.equals(other.authorName)
					&& this.price == other.price && this.pubYear == other.pubYear;

		}
	}
}
