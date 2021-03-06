package Linked_List;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;

public class Class {
	private String name;
	private String year;
	private LinkedList<Student> list = new LinkedList<Student>();

	public Class(String name, String year) {
		super();
		this.name = name;
		this.year = year;
	}

	// load all students from filename into the list of students
	public void loadStudents(String fileName) throws IOException {
		list = StudentUtils.loadStudents(fileName);
	}

	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		list.sort(c);
	}

	// get top n students with highest GPA
	public LinkedList<Student> getTopNStudents(int n) {
		Comparator<Student> comp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if (o1.getGPA() > o2.getGPA())
					return -1;
				return 1;
			}
		};
		sortStudents(comp);
		LinkedList<Student> newList = new LinkedList<Student>();
		for (int i = 0; i < n; i++) {
			newList.add(list.get(i));
		}
		return newList;
	}

	// get random n students from the list of students
	public LinkedList<Student> getRandomNStudents(int n) {
		LinkedList<Student> newList = new LinkedList<Student>();
		int[] check = new int[list.size()];
		for (int i = 0; i < check.length; i++) {
			check[i] = 1;
		}
		int i = 0;
		while (i < n) {
			int ran = (int) (Math.random() * list.size());
			if (check[ran] != 0) {
				newList.add(list.get(ran));
				i++;
				check[ran] = 0;
			}
		}
		return newList;
	}

	// similar as toString method, this method prints the name, year, and all
	// students of the class.
	public void display() {
		for (Student student : list) {
			System.out.println(student);
		}
	}

	public static void main(String[] args) throws IOException {
		Class class1 = new Class("DH19DTA", "2019");
		class1.loadStudents("C:\\Users\\Admin\\Desktop\\CTDL_T.Dũ\\Lab 7_List\\students.txt");

//		for (Student string : class1.getTopNStudents(5)) {
//			System.out.println(string);
//		}
//		for (Student string : class1.getRandomNStudents(5)) {
//			System.out.println(string);
//		}

		LinkedList<Integer> list = new LinkedList<>();
		list.add(3);
		list.addFirst(5);
		list.add(1);
		list.addLast(19);
		list.add(7);
		list.remove();
		list.add(3, 8);
		System.out.println(list);
	}
}
