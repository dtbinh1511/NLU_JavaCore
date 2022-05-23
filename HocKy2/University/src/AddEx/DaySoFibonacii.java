package AddEx;

import java.util.Scanner;

public class DaySoFibonacii {
	public static boolean checkNumber(int number) {
		if (number > 90) {
			return false;
		}
		return true;
	}

	public static void fibonacii(int number) {
		long num1 = 0, num2 = 1, total;
		for (int i = 0; i < number; i++) {
			if (i < 2) {
				System.out.println(i);
			} else {
				total = num1 + num2;
				num1 = num2;
				num2 = total;
				System.out.println(total);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number");
		int number = sc.nextInt();
		while (true) {
			if (checkNumber(number) == false) {
				System.out.println("Enter again number");
				number = sc.nextInt();
				continue;
			}
			fibonacii(number);
			break;
		}
	}

}
