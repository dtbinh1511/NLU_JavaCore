package NK7;

public class Date {
	private int day, month, year;

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}
