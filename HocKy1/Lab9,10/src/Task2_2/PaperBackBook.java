package Task2_2;

public class PaperBackBook extends ABook {

	protected PaperBackBook(String title, String authorName, int price, int pubYear) {
		super(title, authorName, price, pubYear);
	}

	@Override
	public String toString() {
		return "\n" + "Title: " + this.title + "\n" + "Name Author: " + this.authorName + "\n" + "Price: " + this.price
				+ "\n" + "Pub Year: " + this.pubYear + "\n";
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof PaperBackBook))
			return false;
		else {
			PaperBackBook other = (PaperBackBook) obj;
			return this.title.equals(other.title) && this.authorName.equals(other.authorName)
					&& this.price == other.price && this.pubYear == other.pubYear;
		}
	}
}
