package finalAHung;

public class MTLibraryItems implements ILibraryItems {

	@Override
	public ILibraryItems sortByAuthorName() {
		return new MTLibraryItems();
	}

	@Override
	public ILibraryItems insertByAuthorName(LibraryItem item) {
		return new ConsLibraryItems(item, this);
	}
	@Override
	public String toString() {
		return "";
	}
}
