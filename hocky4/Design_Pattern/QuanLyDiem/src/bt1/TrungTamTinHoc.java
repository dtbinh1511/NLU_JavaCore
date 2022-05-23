package bt1;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class TrungTamTinHoc {
	private List<Teacher> teachers = new ArrayList<Teacher>();
	private List<Student> students = new ArrayList<Student>();
	private List<Subject> subjects = new ArrayList<Subject>();

	public TrungTamTinHoc() {
		init();
	}

	public void init() {
		Teacher l1 = new Teacher("Pham Van Tinh", new GregorianCalendar(1970, 11, 20).getTime(), "PhD");
		Teacher l2 = new Teacher("Mai Anh Tho", new GregorianCalendar(1979, 12, 24).getTime(), "MS");
		Teacher l3 = new Teacher("Nguyen Duc Cong Song", new GregorianCalendar(1977, 8, 14).getTime(), "MS");
		teachers.add(l1);
		teachers.add(l2);
		teachers.add(l3);
		Subject c1 = new Subject("Lap trinh co ban", 4, l2);
		Subject c2 = new Subject("Lap trinh nang cao", 4, l3);
		Subject c3 = new Subject("Lap trinh mang", 4, l1);
		Subject c4 = new Subject("Mang may tinh", 4, l1);
		subjects.add(c1);
		subjects.add(c2);
		subjects.add(c3);
		subjects.add(c4);
		Student s1 = new Student("Nguyen Van Tuan", new GregorianCalendar(1988, 1, 23).getTime());
		Student s2 = new Student("Tran Van Thiet", new GregorianCalendar(1989, 11, 2).getTime());
		Student s3 = new Student("Nguyen Thi Lan", new GregorianCalendar(1988, 6, 20).getTime());
		Student s4 = new Student("Nguyen Thi Truc", new GregorianCalendar(1990, 4, 15).getTime());
		Student s5 = new Student("Vo Tan Doi", new GregorianCalendar(1988, 2, 26).getTime());
		Student s6 = new Student("Do The Sang", new GregorianCalendar(1989, 3, 12).getTime());
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		students.add(s6);
		s1.registerSub(c1);
		s1.registerSub(c2);
		s1.registerSub(c3);
		s2.registerSub(c2);
		s2.registerSub(c3);
		s2.registerSub(c4);
		s3.registerSub(c1);
		s3.registerSub(c2);
		s3.registerSub(c3);
		s3.registerSub(c4);
		s4.registerSub(c1);
		s4.registerSub(c3);
		s4.registerSub(c4);
		s5.registerSub(c1);
		s5.registerSub(c2);
		s5.registerSub(c3);
		s5.registerSub(c4);
		s6.registerSub(c1);
		s6.registerSub(c2);
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
	}

	public static void printList(List<?> list) {
		for (Object o : list) {
			System.out.println(o);
		}
		System.out.println("--------------------------");
	}

	public Student findStudentByName(String name) {
		for (Student s : students) {
			if (s.getNameStu().equals(name))
				return s;
		}
		return null;
	}

	public Subject findCourseByName(String name) {
		for (Subject c : subjects) {
			if (c.getNameSub().equals(name))
				return c;
		}
		return null;
	}

	public List<Student> getStudentsOfCourse(Subject c) {
		List<Student> result = new ArrayList<Student>();
		for (Student student : students) {
			for (Register register : student.getRegisters()) {
				if (register.getSubjects().getNameSub().equals(c.getNameSub()))
					result.add(student);
			}
		}
		return result;
	}

	// print report card use case
	public void printStudentReportCardUsecase() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter student name:");
		String studentName = in.nextLine();
		Student student = findStudentByName(studentName.trim());
		if (student != null) {
			student.show();
		} else {
			System.out.println("Student name not found!");
		}
	}
}
