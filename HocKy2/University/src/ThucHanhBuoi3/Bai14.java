package ThucHanhBuoi3;

import java.util.Scanner;

public class Bai14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int number = sc.nextInt();
		System.out.println("Enter a double number");
		double numDou = sc.nextDouble();
		System.out.println("Cong: " + plus(number, numDou));
		System.out.println("Cong dan dau: " + minus(number, numDou));
		System.out.println("maclaurin: " + maclaurin(number, numDou));
	}

	public static double plus(int number, double numDou) {
		double sum = 0;
		for (int i = 0; i <= number; i++) {
			sum += Math.pow(numDou, i);
		}
		return sum;
	}

	public static double minus(int number, double numDou) {
		double sum = 0;
		for (int i = 0; i <= number; i++) {
			sum += Math.pow((-numDou), i);
		}
		return sum;
	}

	public static double maclaurin(int number, double numDou) {
		int giaiThua = 1;
		double sum = 0;
		for (int i = 0; i <= number; i++) {
			if (i == 0) {
				giaiThua = 1;
			} else {
				giaiThua *= i;
			}
			sum += Math.pow(numDou, i) / giaiThua;
		}
		return sum;
	}
}
