package UDP_bai23;

import java.util.ArrayList;
import java.util.List;

public class Dao {
	static List<Student> students = new ArrayList<>();

	public static void createData() {
		students.add(new Student(111, "Nguyễn Thị Hoa Hồng", 18, 9));
		students.add(new Student(222, "Nguyễn Thị Hồng Thắm", 18, 9));
		students.add(new Student(333, "Lê Văn Thắng", 18, 9));
		students.add(new Student(444, "Trần Văn Ơn", 18, 9));
	}

	// findByName
	public static List<Student> findByName(String name) {
		List<Student> list = new ArrayList<>();
		for (Student student : students) {
			if (student.getName().endsWith(name)) {
				list.add(student);
			}
		}
		return list;
	}

	// findByAge
	public static List<Student> findByAge(int age) {
		List<Student> list = new ArrayList<>();
		for (Student student : students) {
			if (student.getAge() == age) {
				list.add(student);
			}
		}
		return list;
	}

	// findByScore
	public static List<Student> findByScore(double score) {
		List<Student> list = new ArrayList<>();
		for (Student student : students) {
			if (student.getScore() == score) {
				list.add(student);
			}
		}
		return list;
	}
}
