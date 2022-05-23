package Task2_2;

public class MTBook implements IBook {

	@Override
	public String toString() {
		return "";
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MTBook))
			return false;
		return true;
	}

	@Override
	public IBook thisAuthor(String nameAuthor) {
		return new MTBook();
	}

	@Override
	public IBook sortByTitle() {
		return new MTBook();
	}

	@Override
	public IBook insertByTitle(ABook that) {
		return new ConsBook(that, this);
	}

}
