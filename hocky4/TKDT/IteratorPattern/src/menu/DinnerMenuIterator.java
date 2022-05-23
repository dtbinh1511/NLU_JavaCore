package menu;

import java.util.Iterator;

public class DinnerMenuIterator implements Iterator<Object> {
	private MenuItem[] item;
	private int position = 0;

	public DinnerMenuIterator(MenuItem[] item) {
		super();
		this.item = item;
	}

	@Override
	public boolean hasNext() {
		if (position >= item.length || item[position] == null)
			return false;
		return true;
	}

	@Override
	public Object next() {
		MenuItem menuItem = item[position++];
		return menuItem;
	}

}
