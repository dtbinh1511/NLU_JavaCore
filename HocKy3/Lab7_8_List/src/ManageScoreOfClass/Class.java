package ManageScoreOfClass;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Class {
	private String id;
	private String name;
	private double year;
	private LinkedList<Student> list = new LinkedList<>();

	public Class(String id, String name, double year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}

// thêm student // sắp xếp theo điểm trung bình
	public void add(Student newStu) {
		if (list.isEmpty()) {
			list.add(newStu);
		} else {
			if (newStu.getAvg() <= list.getFirst().getAvg())
				list.addFirst(newStu);
			if (newStu.getAvg() >= list.getLast().getAvg())
				list.addLast(newStu);
			else {
				for (int i = 1; i < list.size(); i++) {
					if (newStu.getAvg() <= list.get(i).getAvg()) {
						list.add(i, newStu);
						break;
					}
				}
			}
		}
	}

	public String toString() {
		String st = "";
		for (Student student : list) {
			st += student;
		}
		return st;
	}

// lấy ra top đầu
	public String getTop(int n) {
		int i = list.size() - 1;
		int j = 0;
		StringBuilder s = new StringBuilder();
		while (j < n) {
			s.append(list.get(i));
			j++;
			i--;
		}
		return s.toString();
	}

// lấy ra bottom 
	public String getBottom(int n) {
		int i = 0;
		StringBuilder s = new StringBuilder();
		while (i < n) {
			s.append(list.get(i));
			i++;
		}
		return s.toString();
	}

// tìm điểm của student. nếu 2 người trùng tên thì lỗi
	public double findMarkAvg(String nameStu) {
		double result = 0.0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getFullname().equalsIgnoreCase(nameStu))
				result = list.get(i).getAvg();
		}
		return result;
	}

// tính điểm trung bình của lớp
	public double avgOfClass() {
		double sum = 0.0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).getAvg();
		}
		return sum / list.size();
	}

// xóa học sinh dưới điểm trung bình
	public LinkedList<Student> removeLessThanAvg() {
		LinkedList<Student> result = list;
		for (Student student : result) {
			if(student.getAvg() < avgOfClass())
				result.remove(student);
		}
		return result;
	}

	public static void main(String[] args) {
		Student stA = new Student("Nguyen Vang Anh", "001", 4.5);
		Student stB = new Student("Nguyen Van Binh", "002", 7.5);
		Student stC = new Student("Nguyen Van Than", "003", 9.5);
		Student stD = new Student("Nguyen Van Than", "004", 7.5);
		Student stE = new Student("Nguyen Thai Binh", "005", 8.5);

		Class class1 = new Class("DT", "DH19DT", 2019);
		class1.add(stA);
		class1.add(stB);
		class1.add(stC);
		class1.add(stD);
		class1.add(stE);
		System.out.println(class1.toString());
		System.out.println("=================");
		System.out.println(class1.getTop(2));
		System.out.println("=================");
		System.out.println(class1.getBottom(2));
		System.out.println("=================");
		System.out.println(class1.findMarkAvg("Nguyen Van Than"));
		System.out.println("=================");
		System.out.println("Điểm trung bình của lớp: " + class1.avgOfClass());
		System.out.println("=================");
		System.out.println("Học sinh trên điểm trung bình:\n " + class1.removeLessThanAvg());
	}
}
