package NK8;

public class Journal extends LibraryItem {
	public Date publishedDate;

	public Journal(int lid, String title, Author author, String publisher, int maxrentedDays, int price,
			Date publishedDate) {
		super(lid, title, author, publisher, maxrentedDays, price);
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "o  " + this.lid + ", " + this.title + ", " + "(" + this.author.name + ")" + ", " + this.publisher + ", "
				+ this.maxrentedDays + ", " + this.price + ", " + this.publishedDate + "\n";
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Journal))
			return false;
		else {
			Journal other = (Journal) obj;
			return this.lid == other.lid && this.title.equals(other.title) && this.author.equals(other.author)
					&& this.publisher.equals(other.publisher) && this.maxrentedDays == other.maxrentedDays
					&& this.price == other.price && this.publishedDate.equals(other.publishedDate);
		}
	}

	public String getType() {
		return this.title;
	}

	@Override
	public double lossFee() {
		return 0.8 * this.price;
	}

	public boolean samePublisher(String publisherOther) {
		return this.publisher.equals(publisherOther);
	}
}
