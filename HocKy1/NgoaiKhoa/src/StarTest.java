import junit.framework.TestCase;

public class StarTest extends TestCase {
	public void testStarConstructor() {
		Star s1 = new Star("Binh", "Do Thanh", "piano", 120000);
		Star s2 = new Star("Binh", "Do Thanh", "piano", 130000);

	}

	public void testIncrementSales() {

		Star s1 = new Star("Binh", "Do Thanh", "piano", 120000);
		s1.icrementSales().same(new Star("Binh", "Do Thanh", "piano", 140000));
//		Star s2 = s1.icrementSales();
//		assertEquals(s1.icrementSales(), s2 );
	}

	public void testMutableIcrementSales() {
		Star s1 = new Star("Binh", "Do Thanh", "piano", 120000);
		s1.mutableIncrementSales();
		assertEquals(s1.getSales(), 140000);
	}
}
