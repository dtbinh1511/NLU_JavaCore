package iterator;

public interface Menu {
	public Iterator createIterator();

	public void addItem(String name, String description, boolean vegetarian, double price);
}
