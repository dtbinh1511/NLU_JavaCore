package iterator;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements Iterator {
	private ArrayList<MenuItem> menuItems;
	private int position = 0;

	public PancakeHouseMenuIterator(ArrayList<MenuItem> menuItems) {
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
