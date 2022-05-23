package QuanLySach;

public class Book {
	private int id;
	private String code;
	private String name;
	private Author author;

	public Book(int id, String code, String name, Author author) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.author = author;
	}

	@Override
	public String toString() {
		return id + "-" + code + "-" + name + "-" + author.toString();
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Author getAuthor() {
		return author;
	}

}
