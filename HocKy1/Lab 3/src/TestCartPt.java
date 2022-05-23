import junit.framework.TestCase;

public class TestCartPt extends TestCase {
	public void testCartPtConstruction() {
		new CartPt(2, 3);
	}

	public void testDistanceToO() {
		CartPt C1 = new CartPt(2, 3);
		assertEquals(C1.distanceToO(), Math.sqrt(13.0), 0.001);
	}

	public void testDistanceTo(CartPt that) {
		CartPt C1 = new CartPt(2, 4);
		CartPt C2 = new CartPt(1, 3);
		assertEquals(C1.distanceTo(C2), Math.sqrt(2.0), 0.001);
	}
}
