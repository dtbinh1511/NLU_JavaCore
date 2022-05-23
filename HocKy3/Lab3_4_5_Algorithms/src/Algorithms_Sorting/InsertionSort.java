package Algorithms_Sorting;

import java.util.Arrays;

public class InsertionSort {
	public static int[] insertionSortIterative(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
		return array;
	}

	public static void insertionSortRecursive(int[] array, int n) {
		if (n > 1) {
			insertionSortRecursive(array, n - 1);
		}
		int last = array[n - 1];
		int j = n - 2;
		while (j >= 0 && array[j] > last) {
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = last;
	}

	public static void insertionSortRecursive(int[] array) {
		insertionSortRecursive(array, array.length);

		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		int[] array = { 9, 4, 1, 3, 5 };
//		System.out.println(Arrays.toString(insertionSortIterative(array)));

		insertionSortRecursive(array);

	}
}
