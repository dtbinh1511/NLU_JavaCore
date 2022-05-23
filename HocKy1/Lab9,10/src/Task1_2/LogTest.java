package Task1_2;

import junit.framework.TestCase;

public class LogTest extends TestCase {
	public void testConstructor() {
		Entry e1 = new Entry(new Date(15, 11, 2001), 20, 60, "Good");
		Entry e2 = new Entry(new Date(16, 11, 2001), 30, 60, "Good");
		Entry e3 = new Entry(new Date(17, 12, 2001), 10, 60, "Good");

		ILog empty = new MTLog();
		ILog i1 = new ConsLog(e3, empty);
		ILog i2 = new ConsLog(e2, i1);
		ILog i3 = new ConsLog(e1, i2);
//		ILog all = new ConsLog(e1, new ConsLog(e2, new ConsLog(e3, empty)));

		System.out.println(i3);
//		System.out.println("Total  Number of Miles Run:" + i3.totalMilesRun());
//
//		System.out.println("\n" + "To get logs in a given month of a year" + i3.allLogInTime(11, 2001));
//
//		System.out.println("Total Number In Month: " + i3.totalDistanceInMonth(11, 2001));
//		
//		System.out.println("MAX DISTANCE: "+i3.maxDistance());
//		
//		System.out.println("\n"+"Sort By Distance shortest to longest: "+  i3.sortByDistance());
	}

	public void testEquals() {
		Entry e1 = new Entry(new Date(15, 11, 2001), 20, 60, "Good");
		Entry e2 = new Entry(new Date(16, 11, 2001), 30, 60, "Good");
		Entry e3 = new Entry(new Date(17, 12, 2001), 10, 60, "Good");

		ILog empty = new MTLog();
		ILog i1 = new ConsLog(e3, empty);
		ILog i2 = new ConsLog(e2, i1);
		ILog i3 = new ConsLog(e1, i2);
		ILog all = new ConsLog(e1, new ConsLog(e2, new ConsLog(e3, empty)));

		assertTrue(i3.equals(all));
	}

	public void testTotalMilesRun() {
		Entry e1 = new Entry(new Date(15, 11, 2001), 20, 60, "Good");
		Entry e2 = new Entry(new Date(16, 11, 2001), 30, 60, "Good");
		Entry e3 = new Entry(new Date(17, 12, 2001), 10, 60, "Good");

		ILog empty = new MTLog();
		ILog i1 = new ConsLog(e3, empty);
		ILog i2 = new ConsLog(e2, i1);
		ILog i3 = new ConsLog(e1, i2);
		ILog all = new ConsLog(e1, new ConsLog(e2, new ConsLog(e3, empty)));

		assertEquals(i3.totalMilesRun(), 60.0);
	}

	public void testAllLogInTime() {
		Entry e1 = new Entry(new Date(15, 11, 2001), 20, 60, "Good");
		Entry e2 = new Entry(new Date(16, 11, 2001), 30, 60, "Good");
		Entry e3 = new Entry(new Date(17, 12, 2001), 10, 60, "Good");

		ILog empty = new MTLog();
		ILog i1 = new ConsLog(e3, empty);
		ILog i2 = new ConsLog(e2, i1);
		ILog i3 = new ConsLog(e1, i2);
		ILog all = new ConsLog(e1, new ConsLog(e2, new ConsLog(e3, new MTLog())));

		assertEquals(i3.allLogInTime(11, 2001), new ConsLog(e1, new ConsLog(e2, new MTLog())));

	}

	public void testTotalDistanceInMonth() {
		Entry e1 = new Entry(new Date(15, 11, 2001), 20, 60, "Good");
		Entry e2 = new Entry(new Date(16, 11, 2001), 30, 60, "Good");
		Entry e3 = new Entry(new Date(17, 12, 2001), 10, 60, "Good");

		ILog empty = new MTLog();
		ILog i1 = new ConsLog(e3, empty);
		ILog i2 = new ConsLog(e2, i1);
		ILog i3 = new ConsLog(e1, i2);
		ILog all = new ConsLog(e1, new ConsLog(e2, new ConsLog(e3, empty)));

		assertEquals(i3.totalDistanceInMonth(11, 2001), 50.0);
	}

	public void testMaxDistance() {
		Entry e1 = new Entry(new Date(15, 11, 2001), 20, 60, "Good");
		Entry e2 = new Entry(new Date(16, 11, 2001), 30, 60, "Good");
		Entry e3 = new Entry(new Date(17, 12, 2001), 10, 60, "Good");

		ILog empty = new MTLog();
		ILog i1 = new ConsLog(e3, empty);
		ILog i2 = new ConsLog(e2, i1);
		ILog i3 = new ConsLog(e1, i2);
		ILog all = new ConsLog(e1, new ConsLog(e2, new ConsLog(e3, empty)));

		assertEquals(i3.maxDistance(), 30.0);
	}

	public void testSortByDistance() {
		Entry e1 = new Entry(new Date(15, 11, 2001), 20, 60, "Good");
		Entry e2 = new Entry(new Date(16, 11, 2001), 30, 60, "Good");
		Entry e3 = new Entry(new Date(17, 12, 2001), 10, 60, "Good");

		ILog empty = new MTLog();
		ILog i1 = new ConsLog(e3, empty);
		ILog i2 = new ConsLog(e2, i1);
		ILog i3 = new ConsLog(e1, i2);
		ILog all = new ConsLog(e1, new ConsLog(e2, new ConsLog(e3, empty)));

		assertEquals(i3.sortByDistance(), new ConsLog(e3, new ConsLog(e1, new ConsLog(e2, new MTLog()))));

	}
}
