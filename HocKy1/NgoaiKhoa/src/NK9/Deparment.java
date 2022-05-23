package NK9;

public class Deparment {
	private String depName;
	private IListE listDep;

	public Deparment(String depName, IListE listDep) {
		super();
		this.depName = depName;
		this.listDep = listDep;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Deparment))
			return false;
		else {
			Deparment that = (Deparment) obj;
			return this.depName.equals(that.depName) && this.listDep.equals(that.listDep);
		}
	}

	@Override
	public String toString() {
		return "\n" + "Tên ban phòng: " + this.depName + "\n" + "Danh sách thành viên trong ban: " + "\n" + this.listDep
				+ "\n";
	}

	public String fullName() {
		return this.listDep.fullName();
	}

	public double salaryTotal() {
		return this.listDep.salaryTotal();
	}

	public Employee salaryMax() {
		return this.listDep.salaryMax();
	}

	public double salaryMAx() {
		return this.listDep.salaryMAx();
	}

	public IListE getEmployeesByName(String that) {
		return this.listDep.getEmployeesByName(that);
	}

	public IListE sortBySalary() {
		return this.listDep.sortBySalary();
	}
}
