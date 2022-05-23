import junit.framework.TestCase;

public class TestEmployee extends TestCase {
public void testEmployeeConstruction () {
	Employee e1 = new Employee ("Do Thanh Binh", 120);
	Employee e2 = new Employee ("Ngo Thanh De", 2);
	
}
//tien luong kiem duoc
public void testWage () {
	Employee e1 = new Employee ("Do Thanh Binh", 120);
assertEquals(e1.wage(), 1440 );
		Employee e2 = new Employee("Ngo Thanh De", 2);
		assertEquals(e2.wage(), 24);
}
//tien thue
public void testTax () {
	Employee e1 = new Employee ("Do Thanh Binh", 120);
	assertEquals(e1.tax(), 403,2.0);	
	Employee e2 = new Employee ("Ngo Thanh De", 2);
	assertEquals(e2.tax(), 3,6.0);
}
//tien nhan dc
public void testNetPay () {
	Employee e1 = new Employee ("Do Thanh Binh", 120);
	assertEquals (e1.netpay(), 1036,8.0);
	Employee e2 = new Employee ("Ngo Thanh De", 2);
	assertEquals (e2.netpay(), 20,4.0);
	
}
//tien tang cho moi nguoi
public void testRaiseWage () {
	Employee e1 = new Employee ("Do Thanh Binh", 120);
	assertEquals (e1.raiseWage(), 1680.0);
	Employee e2 = new Employee ("Ngo Thanh De", 2);
	assertEquals (e2.raiseWage(), 28.0);
	
}
//kiem tra nhan vien co lam du gio
public void testCheckOverTime () {
	Employee e1 = new Employee ("Do Thanh Binh", 120);
	assertTrue (e1.checkOverTime(100));
	Employee e2 = new Employee ("Ngo Thanh De", 2);
	assertFalse (e2.checkOverTime(100));
}
}
