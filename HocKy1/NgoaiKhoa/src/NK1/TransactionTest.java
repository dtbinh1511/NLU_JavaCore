package NK1;

import junit.framework.TestCase;

public class TransactionTest extends TestCase {
public void testTransactionContructor() {
	Transaction t1 = new Transaction ("Binh", 1000000, 5);
}
public void testInterest() {
	Transaction t1 = new Transaction ("Binh", 10000, 5);
assertEquals(t1.interest(), 500.0 );
}
public void testPayBack() {
	Transaction t1 = new Transaction ("Binh", 10000, 5);
assertEquals(t1.payBack(), 1081,2575.0);
}
}
