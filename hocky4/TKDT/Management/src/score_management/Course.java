package score_management;

public class Course {
	private String nameSub;
	private int credits;
	private Lecturer lecture;

	public Course(String nameSub, int credits, Lecturer lecture) {
		super();
		this.nameSub = nameSub;
		this.credits = credits;
		this.lecture = lecture;
	}

	public String getNameSub() {
		return nameSub;
	}

	public int getCredits() {
		return credits;
	}

}
