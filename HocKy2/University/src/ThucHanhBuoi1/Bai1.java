package ThucHanhBuoi1;

import java.util.Scanner;

public class Bai1 {

	public static boolean isPrime(int n) {

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkEvenNumber(int n) {
		return n % 2 == 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = sc.nextInt();

		if (checkEvenNumber(n)) {
			System.out.println(n + " là số chẵn.");
		}
		System.out.println(n + " là số lẻ.");

		System.out.println(n + " is prime? " + isPrime(n));
		sc.close();

	}
}
