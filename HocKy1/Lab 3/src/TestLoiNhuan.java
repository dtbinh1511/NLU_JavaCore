import junit.framework.TestCase;

public class TestLoiNhuan extends TestCase {
	public void testLoiNhuanConstructor() {
		LoiNhuan LN1 = new LoiNhuan(100, 5, 20);
	}

	public void testTienLoi() {
		LoiNhuan LN1 = new LoiNhuan(100, 5, 20);
		assertEquals(LN1.tienLoi(), 230.0);
	}
}
