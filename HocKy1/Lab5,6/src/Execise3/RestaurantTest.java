package Execise3;

import junit.framework.TestCase;

public class RestaurantTest extends TestCase {
	public void testRestaurantConstructor() {
		Intersection i1 = new Intersection(3, 4);
		Intersection i2 = new Intersection(4, 4);
		Intersection i3 = new Intersection(5, 4);
		Restaurant r1 = new Restaurant("KFC", "Chiken", "20000 - 50000", i1);
		Restaurant r2 = new Restaurant("SlowFood", "Rice and vegestable", "20000 - 50000", i2);
		Restaurant r3 = new Restaurant("FastFood", "Hamberger", "20000 - 50000", i3);

	}

	public void testCloseTo() {
		Intersection i1 = new Intersection(3, 4);
		Intersection i2 = new Intersection(4, 4);
		Intersection i3 = new Intersection(5, 4);
		Restaurant r1 = new Restaurant("KFC", "Chiken", "20000 - 50000", i1);
		Restaurant r2 = new Restaurant("SlowFood", "Rice and vegestable", "20000 - 50000", i2);
		Restaurant r3 = new Restaurant("FastFood", "Hamberger", "20000 - 50000", i3);
		assertTrue(r1.closeTo(r2));
		assertFalse(r1.closeTo(r3));
		assertTrue(r2.closeTo(r3));
	}
}
