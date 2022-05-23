package object;

public class Time {
	private int hours;
	private int minute;
	private int seconds;

	public Time(int hours, int minute, int seconds) {
		this.hours = hours;
		this.minute = minute;
		this.seconds = seconds;
	}

	@Override
	public String toString() {
		return this.hours + " Giờ " + this.minute + " Phút " + this.seconds + " Giây";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hours != other.hours)
			return false;
		if (minute != other.minute)
			return false;
		if (seconds != other.seconds)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		Time time = new Time(1, 30, 30);
		System.out.println(time);
		System.out.println(time.equals(new Time(1, 30, 30)));
	}
}
