package Algorithms_Searching;

public class Employee implements Comparable<Employee> {
	private String id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private double GPA;

	public Employee(String id, String firstName, String lastName, int birthYear, double GPA) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.GPA = GPA;
	}

	public boolean equals(Employee that) {
		return this.id.equals(that.id) && this.firstName.equals(that.firstName) && this.lastName.equals(that.lastName)
				&& this.birthYear == that.birthYear && this.GPA == that.GPA;
	}

	@Override
	public int compareTo(Employee e) {
		return this.lastName.compareTo(e.lastName);
	}

	@Override
	public String toString() {
		return id + " " + firstName + " " + lastName + " " + birthYear + " " + GPA + "\n";
	}

}
