package iterator;

import java.util.Hashtable;

public class CaffeeMenu implements Menu {
	private Hashtable<Integer, MenuItem> menuItems;
	private Integer position = 0;

	public CaffeeMenu() {
		menuItems = new Hashtable<>();
		addItem("Veggie Burger and Air Fries", "Veggie burger on a whole wheat bun, lettuce, tomato, and fries", true,
				3.99);
		addItem("Soup of the day", "A cup of the soup of the day, with a side salad", false, 3.69);
		addItem("Burrito", "A large burrito, with whole pinto beans, salsa, guacamole", true, 4.29);
	}

	@Override
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.put(position++, menuItem);
	}

	@Override
	public Iterator createIterator() {
		return new CaffeeMenuIterator(menuItems);
	}
}
