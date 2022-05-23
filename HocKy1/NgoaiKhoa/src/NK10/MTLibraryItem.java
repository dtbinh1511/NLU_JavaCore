package NK10;

public class MTLibraryItem implements ILibraryItem {

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MTLibraryItem))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public int howManyBookAndStory() {
		return 0;
	}

	@Override
	public ILibraryItem getItemOfAuthor(String nameAuthor) {
		return new MTLibraryItem();
	}

	@Override
	public ILibraryItem getStoryItemOfAuthor(String nameAuthor) {
		return new MTLibraryItem();
	}

	@Override
	public ILibraryItem getJournalItems() {
		return new MTLibraryItem();
	}

	@Override
	public ILibraryItem sortByTitle() {
		return new MTLibraryItem();
	}

	@Override
	public ILibraryItem insertByTitle(LibraryItem other) {
		return new ConsLibraryItem(other, new MTLibraryItem());
	}

	@Override
	public ILibraryItem sortByAuthor() {
		return new MTLibraryItem();
	}

	@Override
	public ILibraryItem insertByAuthor(LibraryItem other) {
		return new ConsLibraryItem(other, new MTLibraryItem());
	}

}
