package Execise5;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	public void testBookConstructor() {
		ABook h1 = new HardCover("Hoa vàng", "Đỗ Bình", 100000, 2018);
		ABook p1 = new PaperBackBook("Hoa đỏ", "Đỗ Bình", 100000, 2017);
		ABook s1 = new SaleBook("Hoa hồng", "Đỗ Bình", 100000, 2016);
	}

	public void testSalePrice() {
		ABook h1 = new HardCover("Hoa vàng", "Đỗ Bình", 100000, 2018);
		ABook p1 = new PaperBackBook("Hoa đỏ", "Đỗ Bình", 100000, 2017);
		ABook s1 = new SaleBook("Hoa hồng", "Đỗ Bình", 100000, 2016);
		assertEquals(h1.salePrice(), 20000.0);
		assertEquals(p1.salePrice(), 100000.0);
		assertEquals(s1.salePrice(), 50000.0);

	}

	public void testCheaperBook() {
		ABook h1 = new HardCover("Hoa vàng", "Đỗ Bình", 120000, 2018);
		ABook p1 = new PaperBackBook("Hoa đỏ", "Đỗ Bình", 110000, 2017);
		ABook s1 = new SaleBook("Hoa hồng", "Đỗ Bình", 100000, 2016);
		assertTrue(p1.cheaperThan(h1));
		assertFalse(h1.cheaperThan(s1));

	}

	public void testSameAuthor() {
		ABook h1 = new HardCover("Hoa vàng", "Đỗ Bình", 100000, 2018);
		ABook p1 = new PaperBackBook("Hoa đỏ", "Đỗ Bình", 100000, 2017);
		ABook s1 = new SaleBook("Hoa hồng", "Điểm", 100000, 2016);
		assertTrue(h1.sameAuthor(p1));
		assertFalse(p1.sameAuthor(s1));
	}
}
