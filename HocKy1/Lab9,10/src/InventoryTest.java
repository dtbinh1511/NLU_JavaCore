
import junit.framework.TestCase;

public class InventoryTest extends TestCase {
	public void testConstructor() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);
		Toy t3 = new Toy("Robot", 150.0, 5);
		Toy t4 = new Toy("Katana", 150.0, 5);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);
		Inventory i3 = new ConsInventory(t3, i2);
		Inventory i4 = new ConsInventory(t4, i3);

		System.out.println(i4);
//		System.out.println(i4.sortByName());
//		System.out.println(i4.averagePrice());
//		System.out.println(i4.equals(all));
//		System.out.println(i2.raisePrice());

	}

	public void testEquals() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);
		Toy t3 = new Toy("Robot", 150.0, 5);
		Toy t4 = new Toy("Katana", 150.0, 5);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);
		Inventory i3 = new ConsInventory(t3, i2);
		Inventory i4 = new ConsInventory(t4, i3);

		Inventory all = new ConsInventory(t4,
				new ConsInventory(t3, new ConsInventory(t2, new ConsInventory(t1, empty))));

		assertTrue(i4.equals(all));
	}

	public void testContain() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);
		Toy t3 = new Toy("Robot", 150.0, 5);
		Toy t4 = new Toy("Katana", 150.0, 5);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);
		Inventory i3 = new ConsInventory(t3, i2);
		Inventory i4 = new ConsInventory(t4, i3);

		assertTrue(i4.contains("Katana"));
		assertFalse(i3.contains("Katana"));
		assertTrue(i2.contains("Car"));

	}

	public void testIsBelow() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);
		Toy t3 = new Toy("Robot", 150.0, 5);
		Toy t4 = new Toy("Katana", 150.0, 5);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);
		Inventory i3 = new ConsInventory(t3, i2);
		Inventory i4 = new ConsInventory(t4, i3);

		assertTrue(i4.isBelow(2100.0));
		assertFalse(i4.isBelow(100.0));
		assertFalse(i3.isBelow(1900.0));
	}

	public void testHowMany() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);
		Toy t3 = new Toy("Robot", 150.0, 5);
		Toy t4 = new Toy("Katana", 150.0, 5);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);
		Inventory i3 = new ConsInventory(t3, i2);
		Inventory i4 = new ConsInventory(t4, i3);

		Inventory all = new ConsInventory(t4,
				new ConsInventory(t3, new ConsInventory(t2, new ConsInventory(t1, empty))));

		assertEquals(i4.howMany(), 15.0);
		assertEquals(i3.howMany(), 10.0);
		assertEquals(i2.howMany(), 5.0);

	}

	public void testRaisePrice() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);

		Toy t3 = new Toy("Car", 105.0, 3);
		Toy t4 = new Toy("Plane", 2100.0, 2);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);

		Inventory i3 = new ConsInventory(t3, empty);
		Inventory i4 = new ConsInventory(t4, i3);

		assertEquals(i2.raisePrice(), i4);
	}

	public void testRaisePriceMutuable() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);

		Toy t3 = new Toy("Car", 105.0, 3);
		Toy t4 = new Toy("Plane", 2100.0, 2);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);

		i2.raisePriceMutuable();

		assertEquals(i2, new ConsInventory(t4, new ConsInventory(t3, empty)));
	}

	public void testToTalPrice() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);
		Toy t3 = new Toy("Robot", 150.0, 5);
		Toy t4 = new Toy("Katana", 150.0, 5);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);
		Inventory i3 = new ConsInventory(t3, i2);
		Inventory i4 = new ConsInventory(t4, i3);

		assertEquals(i4.totalPrice(), 2400.0);
	}

	public void testAveragePrice() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);
		Toy t3 = new Toy("Robot", 150.0, 5);
		Toy t4 = new Toy("Katana", 150.0, 5);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);
		Inventory i3 = new ConsInventory(t3, i2);
		Inventory i4 = new ConsInventory(t4, i3);

		assertEquals(i4.averagePrice(), 160.0);
	}

	public void testReplaceName() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);
		Toy t3 = new Toy("Plane", 100.0, 3);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);

		i2.replaceName("Car", "Plane");
		assertEquals(i2, new ConsInventory(t2, new ConsInventory(t3, empty)));

	}

	public void testEliminate() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);

		assertEquals(i2.eliminate("Car"), new ConsInventory(t2, new MTInvetory()));
	}

	public void tesSortByName() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);
		Toy t3 = new Toy("Robot", 150.0, 5);
		Toy t4 = new Toy("Katana", 150.0, 5);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);
		Inventory i3 = new ConsInventory(t3, i2);
		Inventory i4 = new ConsInventory(t4, i3);

		assertEquals(i4.sortByName(), new ConsInventory(t1,
				new ConsInventory(t4, new ConsInventory(t2, new ConsInventory(t3, new MTInvetory())))));

	}
	public void testMaxPrice() {
		Toy t1 = new Toy("Car", 100.0, 3);
		Toy t2 = new Toy("Plane", 2000.0, 2);
		Toy t3 = new Toy("Robot", 150.0, 5);
		Toy t4 = new Toy("Katana", 150.0, 5);

		Inventory empty = new MTInvetory();
		Inventory i1 = new ConsInventory(t1, empty);
		Inventory i2 = new ConsInventory(t2, i1);
		Inventory i3 = new ConsInventory(t3, i2);
		Inventory i4 = new ConsInventory(t4, i3);
		
		assertEquals(i4.maxPrice(), new Toy("Plane", 2000.0, 2));
	}
}
