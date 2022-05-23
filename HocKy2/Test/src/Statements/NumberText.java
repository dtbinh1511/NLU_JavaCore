package Statements;

import java.util.Scanner;

public class NumberText {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
//		int n = sc.nextInt();
		for (int i = 100; i < 200; i++) {
			readNumber(i);
		}

	}

	public static String readNumber(int a) {
		String[] n = { " ", " mươi ", " trăm ", " lẻ " };
		int b = a / 10;
		int c = a % 10;
		
		switch (numOfDigits(a)) {
		case 1:
			return tranlate(a);
		case 2:
			if ((a < 20) && (a % 10 == 0)) {
				return "mười";
			} else if ((a < 20) && (a % 10 == 5)) {
				return "mười lăm";
			} else if (a < 20) {
				return "mười " + tranlate(a % 10);
			} else if (c == 5) {
				return tranlate(a / 10) + n[1] + "lăm";
			} else if (c == 1 && a > 20) {
				return tranlate(a / 10) + n[1] + "mốt";
			} else {
				return tranlate(a / 10) + n[1] + tranlate(a % 10);
			}
		case 3:
			if (a % 100 == 0) {
				return tranlate(a / 100) + n[2];
			} else if ((c == 5) && (!(b % 10 == 0))) {
				return tranlate(a / 100) + n[2] + tranlate(b % 10) + n[1] + "lăm";
			} else if (b % 10 == 0) {
				return tranlate(a / 100) + n[2] + n[3] + tranlate(a % 100);
			} else if (c == 1) {
				return tranlate(a / 100) + n[2] + tranlate(b % 10) + n[1] + "mốt";
			} else {
				return tranlate(a / 100) + n[2] + tranlate(b % 10) + n[1] + tranlate(a % 10);
			}
		default:
			return "error";
		}
	}

	public static int numOfDigits(int number) {
		int count = 0;
		do {
			number /= 10;
			count++;
		} while (number > 0);
		return count;
	}

	public static String tranlate(int n) {
		switch (n) {
		case 0:
			return "";
		case 1:
			return " Một";
		case 2:
			return " Hai";
		case 3:
			return " Ba";
		case 4:
			return " Bốn";
		case 5:
			return " Năm";
		case 6:
			return " Sáu";
		case 7:
			return " Bảy";
		case 8:
			return " Tám";
		case 9:
			return " Chín";
		default:
			return " Nhập số không chính xác";
		}
	}
}
