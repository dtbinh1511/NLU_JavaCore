package NK10;

public class ConsRentItem implements IRentItem {
	private RentItem first;
	private IRentItem rest;

	public ConsRentItem(RentItem first, IRentItem rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsRentItem other = (ConsRentItem) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (rest == null) {
			if (other.rest != null)
				return false;
		} else if (!rest.equals(other.rest))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.first.toString() + this.rest.toString();
	}

	@Override
	public boolean isRentSomeItem(String thatTitle) {
		return this.first.sameTitle(thatTitle) || this.rest.isRentSomeItem(thatTitle);
	}

	@Override
	public double fineTotal() {
		return this.first.totalmoney() + this.rest.fineTotal();
	}
}
