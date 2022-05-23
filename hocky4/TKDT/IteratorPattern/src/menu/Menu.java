package menu;

import java.util.Iterator;

public interface Menu {
	public void addItem(String name, String description, boolean vegetarian, double price);
	public Iterator<Object> createIterator();
}
