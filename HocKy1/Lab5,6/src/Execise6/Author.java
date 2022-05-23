package Execise6;

public class Author {
	private String name;
	private int birthYear;

	public Author(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}

// Kiểm tra xem tác giả có thuộc nhà văn hiện đại
	public boolean currentAuthor() {
		return this.birthYear >= 1940;
	}

//Kiểm tra xem tên của 2 tác giả có giống nhau
	public boolean thisAuthor(String author) {
		return this.name.equals(author);
	}
// Kiểm tra xem hai tác giả có giống nhau hay không?

	public boolean sameAuthor(Author other) {
		return this.name.equals(other.name) && this.birthYear == other.birthYear;
	}

//Kiểm tra năm sinh xem có cùng thế hệ không?
	public boolean sameGeneration(Author other) {
		if (this.birthYear == other.birthYear && this.name.equals(other.name))
			return false;
		else
			return Math.abs(this.birthYear - other.birthYear) <= 10;
	}
}
