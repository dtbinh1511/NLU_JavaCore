package NK9;

public class Name {
	private String lastName;
	private String middleName;
	private String firstName;

	public Name(String lastName, String middleName, String firstName) {
		super();
		this.lastName = lastName;
		this.middleName = middleName;
		this.firstName = firstName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Name))
			return false;
		else {
			Name that = (Name) obj;
			return this.lastName.equals(that.lastName) && this.middleName.equals(that.middleName)
					&& this.firstName.equals(that.firstName);
		}
	}

	@Override
	public String toString() {
		return this.lastName + " " + this.middleName + " " + this.firstName;
	}

	public String getName() {
		return this.lastName + " " + this.middleName + " " + this.firstName;
	}

	public boolean containsOrSame(String that) {
		return this.getName().contains(that);
	}

	/*public int compareTo(Name that) {
		if (this.firstName.compareTo(that.firstName) > 0)
			return 1;
		else {
			if (this.firstName.compareTo(that.firstName) < 0)
				return -1;
			else if (this.firstName.compareTo(that.firstName) == 0)
				if (this.middleName.compareTo(that.middleName) > 0)
					return 1;
			if (this.middleName.compareTo(that.middleName) < 0)
				return -1;
			if (this.middleName.compareTo(that.middleName) == 0)
				if (this.lastName.compareTo(that.lastName) > 0)
					return 1;
			if (this.lastName.compareTo(that.lastName) < 0)
				return -1;
		}
		return 0;

	}*/
}
