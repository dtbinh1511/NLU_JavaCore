package NK8;

public class ReferenceBook extends LibraryItem {
	public String category;

	public ReferenceBook(int lid, String title, Author author, String publisher, int maxrentedDays, int price,
			String category) {
		super(lid, title, author, publisher, maxrentedDays, price);
		this.category = category;
	}

	public String toString() {
		return "o  " + this.lid + ", " + this.title + ", " + "(" + this.author + ")" + ", " + this.publisher + ", "
				+ this.maxrentedDays + ", " + this.price + ", " + this.category + "\n";

	}

	public String getType() {
		return this.title;
	}

	@Override
	public double lossFee() {
		return 1.2 * this.price;
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ReferenceBook))
			return false;
		else {
			ReferenceBook other = (ReferenceBook) obj;
			return this.lid == other.lid && this.title.equals(other.title) && this.author.equals(other.author)
					&& this.publisher.equals(other.publisher) && this.maxrentedDays == other.maxrentedDays
					&& this.price == other.price && this.category.equals(other.category);
		}
	}
	public boolean samePublisher(String publisherOther) {
		return this.publisher.equals(publisherOther);
	}
}
