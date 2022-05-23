import junit.framework.TestCase;

public class HouseTest extends TestCase {
	public void testHouseConstructor() {
		Address a1 = new Address(23, "Maple Street", "Brookline");
		House h1 = new House("Ranch", 7, 375000, a1);

	}

	public void testHasMoreRooms() {
		Address a1 = new Address(23, "Maple Street", "Brookline");
		House h1 = new House("Ranch", 7, 375000, a1);
		Address a2 = new Address(23, "Maple Street", "Brookline");
		House h2 = new House("Ranch", 8, 375000, a1);
		assertFalse(h1.hasMoreRooms(h2));
	}
public void testInThisCity () {
	Address a1 = new Address(23, "Maple Street", "Brookline");
	House h1 = new House("Ranch", 7, 375000, a1);
	Address a2 = new Address(23, "Maple Street", "Brookline");
	House h2 = new House("Ranch", 8, 375000, a1);
	assertTrue(a1.inThisCity("Brookline"));
	
}
public void testSameCity () {
	Address a1 = new Address(23, "Maple Street", "Brookline");
	House h1 = new House("Ranch", 7, 375000, a1);
	Address a2 = new Address(23, "Maple Street", "Brookline");
	House h2 = new House("Ranch", 8, 375000, a1);
	assertTrue(a1.sameCity(a2));
}
}
