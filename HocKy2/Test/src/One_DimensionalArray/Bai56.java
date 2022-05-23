package One_DimensionalArray;

import java.util.Scanner;

public class Bai56 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number element of array: ");
		int n = sc.nextInt();
		System.out.print("Enter element of array: ");
		int[] array = enter(n, sc);

		// output array
		show(array);
		System.out.println();

		// sap xep tang dan
		sortUpAscending(array);
		System.out.println();

		// sapxep giam dan
		sortDescending(array);
	}

	public static int[] enter(int n, Scanner sc) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		return array;
	}

	public static void show(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
	}

	public static void sortUpAscending(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			System.out.print(array[i] + " ");
		}
	}

	public static void sortDescending(int[] array) {
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			System.out.print(array[i] + " ");
		}
	}
}