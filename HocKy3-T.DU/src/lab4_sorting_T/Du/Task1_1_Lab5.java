package lab4_sorting_T.Du;

import java.util.Arrays;

public class Task1_1_Lab5 {

	// sort by ascending order
	public static int[] mergeSort(int[] array) {
		if (array.length <= 1)
			return array;
		else {
			int mid = (array.length + 1) / 2;

			int[] leftArray = new int[mid];
			System.arraycopy(array, 0, leftArray, 0, mid);
			leftArray = mergeSort(leftArray);

			int[] rightArray = new int[array.length - mid];
			System.arraycopy(array, mid, rightArray, 0, rightArray.length);
			rightArray = mergeSort(rightArray);

			int[] resultArray = new int[leftArray.length + rightArray.length];
			return merge(leftArray, rightArray, resultArray);

		}
	}

	public static int[] merge(int[] arr1, int[] arr2, int[] arr) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		int current3 = 0; // Current index in temp

		while (current1 < arr1.length && current2 < arr2.length) {

			if (arr1[current1] < arr2[current2]) {
				arr[current3] = arr1[current1];
				current1++;
			} else {
				arr[current3] = arr2[current2];
				current2++;
			}
			current3++;

		}

		while (current1 < arr1.length) {
			arr[current3] = arr1[current1];
			current1++;
			current3++;
		}

		while (current2 < arr2.length) {
			arr[current3] = arr2[current2];
			current2++;
			current3++;
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 2, 5, 6, 1, -2, 3, 14, 12 };

		arr = mergeSort(arr);

		System.out.println(Arrays.toString(arr));

	}
}
