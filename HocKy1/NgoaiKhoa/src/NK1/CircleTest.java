package NK1;

import junit.framework.TestCase;

public class CircleTest extends TestCase {
	public void testCircleConstructor() {
		Circle c1 = new Circle(new CartPt(2, 5), 1);
	}

	public void testPerimeter() {
		Circle c1 = new Circle(new CartPt(2, 5), 1);

		assertEquals(c1.perimeter(), 2 * Math.PI);
	}

	public void testArea() {
		Circle c1 = new Circle(new CartPt(2, 5), 1);
		assertEquals(c1.area(), Math.PI);
	}

	public void testRing() {
		Circle c1 = new Circle(new CartPt(2, 5), 1);
		Circle c2 = new Circle(new CartPt(2, 5), 2);
		assertEquals(c1.ring(c2), 3 * Math.PI);
	}
}
