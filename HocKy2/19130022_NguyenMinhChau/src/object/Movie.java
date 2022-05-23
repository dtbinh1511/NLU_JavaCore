package object;

public class Movie extends AFilm {
	private Time time;

	public Movie(String name, String category, int yearOfCreation, Time time) {
		super(name, category, yearOfCreation);
		this.time = time;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Movie))
			return false;
		else {
			Movie that = (Movie) obj;
			return this.name.equals(that.name) && this.category.equals(that.category)
					&& this.yearOfCreation == that.yearOfCreation && this.time.equals(that.time);
		}
	}

	@Override
	public String toString() {
		return this.name + "\t\t" + this.category + "\t\t" + this.time;
	}

	public static void main(String[] args) {
		Movie m = new Movie("A", "Z", 1000, new Time(1, 30, 00));
		System.out.println(m);
		System.out.println(m.equals(new Movie("A", "Z", 1000, new Time(1, 30, 00))));
	}
}
