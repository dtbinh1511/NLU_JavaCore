package NK9;

public class SalaryEmployee extends Employee {
	private double salaryFator;
	private int stockOption;

	public SalaryEmployee(Name name, Date hiredDate, double salaryFator, int stockOption) {
		super(name, hiredDate);
		this.salaryFator = salaryFator;
		this.stockOption = stockOption;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof SalaryEmployee))
			return false;
		else {
			SalaryEmployee that = (SalaryEmployee) obj;
			return this.name.equals(that.name) && this.hiredDate.equals(that.hiredDate)
					&& this.salaryFator == that.salaryFator && this.stockOption == that.stockOption;
		}
	}

	@Override
	public String toString() {
		return "- SalaryEmployee: " + this.name + ", " + this.hiredDate + ", " + this.salaryFator + ", "
				+ this.stockOption;
	}

	public int moneySupport() {
		if (this.workingYear(2015) >= 6)
			return this.workingYear(2015) * 200000;
		return 0;
	}

	@Override
	public double monthlySalary() {
		return this.salaryFator * 1150000 + this.moneySupport();
	}
}
