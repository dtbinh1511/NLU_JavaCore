package Execise;

import junit.framework.TestCase;

public class CircleTest extends TestCase {
	public void testCircleConstructor() {
		CartPt c1 = new CartPt(2, 2);
		AShape C1 = new Circle(c1, 5);
	}

	public void testArea() {
		CartPt c1 = new CartPt(2, 2);
		AShape C1 = new Circle(c1, 5);
		assertEquals(C1.area(), 25 * Math.PI);
	}

	public void testDistanceToO() {
		CartPt c1 = new CartPt(2, 2);
		AShape C1 = new Circle(c1, 5);
		assertEquals(C1.distanceToO(), 2 * Math.sqrt(2));
	}

	public void testDistanceTo() {
		CartPt c1 = new CartPt(2, 2);
		AShape C1 = new Circle(c1, 5);

		CartPt c2 = new CartPt(1, 1);
		assertEquals(C1.distanceTo(c2), Math.sqrt(2));

	}

	public void testContains() {
		CartPt c1 = new CartPt(2, 2);
		AShape C1 = new Circle(c1, 5);
		CartPt c2 = new CartPt(1, 1);
		assertTrue(C1.contains(c1));
	}
}
