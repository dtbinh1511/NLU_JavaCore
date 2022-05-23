package Task1_2;

public class Entry {
	protected Date date;
	protected int distance;
	protected int duration;
	protected String comment;

	public Entry(Date date, int distance, int duration, String comment) {
		super();
		this.date = date;
		this.distance = distance;
		this.duration = duration;
		this.comment = comment;
	}

	public String toString() {
		return "\n" + "Day/Month/Year: " + this.date + "\n" + "Distance: " + this.distance + "\n" + "Duration: "
				+ this.duration + "\n" + "Comment: " + this.comment + "\n";
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Entry))
			return false;
		else {
			Entry other = (Entry) obj;
			return this.date.equals(other.date) && this.distance == other.distance && this.duration == other.duration
					&& this.comment.equals(other.comment);
		}
	}

	public double MilesRun() {
		return this.distance;
	}

	public boolean sameDate(int month, int year) {
		return this.date.sameDate(month, year);

	}

	public boolean lessThan(Entry other) {
		return this.distance < other.distance;
	}

//	public int getDistance() {
//		return this.distance;
//	}


}
