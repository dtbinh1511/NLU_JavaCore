package NK10;

public class Author {
	private String name;
	private int birthYear;

	public Author(String name, int birthYear) {
		super();
		this.name = name;
		this.birthYear = birthYear;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (birthYear != other.birthYear)
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
		return this.name + " " + this.birthYear;
	}

	public boolean sameAuthor(String nameAuthor) {
		return this.name.equals(nameAuthor);
	}

	public int compareTo(Author other) {

		return this.name.compareTo(other.name);
	}
}
