package NK10;

public class ConsLibraryItem implements ILibraryItem {
	private LibraryItem first;
	private ILibraryItem rest;

	public ConsLibraryItem(LibraryItem first, ILibraryItem rest) {
		super();
		this.first = first;
		this.rest = rest;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsLibraryItem other = (ConsLibraryItem) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (rest == null) {
			if (other.rest != null)
				return false;
		} else if (!rest.equals(other.rest))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.first.toString() + ""+this.rest.toString() ;
	}

	// dem so sach thao khao va truyen trong danh sach
	@Override
	public int howManyBookAndStory() {
		if (this.first instanceof ReferenceBook || this.first instanceof Story)
			return 1 + this.rest.howManyBookAndStory();
		return this.rest.howManyBookAndStory();
	}

	@Override
	public ILibraryItem getItemOfAuthor(String nameAuthor) {
		if (this.first.sameAuthor(nameAuthor))
			return new ConsLibraryItem(this.first, this.rest.getItemOfAuthor(nameAuthor));
		return this.rest.getItemOfAuthor(nameAuthor);
	}

	@Override
	public ILibraryItem getStoryItemOfAuthor(String nameAuthor) {
		if (this.first instanceof Story)
			if (this.first.sameAuthor(nameAuthor))
				return new ConsLibraryItem(this.first, this.rest.getStoryItemOfAuthor(nameAuthor));
		return this.rest.getStoryItemOfAuthor(nameAuthor);
	}

	@Override
	public ILibraryItem getJournalItems() {
		if (this.first.getType().equals("Journal") && this.first.isPublishedIn(2014))
			return new ConsLibraryItem(this.first, this.rest.getJournalItems());
		return this.rest.getJournalItems();
	}

// sap xep theo ten an pham theo thu tu tang dan
	public ILibraryItem sortByTitle() {
		return this.rest.sortByTitle().insertByTitle(first);
	}

	public ILibraryItem insertByTitle(LibraryItem other) {
		if (this.first.compareTo(other) < 0)
			return new ConsLibraryItem(first, rest.insertByTitle(other));
		return new ConsLibraryItem(other, this);
	}

// sap xep theo ten tac gia theo thu thu giam dan
	public ILibraryItem sortByAuthor() {
		return this.rest.sortByAuthor().insertByAuthor(first);
	}

	@Override
	public ILibraryItem insertByAuthor(LibraryItem other) {
		if (this.first.compareToo(other) < 0)
			return new ConsLibraryItem(other, this);
		return new ConsLibraryItem(first, rest.insertByAuthor(other));
	}

}
