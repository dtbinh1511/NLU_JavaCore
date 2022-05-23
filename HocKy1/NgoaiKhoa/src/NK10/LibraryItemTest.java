package NK10;

import junit.framework.TestCase;

public class LibraryItemTest extends TestCase {
	LibraryItem r1 = new ReferenceBook(101, "Bậc thầy mô giới địa ốc", new Author("Henry Hùng Anh Dũng", 1960),
			"NXB Trẻ", 7, 300000, "Kinh tế");
	LibraryItem r2 = new ReferenceBook(102, "Nhạc lý căn bản và nâng cao", new Author("Lương Bằng Vinh", 1970),
			"NXB Thị Nghè", 7, 30000, "Nhạc");
	LibraryItem s1 = new Story(201, "Doremon", new Author("Fujiko. F. Fujio", 1950), "NXB Kim Đồng", 3, 20000);
	LibraryItem s2 = new Story(202, "Tôi thấy hoa vàng trên cỏ xanh", new Author("Nguyễn Nhật Ánh", 1955), "NXB Trẻ", 3,
			45000);
	LibraryItem s3 = new Story(203, "Harry Potter and the Hafl-Blood Prince", new Author("J.K. Rowling", 1965),
			"Bloomsbury Publishing PLC", 3, 270000);

	LibraryItem j1 = new Journal(301, "Thế giới vi tính số 256", new Author("Trần Hưng", 1989), "PC World Việt Nam", 1,
			20000, new Date(14, 2, 2014));
	LibraryItem j2 = new Journal(302, "Nhịp cầu đầu tư số 387", new Author("Nguyễn Dũng", 0), "MTV Ấn Phẩm", 1, 15000,
			new Date(20, 6, 2015));

	ILibraryItem empty1 = new MTLibraryItem();
	ILibraryItem Consli1 = new ConsLibraryItem(j2, empty1);
	ILibraryItem Consli2 = new ConsLibraryItem(j1, Consli1);
	ILibraryItem Consli3 = new ConsLibraryItem(s3, Consli2);
	ILibraryItem Consli4 = new ConsLibraryItem(s2, Consli3);
	ILibraryItem Consli5 = new ConsLibraryItem(s1, Consli4);
	ILibraryItem Consli6 = new ConsLibraryItem(r2, Consli5);
	ILibraryItem Consli7 = new ConsLibraryItem(r1, Consli6);

	RentItem Ren1 = new RentItem(r1, 4);
	RentItem Ren2 = new RentItem(j1, 4);
	RentItem Ren3 = new RentItem(r2, 10);
	RentItem Ren4 = new RentItem(s2, 3);

	IRentItem empty = new MTRentItem();
	IRentItem Consren1 = new ConsRentItem(Ren1, empty);
	IRentItem Consren2 = new ConsRentItem(Ren2, Consren1);
	IRentItem Consren3 = new ConsRentItem(Ren3, empty);
	IRentItem Consren4 = new ConsRentItem(Ren4, Consren3);

	Reader R1 = new Reader("Nguyen Tuan", "tuanng@gmai.com", Consren2);
	Reader R2 = new Reader("Le Phuong Lan", "lanphuong@gmail.com", Consren4);
	Reader R3 = new Reader("Do Binh", "a", Consren4);

	public void testGetType() {
		assertEquals(s1.getType(), "Story");
		assertEquals(j1.getType(), "Journal");
		assertEquals(r1.getType(), "ReferenceBook");
		assertEquals(s2.getType(), "Story");
		assertEquals(j2.getType(), "Journal");
		assertEquals(r2.getType(), "ReferenceBook");
	}

	public void testIsPublisher() {
		assertFalse(j2.isPulisher("PC world "));
		assertTrue(r1.isPulisher("NXB Trẻ"));
	}

	public void testLossFee() {
		assertEquals(r1.lossFee(), 225000.0);
		assertEquals(s1.lossFee(), 20000.0);
		assertEquals(j1.lossFee(), 15000.0);

	}

	public void testHowManyBookAndStory() {
		assertEquals(Consli7.howManyBookAndStory(), 5);
	}

	public void testGetItemOfAuthor() {
		assertEquals(Consli7.getItemOfAuthor("Nguyễn Nhật Ánh"), new ConsLibraryItem(s2, empty1));
	}

	public void testGetStoryItemsOfAuthor() {
		assertEquals(Consli7.getStoryItemOfAuthor("J.K. Rowling"), new ConsLibraryItem(s3, empty1));
	}

	public void testJournalItem() {
		assertEquals(Consli7.getJournalItems(), new ConsLibraryItem(j1, empty1));
	}

	public void testSortByTitle() {
		assertEquals(Consli7.sortByTitle(),
				new ConsLibraryItem(r1, new ConsLibraryItem(s1, new ConsLibraryItem(s3, new ConsLibraryItem(r2,
						new ConsLibraryItem(j2, new ConsLibraryItem(j1, new ConsLibraryItem(s2, empty1))))))));

	}

	public void testSortByAuthor() {
		assertEquals(Consli7.sortByAuthor(),
				new ConsLibraryItem(j1, new ConsLibraryItem(s2, new ConsLibraryItem(j2, new ConsLibraryItem(r2,
						new ConsLibraryItem(s3, new ConsLibraryItem(r1, new ConsLibraryItem(s1, empty1))))))));
	}

	public void testIsRentSameTitle() {
		assertFalse(R1.isRentSameItem(R2, "Doremon"));
		assertTrue(R3.isRentSameItem(R2, "Tôi thấy hoa vàng trên cỏ xanh"));
	}

	public void testFineTotal() {
		assertEquals(R1.fineTotal(), 225.0);
		assertEquals(R2.fineTotal(), 337.5);
	}
}
