package Algorithms_3;

import java.util.Arrays;

public class MergeSort {
	public static int[] mergeSort(int[] array) {
		if (array.length <= 1) {
			return array;
		}
		int[] left = Arrays.copyOfRange(array, 0, (array.length + 1) / 2);
		left = mergeSort(left);

		int[] righ = Arrays.copyOfRange(array, (array.length + 1) / 2, array.length);
		righ = mergeSort(righ);

		return merge(left, righ);
	}

	public static int[] merge(int[] arr1, int[] arr2) {
		int[] arr = new int[arr1.length + arr2.length];
		int i = 0;
		int j = 0;
		while (i + j < arr.length) {
			if (j == arr2.length || i < arr1.length && arr1[i] < arr2[j])
				arr[i + j] = arr1[i++];
			else
				arr[i + j] = arr2[j++];
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] array = { 15, 17, 10, 15, 1, 62, 58, 38, 42, 20, 25 };
		System.out.println(Arrays.toString(mergeSort(array)));
	}
}
