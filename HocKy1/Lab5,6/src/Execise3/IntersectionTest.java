package Execise3;

import junit.framework.TestCase;

public class IntersectionTest extends TestCase {
	public void testIntersectionConstruction() {
		Intersection i1 = new Intersection(3, 4);
		Intersection i2 = new Intersection(4, 4);
		Intersection i3 = new Intersection(5, 4);

	}

	public void testCloseTo() {
		Intersection i1 = new Intersection(3, 4);
		Intersection i2 = new Intersection(4, 4);
		Intersection i3 = new Intersection(5, 4);
		assertTrue(i1.closeTo(i2));
		assertFalse(i1.closeTo(i3));
		assertTrue(i2.closeTo(i3));
	}
}
