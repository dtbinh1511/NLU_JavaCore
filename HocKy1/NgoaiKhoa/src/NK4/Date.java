package NK4;

public class Date {
	private int day, month, year;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	// kiểm tra xem 1 ngày có trước ngày khác không?
	public boolean before(Date other) {
		if (this.year < other.year)
		return true;
		else if (this.year > other.year)
			return false;
		else if (this.month < other.month)
			return true;
		else if(this.month > other.month)
			return false;
		else if(this.day < other.day)
			return true;
		else return false;
	}
}
