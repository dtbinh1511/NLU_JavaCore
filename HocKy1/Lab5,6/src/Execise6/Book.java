package Execise6;

public class Book {
	private String trackTitle;
	private int price;
	private int yearOfPubliction;
	private Author author;

	public Book(String trackTitle, int price, int yearOfPubliction, Author author) {
		this.trackTitle = trackTitle;
		this.price = price;
		this.yearOfPubliction = yearOfPubliction;
		this.author = author;
	}
//Kiểm tra xem quyển sách có được xuất bản vào năm 2004 hoặc năm 2003 hay không?

	public boolean currentBook() {
		return (this.yearOfPubliction == 2004) || (this.yearOfPubliction == 2003);
	}

// Kiểm tra xem quyển sách có được viết bởi tác giả có là nhà văn hiện đại hay không?
	public boolean currentAuthor() {
		return this.author.currentAuthor();
	}

//Kiểm tra xem quyển sách có được viết bởi tác giả được chỉ định
	public boolean thisAuthor(String author) {
		return this.author.equals(author);
	}

//Kiểm tra xem quyển sách này với quyển sách khác có cùng 1 tác giả hay không?
	public boolean sameAuthor(Book other) {
		return this.author.sameAuthor(other.author);
	}

// Kiểm tra xem 2 quyển sách này được viết với 2 tác giả có năm sinh cách nhau ít nhất 10 năm
	public boolean sameGeneration(Book other) {
		return this.author.sameGeneration(other.author);

	}
}
