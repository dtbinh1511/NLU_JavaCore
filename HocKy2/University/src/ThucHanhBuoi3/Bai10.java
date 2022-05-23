package ThucHanhBuoi3;

import java.util.Random;

public class Bai10 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		show(subArray(arr, 4));
		System.out.println("\nArray not duplicate");
		show(subArrays(arr, 4));
	}
// mang ngau nhien
	public static int[] subArray(int[] arr, int qty) {
		int[] array = new int[qty];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			int x = random.nextInt(arr.length);
			array[i] = arr[x];
		}
		return array;
	}
// array ko trung
	public static int[] subArrays(int[] arr, int qty) {
		int[] check = new int[arr.length];
		for (int i = 0; i < check.length; i++) {
			check[i] = 1;
		}
		int[] brr = new int[qty];
		int count = 0;
		while (true) {
			int random = (int) (Math.random() * (arr.length));
			if (check[random] != 0) {
				brr[count++] = arr[random];
				check[random] = 0;
			}
			if (count == brr.length)
				break;
		}
		return brr;
	}

	public static void show(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
