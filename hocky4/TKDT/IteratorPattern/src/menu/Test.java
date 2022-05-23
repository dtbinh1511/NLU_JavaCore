package menu;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
//		PancakeHouseMenu houseMenu = new PancakeHouseMenu();
//		ArrayList<MenuItem> breakfast = houseMenu.getMenuItems();
//		DinnerMenu dinnerMenu = new DinnerMenu();
//		MenuItem[] dinner = dinnerMenu.getMenuItems();
//
//		for (int i = 0; i < dinner.length; i++) {
//			MenuItem menuItem = dinner[i];
//			System.out.println(menuItem.getName());
//		}
//		
//		System.out.println("-------");
//		for (int i = 0; i < breakfast.size(); i++) {
//			MenuItem menuItem = breakfast.get(i);
//
//			System.out.println(menuItem.getName());
//		}

		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinnerMenu dinerMenu = new DinnerMenu();
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		waitress.printMenu();
		waitress.printVegetarianMenu();
		System.out.println("\nCustomer asks, is the Hotdog vegetarian?");
		System.out.print("Waitress says: ");
		if (waitress.isItemVegetarian("Hotdog")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		System.out.println("\nCustomer asks, are the Waffles vegetarian?");
		System.out.print("Waitress says: ");
		if (waitress.isItemVegetarian("Waffles")) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}
}
