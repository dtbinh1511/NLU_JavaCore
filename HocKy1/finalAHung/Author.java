package finalAHung;

public class Author {
	private String name;
	private int birthYear;

	public Author(String name, int birthYear) {
		super();
		this.name = name;
		this.birthYear = birthYear;
	}

	public boolean hasNameBefore(Author author) {
		return this.name.compareTo(author.name) < 0;
	}

	@Override
	public String toString() {
		return name + ", " + birthYear;
	}

}
