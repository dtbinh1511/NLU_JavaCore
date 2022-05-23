package NK8;

public class MTRentItem implements IRentItem {

	public String toString() {
		return "";
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof IRentItem))
			return false;
		return true;
	}
}
