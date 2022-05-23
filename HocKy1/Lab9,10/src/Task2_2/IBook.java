package Task2_2;

public interface IBook {
	public String toString();

	public boolean equals(Object obj);

	public IBook thisAuthor(String other);

	public IBook sortByTitle();

	public IBook insertByTitle(ABook that);
}
