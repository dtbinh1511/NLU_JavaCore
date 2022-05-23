package NK10;

public class MTRentItem implements IRentItem {

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MTRentItem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "";
	}

	public boolean isRentSomeItem(String thatTitle) {
		return false;
	}

	@Override
	public double fineTotal() {
		return 0.0;
	}

}
