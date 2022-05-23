package task2;

import junit.framework.TestCase;

public class JetFuelTest extends TestCase {
	public void testJetFuelConstructor() {
		JetFuel f1 = new JetFuel(1000, "very good", 100000);
	}

	public void testTotalCostConstructor() {
		JetFuel f1 = new JetFuel(1000, "very good", 100000);
		assertEquals(f1.totalCost(), 100000000.0, 0.001);
	}

	public void testDiscountPrice() {
		JetFuel f1 = new JetFuel(900000, "very good", 10);
		assertEquals(f1.discountPrice(), 900000.0);
	}
}
