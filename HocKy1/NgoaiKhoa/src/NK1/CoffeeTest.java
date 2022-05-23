package NK1;

import junit.framework.TestCase;

public class CoffeeTest extends TestCase {
	public void testCoffeeConstructor() {
		Coffee c1 = new Coffee("Haiwaiian Kona", 15.95, 100);
		Coffee c2 = new Coffee("Ethiopian", 8.0, 1000);
		Coffee c3 = new Coffee("Colombian Supreme", 9.5, 1700);

	}

//	public void testCost() {
//		Coffee c1 = new Coffee("Haiwaiian Kona", 15.95, 100);// 1595
//		Coffee c2 = new Coffee("Ethiopian", 8.0, 1000);// 8000
//		Coffee c3 = new Coffee("Colombian Supreme", 9.5, 1700);// 16150
//		assertEquals(c1.cost(), 1595.0);
//		assertEquals(c2.cost(), 8000.0);
//		assertEquals(c3.cost(), 16150.0);

//	}

	public void testPriceOver() {
		Coffee c1 = new Coffee("Haiwaiian Kona", 15.95, 100);
		Coffee c2 = new Coffee("Ethiopian", 8.0, 1000);
		Coffee c3 = new Coffee("Colombian Supreme", 9.5, 1700);
		assertTrue(c1.priceOver(12.0));
		assertFalse(c2.priceOver(12.0));
		assertFalse(c3.priceOver(12.0));

	}

	public void testCost() {
	Coffee c1 = new Coffee("Haiwaiian Kona", 15.95, 100);// 1595
	Coffee c2 = new Coffee("Ethiopian", 8.0, 1000);// 8000
	Coffee c3 = new Coffee("Colombian Supreme", 9.5, 1700);// 16150
assertEquals(c1.cost(), 0.0);
assertEquals(c2.cost(), 800.0);
assertEquals(c3.cost(), 1615.0);
}
	}
	
