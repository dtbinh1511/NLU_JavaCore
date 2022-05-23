package Task2_3;

import junit.framework.TestCase;

public class ScoreBoardTest extends TestCase {
	public void testConStructor() {
		GradeRecord g1 = new GradeRecord(211, "Database Fundamentals", 3, 7.5);
		GradeRecord g2 = new GradeRecord(220, "Basic Programming", 3, 5.0);
		GradeRecord g3 = new GradeRecord(690, "Algorihms", 4, 7.0);
		GradeRecord g4 = new GradeRecord(721, "Data Structure", 4, 8.0);

		IList empty = new MTList();
		IList cons1 = new ConsList(g1, empty);
		IList cons2 = new ConsList(g2, cons1);
		IList cons3 = new ConsList(g3, cons2);
		IList cons4 = new ConsList(g4, cons3);

		ScoreBoard s1 = new ScoreBoard("Tran Van Hoa", 2009, cons4);
		System.out.println(s1);
	}

	public void testHowManyCredits() {
		GradeRecord g1 = new GradeRecord(211, "Database Fundamentals", 3, 7.5);
		GradeRecord g2 = new GradeRecord(220, "Basic Programming", 3, 5.0);
		GradeRecord g3 = new GradeRecord(690, "Algorihms", 4, 7.0);
		GradeRecord g4 = new GradeRecord(721, "Data Structure", 4, 8.0);

		IList empty = new MTList();
		IList cons1 = new ConsList(g1, empty);
		IList cons2 = new ConsList(g2, cons1);
		IList cons3 = new ConsList(g3, cons2);
		IList cons4 = new ConsList(g4, cons3);

		ScoreBoard s1 = new ScoreBoard("Tran Van Hoa", 2009, cons4);

		assertEquals(s1.howManyCredits(), 14);
	}

	public void testGradeAverage() {
		GradeRecord g1 = new GradeRecord(211, "Database Fundamentals", 3, 7.5);
		GradeRecord g2 = new GradeRecord(220, "Basic Programming", 3, 5.0);
		GradeRecord g3 = new GradeRecord(690, "Algorihms", 4, 7.0);
		GradeRecord g4 = new GradeRecord(721, "Data Structure", 4, 8.0);

		IList empty = new MTList();
		IList cons1 = new ConsList(g1, empty);
		IList cons2 = new ConsList(g2, cons1);
		IList cons3 = new ConsList(g3, cons2);
		IList cons4 = new ConsList(g4, cons3);

		ScoreBoard s1 = new ScoreBoard("Tran Van Hoa", 2009, cons4);

		assertEquals(s1.gradeAverage(), 1.964, 0.001);

	}

	public void testSortByGradeDec() {
		GradeRecord g1 = new GradeRecord(211, "Database Fundamentals", 3, 7.5);
		GradeRecord g2 = new GradeRecord(220, "Basic Programming", 3, 5.0);
		GradeRecord g3 = new GradeRecord(690, "Algorihms", 4, 7.0);
		GradeRecord g4 = new GradeRecord(721, "Data Structure", 4, 8.0);

		IList empty = new MTList();
		IList cons1 = new ConsList(g1, empty);
		IList cons2 = new ConsList(g2, cons1);
		IList cons3 = new ConsList(g3, cons2);
		IList cons4 = new ConsList(g4, cons3);

		ScoreBoard s1 = new ScoreBoard("Tran Van Hoa", 2009, cons4);
		
		assertEquals(s1.sortByGradeDec(),
				new ConsList(g4, new ConsList(g1, new ConsList(g3, new ConsList(g2, new MTList())))));
	}

	public void testGreaterThanList() {
		GradeRecord g1 = new GradeRecord(211, "Database Fundamentals", 3, 7.5);
		GradeRecord g2 = new GradeRecord(220, "Basic Programming", 3, 5.0);
		GradeRecord g3 = new GradeRecord(690, "Algorihms", 4, 7.0);
		GradeRecord g4 = new GradeRecord(721, "Data Structure", 4, 8.0);

		IList empty = new MTList();
		IList cons1 = new ConsList(g1, empty);
		IList cons2 = new ConsList(g2, cons1);
		IList cons3 = new ConsList(g3, cons2);
		IList cons4 = new ConsList(g4, cons3);

		ScoreBoard s1 = new ScoreBoard("Tran Van Hoa", 2009, cons4);

		assertEquals(s1.greaterThanList(7.0), new ConsList(g4, new ConsList(g1, new MTList())));
	}
}
