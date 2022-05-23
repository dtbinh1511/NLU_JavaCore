package NK9;

public abstract class Employee {
	protected Name name;
	protected Date hiredDate;

	public Employee(Name name, Date hiredDate) {
		super();
		this.name = name;
		this.hiredDate = hiredDate;
	}

	@Override
	public abstract boolean equals(Object obj);

	@Override
	public abstract String toString();

	public String getName() {
		return this.name.getName();
	}

	public boolean workingAfter(Employee that) {
		return this.hiredDate.isAfterDate(that.hiredDate);
	}

	public int workingYear(int toYear) {
		return this.hiredDate.numTrain(toYear);
	}

	public abstract double monthlySalary();

	public boolean salaryMaxE(Employee that) {
		return this.monthlySalary() > that.monthlySalary();

	}

	public boolean nameContainOrSameE(String that) {
		return this.name.containsOrSame(that);
	}

}
