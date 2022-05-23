package NK10;

public abstract class LibraryItem {
	protected int lid;
	protected String title;
	protected Author author;
	protected String publisher;
	protected int maxRentDays;
	protected double price;

	public LibraryItem(int lid, String title, Author author, String publisher, int maxRentDays, double price) {
		super();
		this.lid = lid;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.maxRentDays = maxRentDays;
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryItem other = (LibraryItem) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (lid != other.lid)
			return false;
		if (maxRentDays != other.maxRentDays)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.lid + "/n " + this.title + " /n" + this.author + "/n " + this.publisher + "/n " + this.maxRentDays + "/n"
				+ this.price;
	}

	// xac dinh ten cua loai an
	public abstract String getType();

	// kiem tra xem 1 an pham co phai do 1 nha xuat ban co ten truoc hay khong
	public boolean isPulisher(String publisher) {
		return this.publisher.equals(publisher);
	}

	// tinh gia den 1 an pham khi doc gia lam mat an pham cho muon
	public double lossFee() {
		return this.price * 0.75;
	}

	public boolean sameAuthor(String nameAuthor) {
		return this.author.sameAuthor(nameAuthor);
	}

	public abstract boolean isPublishedIn(int year);

	public boolean sameLibraryItem(String titleBefore) {
		return this.title.equals(titleBefore);
	}

	public int compareTo(LibraryItem other) {
		return this.title.compareTo(other.title);
	}

	public int compareToo(LibraryItem other) {
		return this.author.compareTo(other.author);
	}

	public int getMaxRentDays() {
		return maxRentDays;
	}
	public boolean sameTitle(String thatTitle) {
		return this.title.equals(thatTitle);
	}
	public abstract double moneyTotal();

}
