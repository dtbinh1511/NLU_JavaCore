package bai_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOStudent {
	class StudentEntry {
		int stt;
		long position;

		public StudentEntry(int stt, long position) {
			super();
			this.stt = stt;
			this.position = position;
		}

	}

	public void writeStudent(List<Student> students, String archiveName) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(archiveName, "rw");
		List<StudentEntry> header = new ArrayList<IOStudent.StudentEntry>();

		for (int i = 0; i < students.size(); i++) {
			header.add(new StudentEntry(i, raf.getFilePointer()));
			students.get(i).writeStudent(raf);
		}

		long headerPosition = raf.getFilePointer();
		raf.writeInt(students.size());
		for (StudentEntry studentEntry : header) {
			raf.writeInt(studentEntry.stt);
			raf.writeLong(studentEntry.position);
		}
		raf.writeLong(headerPosition);
		raf.close();
	}

	public Student readStudentToFile(String archiveName, int n) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(archiveName, "r");
		long actPosition = raf.length() - 8;
		raf.seek(actPosition);

		// load student
		long headerPosition = raf.readLong();
		raf.seek(headerPosition);
		int studentNumber = raf.readInt();
		List<StudentEntry> header = new ArrayList<IOStudent.StudentEntry>();
		for (int i = 0; i < studentNumber; i++) {
			header.add(new StudentEntry(raf.readInt(), raf.readLong()));
		}

		// read student
		Student st = null;
		for (StudentEntry studentEntry : header) {
			if (n == studentEntry.stt) {
				raf.seek(studentEntry.position);
				st = new Student(raf.readLong(), raf.readUTF(), raf.readUTF(), raf.readInt(), raf.readBoolean(),
						raf.readUTF(), raf.readDouble());
			}
		}
		raf.close();
		return st;
	}

	public void changedInfoStudent(String archiveName, int n, Student st) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(archiveName, "rw");
		long actPosition = raf.length() - 8;
		raf.seek(actPosition);

		// load student
		long headerPosition = raf.readLong();
		raf.seek(headerPosition);

		int studentNumber = raf.readInt();
		List<StudentEntry> header = new ArrayList<IOStudent.StudentEntry>();
		for (int i = 0; i < studentNumber; i++) {
			header.add(new StudentEntry(raf.readInt(), raf.readLong()));
		}

		// changes student
		for (StudentEntry studentEntry : header) {
			if (n == studentEntry.stt) {
				raf.seek(studentEntry.position);
				st.writeStudent(raf);
				break;
			}
		}
		raf.close();
	}

	public List<Student> createStudents() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(21130001, "Tr???n Trung", "T??n", 18, true, "DH21DTD", 23.75));
		students.add(new Student(21130002, "V?? Th??? Ng???c", "Th???o", 18, false, "DH21DTA", 25.25));
		students.add(new Student(21130003, "Tr???n Th??? Minh", "Th??", 18, true, "DH21DTB", 23.75));
		students.add(new Student(21130004, "Ph???m Ho??ng", "Ti???n", 18, true, "DH21DTC", 24.75));
		students.add(new Student(21130005, "Nguy???n Ho??ng", "T??", 18, true, "DH21DTA", 25.75));
		students.add(new Student(21130006, "Mai Th???", "S????ng", 18, false, "DH21DTC", 26));
		students.add(new Student(21130007, "Nguy???n Nh??", "To??n", 18, true, "DH21DTD", 24));
		students.add(new Student(21130008, "Nguy???n Th??? Thanh", "Tr??c", 18, false, "DH21DTB", 24.25));
		students.add(new Student(21130009, "Ng?? C???", "V??n", 18, true, "DH21DTB", 24.25));
		students.add(new Student(21130010, "V?? Ho??ng", "Nh???t", 18, true, "DH21DTC", 25));
		students.add(new Student(21130011, "Nguy???n", "Th????ng", 18, false, "DH21DTA", 24.75));
		students.add(new Student(21130012, "Mai Th??? Thu", "Trang", 18, false, "DH21DTC", 25));
		students.add(new Student(21130013, "Ho??ng Minh", "Hi???u", 18, true, "DH21DTB", 25.5));
		students.add(new Student(21130014, "Tr???n Minh", "H?????ng", 18, true, "DH21DTD", 23));
		students.add(new Student(21130015, "V?? Minh", "Th???nh", 18, true, "DH21DTD", 23.25));
		students.add(new Student(21130016, "V?? Phi", "Ho??ng", 18, true, "DH21DTA", 23.5));
		students.add(new Student(21130017, "Ph???m Th??? Ng???c", "H??a", 18, false, "DH21DTB", 23.75));
		students.add(new Student(21130018, "Nguy???n Th??? M???", "Duy??n", 18, false, "DH21DTA", 23.62));
		students.add(new Student(21130019, "L?? Th??? Xu??n", "Nhi", 18, false, "DH21DTC", 23.62));
		students.add(new Student(21130020, "Kh??u Tr???ng", "Ph??c", 18, true, "DH21DTC", 23.62));

		return students;
	}

	public static void main(String[] args) throws IOException {
		IOStudent ioStudent = new IOStudent();
		List<Student> students = ioStudent.createStudents();
		String archiveName = "E:\\java\\hocKy5\\visual\\student.txt";

		ioStudent.writeStudent(students, archiveName);
//
//		int position = 4;
//		System.out.println(ioStudent.readStudentToFile(archiveName, position));

//		Student newStudent = new Student(21130021, "L??u Nguy???n Thanh", "V??", 18, true, "DH21DTC", 23.62);
//		ioStudent.changedInfoStudent(archiveName, position, newStudent);
	} 

}
