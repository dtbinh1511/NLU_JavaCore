package NK9;

public class HourlyEmployee extends Employee {
	private int hourlyRate;
	private int primaryRate;

	public HourlyEmployee(Name name, Date hiredDate, int hourlyRate, int primaryRate) {
		super(name, hiredDate);
		this.hourlyRate = hourlyRate;
		this.primaryRate = primaryRate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof HourlyEmployee))
			return false;
		else {
			HourlyEmployee that = (HourlyEmployee) obj;
			return this.name.equals(that.name) && this.hiredDate.equals(that.hiredDate)
					&& this.hourlyRate == that.hourlyRate && this.primaryRate == that.primaryRate;
		}
	}

	@Override
	public String toString() {
		return "- HourlyEmployee: " + this.name + ", " + this.hiredDate + ", " + this.hourlyRate + ", "
				+ this.primaryRate;
	}

	@Override
	public double monthlySalary() {
		return this.hourlyRate * this.primaryRate * 4;
	}

}
