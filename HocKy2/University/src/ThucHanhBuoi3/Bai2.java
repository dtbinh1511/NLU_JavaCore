package ThucHanhBuoi3;

import java.util.Random;
import java.util.Scanner;

public class Bai2 {

	public static void numberTime(int anyNumber, int ranNumber) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (true) {
			if (anyNumber < ranNumber) {
				System.out.println("Enter a higher number");
				count++;
			} else if (anyNumber > ranNumber) {
				System.out.println("Enter a lower number");
				count++;
			} else {
				System.out.println("Congratulations, you're so lucky");
				break;
			}
			anyNumber = sc.nextInt();
		}
		System.out.println("Number times enter: " + count);
		System.out.println("Point: " + (100 - count));

	}

	public static void main(String[] args) {
		int ranNumber = new Random().nextInt(100);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any number");
		int anyNumber = sc.nextInt();
		numberTime(anyNumber, ranNumber);
		sc.close();
	}

}
