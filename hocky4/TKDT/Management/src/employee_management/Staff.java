package employee_management;

import java.util.Date;

public abstract class Staff {
	protected String id;
	protected String fullName;
	protected String gender;
	protected Date dateOfBirth;
	protected int basicSalary;
	protected int workMonth;

	public Staff(String id, String fullName, String gender, Date dateOfBirth, int basicSalary, int workMonth) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.basicSalary = basicSalary;
		this.workMonth = workMonth;
	}

	public abstract double salary();

	public abstract double bonus();

	public String getFullName() {
		return fullName;
	}

	
}
