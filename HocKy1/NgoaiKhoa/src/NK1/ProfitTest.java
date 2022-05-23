package NK1;

import junit.framework.TestCase;

public class ProfitTest extends TestCase {
	public void testProfitConstructor() {
		Profit p1 = new Profit(1000,10);

	}

	public void testTotalProfit() {
		Profit p1 = new Profit(1000,10);
		assertEquals(p1.totalProfit(), 4300.0);
	}
}
