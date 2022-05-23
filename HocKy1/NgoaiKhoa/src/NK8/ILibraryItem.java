package NK8;

public interface ILibraryItem {
	public String toString();

//	public ILibraryItem sortByType();
//
//	public ILibraryItem insertByType(LibraryItem other);
	public int howManyStoryAndJournal();

	public boolean equals(Object obj);

	public ILibraryItem getItemsOfPublisher(String publisherOther);

	public ILibraryItem sortByAuthor();

	public ILibraryItem insertByAuthor(LibraryItem that);
}
