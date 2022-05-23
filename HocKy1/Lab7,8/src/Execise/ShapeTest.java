package Execise;

import junit.framework.TestCase;

public class ShapeTest extends TestCase {
public void testDistanceToO() {
	CartPt c1 = new CartPt(2, 0);
	CartPt c2 = new CartPt(1, 0);
	CartPt c3 = new CartPt(4, 0);

	AShape d1 = new Dot(c1);
	AShape c = new Circle(c2, 2);
	AShape s1 = new Square(c3, 4);
	
	assertEquals(d1.distanceToO(), 2.0);
	assertEquals(c.distanceToO(), 1.0);
	assertEquals(s1.distanceToO(), 4.0);
	
}
}
