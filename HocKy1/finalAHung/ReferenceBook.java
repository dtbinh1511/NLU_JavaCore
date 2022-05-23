package finalAHung;

public class ReferenceBook extends LibraryItem {
	private String category;

	public ReferenceBook(int lid, String title, Author author, String publisher, int maxRentedDays, int price,
			String category) {
		super(lid, title, author, publisher, maxRentedDays, price);
		this.category = category;
	}

}
