package NK9;

public class Consultant extends Employee {
	private int contracNumber;
	private int billingRate;

	public Consultant(Name name, Date hiredDate, int contracNumber, int billingRate) {
		super(name, hiredDate);
		this.contracNumber = contracNumber;
		this.billingRate = billingRate;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Consultant))
			return false;
		else {
			Consultant that = (Consultant) obj;
			return this.name.equals(that.name) && this.hiredDate.equals(that.hiredDate)
					&& this.contracNumber == that.contracNumber && this.billingRate == that.billingRate;
		}
	}

	@Override
	public String toString() {
		return "- ConsultantEmployee: " + this.name + ", " + this.hiredDate + ", " + this.contracNumber + ", "
				+ this.billingRate;
	}

	@Override
	public double monthlySalary() {
		return this.billingRate;
	}
}
