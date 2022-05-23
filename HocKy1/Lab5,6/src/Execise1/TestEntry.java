package Execise1;

import junit.framework.TestCase;

public class TestEntry extends TestCase {
	public void testEntryContructor() {
		Entry e1 = new Entry(new Date(15, 11, 2001), 100, 2, "bad");
		Date d2 = new Date(15, 11, 2001);
		Entry e2 = new Entry(d2, 12, 1, "good");
	}
}
