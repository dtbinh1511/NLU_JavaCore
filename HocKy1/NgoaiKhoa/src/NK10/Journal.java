package NK10;

public class Journal extends LibraryItem {
	private Date publishedDate;

	public Journal(int lid, String title, Author author, String publisher, int maxRentDays, double price,
			Date publishedDate) {
		super(lid, title, author, publisher, maxRentDays, price);
		this.publishedDate = publishedDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Journal other = (Journal) obj;
		if (publishedDate == null) {
			if (other.publishedDate != null)
				return false;
		} else if (!publishedDate.equals(other.publishedDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return   this.title +  this.author +this.lid + this.maxRentDays + this.price + this.publisher
				+ this.publishedDate ;
	}

	public String getType() {
		return "Journal";
	}

	@Override
	public boolean isPublishedIn(int year) {
		return this.publishedDate.sameYear(year);
	}

	@Override
	public double moneyTotal() {
		return 0.005 * this.lossFee();
	}
}
