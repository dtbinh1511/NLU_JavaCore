package bai_15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImportExport {

	public static void exportStudent(List<Student> students, String txtPath, String charset, String delimited)
			throws IOException {
		PrintWriter pw = new PrintWriter(txtPath, charset);
		String line = "";
		for (Student student : students) {
			line = student.exportLine(delimited);
			pw.print(line);
		}
		pw.close();
	}

	public static List<Student> importStudent(String txtPath, String charset, String delimited) throws IOException {
		List<Student> students = new ArrayList<Student>();
		InputStreamReader isr = new InputStreamReader(new FileInputStream(txtPath), charset);
		BufferedReader br = new BufferedReader(isr);

		String line = "";
		while ((line = br.readLine()) != null) {
			Student st = new Student();
			st.importLine(line, delimited);
			students.add(st);
		}

		br.close();
		return students;
	}

	// create student
	public static List<Student> createStudents() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(21130001, "Trần Trung", "Tín", 18, true, "DH21DTD", 23.75));
		students.add(new Student(21130002, "Võ Thị Ngọc", "Thảo", 18, false, "DH21DTA", 25.25));
		students.add(new Student(21130003, "Trần Thị Minh", "Thư", 18, true, "DH21DTB", 23.75));
		students.add(new Student(21130004, "Phạm Hoàng", "Tiến", 18, true, "DH21DTC", 24.75));
		students.add(new Student(21130005, "Nguyễn Hoàng", "Tú", 18, true, "DH21DTA", 25.75));
		students.add(new Student(21130006, "Mai Thị Tuyết", "Sương", 18, false, "DH21DTC", 26));
		students.add(new Student(21130007, "Nguyễn Như", "Toàn", 18, true, "DH21DTD", 24));
		students.add(new Student(21130008, "Nguyễn Thị Thanh", "Trúc", 18, false, "DH21DTB", 24.25));
		students.add(new Student(21130009, "Ngô Cự", "Văn", 18, true, "DH21DTB", 24.25));
		students.add(new Student(21130010, "Vũ Hoàng", "Nhật", 18, true, "DH21DTC", 25));
		students.add(new Student(21130011, "Nguyễn", "Thương", 18, false, "DH21DTA", 24.75));
		students.add(new Student(21130012, "Mai Thị Thu", "Trang", 18, false, "DH21DTC", 25));
		students.add(new Student(21130013, "Hoàng Minh", "Hiếu", 18, true, "DH21DTB", 25.5));
		students.add(new Student(21130014, "Trần Minh", "Hướng", 18, true, "DH21DTD", 23));
		students.add(new Student(21130015, "Võ Minh", "Thịnh", 18, true, "DH21DTD", 23.25));
		students.add(new Student(21130016, "Võ Phi", "Hoàng", 18, true, "DH21DTA", 23.5));
		students.add(new Student(21130017, "Phạm Thị Ngọc", "Hòa", 18, false, "DH21DTB", 23.75));
		students.add(new Student(21130018, "Nguyễn Thị Mỹ", "Duyên", 18, false, "DH21DTA", 23.62));
		students.add(new Student(21130019, "Lê Thị Xuân", "Nhi", 18, false, "DH21DTC", 23.62));
		students.add(new Student(21130020, "Khưu Trọng", "Phúc", 18, true, "DH21DTC", 23.62));

		return students;
	}

	public static void viewList(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

	public static void main(String[] args) throws IOException {
		List<Student> students = createStudents();
		String txtPath = "E:\\java\\hocKy5\\visual\\student.txt";
		String charset = "UTF-8";
		String delimited = "\t";
//		System.out.println("Dữ liệu gốc");
//		viewList(students);

//		exportStudent(students, txtPath, charset, delimited);
		System.out.println("Dữ liệu từ file");

		students = importStudent(txtPath, "UTF-16", delimited);
		viewList(students);
 
	}
}
