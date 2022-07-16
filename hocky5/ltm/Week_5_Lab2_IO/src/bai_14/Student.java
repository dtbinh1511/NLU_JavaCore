package bai_14;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

public class Student {
	long id;
	String lname;
	String fname;
	int age;
	boolean gender;
	String idClass;
	double score;

	public Student(long id, String fname, String lname, int age, boolean gender, String idClass, double score) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
		this.idClass = idClass;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", lname=" + lname + ", fname=" + fname + ", age=" + age + ", gender=" + gender
				+ ", idClass=" + idClass + ", score=" + score + "]";
	}

	public void writeStudent(RandomAccessFile raf) throws IOException {
		raf.writeLong(id);
		raf.writeUTF(fname);
		raf.writeUTF(lname);
		raf.writeInt(age);
		raf.writeBoolean(gender);
		raf.writeUTF(idClass);
		raf.writeDouble(score);
	}

	public void writeStudent(OutputStreamWriter osw) throws IOException {
		osw.write(id + "");
		osw.write(fname);
		osw.write(lname);
		osw.write(age);
		osw.write(gender + "");
		osw.write(idClass);
		osw.write(score + "");
	}
}
