package Task1_2;

public class Date {
	protected int day, month, year;

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Date))
			return false;
		else {
			Date other = (Date) obj;
			return this.day == other.day & this.month == other.month && this.year == other.year;
		}
	}

	public boolean sameDate(int month, int year) {
		return this.month == month && this.year == year;
	}

	

}
