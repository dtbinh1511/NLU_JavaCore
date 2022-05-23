package ManagementStuden;

import java.util.Scanner;

public class Date {
	public int day, month, year;

	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Date() {

	}

	@Override
	public String toString() {
		return day + "/" + month + "/" + year;
	}

	public void output() {
		System.out.println(this.toString());
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day >= 1 && day <= 31) {
			this.day = day;
		} else {
			System.err.println("Nhập lại");
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month >= 1 && month <= 12) {
			this.month = month;
		} else {
			System.err.println("Nhập lại");
		}

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		} else {
			System.err.println("Nhập lại");
		}
	}

	public void setBirth() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập ngày");
		setDay(sc.nextInt());
		System.out.println("Nhập tháng");
		setMonth(sc.nextInt());
		System.out.println("Nhập năm");
		setYear(sc.nextInt());
	}

}
