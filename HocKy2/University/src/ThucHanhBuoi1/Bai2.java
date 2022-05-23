package ThucHanhBuoi1;

import java.util.Scanner;

public class Bai2 {
	public static boolean checkEvenNumber(int n) {
		return n % 2 == 0;
	}

	public static int totalNumberOfDigits(int n) {
		int count = 0;
		while (n > 0) {
			n /= 10;
			count++;
		}
		return count;
	}

	public static int totalEvenDigits(int n) {
		int count = 0;
//		int s = 0;
		while (n > 0) {
//			s = n % 10;
			if (checkEvenNumber(n))
				count++;
			n /= 10;

		}

		return count;
	}

	public static int totalOddDigits(int n) {
		int count = 0;
//		int s = 0;
		while (n > 0) {
//			s = n % 10;
			if (!checkEvenNumber(n))
				count++;
			n /= 10;

		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = sc.nextInt();

		System.out.println("total number of digits: " + totalNumberOfDigits(n));
		System.out.println("Total even digits: " + totalEvenDigits(n));
		System.out.println("Total odd digits: " + totalOddDigits(n));
		sc.close();
	}

}
