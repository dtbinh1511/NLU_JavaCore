package NK8;

public class Story extends LibraryItem {

	public Story(int lid, String title, Author author, String publisher, int maxrentedDays, int price) {
		super(lid, title, author, publisher, maxrentedDays, price);
	}

	@Override
	public String toString() {
		return "o  " + this.lid + ", " + this.title + ", " + "(" + this.author + ")" + ", " + this.publisher + ", "
				+ this.maxrentedDays + ", " + this.price + "\n";

	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Story))
			return false;
		else {
			Story other = (Story) obj;
			return this.lid == other.lid && this.title.equals(other.title) && this.author.equals(other.author)
					&& this.publisher.equals(other.publisher) && this.maxrentedDays == other.maxrentedDays
					&& this.price == other.price;
		}
	}

	public String getType() {
		return this.title;
	}

	@Override
	public double lossFee() {
		return 1.2 * this.price;
	}
	public boolean samePublisher(String publisherOther) {
		return this.publisher.equals(publisherOther);
	}

}
