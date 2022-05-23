package menu;

import java.util.Iterator;

public class Waitress {
	private PancakeHouseMenu pancakeHouseMenu;
	private DinnerMenu dinnerMenu;

	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinnerMenu dinnerMenu) {
		super();
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinnerMenu = dinnerMenu;
	}

	public void printMenu() {
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinnerIterator = dinnerMenu.createIterator();
		System.out.println("MENU\n----------\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinnerIterator);
	}

	public void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem item = (MenuItem) iterator.next();
			System.out.println(item.getName());
		}
	}

	public void printVegetarianMenu() {
		System.out.println("\nMenu vegetarian\n");
		printVegetarianMenu(pancakeHouseMenu.createIterator());
		printVegetarianMenu(dinnerMenu.createIterator());

	}

	public void printVegetarianMenu(Iterator iterator) {
		while (iterator.hasNext()) {
			MenuItem item = (MenuItem) iterator.next();
			if (isItemVegetarian(item.getName())) {
				System.out.println(item.getName());
			}
		}
	}

	public boolean isItemVegetarian(String name) {
		Iterator pancake = pancakeHouseMenu.createIterator();
		if (isItemVegetarian(name, pancake))
			return true;
		Iterator dinner = dinnerMenu.createIterator();
		if (isItemVegetarian(name, dinner))
			return true;
		return false;
	}

	public boolean isItemVegetarian(String name, Iterator iterator) {
		boolean isVegetarian = false;
		while (iterator.hasNext()) {
			MenuItem item = (MenuItem) iterator.next();
			if (item.getName().equals(name)) {
				isVegetarian = item.isVegetarian();
				break;
			}
		}
		return isVegetarian;
	}
}
