package QuanLySach;

public class App {
	public static void main(String[] args) {
		Author author = new Author(1, "Đỗ Bình");

		Library lb = new Library();
		for (int i = 0; i <= 5; i++) {
			Book a = new Book(i, "000" + i, "Book", author);
			lb.add(a);
		}
		System.out.print(lb.toString());
		
		//remove
		lb.remove(1);
		System.out.println("After remove");
		System.out.println(lb.toString());
		
		//search
		System.out.println(lb.search(3).toString());
		
	}
}
