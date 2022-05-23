package NK10;

public class Story extends LibraryItem {

	public Story(int lid, String title, Author author, String publisher, int maxRentDays, double price) {
		super(lid, title, author, publisher, maxRentDays, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.title + this.author + this.lid + this.maxRentDays + this.price + this.publisher;
	}

	@Override
	public double lossFee() {
		return this.price;
	}

	@Override
	public String getType() {
		return "Story";
	}

	@Override
	public boolean isPublishedIn(int year) {
		return false;
	}

	@Override
	public double moneyTotal() {
		return 0.0015 * this.lossFee();
	}

}
