package bai_15;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.StringTokenizer;

public class Student {
	long id;
	String fname;
	String lname;
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

	public Student() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return id + "	" + fname + "	" + lname + "	" + age + "	" + gender + "	" + idClass + "	" + score + "\n";
	}

	public String exportLine(String delimited) {
		return id + delimited + fname + delimited + lname + delimited + age + delimited + gender + delimited + idClass
				+ delimited + score + "\n";
	}

	public void importLine(String line, String delimited) {
		StringTokenizer token = new StringTokenizer(line, delimited);
		id = Long.parseLong(token.nextToken());
		fname = token.nextToken();
		lname = token.nextToken();
		age = Integer.parseInt(token.nextToken());
		gender = Boolean.parseBoolean(token.nextToken());
		idClass = token.nextToken();
		score = Double.parseDouble(token.nextToken());
	}

}
