package NK11;

public class ClockTime {
	private int minute;
	private int second;

	public ClockTime(int minute, int second) {
		super();
		this.minute = minute;
		this.second = second;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClockTime other = (ClockTime) obj;
		if (minute != other.minute)
			return false;
		if (second != other.second)
			return false;
		return true;
	}

	public int totalTime() {
		return this.second + this.minute * 60;
	}

	public boolean checkTimeLonger(int minute, int second) {

		if (this.minute > minute)
			return true;
		else if (this.minute < minute)
			return false;
		else if (this.second > second)
			return true;
		return false;
	}

	public boolean checkTimeBigger(ClockTime other) {
		return this.totalTime() > other.totalTime();

	}
}
