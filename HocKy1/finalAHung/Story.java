package finalAHung;

public class Story extends LibraryItem {

	public Story(int lid, String title, Author author, String publisher, int maxRentedDays, int price) {
		super(lid, title, author, publisher, maxRentedDays, price);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
