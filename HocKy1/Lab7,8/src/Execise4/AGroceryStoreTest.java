package Execise4;

import junit.framework.TestCase;

public class AGroceryStoreTest extends TestCase {
public void testAGroceryStoreConStructor() {
	AGroceryStore c1= new Coffee("Trung Nguyen Legends", 1000, 100000, "Chon");
	AGroceryStore j1 = new Juice("Coca", 2, 20000, "xa xi", "frozen");
	AGroceryStore i1 = new IceCream("coba", 100, 5000, "dau", "fresh");
	
}
public void testUnitPrice() { 
	AGroceryStore c1= new Coffee("Trung Nguyen Legends", 10, 100000, "Chon");
	AGroceryStore j1 = new Juice("Coca", 2, 20000, "xa xi", "frozen");
	AGroceryStore i1 = new IceCream("coba", 100, 5000, "dau", "fresh");
	assertEquals(c1.unitPrice(), 1000000.0);
	assertEquals(j1.unitPrice(), 40000.0);
	assertEquals(i1.unitPrice(), 500000.0);
}
public void testLowerPrice() {
	AGroceryStore c1= new Coffee("Trung Nguyen Legends", 10, 100000, "Chon");
	AGroceryStore j1 = new Juice("Coca", 2, 20000, "xa xi", "frozen");
	AGroceryStore i1 = new IceCream("coba", 100, 5000, "dau", "fresh");
	assertFalse(c1.lowerPrice(10000.0));
	assertTrue(j1.lowerPrice(50000.0));
	assertTrue(i1.lowerPrice(600000.0));
	
}
public void testCheaperThan() {
	AGroceryStore c1= new Coffee("Trung Nguyen Legends", 10, 100000, "Chon");
	AGroceryStore j1 = new Juice("Coca", 2, 20000, "xa xi", "frozen");
	AGroceryStore i1 = new IceCream("coba", 100, 5000, "dau", "fresh");
	assertTrue(j1.cheaperThan(c1));
	assertFalse(c1.cheaperThan(i1));
	
}
}
