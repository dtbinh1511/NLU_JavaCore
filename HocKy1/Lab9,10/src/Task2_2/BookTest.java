package Task2_2;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	public void testBookConstructor() {
		ABook h1 = new HardCover("Hoa vàng trên cỏ xanh", "Đỗ Bình", 100000, 2018);
		ABook p1 = new PaperBackBook("Nàng bạch tuyết và bảy chú lùn", "Đỗ Bình", 100000, 2017);
		ABook s1 = new SaleBook("Dấu chân", "Bình", 100000, 2016);

		IBook empty = new MTBook();
		IBook cons1 = new ConsBook(h1, empty);
		IBook cons2 = new ConsBook(p1, cons1);
		IBook cons3 = new ConsBook(s1, cons2);

		System.out.println(cons3);
	}

	public void testThisAuthor() {
		ABook h1 = new HardCover("Hoa vàng trên cỏ xanh", "Đỗ Bình", 100000, 2018);
		ABook p1 = new PaperBackBook("Nàng bạch tuyết và bảy chú lùn", "Đỗ Bình", 100000, 2017);
		ABook s1 = new SaleBook("Dấu chân", "Bình", 100000, 2016);

		IBook empty = new MTBook();
		IBook cons1 = new ConsBook(h1, empty);
		IBook cons2 = new ConsBook(p1, cons1);
		IBook cons3 = new ConsBook(s1, cons2);

		assertEquals(cons3.thisAuthor("Đỗ Bình"), new ConsBook(p1, new ConsBook(h1, new MTBook())));
	}

	public void testSortByTitle() {
		ABook h1 = new HardCover("Hoa vàng trên cỏ xanh", "Đỗ Bình", 100000, 2018);
		ABook p1 = new PaperBackBook("Nàng bạch tuyết và bảy chú lùn", "Đỗ Bình", 100000, 2017);
		ABook s1 = new SaleBook("Dấu chân", "Bình", 100000, 2016);

		IBook empty = new MTBook();
		IBook cons1 = new ConsBook(h1, empty);
		IBook cons2 = new ConsBook(p1, cons1);
		IBook cons3 = new ConsBook(s1, cons2);

		IBook cons4 = new ConsBook(p1, empty);
		IBook cons5 = new ConsBook(h1, cons4);
		IBook cons6 = new ConsBook(s1, cons5);

		assertEquals(cons3.sortByTitle(), cons6);

	}
}
