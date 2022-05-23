package NK1;

import junit.framework.TestCase;

public class StarTest extends TestCase {
	public void testStarConstructor() {
		Star s1 = new Star("Binh", "Do", "piano", 100000);
	}

	public void testSame() {
		Star s1 = new Star("Binh", "Do", "piano", 100000);
		Star s2 = new Star("Binh", "Do", "piano", 100000);
		assertTrue(s1.same(s2));
	}

	public void testBiggerSales() {
		Star s1 = new Star("Binh", "Do", "piano", 100000);
		Star s2 = new Star("Binh", "Do", "piano", 200000);
          assertFalse(s1.biggerSales(s2));
}
	public void testIncrementSales() {
		Star s1 = new Star("Binh", "Do", "piano", 100000);
		Star s2 = new Star("Binh", "Do", "piano", 120000);
		assertTrue(s1.incrementSales().same(s2));
	}
	public void testMuatableIncrementSales() {
		Star s1 = new Star("Binh", "Do", "piano", 100000);
		Star s2 = new Star("Binh", "Do", "piano", 200000);
		s1.muatbleIncrementSales();
		s2.muatbleIncrementSales();
		assertEquals(s1.getSales(), 120000);
		assertEquals(s2.getSales(), 220000);
	}
}
