package NK1;

import junit.framework.TestCase;

public class CylinderTest extends TestCase {
	public void testCylinderConstructor() {
		Cylinder c1 = new Cylinder(new Circle(new CartPt(2, 2), 2), 4);
	}

	public void testVolume() {
		Cylinder c1 = new Cylinder(new Circle(new CartPt(2, 2), 2), 4);
		assertEquals(c1.volume(), 16 * Math.PI);
	}

	public void testSurfaceArea() {
		Cylinder c1 = new Cylinder(new Circle(new CartPt(2, 2), 2), 4);
		assertEquals(c1.surfaceArea(), 16 * Math.PI);
	}
}
