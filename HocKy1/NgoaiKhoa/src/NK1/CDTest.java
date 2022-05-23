package NK1;

import junit.framework.TestCase;

public class CDTest extends TestCase {
public void testCDConstructor() {
	CD c1 = new CD ("Diem", 100000);
}
public void testInterset() {
	CD c1 = new CD ("Diem", 100000);
assertEquals(c1.interest(), 2500.0);
}
}
