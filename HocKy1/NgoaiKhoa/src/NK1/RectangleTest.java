package NK1;

import junit.framework.TestCase;

public class RectangleTest extends TestCase {
	public void testRectangleConstructor() {
		Rectangle r1 = new Rectangle(new CartPt(2, 2), 4, 6);
	}

//	public void testDistanceToO() {
//		Rectangle r1 = new Rectangle(new CartPt(2, 2), 4, 6);
//		assertEquals(r1.distanceToO(), 2 * Math.sqrt(2));
//	}

	public void testDistanceCenterToO() {
		Rectangle r1 = new Rectangle(new CartPt(2, 2), 4, 6);
		assertEquals(r1.distanceCenterToO(), Math.sqrt(41));
	}
}
