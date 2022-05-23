package NK10;

public class ReferenceBook extends LibraryItem {
	private String category;

	public ReferenceBook(int lid, String title, Author author, String publisher, int maxRentDays, double price,
			String category) {
		super(lid, title, author, publisher, maxRentDays, price);
		this.category = category;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReferenceBook other = (ReferenceBook) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.title + this.author + this.lid + this.maxRentDays + this.price + this.publisher + this.category;
	}

	@Override
	public String getType() {
		return "ReferenceBook";
	}

	@Override
	public boolean isPublishedIn(int year) {
		return false;
	}

	@Override
	public double moneyTotal() {
		return 0.005 * this.lossFee();
	}

}
