package finalAHung;

import junit.framework.TestCase;

public class TestLibraryItems extends TestCase {
	public void testSortByAuthorName() {
		LibraryItem ref1 = new ReferenceBook(101, "Bac thay moi gioi dia oc", new Author("Henry Huynh Anh Dung", 1960),
				"NXB Tre", 7, 300000, "Kinh te");
		LibraryItem ref2 = new ReferenceBook(102, "Nhac ly can ban va nang cao", new Author("Luong Bang Vinh", 1970),
				"NXB Thi Nghe", 7, 300000, "Nhac");
		LibraryItem sto1 = new Story(201, "Doremon", new Author("Fujiko. F. Fujio", 1950), "NXB Kim Dong", 7, 200000);
		LibraryItem sto2 = new Story(202, "Toi thay hoa vang tren co xanh", new Author("Nguyen Nhat Anh", 1955),
				"NXB Tre", 3, 45000);
		LibraryItem sto3 = new Story(203, "Harry Potter and the Half-Blood Prince", new Author("J.K. Rowling", 1965),
				"Bloomsbury Publishing PLC", 3, 270000);
		LibraryItem jou1 = new Journal(301, "The gioi vi tinh so 256", new Author("Tran Minh Tri", 1985),
				"PC World Vietnam", 7, 20000, new Date(14, 2, 2014));
		LibraryItem jou2 = new Journal(301, "Nhip cau tu van so 378", new Author("Ly A Bang", 1978),
				"MTV An pham", 1, 15000, new Date(14, 2, 2014));

		ILibraryItems empty = new MTLibraryItems();
		ILibraryItems i1 = new ConsLibraryItems(ref1, empty);
		ILibraryItems i2 = new ConsLibraryItems(ref2, i1);
		ILibraryItems i3 = new ConsLibraryItems(sto1, i2);
		ILibraryItems i4 = new ConsLibraryItems(sto2, i3);
		ILibraryItems i5 = new ConsLibraryItems(sto3, i4);
		ILibraryItems i6 = new ConsLibraryItems(jou1, i5);
		ILibraryItems i7 = new ConsLibraryItems(jou2, i6);

		ILibraryItems sortedItems = i7.sortByAuthorName();

		System.out.println(i7);
		System.out.println();
		System.out.println(sortedItems);
	}
}
