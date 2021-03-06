package raf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Student {
	private String id;
	private String name;
	private int age;
	private float score;

	public Student() {
		super();
	}

	public Student(String id, String name, int age, float score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	public void writeFile(DataOutputStream dos) throws IOException {
		dos.writeUTF(id);
		dos.writeUTF(name);
		dos.writeInt(age);
		dos.writeFloat(score);
	}

	public void readFile(DataInputStream dis) throws IOException {
		this.setId(dis.readUTF());
		this.setName(dis.readUTF());
		this.setAge(dis.readInt());
		this.setScore(dis.readFloat());
	}

}
