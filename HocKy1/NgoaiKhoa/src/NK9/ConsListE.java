package NK9;

public class ConsListE implements IListE {
	public Employee first;
	public IListE rest;

	public ConsListE(Employee first, IListE rest) {
		super();
		this.first = first;
		this.rest = rest;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof ConsListE))
			return false;
		else {
			ConsListE that = (ConsListE) obj;
			return this.first.equals(that.first) && this.rest.equals(that.rest);
		}
	}

	@Override
	public String toString() {
		return this.first.toString() + "\n" + this.rest.toString();
	}

	@Override
	public String fullName() {
		return this.first.getName() + this.rest.fullName();
	}

	@Override
	public double salaryTotal() {
		return this.first.monthlySalary() + this.rest.salaryTotal();
	}

	@Override
	public Employee salaryMax() {
		if (this.rest.salaryMax() == null)
			return this.first;
		else {
			if (this.first.salaryMaxE(rest.salaryMax()))
				return this.first;
			return this.rest.salaryMax();
		}
	}

	@Override
	public double salaryMAx() {
		if (this.first.monthlySalary() > rest.salaryMAx())
			return this.first.monthlySalary();
		return this.rest.salaryMAx();
	}

	@Override
	public IListE getEmployeesByName(String that) {
		if (this.first.nameContainOrSameE(that))
			return new ConsListE(first, rest.getEmployeesByName(that));
		return this.rest.getEmployeesByName(that);
	}

	@Override
	public IListE sortBySalary() {
		return this.rest.sortBySalary().insertBySalary(first);
	}

	@Override
	public IListE insertBySalary(Employee that) {
		if (this.first.salaryMaxE(that))
			return new ConsListE(this.first, this.rest.insertBySalary(that));
		return new ConsListE(that, this);
	}

}
