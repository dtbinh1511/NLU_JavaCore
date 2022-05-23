package Execise6;

import junit.framework.TestCase;

public class BookTest extends TestCase {
	public void testBookConstuctor() {
		Author a1 = new Author("Do Thanh Binh", 1950);
		Book b1 = new Book("Trinh Tham", 100000, 2010, a1);

	}

	public void testCurrentBook() {
		Author a1 = new Author("Do Thanh Binh", 1950);
		Book b1 = new Book("Trinh Tham", 100000, 2010, a1);
		assertFalse(b1.currentBook());

	}

	public void testCurrentAuthor() {
		Author a1 = new Author("Do Thanh Binh", 1950);
		Book b1 = new Book("Trinh Tham", 100000, 2010, a1);
		assertTrue(b1.currentAuthor());
	}

	public void testThisAuthor() {
		Author a1 = new Author("Do Thanh Binh", 1950);
		Book b1 = new Book("Trinh Tham", 100000, 2010, a1);
		assertTrue(a1.thisAuthor("Do Thanh Binh"));
	}

	public void testSameAuthor() {
		Author a1 = new Author("Do Thanh Binh", 1950);
		Book b1 = new Book("Trinh Tham", 100000, 2010, a1);
		Author a2 = new Author("Do Thanh Binh", 1950);
		Book b2 = new Book("Trinh Tham", 100000, 2010, a2);
		assertTrue(b1.sameAuthor(b2));
	}

	public void testSameGeneration() {
		Author a1 = new Author("Do Thanh Binh", 1950);
		Book b1 = new Book("Trinh Tham", 100000, 2010, a1);
		Author a2 = new Author("Do Binh", 1970);
		Book b2 = new Book("Trinh Tham", 100000, 2010, a2);
		assertFalse(b1.sameGeneration(b2));
	}
}
