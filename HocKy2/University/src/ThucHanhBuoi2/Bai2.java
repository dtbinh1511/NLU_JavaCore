package ThucHanhBuoi2;

import java.util.Scanner;
// xuất ra số ngto tiếp theo
public class Bai2 {
	public static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int[] firstsNumber(int anyNum, int numOut) {
		int[] array = new int[numOut];
		int count = 0;
		while (count < numOut) {
			anyNum++;
			if (isPrime(anyNum))
				array[count++] = anyNum;
		}
		return array;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter any number :");
		int anyNum = sc.nextInt();
		System.out.print("Enter numbers want output: ");
		int numOut = sc.nextInt();
		for (int i : firstsNumber(anyNum, numOut)) {
			System.out.print(i + " ");
		}
	}
}
