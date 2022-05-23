package employee_management;

import java.util.Date;

public class ContractStaff extends Staff {

	public ContractStaff(String id, String fullName, String gender, Date dateOfBirth, int basicSalary, int workMonth) {
		super(id, fullName, gender, dateOfBirth, basicSalary, workMonth);
	}

	@Override
	public double salary() {
		return basicSalary * workMonth;
	}

	@Override
	public double bonus() {
		int numYearWork = workMonth / 12;

		return numYearWork * salary();
	}

}
