package employee_management;

import java.util.ArrayList;

public class Department {
	private String id;
	private String name;
	private ArrayList<Staff> staffs = new ArrayList<Staff>();

	public Department(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	// add staff
	public void addStaff(Staff staff) {
		staffs.add(staff);
	}

	// remove staff
	public boolean removeStaff(Staff staff) {
		if (staffs.contains(staff)) {
			staffs.remove(staff);
			return true;
		}
		return false;
	}

	// total salary
	public double totalOfDepartment() {
		double total = 0;
		for (Staff staff : staffs) {
			total += staff.salary();
		}
		return total;
	}

	// print
	public String statement() {
		StringBuilder builder = new StringBuilder("Department: " + name + "\n");
		for (Staff staff : staffs) {
			builder.append(staff.getFullName() + ", salary per month = " + staff.salary() + "\n");
		}
		builder.append("Total of deparment " + name + ": " + totalOfDepartment()+"\n\n");
		return builder.toString();
	}
}
