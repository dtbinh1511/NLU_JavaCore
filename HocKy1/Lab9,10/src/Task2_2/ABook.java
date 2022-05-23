package Task2_2;

public abstract class ABook {
	protected String title;
	protected String authorName;
	protected int price;
	protected int pubYear;

	protected ABook(String title, String authorName, int price, int pubYear) {
		super();
		this.title = title;
		this.authorName = authorName;
		this.price = price;
		this.pubYear = pubYear;
	}

	@Override
	public abstract String toString();

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ABook))
			return false;
		else {
			ABook other = (ABook) obj;
			return this.title.equals(other.title) && this.authorName.equals(other.authorName)
					&& this.price == other.price && this.pubYear == other.pubYear;
		}
	}

	public int compareTo(ABook that) {
		return this.title.compareTo(that.title);
	}

	public boolean sameAuthor(String other) {
		return this.authorName.equals(other);
	}

}
