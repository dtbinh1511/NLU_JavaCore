package NK8;

public class RentItem {
	public LibraryItem item;
	public int rentedDays;

	public RentItem(LibraryItem item, int rentedDays) {
		super();
		this.item = item;
		this.rentedDays = rentedDays;
	}

	public String toString() {
		return this.item + "," + this.rentedDays;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof RentItem))
			return false;
		else {
			RentItem other = (RentItem) obj;
			return this.item.equals(other.item) && this.rentedDays == other.rentedDays;
		}
	}

}
