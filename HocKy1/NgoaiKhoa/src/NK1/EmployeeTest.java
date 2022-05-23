package NK1;

import junit.framework.TestCase;

public class EmployeeTest extends TestCase {
	public void testEmployeeConstructor() {

		Employee e1 = new Employee("Binh", 101);

	}

	/*
	 * public void testWage(){ Employee e1 = new Employee("Binh", 101);
	 * assertEquals(e1.wage(), 1212);
	 * 
	 * }
	 * 
	 * public void testTax() { Employee e1 = new Employee("Binh", 101);
	 * assertEquals(e1.tax(), 181,8.0); }
	 * 
	 * public void testNetPay() { Employee e1 = new Employee("Binh", 101);
	 * assertEquals(e1.netpay(), 1030.2); }
	 */
	public void RaisedWage() {
		Employee e1 = new Employee("Binh", 101);
		assertEquals(e1.raisedWage(), 1414);
	}

	public void CheckOverTime() {
		Employee e1 = new Employee("Binh", 101);
		assertTrue(e1.checkOverTime());
	}

	public void testTax() {
		Employee e1 = new Employee("Binh", 100);
		assertEquals(e1.tax(), 336.0, 0.001);

	}

	public void testNetPay() {
		Employee e1 = new Employee("Binh", 100);
		assertEquals(e1.netpay(), 864.0);
	}
}
