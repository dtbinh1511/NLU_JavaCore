package Algorithms_Sorting;

import java.util.Arrays;


public class SelectionSort {
	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static int[] iterativeSelectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min])
					min = j;
			}
			swap(array, min, i);
		}
		return array;
	}

	public static int[] recursiveSelectionSort(int[] array, int stepNum) {
		if (stepNum > array.length - 1)
			return array;
		else
			for (int i = stepNum; i < array.length; i++) {
				int min = stepNum;
				if (array[min] < array[i]) {
					min = i;
				}
				swap(array, i, min);
			}
		return recursiveSelectionSort(array, stepNum + 1);
	}

	public static void main(String[] args) {
		int[] array = { 9, 4, 1, 3, 5 };
//		System.out.println(Arrays.toString(iterativeSelectionSort(array)));
		System.out.println(Arrays.toString(recursiveSelectionSort(array, 0)));

	}
}
