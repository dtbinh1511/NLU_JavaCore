package score_management;

import java.util.GregorianCalendar;

public class Test {

	public static void main(String[] args) {
		CenterIT it = new CenterIT("NLU");

		Lecturer l1 = new Lecturer("Pham Van Tinh", new GregorianCalendar(1970, 11, 20).getTime(), "PhD");
		Lecturer l2 = new Lecturer("Mai Anh Tho", new GregorianCalendar(1979, 12, 24).getTime(), "MS");
		Lecturer l3 = new Lecturer("Nguyen Duc Cong Song", new GregorianCalendar(1977, 8, 14).getTime(), "MS");

		it.lecturers.add(l1);
		it.lecturers.add(l2);
		it.lecturers.add(l3);

		Course c1 = new Course("Lap trinh co ban", 4, l2);
		Course c2 = new Course("Lap trinh nang cao", 4, l3);
		Course c3 = new Course("Lap trinh mang", 4, l1);
		Course c4 = new Course("Mang may tinh", 4, l1);

		it.courses.add(c1);
		it.courses.add(c2);
		it.courses.add(c3);
		it.courses.add(c4);

		Student s1 = new Student("Nguyen Van Tuan", new GregorianCalendar(1988, 1, 23).getTime());

		Student s2 = new Student("Tran Van Thiet", new GregorianCalendar(1989, 11, 2).getTime());
		Student s3 = new Student("Nguyen Thi Lan", new GregorianCalendar(1988, 6, 20).getTime());
		Student s4 = new Student("Nguyen Thi Truc", new GregorianCalendar(1990, 4, 15).getTime());
		Student s5 = new Student("Vo Tan Doi", new GregorianCalendar(1988, 2, 26).getTime());
		Student s6 = new Student("Do The Sang", new GregorianCalendar(1989, 3, 12).getTime());
		it.students.add(s1);
		it.students.add(s2);
		it.students.add(s3);
		it.students.add(s4);
		it.students.add(s5);
		it.students.add(s6);

		// student register course
		s1.register(c1);
		s1.register(c2);
		s1.register(c3);
		s2.register(c2);
		s2.register(c3);
		s2.register(c4);
		s3.register(c1);
		s3.register(c2);
		s3.register(c3);
		s3.register(c4);
		s4.register(c1);
		s4.register(c3);
		s4.register(c4);
		s5.register(c1);
		s5.register(c2);
		s5.register(c3);
		s5.register(c4);
		s6.register(c1);
		s6.register(c2);

		s1.updateScore(c1, 6);
		s1.updateScore(c2, 7);
		s1.updateScore(c3, 8);
		s2.updateScore(c2, 8.5f);
		s2.updateScore(c3, 5);
		s2.updateScore(c4, 7);
		s3.updateScore(c1, 4);
		s3.updateScore(c2, 7.5f);
		s3.updateScore(c3, 8);
		s3.updateScore(c4, 10);
		s4.updateScore(c1, 8);
		s4.updateScore(c3, 3);
		s4.updateScore(c4, 6);
		s5.updateScore(c1, 5);
		s5.updateScore(c2, 4);
		s5.updateScore(c3, 6);
		s5.updateScore(c4, 8);
		s6.updateScore(c1, 5);
		s6.updateScore(c2, 8);

		
		it.showName();
	}
}
