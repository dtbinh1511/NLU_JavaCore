package NK9;

public interface IListE {

	@Override
	public boolean equals(Object obj);

	@Override
	public String toString();

	public String fullName();

	public double salaryTotal();

	public Employee salaryMax();

	public double salaryMAx();

	public IListE getEmployeesByName(String that);

	public IListE sortBySalary();

	public IListE insertBySalary(Employee that);
}
