package Task3;

import junit.framework.TestCase;

public class TestStar extends TestCase {
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

	public void testGetSales() {
		Star s1 = new Star("Binh", "Do Thanh", "piano", 100000);
		Star s2 = new Star("Thu", "Nguyen Thi Anh", "piano", 90000);
		assertEquals(s1.getSales(), 100000);
		assertEquals(s2.getSales(), 90000);

	}

	public void testIncremenSales() {
		Star s1 = new Star("Binh", "Do Thanh", "piano", 100000);
		Star s2 = new Star("Thu", "Nguyen Thi Anh", "piano", 90000);
		s1.incrementSales().same(new Star("Binh", "Do Thanh", "piano", 120000));
		s2.incrementSales().same(new Star("Thu", "Nguyen Thi Anh", "piano", 110000));
	}

	public void testMuatbleIncrementSales() {
		Star s1 = new Star("Binh", "Do Thanh", "piano", 100000);
		Star s2 = new Star("Thu", "Nguyen Thi Anh", "piano", 90000);
		s1.muatbleIncrementSales();
		assertEquals(s1.getSales(), 120000);
		s2.muatbleIncrementSales();
		assertEquals(s2.getSales(), 110000);
	}
}
