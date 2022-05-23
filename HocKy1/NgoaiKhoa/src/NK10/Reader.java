package NK10;

public class Reader {
	private String name;
	private String email;
	private IRentItem listRent;

	public Reader(String name, String email, IRentItem listRent) {
		super();
		this.name = name;
		this.email = email;
		this.listRent = listRent;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reader other = (Reader) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (listRent == null) {
			if (other.listRent != null)
				return false;
		} else if (!listRent.equals(other.listRent))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.name + this.email + this.listRent;
	}

	// kiem tra xem 2 doc gia co muon cung mot an pham co ten cho truoc
	public boolean isRentSameItem(Reader other, String thatTitle) {
		return this.listRent.isRentSomeItem(thatTitle) && other.listRent.isRentSomeItem(thatTitle);
	}

	public double fineTotal() {
		return this.listRent.fineTotal();
	}
}
