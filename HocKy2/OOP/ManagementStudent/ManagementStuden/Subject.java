package ManagementStuden;

import java.util.Scanner;

public class Subject {
	private String nameSub;
	private String idSub;
	private double grade;

	public Subject(String nameSub, String idSub, double grade) {
		super();
		this.nameSub = nameSub;
		this.idSub = idSub;
		this.grade = grade;
	}

	public Subject() {

	}

	public String getNameSub() {
		return nameSub;
	}

	public void setNameSub(String nameSub) {
		this.nameSub = nameSub;
	}

	public String getIdSub() {
		return idSub;
	}

	public void setIdSub(String idSub) {
		this.idSub = idSub;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		if (grade >= 0 && grade <= 10) {
			this.grade = grade;
		} else {
			System.err.println("Nhập lại");
		}
	}

	public void subList() {
		Scanner input = new Scanner(System.in);
			System.out.println("Nhập tên môn học");
			setNameSub(input.next());
			System.out.println("Nhập mã số môn học");
			setIdSub(input.next());
			System.out.println("Nhập điểm môn " + getNameSub());
			setGrade(input.nextDouble());
		
	}

	@Override
	public String toString() {
		return "nameSub: "+ getNameSub() + ", idSub: " + getIdSub() + ", grade: " + getGrade() +"\n";
	}

	
}
