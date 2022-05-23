package finalAHung;

public class ConsLibraryItems implements ILibraryItems {
	private LibraryItem first;
	private ILibraryItems rest;

	public ConsLibraryItems(LibraryItem first, ILibraryItems rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	@Override
	public ILibraryItems sortByAuthorName() {
		return this.rest.sortByAuthorName().insertByAuthorName(this.first);
	}

	@Override
	public ILibraryItems insertByAuthorName(LibraryItem item) {
		if (this.first.hasAuthorNameBefore(item))
			return new ConsLibraryItems(this.first, this.rest.insertByAuthorName(item));
		else
			return new ConsLibraryItems(item, this);
	}
	
	@Override
	public String toString() {
		return this.first+"\n"+this.rest;
	}

}
