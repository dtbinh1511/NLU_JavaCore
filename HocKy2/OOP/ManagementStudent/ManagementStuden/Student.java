package ManagementStuden;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	private String nameStu;
	private String idStu;
	private Date date = new Date();
	private ManagamentSub manSub = new ManagamentSub();
	Scanner input = new Scanner(System.in);

	public Student() {

	}

	public String getNameStu() {
		return nameStu;
	}

	public void setNameStu(String nameStu) {
		this.nameStu = nameStu;
	}

	public String getIdStu() {
		return idStu;
	}

	public void setIdStu(String idStu) {
		this.idStu = idStu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void addStudent() {
		System.out.println("Nhập tên sinh viên");
		setNameStu(input.nextLine());
		System.out.println("Nhập mã số sinh viên");
		setIdStu(input.nextLine());
		date.setBirth();
		manSub.addSub();
	}

	public void addSubInStu() {
		manSub.addSub();
	}

	@Override
	public String toString() {
		return "nameStudent: " + nameStu + ", idStu: " + idStu + ", date: " + date.toString() + ", listSub: "
				+ manSub.toString();
	}

	public void output() {
		System.out.println(this.toString());
	}

	public double avgMark() {
		return manSub.avgMark();
	}
	public void chMark() {
		manSub.chMark();
	}
	public void showClassification() {
		manSub.showClassification();
	}
}
