package Lab7_T.Du;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Class {

	private String name;
	private int year;
	private ArrayList<Student> list = new ArrayList<Student>();

	public Class(String name, int year) {
		this.name = name;
		this.year = year;
	}

	// load all students from filename into the list of
	// students
	public void loadStudents(String fileName) {
		try {
			list = StudentUtils.loadStudents(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		list.sort(c);
	}

	// get top n students with highest GPA
	public ArrayList<Student> getTopNStudents(int n) {

		ArrayList<Student> result = new ArrayList<>();
		ArrayList<Student> copyAList = (ArrayList<Student>) this.list.clone();

		Comparator<Student> comparator = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if (o1.getGpa() < o2.getGpa())
					return 1;
				return -1;
			}
		};

		list.sort(comparator);

		for (int i = 0; i < n; i++) {
			result.add(list.get(i));
		}
		
		list = copyAList;

		return result;
	}

	// get random n students from the list of students
	public ArrayList<Student> getRandomNStudents(int n) {

		ArrayList<Student> result = new ArrayList<Student>();

		Random rd = new Random();

		int countStd = 0;
		while (countStd < n) {

			Student std = list.get(rd.nextInt(list.size() - 1));

			boolean checkExist = false;

			for (int j = 0; j < result.size(); j++) {
				if (std.equals(result.get(j))) {
					checkExist = true;
					break;
				}
			}

			if (!checkExist) {
				result.add(std);
				countStd++;
			}
		}

		return result;
	}

	// similar as toString method, this method prints the
	// name, year, and all students of the class.
	// Note that, using iterator
	public void display() {
		System.out.println("Name class: " + this.name);
		System.out.println("Year: " + this.year);
		for (Student student : list) {
			System.out.print(student);
		}
	}
	
	

	public static void main(String[] args) {

		Class class1 = new Class("A", 2019);
		class1.loadStudents("students.txt");
		System.out.println(class1.list.toString());

		Comparator<Student> comparator = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.compare(o2);
			}
		};

		class1.sortStudents(comparator);
		System.out.println(class1.list.toString());

		System.out.println(class1.getTopNStudents(3).toString());

		System.out.println(class1.getRandomNStudents(3).toString());

		class1.display();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Class other = (Class) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	

}
