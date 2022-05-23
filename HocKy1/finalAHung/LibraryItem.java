package finalAHung;

public abstract class LibraryItem {
	protected int lid;
	protected String title;
	protected Author author;
	protected String publisher;
	protected int maxRentedDays;
	protected int price;

	protected LibraryItem(int lid, String title, Author author, String publisher, int maxRentedDays, int price) {
		super();
		this.lid = lid;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.maxRentedDays = maxRentedDays;
		this.price = price;
	}

	public boolean hasAuthorNameBefore(LibraryItem item) {
		return this.author.hasNameBefore(item.author);
	}

	@Override
	public String toString() {
		return lid + " " + title + " (" + author + ") " + publisher
				+ " " + maxRentedDays + " " + price;
	}
	
}
