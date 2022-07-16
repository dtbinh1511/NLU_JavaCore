package bai_13;

import java.io.*;

public class Student {
	private long id;
	private String fName;
	private String lName;
	private double grade;

	public Student(long id, String fName, String lName, double d) {
		super();
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.grade = d;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public double getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fName=" + fName + ", lName=" + lName + ", grade=" + grade + "]";
	}

	public void save(DataOutput dos) throws IOException {
		dos.writeLong(id);
		dos.writeUTF(fName);
		dos.writeUTF(lName);
		dos.writeDouble(grade);
	}

	public void read(DataInput dis) throws IOException {
		id = dis.readLong();
		fName = dis.readUTF();
		lName = dis.readUTF();
		grade = dis.readDouble();
	}

}
