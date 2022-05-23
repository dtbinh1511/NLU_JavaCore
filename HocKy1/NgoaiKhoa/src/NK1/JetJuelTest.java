package NK1;

import junit.framework.TestCase;

public class JetJuelTest extends TestCase {
	public void testJetJuelConstructor() {
		JetJuel j1 = new JetJuel(100000, "Good", 12);
	}

	public void testTotalCost() {
		JetJuel j1 = new JetJuel(100000, "Good", 12);
		assertEquals(j1.totalCost(), 1200000.0);
	}

	public void testDiscountPrice() {
		JetJuel j1 = new JetJuel(100000, "Good", 12);
		assertEquals(j1.discountPrice(), 1080000.0);
	}
}
