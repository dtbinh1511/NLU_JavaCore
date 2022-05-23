package Task2_2;

public class ConsBook implements IBook {
	public ABook first;
	public IBook rest;

	public ConsBook(ABook first, IBook rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	@Override
	public String toString() {
		return this.first.toString() + this.rest.toString();
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ConsBook))
			return false;
		else {
			ConsBook other = (ConsBook) obj;
			return this.first.equals(other.first) && this.rest.equals(other.rest);
		}
	}
	@Override
	public IBook thisAuthor(String other) {
		if (this.first.sameAuthor(other))
			return new ConsBook(this.first, this.rest.thisAuthor(other));
		return this.rest.thisAuthor(other);

	}
	@Override
	public IBook sortByTitle() {
		return this.rest.sortByTitle().insertByTitle(first);
	}

	@Override
	public IBook insertByTitle(ABook that) {
		if (this.first.compareTo(that) < 0)
			return new ConsBook(this.first, this.rest.insertByTitle(that));
		return new ConsBook(that, this);
	}

	

}
