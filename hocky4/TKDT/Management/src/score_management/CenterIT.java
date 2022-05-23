package score_management;

import java.util.*;

public class CenterIT {
	protected ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
	protected ArrayList<Student> students = new ArrayList<Student>();
	protected ArrayList<Course> courses = new ArrayList<Course>();

	private String name;

	public CenterIT(String name) {
		this.name = name;
	}

	public Student findName(String nameStu) {
		for (Student student : students) {
			if (student.getName().equals(nameStu))
				return student;
		}
		return null;
	}

	public void showName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		String name = sc.nextLine();
		if (findName(name) != null) {
			System.out.print(findName(name).statement());
		}else {
			System.out.println("Not found student");
		}
	}
}
