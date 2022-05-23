package NK1;

import junit.framework.TestCase;

public class RestaurantTest extends TestCase {
	public void testRestaurantConstructor() {
		Restaurant r1 = new Restaurant("Italia", "Nooddle", new Intersection(3, 4));
		Restaurant r2 = new Restaurant("paris", "modle", new Intersection(2, 4));
		Restaurant r3 = new Restaurant("spain", "cow", new Intersection(2, 5));

	}
	public void testCloseTo() {
		Restaurant r1 = new Restaurant("Italia", "Nooddle", new Intersection(3, 4));
		Restaurant r2 = new Restaurant("paris", "modle", new Intersection(2, 4));
		Restaurant r3 = new Restaurant("spain", "cow", new Intersection(2, 5));
		assertTrue(r1.closeTo(r2));
		assertTrue(r2.closeTo(r3));
		assertTrue(r1.closeTo(r3));
	}
}
