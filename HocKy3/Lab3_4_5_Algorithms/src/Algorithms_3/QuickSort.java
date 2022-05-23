package Algorithms_3;

import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
	}

	public static void quickSort(int[] array, int low, int high) {
		if (low >= high)
			return;
		int left = low;
		int right = high - 1;
		int pivot = array[high];
		while (left <= right) {
			while (left <= right && array[left] < pivot)
				left++;
			while (left <= right && array[right] > pivot)
				right--;
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;
			}
		}
		swap(array, left, high);
		quickSort(array, low, left - 1);
		quickSort(array, left + 1, high);
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void main(String[] args) {
//		int[] array = { 15, 17, 10, 15, 1, 62, 58, 38, 42, 20, 25 };
		int[] array = { 3, 15, 42, 20, 25, 15 };

		quickSort(array);
		System.out.println(Arrays.toString(array));
	}
}
