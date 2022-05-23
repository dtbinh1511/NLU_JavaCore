package Management;

public class Subject {
	private String nameSub;
	private String IDSub;
	private double grade;

	public Subject(String nameSub, String iDSub, double grade) {
		super();
		this.nameSub = nameSub;
		IDSub = iDSub;
		this.grade = grade;
	}

	public Subject() {
	}

	public String getNameSub() {
		return nameSub;
	}

	public void setNameSub(String nameSub) {
		this.nameSub = nameSub;
	}

	public String getIDSub() {
		return IDSub;
	}

	public void setIDSub(String iDSub) {
		IDSub = iDSub;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "nameSub: " + nameSub + " grade: " + grade;
//		return "nameSub: " + nameSub + ", IDSub: " + IDSub + ", grade: " + grade;
	}
	
}
