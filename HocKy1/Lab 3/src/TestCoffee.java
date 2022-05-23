import junit.framework.TestCase;

public class TestCoffee extends TestCase {
public void testCoffeeConstruction () {
	 new Coffee ("Chon", 15.95, 100);
}
public void testCost () {
	Coffee cf1 = new Coffee ("Chon", 15.95, 100);
	assertEquals (cf1.cost(), 1595.0);
	
}
public void testPriceOver () {
	Coffee cf2 = new Coffee ("Meo", 8.0, 1000);
	assertFalse(cf2.priceOver(12));
}
}
