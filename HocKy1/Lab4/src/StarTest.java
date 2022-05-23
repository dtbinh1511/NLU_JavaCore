import junit.framework.TestCase;

public class StarTest extends TestCase {
	public void testStarConstructor() {
		Star s1 = new Star("Binh", "Do Thanh", "piano", 100000);
	}

	public void testBiggerSalesConstructor() {
		Star s1 = new Star("Binh", "Do Thanh", "piano", 100000);
		Star s2 = new Star("Thu", "Nguyen Thi Anh", "piano", 90000);
		assertTrue(s1.biggerSales(s2));
	}

	public void testSame() {
		Star s1 = new Star("Binh", "Do Thanh", "piano", 100000);
		Star s2 = new Star("Thu", "Nguyen Thi Anh", "piano", 90000);
		assertFalse(s1.same(s2));
	}

	public void testEquals() {
		Star s1 = new Star("Binh", "Do Thanh", "piano", 100000);
		Star s2 = new Star("Thu", "Nguyen Thi Anh", "piano", 90000);
		assertFalse(s1.same(s2));
	}
}
