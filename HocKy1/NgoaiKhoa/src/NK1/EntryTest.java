package NK1;

import junit.framework.TestCase;

public class EntryTest extends TestCase {
public void testEntryConstructor() {
	Entry e1 = new Entry(new Date (15, 11, 2001), 10, 60, "Bad");
}
public void testSpeed() {
	Entry e1 = new Entry(new Date (15, 11, 2001), 60, 10, "Bad");
assertEquals(e1.speed(), 6.0);
}
public void testDateEarlier() {
	Entry e1 = new Entry(new Date (15, 11, 2001), 10, 60, "Bad");
	Entry e2 = new Entry(new Date (15, 10, 2001), 10, 60, "Bad");
	assertFalse(e1.DateEarlier(e2));
	
}
}
