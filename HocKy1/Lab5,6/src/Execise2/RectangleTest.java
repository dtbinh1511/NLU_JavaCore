package Execise2;

import junit.framework.TestCase;

public class RectangleTest extends TestCase {
	public void testRectangleConstructor() {
		CartPt c1 = new CartPt(2, 3);
		Rectangle r1 = new Rectangle(c1, 3, 3);

	}

	public void testDistanceToO() {
		CartPt c1 = new CartPt(2, 3);
		Rectangle r1 = new Rectangle(c1, 3, 3);
		double d = r1.distanceToO();
		assertEquals(d, Math.sqrt(13), 0.001);
	}


	public void testDistanceFromCenterToO() {
		CartPt c1 = new CartPt(1, 1);
		Rectangle r1 = new Rectangle(c1, 2, 2);
		assertEquals(r1.center().distanceToO(), 2 * Math.sqrt(2), 0.001);
	}
}
