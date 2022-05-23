package iterator;

import java.util.Hashtable;

public class CaffeeMenuIterator implements Iterator {
	private Hashtable<Integer, MenuItem> menuItems = new Hashtable<>();
	private Integer position = 0;

	public CaffeeMenuIterator(Hashtable<Integer, MenuItem> menuItems) {
		super();
		this.menuItems = menuItems;
	}

	@Override
	public boolean hasNext() {
		if (position >= menuItems.size() || menuItems.get(position) == null)
			return false;
		return true;
	}

	@Override
	public Object next() {
		MenuItem menuItem = menuItems.get(position++);
		return menuItem;
	}

}
