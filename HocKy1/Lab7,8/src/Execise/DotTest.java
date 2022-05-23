package Execise;

import junit.framework.TestCase;

public class DotTest extends TestCase {
	public void testDotConstructor() {
		CartPt c1 = new CartPt(2, 2);
		AShape d1 = new Dot(c1);
	}

	public void testArea() {
		CartPt c1 = new CartPt(2, 2);
		AShape d1 = new Dot(c1);
		assertEquals(d1.area(), 0.0);
	}
	public void testDistanceToO() {
		CartPt c1 = new CartPt(2, 0);
		AShape d1 = new Dot(c1);
		assertEquals(d1.distanceToO(), 2.0);
	}
	public void testDistanceTo() {
		CartPt c1 = new CartPt(2, 2);
		AShape d1 = new Dot(c1);
		CartPt c2 = new CartPt(1, 1);
		assertEquals(d1.distanceTo(c2), Math.sqrt(2));

	}
	public void testContains() {
		CartPt c1 = new CartPt(2, 2);
		AShape d1 = new Dot(c1);
		CartPt c2 = new CartPt(1, 1);
		assertTrue(d1.contains(c1));
	}
}
