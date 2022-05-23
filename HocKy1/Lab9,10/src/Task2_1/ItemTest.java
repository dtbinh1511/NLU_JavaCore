package Task2_1;

import junit.framework.TestCase;

public class ItemTest extends TestCase {
	public void testConstructor() {
		AnItem C1 = new Coffee("Trung Nguyen Lengend", 100.0, 12000.0, "Fox Caffe");
		AnItem I1 = new IceCream("Trang Tien", 100.0, 12000.0, "Strawberry Flavor", "Ice Cream Box");
		AnItem J1 = new Juice("Yomost", 100.0, 12000.0, "Strawberry Flavor", "Lyophiclic Juice");

		IShoppingList empty = new MTShoppingList();
		IShoppingList cons1 = new ConsShoppingList(C1, empty);
		IShoppingList cons2 = new ConsShoppingList(I1, cons1);
		IShoppingList cons3 = new ConsShoppingList(J1, cons2);

		System.out.println(cons3);

	}

	public void testHowMany() {
		AnItem C1 = new Coffee("Trung Nguyen Lengend", 100.0, 12000.0, "Fox Caffe");
		AnItem I1 = new IceCream("Trang Tien", 100.0, 12000.0, "Strawberry Flavor", "Ice Cream Box");
		AnItem J1 = new Juice("Yomost", 100.0, 12000.0, "Strawberry Flavor", "Lyophiclic Juice");

		IShoppingList empty = new MTShoppingList();
		IShoppingList cons1 = new ConsShoppingList(C1, empty);
		IShoppingList cons2 = new ConsShoppingList(I1, cons1);
		IShoppingList cons3 = new ConsShoppingList(J1, cons2);

		assertEquals(cons3.howMany(), 3);
	}

	public void testBrandList() {
		AnItem C1 = new Coffee("Trung Nguyen Lengend", 100.0, 12000.0, "Fox Caffe");
		AnItem I1 = new IceCream("Trang Tien", 100.0, 12000.0, "Strawberry Flavor", "Ice Cream Box");
		AnItem J1 = new Juice("Yomost", 100.0, 12000.0, "Strawberry Flavor", "Lyophiclic Juice");

		IShoppingList empty = new MTShoppingList();
		IShoppingList cons1 = new ConsShoppingList(C1, empty);
		IShoppingList cons2 = new ConsShoppingList(I1, cons1);
		IShoppingList cons3 = new ConsShoppingList(J1, cons2);

		assertEquals(cons3.brandList(), "Yomost"+  "Trang Tien" + "Trung Nguyen Lengend");
	}
	public void testHighestPrice() {
		AnItem C1 = new Coffee("Trung Nguyen Lengend", 100.0, 30000.0, "Cookie socola");
		AnItem I1 = new IceCream("Trang Tien", 100.0, 10000.0, "Strawberry Flavor", "Ice Cream Box");
		AnItem J1 = new Juice("Yomost", 100.0, 14000.0, "Strawberry Flavor", "Lyophiclic Juice");

		IShoppingList empty = new MTShoppingList();
		IShoppingList cons1 = new ConsShoppingList(C1, empty);
		IShoppingList cons2 = new ConsShoppingList(I1, cons1);
		IShoppingList cons3 = new ConsShoppingList(J1, cons2);

		assertEquals(cons3.highestPrice(), 30000.0);
	}

}
