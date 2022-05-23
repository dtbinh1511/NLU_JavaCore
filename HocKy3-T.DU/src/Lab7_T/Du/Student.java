package Lab7_T.Du;

public class Student {

	private String id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private double gpa;

	public Student(String id, String firstName, String lastName, int birthYear, double gpa) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + ", First Name: " + this.firstName + ", Last Name: " + this.lastName + ", Birth year: "
				+ this.birthYear + ", GPA: " + this.gpa + "\n";
	}

	public boolean equals(Student that) {
		return this.id.equals(that.id);
	}

	public int compare(Student that) {
		return this.id.compareTo(that.id);
	}

	public double getGpa() {
		return gpa;
	}

}
