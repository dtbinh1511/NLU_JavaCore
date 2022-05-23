import junit.framework.TestCase;

public class CoffeeTest extends TestCase {
	public void testCoffeeConstrutor() {
		Coffee C1 = new Coffee("Ca Phe Trung Nguyen", 10000, 2);
	}

	public void testCost() {
		Coffee C1 = new Coffee("Ca Phe Trung Nguyen", 10000, 2);
		assertEquals(C1.cost(), 18000.0, 0.001);
	}
}
