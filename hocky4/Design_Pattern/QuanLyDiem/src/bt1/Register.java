package bt1;


public class Register {
	private Subject subjects;
	private double score;

	public Register(Subject subjects) {
		super();
		this.subjects = subjects;
	}

	public Subject getSubjects() {
		return subjects;
	}

	public void setSubjects(Subject subjects) {
		this.subjects = subjects;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Register [subjects=" + subjects + ", score=" + score + "]";
	}

}
