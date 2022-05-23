package NK9;

import junit.framework.TestCase;

public class IListETest extends TestCase {
	public void testConStructor() {
		Employee s1 = new SalaryEmployee(new Name("Nguyen", "Van", "Minh"), new Date(20, 5, 2001), 4.36, 2500);
		Employee s2 = new SalaryEmployee(new Name("Ly", "", "Loan"), new Date(01, 7, 2010), 3.14, 0);
		Employee h1 = new HourlyEmployee(new Name("Tran", "Duc", "Minh"), new Date(30, 6, 2009), 50000, 40);
		Employee h2 = new HourlyEmployee(new Name("Nguyen", "Thị", "Huyen"), new Date(15, 02, 2011), 70000, 24);
		Employee c1 = new Consultant(new Name("Le", "Dinh", "Van"), new Date(25, 9, 2013), 012030, 5000000);

		IListE empty = new MTListE();
		IListE cons1 = new ConsListE(c1, empty);
		IListE cons2 = new ConsListE(h2, cons1);
		IListE cons3 = new ConsListE(h1, cons2);
		IListE cons4 = new ConsListE(s2, cons3);
		IListE cons5 = new ConsListE(s1, cons4);

		Deparment d1 = new Deparment("Quản lý đất đai", cons5);
		System.out.println(d1.toString());
	}

	public void testFullName() {
		Employee s1 = new SalaryEmployee(new Name("Nguyen", "Van", "Minh"), new Date(20, 5, 2001), 4.36, 2500);
		Employee s2 = new SalaryEmployee(new Name("Ly", "", "Loan"), new Date(01, 7, 2010), 3.14, 0);
		Employee h1 = new HourlyEmployee(new Name("Tran", "Duc", "Minh"), new Date(30, 6, 2009), 50000, 40);
		Employee h2 = new HourlyEmployee(new Name("Nguyen", "Thi", "Huyen"), new Date(15, 02, 2011), 70000, 24);
		Employee c1 = new Consultant(new Name("Le", "Dinh", "Van"), new Date(25, 9, 2013), 012030, 50000000);

		IListE empty = new MTListE();
		IListE cons1 = new ConsListE(c1, empty);
		IListE cons2 = new ConsListE(h2, cons1);
		IListE cons3 = new ConsListE(h1, cons2);
		IListE cons4 = new ConsListE(s2, cons3);
		IListE cons5 = new ConsListE(s1, cons4);

		Deparment d1 = new Deparment("Quản lý đất đai", cons5);

		assertEquals(d1.fullName(), "Nguyen" + " Van" + " Minh" + "Ly" + " " + " Loan" + "Tran" + " Duc" + " Minh"
				+ "Nguyen" + " Thi" + " Huyen" + "Le" + " Dinh " + "Van");
	}

	public void testWorkingAfter() {
		Employee s1 = new SalaryEmployee(new Name("Nguyen", "Van", "Minh"), new Date(20, 5, 2001), 4.36, 2500);
		Employee s2 = new SalaryEmployee(new Name("Ly", "", "Loan"), new Date(01, 7, 2010), 3.14, 0);
		Employee h1 = new HourlyEmployee(new Name("Tran", "Duc", "Minh"), new Date(30, 6, 2009), 50000, 40);
		Employee h2 = new HourlyEmployee(new Name("Nguyen", "Thi", "Huyen"), new Date(15, 02, 2011), 70000, 24);
		Employee c1 = new Consultant(new Name("Le", "Dinh", "Van"), new Date(25, 9, 2013), 012030, 50000000);

		assertTrue(c1.workingAfter(s1));
		assertFalse(s1.workingAfter(h1));
		assertTrue(h2.workingAfter(s2));

	}

	public void testWorkingYears() {
		Employee s1 = new SalaryEmployee(new Name("Nguyen", "Van", "Minh"), new Date(20, 5, 2001), 4.36, 2500);
		Employee s2 = new SalaryEmployee(new Name("Ly", "", "Loan"), new Date(01, 7, 2010), 3.14, 0);
		Employee h1 = new HourlyEmployee(new Name("Tran", "Duc", "Minh"), new Date(30, 6, 2009), 50000, 40);
		Employee h2 = new HourlyEmployee(new Name("Nguyen", "Thi", "Huyen"), new Date(15, 02, 2011), 70000, 24);
		Employee c1 = new Consultant(new Name("Le", "Dinh", "Van"), new Date(25, 9, 2013), 012030, 5000000);

		assertEquals(s1.workingYear(2019), 18);
		assertEquals(s2.workingYear(2019), 9);
		assertEquals(h1.workingYear(2019), 10);
		assertEquals(h2.workingYear(2019), 8);
		assertEquals(c1.workingYear(2019), 6);
	}

	public void testMonthLySalary() {
		Employee s1 = new SalaryEmployee(new Name("Nguyen", "Van", "Minh"), new Date(20, 5, 2001), 4.36, 2500);
		Employee s2 = new SalaryEmployee(new Name("Ly", "", "Loan"), new Date(01, 7, 2010), 3.14, 0);
		Employee h1 = new HourlyEmployee(new Name("Tran", "Duc", "Minh"), new Date(30, 6, 2009), 50000, 40);
		Employee h2 = new HourlyEmployee(new Name("Nguyen", "Thi", "Huyen"), new Date(15, 02, 2011), 70000, 24);
		Employee c1 = new Consultant(new Name("Le", "Dinh", "Van"), new Date(25, 9, 2013), 012030, 5000000);

		assertEquals(s1.monthlySalary(), 7814000.0);
		assertEquals(s2.monthlySalary(), 3611000.0);
		assertEquals(h1.monthlySalary(), 8000000.0);
		assertEquals(h2.monthlySalary(), 6720000.0);
		assertEquals(c1.monthlySalary(), 5000000.0);
	}

	public void testSalaryTotal() {
		Employee s1 = new SalaryEmployee(new Name("Nguyen", "Van", "Minh"), new Date(20, 5, 2001), 4.36, 2500);
		Employee s2 = new SalaryEmployee(new Name("Ly", "", "Loan"), new Date(01, 7, 2010), 3.14, 0);
		Employee h1 = new HourlyEmployee(new Name("Tran", "Duc", "Minh"), new Date(30, 6, 2009), 50000, 40);
		Employee h2 = new HourlyEmployee(new Name("Nguyen", "Thi", "Huyen"), new Date(15, 02, 2011), 70000, 24);
		Employee c1 = new Consultant(new Name("Le", "Dinh", "Van"), new Date(25, 9, 2013), 012030, 5000000);

		IListE empty = new MTListE();
		IListE cons1 = new ConsListE(c1, empty);
		IListE cons2 = new ConsListE(h2, cons1);
		IListE cons3 = new ConsListE(h1, cons2);
		IListE cons4 = new ConsListE(s2, cons3);
		IListE cons5 = new ConsListE(s1, cons4);

		Deparment d1 = new Deparment("Quản lý đất đai", cons5);
//		System.out.println(d1.salaryTotal());
		assertEquals(d1.salaryTotal(), 31145000.0);
	}

	public void testSalaryMax() {
		Employee s1 = new SalaryEmployee(new Name("Nguyen", "Van", "Minh"), new Date(20, 5, 2001), 4.36, 2500);
		Employee s2 = new SalaryEmployee(new Name("Ly", "", "Loan"), new Date(01, 7, 2010), 3.14, 0);
		Employee h1 = new HourlyEmployee(new Name("Tran", "Duc", "Minh"), new Date(30, 6, 2009), 50000, 40);
		Employee h2 = new HourlyEmployee(new Name("Nguyen", "Thi", "Huyen"), new Date(15, 02, 2011), 70000, 24);
		Employee c1 = new Consultant(new Name("Le", "Dinh", "Van"), new Date(25, 9, 2013), 012030, 5000000);

		IListE empty = new MTListE();
		IListE cons1 = new ConsListE(c1, empty);
		IListE cons2 = new ConsListE(h2, cons1);
		IListE cons3 = new ConsListE(h1, cons2);
		IListE cons4 = new ConsListE(s2, cons3);
		IListE cons5 = new ConsListE(s1, cons4);

		Deparment d1 = new Deparment("Quản lý đất đai", cons5);

		assertEquals(d1.salaryMax(),
				new HourlyEmployee(new Name("Tran", "Duc", "Minh"), new Date(30, 6, 2009), 50000, 40));
	}

	public void testSalaryMAx() {
		Employee s1 = new SalaryEmployee(new Name("Nguyen", "Van", "Minh"), new Date(20, 5, 2001), 4.36, 2500);
		Employee s2 = new SalaryEmployee(new Name("Ly", "", "Loan"), new Date(01, 7, 2010), 3.14, 0);
		Employee h1 = new HourlyEmployee(new Name("Tran", "Duc", "Minh"), new Date(30, 6, 2009), 50000, 40);
		Employee h2 = new HourlyEmployee(new Name("Nguyen", "Thi", "Huyen"), new Date(15, 02, 2011), 70000, 24);
		Employee c1 = new Consultant(new Name("Le", "Dinh", "Van"), new Date(25, 9, 2013), 012030, 5000000);

		IListE empty = new MTListE();
		IListE cons1 = new ConsListE(c1, empty);
		IListE cons2 = new ConsListE(h2, cons1);
		IListE cons3 = new ConsListE(h1, cons2);
		IListE cons4 = new ConsListE(s2, cons3);
		IListE cons5 = new ConsListE(s1, cons4);

		Deparment d1 = new Deparment("Quản lý đất đai", cons5);

		assertEquals(d1.salaryMAx(), 8000000.0);
	}

	public void testGetEmployeesByName() {
		Employee s1 = new SalaryEmployee(new Name("Nguyen", "Van", "Minh"), new Date(20, 5, 2001), 4.36, 2500);
		Employee s2 = new SalaryEmployee(new Name("Ly", "", "Loan"), new Date(1, 7, 2010), 3.14, 0);
		Employee h1 = new HourlyEmployee(new Name("Tran", "Duc", "Minh"), new Date(30, 6, 2009), 50000, 40);
		Employee h2 = new HourlyEmployee(new Name("Nguyen", "Thi", "Huyen"), new Date(15, 2, 2011), 70000, 24);
		Employee c1 = new Consultant(new Name("Le", "Dinh", "Van"), new Date(25, 9, 2013), 012030, 5000000);

		IListE empty = new MTListE();
		IListE cons1 = new ConsListE(c1, empty);
		IListE cons2 = new ConsListE(h2, cons1);
		IListE cons3 = new ConsListE(h1, cons2);
		IListE cons4 = new ConsListE(s2, cons3);
		IListE cons5 = new ConsListE(s1, cons4);

		Deparment d1 = new Deparment("Quản lý đất đai", cons5);

//		System.out.println(d1.getEmployeesByName("Nguyen Minh"));
		assertEquals(d1.getEmployeesByName("Van"), new ConsListE(s1, new ConsListE(c1, new MTListE())));
	}

	public void testSortBySalary() {
		Employee s1 = new SalaryEmployee(new Name("Nguyen", "Van", "Minh"), new Date(20, 5, 2001), 4.36, 2500);
		Employee s2 = new SalaryEmployee(new Name("Ly", "", "Loan"), new Date(1, 7, 2010), 3.14, 0);
		Employee h1 = new HourlyEmployee(new Name("Tran", "Duc", "Minh"), new Date(30, 6, 2009), 50000, 40);
		Employee h2 = new HourlyEmployee(new Name("Nguyen", "Thi", "Huyen"), new Date(15, 2, 2011), 70000, 24);
		Employee c1 = new Consultant(new Name("Le", "Dinh", "Van"), new Date(25, 9, 2013), 012030, 5000000);

		IListE empty = new MTListE();
		IListE cons1 = new ConsListE(c1, empty);
		IListE cons2 = new ConsListE(h2, cons1);
		IListE cons3 = new ConsListE(h1, cons2);
		IListE cons4 = new ConsListE(s2, cons3);
		IListE cons5 = new ConsListE(s1, cons4);

		Deparment d1 = new Deparment("Quản lý đất đai", cons5);

		assertEquals(d1.sortBySalary(), new ConsListE(h1,
				new ConsListE(s1, new ConsListE(h2, new ConsListE(c1, new ConsListE(s2, new MTListE()))))));
	}
}
