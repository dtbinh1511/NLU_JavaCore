package score_management;

public class Register {
	private Course coure;
	private double score;

	public Register(Course coure, double score) {
		super();
		this.coure = coure;
		this.score = score;
	}

	public Course getCoure() {
		return coure;
	}

	public void setCoure(Course coure) {
		this.coure = coure;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

}
