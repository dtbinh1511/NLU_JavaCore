package finalAHung;

public class Journal extends LibraryItem {
	private Date publishedDate;

	public Journal(int lid, String title, Author author, String publisher, int maxRentedDays, int price,
			Date publishedDate) {
		super(lid, title, author, publisher, maxRentedDays, price);
		this.publishedDate = publishedDate;
	}

	public String toString() {
		return super.toString()+" "+this.publishedDate;
	}
	
}
