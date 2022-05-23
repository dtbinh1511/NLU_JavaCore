package Execise2;

import junit.framework.TestCase;

public class CartPtTest extends TestCase {
	public void testCartPtConstructor() {
		CartPt c1 = new CartPt(2, 3);

	}

	public void testDistanceToO() {
		CartPt c1 = new CartPt(4, 3);
		assertEquals(c1.distanceToO(), 5.0);
	}
}
