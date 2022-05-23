package employee_management;

import java.util.Date;

public class OriginStaff extends Staff {
	private double coefficient;
	private int insurance;

	public OriginStaff(String id, String fullName, String gender, Date dateOfBirth, int basicSalary, int workMonth,
			double coefficient, int insurance) {
		super(id, fullName, gender, dateOfBirth, basicSalary, workMonth);
		this.coefficient = coefficient;
		this.insurance = insurance;
	}

	public double salaryPerMonth() {
		if (insurance > basicSalary)
			return 0;
		return basicSalary * coefficient - insurance;
	}

	@Override
	public double salary() {

		return workMonth * salaryPerMonth();
	}

	@Override
	public double bonus() {
		int numYearWork = workMonth / 12;
		if (salaryPerMonth() == 0)
			return 0;
		return numYearWork * (salaryPerMonth() - insurance);
	}

}
