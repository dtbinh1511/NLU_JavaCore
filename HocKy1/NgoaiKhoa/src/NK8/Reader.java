package NK8;

public class Reader {
	public String name;
	public String email;
	public IRentItem rentItems;

	public Reader(String name, String email, IRentItem rentItems) {
		super();
		this.name = name;
		this.email = email;
		this.rentItems = rentItems;
	}

	public String toString() {
		return "\n" + "o  " + this.name + "," + this.email + "\n" + this.rentItems;
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Reader))
			return false;
		else {
			Reader other = (Reader) obj;
			return this.name.equals(other.name) && this.email.equals(other.email)
					&& this.rentItems.equals(other.rentItems);
		}
	}
}
