package ThucHanhBuoi4;

import java.util.Scanner;

public class Bai18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = sc.nextInt();
		countsAndAvg(number);
		sc.close();
	}

	public static void countsAndAvg(int number) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int sum = 0;
		do {
			count++;
			sum += number;
			System.out.print("Enter continue: ");
			number = sc.nextInt();
		} while (number != 0);
		double average = (double)sum / count;
		System.out.println("Numbers enter times: " + count);
		System.out.println("Numbers average enter: " + average);
		sc.close();
	}

	

}
