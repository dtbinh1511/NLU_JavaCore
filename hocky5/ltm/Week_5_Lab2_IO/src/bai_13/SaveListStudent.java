package bai_13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveListStudent {
	public static void saveToFile(List<Student> students, String dest) throws IOException {
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dest)));
		dos.writeInt(students.size());
		for (Student student : students) {
			student.save(dos);
		}
		dos.close();
	}

	public static List<Student> loadToFile(String source) throws IOException {
		File file = new File(source);
		if (!file.exists())
			return null;

		List<Student> list = new ArrayList<Student>();
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(source)));
		int length = dis.readInt();

		Student st;
		for (int i = 0; i < length; i++) {
			st = new Student();
			st.read(dis);
			list.add(st);
		}
		dis.close();
		return list;
	}

	public static List<Student> createStudents() {
		List<Student> list = new ArrayList<>();
		list.add(new Student(19130001, "Nguyễn", "A", 22.5));
		list.add(new Student(19120132, "Trần", "B", 25.06));
		list.add(new Student(19130051, "Đỗ", "C", 24.8));

		return list;
	}

	public static void main(String[] args) throws IOException {
		List<Student> list = createStudents();
		System.out.println("Dữ liệu mẫu");
		for (Student student : list) {
			System.out.println(student);
		}

		String path = "E:\\java\\hocKy5\\visual\\student.dat";
//		saveToFile(list, path);
		list = loadToFile(path);

		System.out.println("Dữ liệu từ file");
		for (Student st : list) {
			System.out.println(st);
		}
	} 
}
