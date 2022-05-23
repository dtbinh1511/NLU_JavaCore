package Task2_3;

public class GradeRecord {
	public int number;
	public String title;
	public int credits;
	public double grade;

	public GradeRecord(int number, String title, int credits, double grade) {
		super();
		this.number = number;
		this.title = title;
		this.credits = credits;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "\n" + "NUMBER: " + this.number + "\n" + "TITLE: " + this.title + "\n" + "CREDITS: " + this.credits
				+ "\n" + "GRADE: " + this.grade + "\n";
	}

	public int getCredits() {
		return this.credits;
	}

	public double getGrade() {
		return this.grade;
	}

	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof GradeRecord))
			return false;
		else {
			GradeRecord other = (GradeRecord) obj;
			return this.number == other.number && this.title.equals(other.title) && this.credits == other.credits
					&& this.grade == other.grade;
		}
	}

	public boolean biggerThan(GradeRecord that) {
		return this.grade > that.grade;
	}

	public boolean biggerThanGrade(double grade) {
		return this.grade > grade;
	}
}
