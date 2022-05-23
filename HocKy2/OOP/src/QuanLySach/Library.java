package QuanLySach;

import java.util.ArrayList;

public class Library {
	private ArrayList<Book> lstBook = new ArrayList<Book>();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Book book : lstBook) {
			sb.append(book.toString() + "\n");

		}
		return sb.toString();
	}

	public void add(Book a) {
		lstBook.add(a);

	}

	public void remove(int id) {
		Book a;
		for (int i = 0; i < lstBook.size(); i++) {
			a = lstBook.get(i);
			if (a.getId() == id)
				lstBook.remove(i);
		}
	}

	public Book search(int id) {
		for (int i = 0; i < lstBook.size(); i++) {
			Book a = lstBook.get(i);
			if (a.getId() == id)
				return a;
		}
		return null;
	}	
}
