package Execise5;

import junit.framework.TestCase;

public class HouseTest extends TestCase {
	public void testHouseConstructor() {
		Address a1 = new Address(23, "Maple Street", "Brookline");
		Address a2 = new Address(5, "Joye Road", "Newton");
		Address a3 = new Address(83, "Winslow Road", "Waltham");

		House h1 = new House("Ranch", 7, 375000, a1);
		House h2 = new House("Colonial", 9, 450000, a2);
		House h3 = new House("Cape", 6, 235000, a3);

	}

	public void testHasMoreRooms() {
		Address a1 = new Address(23, "Maple Street", "Brookline");
		Address a2 = new Address(5, "Joye Road", "Newton");
		Address a3 = new Address(83, "Winslow Road", "Waltham");

		House h1 = new House("Ranch", 7, 375000, a1);
		House h2 = new House("Colonial", 9, 450000, a2);
		House h3 = new House("Cape", 6, 235000, a3);
		assertFalse(h1.hasMoreRooms(h2));
		assertFalse(h3.hasMoreRooms(h2));
		assertTrue(h2.hasMoreRooms(h1));
	}

	public void testInThisCity(String city) {
		Address a1 = new Address(23, "Maple Street", "Brookline");
		Address a2 = new Address(5, "Joye Road", "Newton");
		Address a3 = new Address(83, "Winslow Road", "Waltham");

		House h1 = new House("Ranch", 7, 375000, a1);
		House h2 = new House("Colonial", 9, 450000, a2);
		House h3 = new House("Cape", 6, 235000, a3);
		assertTrue(a1.inThisCity("Brookline"));
		assertTrue(a2.inThisCity("Newton"));
		assertTrue(a3.inThisCity("Waltham"));

	}

	public void testSameCity(Address other) {
		Address a1 = new Address(23, "Maple Street", "Brookline");
		Address a2 = new Address(5, "Joye Road", "Newton");
		Address a3 = new Address(83, "Winslow Road", "Waltham");

		House h1 = new House("Ranch", 7, 375000, a1);
		House h2 = new House("Colonial", 9, 450000, a2);
		House h3 = new House("Cape", 6, 235000, a3);
		assertFalse(h1.sameCity(h2));
		assertFalse(h1.sameCity(h3));
	}
}
