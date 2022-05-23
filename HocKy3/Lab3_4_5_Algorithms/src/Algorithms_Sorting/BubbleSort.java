package Algorithms_Sorting;

import java.util.Arrays;

public class BubbleSort {
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static int[] iterativeBubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1])
					swap(array, j, j + 1);
			}
		}
		return array;
	}

	public static int[] recursiveBubbleSort(int[] array, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (array[i] > array[i + 1])
				swap(array, i, i + 1);
		}
		if (n - 1 > 1)
			return recursiveBubbleSort(array, n - 1);
		return array;

	}

	public static void main(String[] args) {
		int[] array = { 9, 4, 1, 3, 5 };
//		System.out.println(Arrays.toString(iterativeBubbleSort(array)));
		System.out.println(Arrays.toString(recursiveBubbleSort(array, array.length)));

	}
}
