package lab7_linked_list;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Class {
	private String name;
	private String year;// 2017, 2018, 2019, ...
	private LinkedList<Student> students = new LinkedList<Student>();

	public Class(String name, String year) {
		this.name = name;
		this.year = year;
	}

	// load all students from filename into the list of students
	public void loadStudents(String fileName) throws IOException {
		students = StudentUtils.loadStudents(fileName);
	}

	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		students.sort(c);
	}

	// get top n students with highest GPA
	public LinkedList<Student> getTopNStudents(int n) {
		return null;
	}

	// get random n students from the list of students
	public LinkedList<Student> getRandomNStudents(int n) {
		return null;
	}

	// similar as toString method, this method prints the name, year, and all
	// students of the class.
	public void display() {
		System.out.println("Class name: " + this.name);
		System.out.println("Year: " + this.year);
		for (Student student : students) {
			System.out.print(student);
		}
	}

	public static void main(String[] args) throws IOException {

		Class class1 = new Class("A", "2019");
		class1.loadStudents("students.txt");
		class1.display();
		
		Comparator<Student> comparator = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};

	}
}
