package Arrays_List;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import Linked_List.Student;

public class Class {
	public String name;
	public String year;
	private ArrayList<Student> student = new ArrayList<Student>();

	public Class(String name, String year) {
		super();
		this.name = name;
		this.year = year;
	}

	// load all students from filename into the list of students
	public void loadStudents(String fileName) throws IOException {
		student = StudentUtils.loadStudents(fileName);
	}

	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		student.sort(c);
	}

	// get top n students with highest GPA
	public ArrayList<Student> getTopNStudents(int n) {
		Comparator<Student> comp = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.getGPA() > o2.getGPA())
					return -1;
				return 1;
			}
		};
		sortStudents(comp); // sort to GPA

		ArrayList<Student> newList = new ArrayList<Student>(); // create new list to storage
		for (int i = 0; i < n; i++) {
			newList.add(student.get(i));
		}
		return newList;
	}

	// get random n students from the list of students
	public ArrayList<Student> getRandomNStudents(int n) {
		ArrayList<Student> newList = new ArrayList<Student>();
		int[] check = new int[student.size()];
		for (int i = 0; i < check.length; i++) {
			check[i] = 1;
		}
		int i = 0;
		while (i < n) {
			int ran = (int) (Math.random() * (student.size()));
			if (check[ran] != 0) {
				newList.add(student.get(ran));
				i++;
				check[ran] = 0;
			}
		}
		return newList;

	}

	// similar as toString method, this method prints the
	// name, year, and all students of the class.
	// Note that, using iterator
	public void display() {
		for (int i = 0; i < student.size(); i++) {
			System.out.println(student.get(i).toString());
		}
	}

	public static void main(String[] args) throws IOException {
		Class class1 = new Class("DH19DTA", "2019");
		class1.loadStudents("C:\\Users\\Admin\\Desktop\\CTDL_T.D??\\Lab 7_List\\students.txt");

//		for (Student string : class1.getTopNStudents(5)) {
//			System.out.println(string);
//		}

//		for (Student string : class1.getRandomNStudents(5)) {
//			System.out.println(string);
//		}
//		LinkedList<Integer> list = new LinkedList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		System.out.println(list);
////		System.out.println(list.remove(3));
//		System.out.println(list.removeFirst());
	}

}
