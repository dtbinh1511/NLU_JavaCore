package object;

public abstract class AFilm {
	protected String name;
	protected String category;
	protected int yearOfCreation;

	public AFilm(String name, String category, int yearOfCreation) {
		this.name = name;
		this.category = category;
		this.yearOfCreation = yearOfCreation;
	}
	
	//so sanh
	public int compareTo(AFilm that) {
		return this.name.compareToIgnoreCase(that.name);
	}
	
	public boolean isYearOfCreation(int yearCreateFilm) {
		return this.yearOfCreation == yearCreateFilm;
	}
}
