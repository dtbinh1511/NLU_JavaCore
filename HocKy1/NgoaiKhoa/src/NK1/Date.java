package NK1;

public class Date {
	private int day, month, year;

	public Date(int day, int month, int year) {

		this.day = day;
		this.month = month;
		this.year = year;
	}

//Kiểm tra xem một ngày có sớm hơn ngày khác không
	public boolean DateEarlier(Date other) {
		if (this.year > other.year)
			return true;
		else if (this.year < other.year)
			return false;
		else if (this.month > other.month)
			return true;
		else if (this.month < other.month)
			return false;
		else if (this.day > other.day)
			return true;
		else
			return false;
	}
}
