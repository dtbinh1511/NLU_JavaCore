package bt1;

public class Subject {
	private String nameSub;
	private int credit;
	private Teacher teacher;

	public Subject(String nameSub, int credit, Teacher teacher) {
		super();
		this.nameSub = nameSub;
		this.credit = credit;
		this.teacher = teacher;
	}

	public String getNameSub() {
		return nameSub;
	}

	public void setNameSub(String nameSub) {
		this.nameSub = nameSub;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Subject [nameSub=" + nameSub + ", credit=" + credit + ", teacher=" + teacher + "]";
	}

}
