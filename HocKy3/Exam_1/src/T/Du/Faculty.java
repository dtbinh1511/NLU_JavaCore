package T.Du;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Faculty {
	private String name;
	private int establishedYear;
	private List<Student> students;

	public Faculty(String name, int establishedYear, List<Student> students) {
		super();
		this.name = name;
		this.establishedYear = establishedYear;
		this.students = students;
	}

	@Override
	public String toString() {
		return "Faculty [name=" + name + ", establishedYear=" + establishedYear + ", students=" + students + "]";
	}

	public Map<Student, Integer> maxPublictionStat() {
		Map<Student, Integer> map = new HashMap<>();
		for (Student student : students) {
			map.put(student, student.maxGradePublication().getGrade());
		}
		return map;
	}

	public Map<Student, Integer> pubGradeStat() {
		Map<Student, Integer> map = new HashMap<>();
		for (Student student : students) {
			map.put(student, student.totalGrade());
		}
		return map;
	}

	public static void main(String[] args) {
		Publication p1 = new Publication("Cô bé", "A", 2010, 1);
		Publication p2 = new Publication("Cậu bé", "B", 2010, 3);
		Publication p3 = new Publication("Cô bé", "C", 2010, 5);
		Publication p4 = new Publication("Cậu bé", "D", 2010, 6);
		Publication p5 = new Publication("Cô bé", "E", 2010, 10);
		Publication p6 = new Publication("Cậu bé", "F", 2010, 9);

		ArrayList<Publication> pubs1 = new ArrayList<>();
		pubs1.add(p1);
		pubs1.add(p6);
		pubs1.add(p5);
		ArrayList<Publication> pubs2 = new ArrayList<>();
		pubs2.add(p3);
		pubs2.add(p2);
		pubs2.add(p4);

		Student st1 = new Student("1", "A", null, 2001, pubs1);
		Student st2 = new Student("2", "B", null, 2001, pubs2);
		ArrayList<Student> st = new ArrayList<>();
		st.add(st1);
		st.add(st2);
		Faculty f = new Faculty("CNTT", 2020, st);

//		System.out.println(f.maxPublictionStat());
		System.out.println(f.pubGradeStat());

	}
}
