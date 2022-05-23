package NK8;

public class ConsLibraryItem implements ILibraryItem {
	public LibraryItem first;
	public ILibraryItem rest;

	public ConsLibraryItem(LibraryItem first, ILibraryItem rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	public String toString() {
		return this.first.toString() + this.rest.toString();
	}

	@Override
	public int howManyStoryAndJournal() {
		if (this.first instanceof Story || this.first instanceof Journal)
			return 1 + this.rest.howManyStoryAndJournal();
		return this.rest.howManyStoryAndJournal();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ConsLibraryItem))
			return false;
		else {
			ConsLibraryItem other = (ConsLibraryItem) obj;
			return this.first.equals(other.first) && this.rest.equals(other.rest);
		}
	}

	@Override
	public ILibraryItem getItemsOfPublisher(String publisherOther) {
		if (this.first.samePublisher(publisherOther))
			return new ConsLibraryItem(this.first, this.rest.getItemsOfPublisher(publisherOther));
		return this.rest.getItemsOfPublisher(publisherOther);
	}

	@Override
	public ILibraryItem sortByAuthor() {
		return this.rest.sortByAuthor().insertByAuthor(first);
	}

	@Override
	public ILibraryItem insertByAuthor(LibraryItem that) {
		if (this.first.compareTo(that) < 0)
			return new ConsLibraryItem(first, rest.insertByAuthor(that));
		return new ConsLibraryItem(that, this);
	}

}

//	@Override
//	public ILibraryItem sortByType() {
//		return this.rest.sortByType().insertByType(first);
//	}
//
//	@Override
//	public ILibraryItem insertByType(LibraryItem other) {
//		if (other instanceof first.ReferenceBook )
//			return new ConsLibraryItem(other, new ConsLibraryItem(first,rest).insertByType(other));
//					return new ConsLibraryItem(other, rest.insertByType(first));
//	}
