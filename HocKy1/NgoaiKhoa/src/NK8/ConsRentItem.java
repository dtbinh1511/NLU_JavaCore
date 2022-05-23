package NK8;

public class ConsRentItem implements IRentItem {
	public RentItem first;
	public IRentItem rest;

	public ConsRentItem(RentItem first, IRentItem rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	public String toString() {
		return this.first.toString() + this.rest.toString();
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ConsRentItem))
			return false;
		else {
			ConsRentItem other = (ConsRentItem) obj;
			return this.first.equals(other.first) && this.rest.equals(other.rest);
		}
	}
}
