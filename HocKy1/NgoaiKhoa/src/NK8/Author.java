package NK8;

public class Author {
	public String name;
	public int birthYear;

	public Author(String name, int birthYear) {
		super();
		this.name = name;
		this.birthYear = birthYear;
	}

	public String toString() {
		return this.name + "," + this.birthYear;
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Author))
			return false;
		else {
			Author other = (Author) obj;
			return this.name.equals(other.name) && this.birthYear == other.birthYear;
		}
	}

	public boolean sameAuthor(String nameAuthor) {
		return this.name.equals(nameAuthor);
	}

	public int compareTo(Author that) {
		return this.name.compareTo(that.name);
	}
}
