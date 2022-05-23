package menu;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHousMenuIterator implements Iterator<Object> {
	private ArrayList<MenuItem> menuItems;
	private int position = 0;

	public PancakeHousMenuIterator(ArrayList<MenuItem> menuItems) {
		super();
		this.menuItems = menuItems;
	}

	@Override
	public boolean hasNext() {
		if (position >= menuItems.size())
			return false;
		return true;
	}

	@Override
	public Object next() {
		MenuItem menuItem = menuItems.get(position++);
		return menuItem;
	}

}
