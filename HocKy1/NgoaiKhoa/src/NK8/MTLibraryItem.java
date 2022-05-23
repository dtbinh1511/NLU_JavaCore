package NK8;

public class MTLibraryItem implements ILibraryItem {

	public String toString() {
		return "";

	}

	@Override
	public int howManyStoryAndJournal() {
		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MTLibraryItem))
			return false;
		return true;
	}

	@Override
	public ILibraryItem getItemsOfPublisher(String publisherOther) {
		return new MTLibraryItem();

	}

	@Override
	public ILibraryItem sortByAuthor() {
		return new MTLibraryItem();
	}

	@Override
	public ILibraryItem insertByAuthor(LibraryItem that) {
		return new ConsLibraryItem(that, new MTLibraryItem());
	}

//	@Override
//	public ILibraryItem insertByType(LibraryItem other) {
//		return new ConsLibraryItem(other, new MTLibraryItem());
//	}
//
//	@Override
//	public ILibraryItem sortByType() {
//		return new MTLibraryItem();
//	}

}
