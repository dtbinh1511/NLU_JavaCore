package NK10;

public class RentItem {
	private LibraryItem item;
	private int rentedDays;

	public RentItem(LibraryItem item, int rentedDays) {
		super();
		this.item = item;
		this.rentedDays = rentedDays;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentItem other = (RentItem) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (rentedDays != other.rentedDays)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.item + "" + this.rentedDays;
	}

	public boolean sameLibraryItem(String titleBefore) {
		return this.item.sameLibraryItem(titleBefore);
	}

	public boolean sameTitle(String thatTitle) {
		return this.item.sameTitle(thatTitle);
	}

	public int numDayLate() {
		return this.item.maxRentDays - this.rentedDays;
	}

	public double totalmoney() {
		if (this.numDayLate() > 0)
			return 0;
		return Math.abs(this.item.moneyTotal() * this.numDayLate());
	}
}
