package Execise;

import junit.framework.TestCase;

public class SquareTest extends TestCase {
	public void testSquareConstructor() {
		CartPt c1 = new CartPt(2, 2);
		AShape s1 = new Square(c1, 5);
	}

	public void testArea() {
		CartPt c1 = new CartPt(2, 2);
		AShape s1 = new Square(c1, 5);
		assertEquals(s1.area(), 25.0);
	}
	public void testDistanceToO() {
		CartPt c1 = new CartPt(2, 2);
		AShape s1 = new Square(c1, 5);
		assertEquals(s1.distanceToO(), 2 * Math.sqrt(2));
	}
	public void testDistanceTo() {
		CartPt c1 = new CartPt(2, 2);
		AShape s1 = new Square(c1, 5);
		CartPt c2 = new CartPt(1, 1);
		assertEquals(s1.distanceTo(c2), Math.sqrt(2));

	}
	public void testContains() {
		CartPt c1 = new CartPt(2, 2);
		AShape s1 = new Square(c1, 5);
		CartPt c2 = new CartPt(1, 1);
		assertTrue(s1.contains(c1));
}
}
