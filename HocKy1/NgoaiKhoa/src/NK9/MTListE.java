package NK9;

public class MTListE implements IListE {

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof MTListE))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public String fullName() {
		return "";
	}

	@Override
	public double salaryTotal() {
		return 0.0;
	}

	@Override
	public Employee salaryMax() {
		return null;
	}

	@Override
	public double salaryMAx() {
		return 0;
	}

	@Override
	public IListE getEmployeesByName(String that) {
		return new MTListE();
	}

	@Override
	public IListE sortBySalary() {
		return new MTListE();
	}

	@Override
	public IListE insertBySalary(Employee that) {
		return new ConsListE(that, new MTListE());
	}

}
