package lab7_linked_list;

public class Student {
	private String id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private double GPA;

	public Student(String id, String firstName, String lastName, int birthYear, double GPA) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.GPA = GPA;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + ", First Name: " + this.firstName + ", Last Name: " + this.lastName + ", Birth year: "
				+ this.birthYear + ", GPA: " + this.GPA + "\n";
	}
}
