package T.Du;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
	private String id;
	private String name;
	private Date brithday;
	private int year;
	private List<Publication> pubs;

	public Student(String id, String name, Date brithday, int year, List<Publication> pubs) {
		super();
		this.id = id;
		this.name = name;
		this.brithday = brithday;
		this.year = year;
		this.pubs = pubs;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", brithday=" + brithday + ", year=" + year + ", pubs=" + pubs
				+ "\n";
	}

	public Publication maxGradePublication() {
		Publication publication = pubs.get(0);
		for (int i = 1; i < pubs.size(); i++) {
			if (pubs.get(i).getGrade() > publication.getGrade())
				publication = pubs.get(i);
		}
		return publication;
	}

	public int totalGrade() {
		int result = 0;
		for (Publication publication : pubs) {
			result += publication.getGrade();
		}
		return result;
	}

	public static void main(String[] args) {
		Publication p1 = new Publication("Cô bé", "A", 2010, 1);
		Publication p2 = new Publication("Cậu bé", "B", 2010, 3);
		Publication p3 = new Publication("Cô bé", "C", 2010, 5);
		Publication p4 = new Publication("Cậu bé", "D", 2010, 6);
		Publication p5 = new Publication("Cô bé", "E", 2010, 10);
		Publication p6 = new Publication("Cậu bé", "F", 2010, 9);

		ArrayList<Publication> pubs = new ArrayList<>();
		pubs.add(p1);
		pubs.add(p6);
		pubs.add(p5);
		pubs.add(p3);
		pubs.add(p2);
		pubs.add(p4);

		Student st = new Student("1", "A", null, 2001, pubs);
//		System.out.println(st);
		System.out.println(st.maxGradePublication());
	}
}
