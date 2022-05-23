package NK8;

import junit.framework.TestCase;

public class LibraryItemTest extends TestCase {
	public void testConStructor() {
		LibraryItem r1 = new ReferenceBook(101, "Bậc thầy mô giới địa ốc", new Author("Henry Hùng Anh Dũng", 1960),
				"NXB Trẻ", 7, 30000, "Kinh tế");
		LibraryItem r2 = new ReferenceBook(102, "Nhạc lý căn bản và nâng cao", new Author("Lương Bằng Vinh", 1970),
				"NXB Thị Nghè", 7, 30000, "Nhạc");
		LibraryItem s1 = new Story(201, "Doremon", new Author("Fujiko. F. Fujio", 1950), "NXB Kim Đồng", 3, 20000);
		LibraryItem s2 = new Story(202, "Tôi thấy hoa vàng trên cỏ xanh", new Author("Nguyễn Nhật Ánh", 1955),
				"NXB Trẻ", 3, 45000);
		LibraryItem s3 = new Story(203, "Harry Potter and the Hafl-Blood Prince", new Author("J.K. Rowling", 1965),
				"Bloomsbury Publishing PLC", 3, 270000);

		LibraryItem j1 = new Journal(301, "Thế giới vi tính số 256", new Author("-", 0), "PC World Việt Nam", 1, 20000,
				new Date(14, 2, 2014));
		LibraryItem j2 = new Journal(302, "Nhịp cầu đầu tư số 387", new Author("-", 0), "MTV Ấn Phẩm", 1, 15000,
				new Date(20, 6, 2014));

		ILibraryItem empty1 = new MTLibraryItem();
		ILibraryItem Consli1 = new ConsLibraryItem(j2, empty1);
		ILibraryItem Consli2 = new ConsLibraryItem(j1, Consli1);
		ILibraryItem Consli3 = new ConsLibraryItem(s3, Consli2);
		ILibraryItem Consli4 = new ConsLibraryItem(s2, Consli3);
		ILibraryItem Consli5 = new ConsLibraryItem(s1, Consli4);
		ILibraryItem Consli6 = new ConsLibraryItem(r2, Consli5);
		ILibraryItem Consli7 = new ConsLibraryItem(r1, Consli6);

		System.out.println(Consli7.sortByAuthor());
	}

	public void testGetType() {
		LibraryItem r1 = new ReferenceBook(101, "Bậc thầy mô giới địa ốc", new Author("Henry Hùng Anh Dũng", 1960),
				"NXB Trẻ", 7, 30000, "Kinh tế");
		LibraryItem r2 = new ReferenceBook(102, "Nhạc lý căn bản và nâng cao", new Author("Lương Bằng Vinh", 1970),
				"NXB Thị Nghè", 7, 30000, "Nhạc");
		LibraryItem s1 = new Story(201, "Doremon", new Author("Fujiko. F. Fujio", 1950), "NXB Kim Đồng", 3, 20000);
		LibraryItem s2 = new Story(202, "Tôi thấy hoa vàng trên cỏ xanh", new Author("Nguyễn Nhật Ánh", 1955),
				"NXB Trẻ", 3, 4500);
		LibraryItem s3 = new Story(203, "Harry Potter and the Hafl-Blood Prince", new Author("J.K. Rowling", 1965),
				"Bloomsbury Publishing PLC", 3, 270000);

		LibraryItem j1 = new Journal(301, "Thế giới vi tính số 256", new Author("-", 0), "PC World Việt Nam", 1, 20000,
				new Date(14, 2, 2014));
		LibraryItem j2 = new Journal(302, "Nhịp cầu đầu tư số 387", new Author("-", 0), "MTV Ấn Phẩm", 1, 15000,
				new Date(20, 6, 2014));

		assertEquals(r1.getType(), "Bậc thầy mô giới địa ốc");
		assertEquals(r2.getType(), "Nhạc lý căn bản và nâng cao");
		assertEquals(s1.getType(), "Doremon");
		assertEquals(s2.getType(), "Tôi thấy hoa vàng trên cỏ xanh");
		assertEquals(s3.getType(), "Harry Potter and the Hafl-Blood Prince");
		assertEquals(j1.getType(), "Thế giới vi tính số 256");
		assertEquals(j2.getType(), "Nhịp cầu đầu tư số 387");
	}

	public void testIsAuthor() {
		LibraryItem r1 = new ReferenceBook(101, "Bậc thầy mô giới địa ốc", new Author("Henry Hùng Anh Dũng", 1960),
				"NXB Trẻ", 7, 30000, "Kinh tế");
		LibraryItem r2 = new ReferenceBook(102, "Nhạc lý căn bản và nâng cao", new Author("Lương Bằng Vinh", 1970),
				"NXB Thị Nghè", 7, 30000, "Nhạc");
		LibraryItem s1 = new Story(201, "Doremon", new Author("Fujiko. F. Fujio", 1950), "NXB Kim Đồng", 3, 20000);
		LibraryItem s2 = new Story(202, "Tôi thấy hoa vàng trên cỏ xanh", new Author("Nguyễn Nhật Ánh", 1955),
				"NXB Trẻ", 3, 4500);
		LibraryItem s3 = new Story(203, "Harry Potter and the Hafl-Blood Prince", new Author("J.K. Rowling", 1965),
				"Bloomsbury Publishing PLC", 3, 270000);

		LibraryItem j1 = new Journal(301, "Thế giới vi tính số 256", new Author("-", 0), "PC World Việt Nam", 1, 20000,
				new Date(14, 2, 2014));
		LibraryItem j2 = new Journal(302, "Nhịp cầu đầu tư số 387", new Author("-", 0), "MTV Ấn Phẩm", 1, 15000,
				new Date(20, 6, 2014));

		assertTrue(r1.isAuthor("Henry Hùng Anh Dũng"));
		assertFalse(r2.isAuthor("Henry Hùng Anh Dũng"));
		assertFalse(s1.isAuthor("Lương Bằng Vinh"));
		assertTrue(r2.isAuthor("Lương Bằng Vinh"));
		assertTrue(s1.isAuthor("Fujiko. F. Fujio"));
		assertFalse(s2.isAuthor("Fujiko. F. Fujio"));
		assertTrue(j1.isAuthor("-"));
		assertFalse(j2.isAuthor("Fujiko. F. Fujio"));

	}

	public void testLossFee() {
		LibraryItem r1 = new ReferenceBook(101, "Bậc thầy mô giới địa ốc", new Author("Henry Hùng Anh Dũng", 1960),
				"NXB Trẻ", 7, 30000, "Kinh tế");
		LibraryItem r2 = new ReferenceBook(102, "Nhạc lý căn bản và nâng cao", new Author("Lương Bằng Vinh", 1970),
				"NXB Thị Nghè", 7, 30000, "Nhạc");
		LibraryItem s1 = new Story(201, "Doremon", new Author("Fujiko. F. Fujio", 1950), "NXB Kim Đồng", 3, 20000);
		LibraryItem s2 = new Story(202, "Tôi thấy hoa vàng trên cỏ xanh", new Author("Nguyễn Nhật Ánh", 1955),
				"NXB Trẻ", 3, 45000);
		LibraryItem s3 = new Story(203, "Harry Potter and the Hafl-Blood Prince", new Author("J.K. Rowling", 1965),
				"Bloomsbury Publishing PLC", 3, 270000);

		LibraryItem j1 = new Journal(301, "Thế giới vi tính số 256", new Author("-", 0), "PC World Việt Nam", 1, 20000,
				new Date(14, 2, 2014));
		LibraryItem j2 = new Journal(302, "Nhịp cầu đầu tư số 387", new Author("-", 0), "MTV Ấn Phẩm", 1, 15000,
				new Date(20, 6, 2014));

		assertEquals(r1.lossFee(), 36000.0);
		assertEquals(r2.lossFee(), 36000.0);
		assertEquals(s1.lossFee(), 24000.0);
		assertEquals(s2.lossFee(), 54000.0);
		assertEquals(s3.lossFee(), 324000.0);
		assertEquals(j1.lossFee(), 16000.0);
		assertEquals(j2.lossFee(), 12000.0);

	}

	public void testHowManyStoryAndJournal() {
		LibraryItem r1 = new ReferenceBook(101, "Bậc thầy mô giới địa ốc", new Author("Henry Hùng Anh Dũng", 1960),
				"NXB Trẻ", 7, 30000, "Kinh tế");
		LibraryItem r2 = new ReferenceBook(102, "Nhạc lý căn bản và nâng cao", new Author("Lương Bằng Vinh", 1970),
				"NXB Thị Nghè", 7, 30000, "Nhạc");
		LibraryItem s1 = new Story(201, "Doremon", new Author("Fujiko. F. Fujio", 1950), "NXB Kim Đồng", 3, 20000);
		LibraryItem s2 = new Story(202, "Tôi thấy hoa vàng trên cỏ xanh", new Author("Nguyễn Nhật Ánh", 1955),
				"NXB Trẻ", 3, 45000);
		LibraryItem s3 = new Story(203, "Harry Potter and the Hafl-Blood Prince", new Author("J.K. Rowling", 1965),
				"Bloomsbury Publishing PLC", 3, 270000);

		LibraryItem j1 = new Journal(301, "Thế giới vi tính số 256", new Author("-", 0), "PC World Việt Nam", 1, 20000,
				new Date(14, 2, 2014));
		LibraryItem j2 = new Journal(302, "Nhịp cầu đầu tư số 387", new Author("-", 0), "MTV Ấn Phẩm", 1, 15000,
				new Date(20, 6, 2014));

		ILibraryItem empty1 = new MTLibraryItem();
		ILibraryItem Consli1 = new ConsLibraryItem(j2, empty1);
		ILibraryItem Consli2 = new ConsLibraryItem(j1, Consli1);
		ILibraryItem Consli3 = new ConsLibraryItem(s3, Consli2);
		ILibraryItem Consli4 = new ConsLibraryItem(s2, Consli3);
		ILibraryItem Consli5 = new ConsLibraryItem(s1, Consli4);
		ILibraryItem Consli6 = new ConsLibraryItem(r2, Consli5);
		ILibraryItem Consli7 = new ConsLibraryItem(r1, Consli6);

		assertEquals(Consli7.howManyStoryAndJournal(), 5);
	}

	public void testGetItemsOfPublisher() {

		LibraryItem r1 = new ReferenceBook(101, "Bậc thầy mô giới địa ốc", new Author("Henry Hùng Anh Dũng", 1960),
				"NXB Trẻ", 7, 30000, "Kinh tế");
		LibraryItem r2 = new ReferenceBook(102, "Nhạc lý căn bản và nâng cao", new Author("Lương Bằng Vinh", 1970),
				"NXB Thị Nghè", 7, 30000, "Nhạc");
		LibraryItem s1 = new Story(201, "Doremon", new Author("Fujiko. F. Fujio", 1950), "NXB Kim Đồng", 3, 20000);
		LibraryItem s2 = new Story(202, "Tôi thấy hoa vàng trên cỏ xanh", new Author("Nguyễn Nhật Ánh", 1955),
				"NXB Trẻ", 3, 45000);
		LibraryItem s3 = new Story(203, "Harry Potter and the Hafl-Blood Prince", new Author("J.K. Rowling", 1965),
				"Bloomsbury Publishing PLC", 3, 270000);

		LibraryItem j1 = new Journal(301, "Thế giới vi tính số 256", new Author("-", 0), "PC World Việt Nam", 1, 20000,
				new Date(14, 2, 2014));
		LibraryItem j2 = new Journal(302, "Nhịp cầu đầu tư số 387", new Author("-", 0), "MTV Ấn Phẩm", 1, 15000,
				new Date(20, 6, 2014));

		ILibraryItem empty1 = new MTLibraryItem();
		ILibraryItem Consli1 = new ConsLibraryItem(j2, empty1);
		ILibraryItem Consli2 = new ConsLibraryItem(j1, Consli1);
		ILibraryItem Consli3 = new ConsLibraryItem(s3, Consli2);
		ILibraryItem Consli4 = new ConsLibraryItem(s2, Consli3);
		ILibraryItem Consli5 = new ConsLibraryItem(s1, Consli4);
		ILibraryItem Consli6 = new ConsLibraryItem(r2, Consli5);
		ILibraryItem Consli7 = new ConsLibraryItem(r1, Consli6);

		assertEquals(Consli7.getItemsOfPublisher("NXB Trẻ"),
				new ConsLibraryItem(r1, new ConsLibraryItem(s2, new MTLibraryItem())));
	}

	public void testSortByAuthor() {
		LibraryItem r1 = new ReferenceBook(101, "Bậc thầy mô giới địa ốc", new Author("Henry Hùng Anh Dũng", 1960),
				"NXB Trẻ", 7, 30000, "Kinh tế");
		LibraryItem r2 = new ReferenceBook(102, "Nhạc lý căn bản và nâng cao", new Author("Lương Bằng Vinh", 1970),
				"NXB Thị Nghè", 7, 30000, "Nhạc");
		LibraryItem s1 = new Story(201, "Doremon", new Author("Fujiko. F. Fujio", 1950), "NXB Kim Đồng", 3, 20000);
		LibraryItem s2 = new Story(202, "Tôi thấy hoa vàng trên cỏ xanh", new Author("Nguyễn Nhật Ánh", 1955),
				"NXB Trẻ", 3, 45000);
		LibraryItem s3 = new Story(203, "Harry Potter and the Hafl-Blood Prince", new Author("J.K. Rowling", 1965),
				"Bloomsbury Publishing PLC", 3, 270000);

		LibraryItem j1 = new Journal(301, "Thế giới vi tính số 256", new Author("-", 0), "PC World Việt Nam", 1, 20000,
				new Date(14, 2, 2014));
		LibraryItem j2 = new Journal(302, "Nhịp cầu đầu tư số 387", new Author("-", 0), "MTV Ấn Phẩm", 1, 15000,
				new Date(20, 6, 2014));

		ILibraryItem empty1 = new MTLibraryItem();
		ILibraryItem Consli1 = new ConsLibraryItem(j2, empty1);
		ILibraryItem Consli2 = new ConsLibraryItem(j1, Consli1);
		ILibraryItem Consli3 = new ConsLibraryItem(s3, Consli2);
		ILibraryItem Consli4 = new ConsLibraryItem(s2, Consli3);
		ILibraryItem Consli5 = new ConsLibraryItem(s1, Consli4);
		ILibraryItem Consli6 = new ConsLibraryItem(r2, Consli5);
		ILibraryItem Consli7 = new ConsLibraryItem(r1, Consli6);

		assertEquals(Consli7.sortByAuthor(),
				new ConsLibraryItem(j1,
						new ConsLibraryItem(j2, new ConsLibraryItem(s1, new ConsLibraryItem(r1, new ConsLibraryItem(s3,
								new ConsLibraryItem(r2, new ConsLibraryItem(s2, new MTLibraryItem()))))))));
	}
}