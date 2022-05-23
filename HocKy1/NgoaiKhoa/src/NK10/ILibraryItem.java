package NK10;

public interface ILibraryItem {
	public int howManyBookAndStory();

	public ILibraryItem getItemOfAuthor(String nameAuthor);

	public ILibraryItem getStoryItemOfAuthor(String nameAuthor);

	public ILibraryItem getJournalItems();

	public ILibraryItem sortByTitle();

	public ILibraryItem insertByTitle(LibraryItem other);

	public ILibraryItem sortByAuthor();

	public ILibraryItem insertByAuthor(LibraryItem other);

	public boolean equals(Object obj);

	public String toString();

}
