package bai13;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	// write file txt
	public void writeFile(String destPath, List<Student> list) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(destPath));
		dos.writeInt(list.size());
		for (Student student : list) {
			student.writeFile(dos);
		}
	}

	// read file txt
	public List<Student> readFile(String sPath) throws IOException {
		List<Student> list = new ArrayList<Student>();
		DataInputStream dis = new DataInputStream(new FileInputStream(sPath));
		int size = dis.readInt();
		for (int i = 0; i < size; i++) {
			Student st = new Student();
			st.readFile(dis);
			list.add(st);
		}
		return list;
	}

	public List<Student> createList() {
		List<Student> list = new ArrayList<Student>();
		Student s1 = new Student("0001", "Don DS", 12, 6.7f);
		Student s2 = new Student("0002", "Don DS", 16, 6.7f);
		Student s3 = new Student("0003", "Don DS", 18, 6.7f);
		list.add(s1);
		list.add(s2);
		list.add(s3);
		return list;
	}

	public static void main(String[] args) throws IOException {
		String spath = "";
		String destPath = "E:\\Test\\Client2\\student.dat";

		StudentDAO dao = new StudentDAO();
		System.out.println("Dữ liệu mẫu");
		List<Student> list = dao.createList();
		for (Student student : list) {
			System.out.println(student.toString());
		}
		dao.writeFile(destPath, list);
		
		
		list = dao.readFile(destPath);
		System.out.println("Dữ liệu từ file");
		for (Student student : list) {
			System.out.println(student.toString());
		}
	}
}
