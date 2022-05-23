import junit.framework.TestCase;

public class TestCD extends TestCase {
	public void testCDConstructor() {
		CD CD1 = new CD("Hay Trao Cho Anh", 100000000);
	}

	public void testInterest() {
		CD CD1 = new CD("Hay Trao Cho Anh", 100000);
		assertEquals(CD1.interest(), 25000.0);
	}
}
