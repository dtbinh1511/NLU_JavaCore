package AddEx;

import java.util.Random;

public class ArrayInArray {
	public static int[] subArray(int[] arr, int qty) {
		int[] array = new int[qty];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			int index = random.nextInt(arr.length);
			array[i] = arr[index];
		}
		return array;
	}
// random nhưng ko lặp
	public static int[] subArray2(int[] arr, int qty) {
		int[] check = new int[arr.length];
		for (int i = 0; i < check.length; i++) {
			check[i] = 1;
		}
		int[] array = new int[qty];
		int index = 0;
		while (true) {
			int random = (int) (Math.random() * (arr.length));
			if (check[random] != 0) {
				array[index++] = arr[random];
				check[random] = 0;
			}
			if (index == array.length)
				break;
		}
		return array;
	}

	public static void show(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		show(subArray(arr, 4));
		System.out.println("======================");
		show(subArray2(arr, 5));
	}
}
