package NK1;

import junit.framework.TestCase;

public class ImageTest extends TestCase {
	public void testImageConstructor() {
		Image i1 = new Image(100, 111, "VietNam", "Good");
	}

	public void testIsPortrait() {
		Image i1 = new Image(100, 111, "VietNam", "Good");
		assertTrue(i1.isPortrait());
	}

	public void testSize() {
		Image i1 = new Image(100, 111, "VietNam", "Good");
		assertEquals(i1.size(), 11100);
	}


	public void testSame() {
		Image i1 = new Image(100, 100, "VietNam", "Good");
		Image i2 = new Image(100, 111, "VietNam", "Good");
		assertFalse(i1.same(i2));
	}

	public void testSizeString() {
		Image i1 = new Image(100, 100, "VietNam", "Good");
		Image i2 = new Image(100, 111, "VietNam", "Good");
		i1.sizeString().equals("small");
		i2.sizeString().equals("medium");
	}
	public void testIsLarge() {
		Image i1 = new Image(100, 100, "VietNam", "Good");
		Image i2 = new Image(100, 111, "VietNam", "Good");
		assertTrue(i2.isLarger(i1));
		
	}
}
