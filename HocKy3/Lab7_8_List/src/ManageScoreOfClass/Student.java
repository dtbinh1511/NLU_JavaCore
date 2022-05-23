package ManageScoreOfClass;

public class Student {
	private String fullname;
	private String id;
	private double avg;

	public Student(String fullname, String id, double avg) {
		super();
		this.fullname = fullname;
		this.id = id;
		this.avg = avg;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {

		return fullname + " \t" + id + "\t" + avg + "\n";
	}

}
