package Recursive;

import java.util.Arrays;

public class ReverseArray {
	public static int[] reverse(int[] data, int low, int high) {
		if (low < high) {
			int temp = data[low];
			data[low] = data[high];
			data[high] = temp;
			reverse(data, low + 1, high - 1);
		}
		return data;

	}

	public static int[] reverse(int[] data) {
		return reverse(data, 0, data.length - 1);
	}

	public static void main(String[] args) {
		int[] data = { 2, 4, 6, 8 };
		System.out.println(Arrays.toString(reverse(data)));
	}
}
