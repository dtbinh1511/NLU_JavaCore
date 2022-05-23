package NK3;

import junit.framework.TestCase;

public class ShapeTest extends TestCase {
	public void testShapeConstructor() {
		// test for class CartPt
		CartPt p1 = new CartPt(2, 4);
		CartPt p2 = new CartPt(3, 5);
		// test for class Dot
		IShape d1 = new Dot(p1);
		IShape d2 = new Dot(p2);
		// test for class Square
		IShape s1 = new Square(p1, 5);
		IShape s2 = new Square(p2, 2);
		// test for class Circle
		IShape c1 = new Circle(p1, 3);
		IShape c2 = new Circle(p2, 1);

	}

	public void testArea() {
		CartPt p1 = new CartPt(2, 4);
		CartPt p2 = new CartPt(3, 5);

		IShape d1 = new Dot(p1);
		IShape d2 = new Dot(p2);
		assertEquals(d1.area(), 0.0);
		assertEquals(d2.area(), 0.0);

		IShape s1 = new Square(p1, 5);
		IShape s2 = new Square(p2, 2);
		assertEquals(s1.area(), 25.0);
		assertEquals(s2.area(), 4.0);

		IShape c1 = new Circle(p1, 3);
		IShape c2 = new Circle(p2, 1);
		assertEquals(c1.area(), 9 * Math.PI);
		assertEquals(c2.area(), Math.PI);

	}

	public void testDistanceToO() {
		CartPt p1 = new CartPt(2, 4);
		CartPt p2 = new CartPt(1, 2);
		CartPt p3 = new CartPt(2, 2);

		IShape d1 = new Dot(p1);
		assertEquals(d1.distanceToO(), 2 * Math.sqrt(5));

		IShape s1 = new Square(p2, 5);
		assertEquals(s1.distanceToO(), Math.sqrt(5));

		IShape c1 = new Circle(p3, 3);
		assertEquals(c1.distanceToO(), 2 * Math.sqrt(2));

	}
}
