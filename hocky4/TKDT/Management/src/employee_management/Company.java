package employee_management;

import java.util.Map;
import java.util.HashMap;

public class Company {
	private String name;
	private Map<Department, Staff> map = new HashMap<Department, Staff>();

	public Company(String name) {
		super();
		this.name = name;
	}

	public void add(Department department, Staff staff) {
		map.put(department, staff);
	}

	public String showSalary() {
		StringBuilder builder = new StringBuilder("Company: " + name + "\n\n");
		for (Department department : map.keySet()) {
			builder.append(department.statement() + "\n");
		}
		return builder.toString();
	}
}
