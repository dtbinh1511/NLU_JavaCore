package NK8;

public abstract class LibraryItem {
	protected int lid;
	protected String title;
	protected Author author;
	protected String publisher;
	protected int maxrentedDays;
	protected int price;

	public LibraryItem(int lid, String title, Author author, String publisher, int maxrentedDays, int price) {
		super();
		this.lid = lid;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.maxrentedDays = maxrentedDays;
		this.price = price;

	}

	public abstract String toString();

	public String getType() {
		return this.title;
	}

	public boolean isAuthor(String nameAuthor) {
		return this.author.sameAuthor(nameAuthor);
	}

	public abstract double lossFee();

	public abstract boolean equals(Object obj);

	public boolean samePublisher(String publisherOther) {
		return this.publisher.equals(publisherOther);
	}

	public int compareTo(LibraryItem that) {
		return this.author.compareTo(that.author);
	}
}