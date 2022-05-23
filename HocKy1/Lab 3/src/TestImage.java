import junit.framework.TestCase;

public class TestImage extends TestCase {
	public void testImageConstrctor() {
		Image image1 = new Image(12, 11, "google", "good");

	}

	public void testIsPortrait() {
		Image image1 = new Image(12, 11, "google", "good");
		assertFalse(image1.isPortrait());
	}

	public void testSize() {
		Image i2 = new Image(10, 11, "google", "good");
		assertEquals(i2.size(), 110.0, 0.001);

	}

	public void testIsLarge() {
		Image i3 = new Image(4, 11, "google", "good");
		Image i2 = new Image(10, 11, "google", "good");
		assertFalse(i3.isLarger(i2));
	}

	public void testSame() {
		Image i3 = new Image(4, 11, "google", "good");
		Image i2 = new Image(10, 11, "google", "good");
		assertFalse(i3.equals(i2));
	}

	public void testSizeString() {
		Image i3 = new Image(4, 11, "google", "good");
		Image i2 = new Image(10, 11, "google", "good");
		assertEquals(i2.sizeString(), "small");
	}
}
