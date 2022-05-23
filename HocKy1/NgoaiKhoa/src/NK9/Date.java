package NK9;

public class Date {
	private int day, month, year;

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Date))
			return false;
		else {
			Date that = (Date) obj;
			return this.day == that.day && this.month == that.month & this.year == that.year;
		}
	}

	@Override
	public String toString() {
		return this.day + "-" + this.month + "-" + this.year;
	}

	public boolean isAfterDate(Date that) {
		if (this.year > that.year)
			return true;
		else if (this.year < that.year)
			return false;
		else if (this.month > that.month)
			return true;
		else if (this.month < that.month)
			return false;
		else if (this.day > that.day)
			return true;
		return false;
	}

	public int numTrain(int toYear) {
		return toYear - this.year;
	}

}
