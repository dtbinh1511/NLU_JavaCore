package One_Dimensional_Arrays;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// DISPLAY the elements of the array. Using loop to print the elements in
	// the array (without using Arrays.toString(...)
	public String toString() {
		StringBuilder print = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			print.append(array[i] + " ");
		}
		return print.toString();
	}

	// UPDATE the value at index i by newValue
	public void update(int i, int newValue) {
		for (int j = 0; j < array.length; j++) {
			if (j == i - 1)
				array[j] = newValue;
		}
		System.out.println(toString());
	}

	// CHECK whether there exist a value at index i in the array
	public boolean find(int i) {
		for (int j = 0; j < array.length; j++) {
			if (j == i - 1)
				return true;
		}
		return false;
	}

	// GET the element which its occurrence is the most in the array.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}
	// Output: 10
	public int getMode() {
		int first = array[0];
		for (int i = 1; i < array.length; i++) {
			if (counter(array, array[i]) > counter(array, first))
				first = array[i];
		}
		return first;
	}

	public int counter(int[] arr, int num) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num)
				count++;
		}
		return count;
	}

	// GET unique elements in the array.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}
	// Output: 12, 9, 2
	public int[] getUniqueElements() {
		int count = 0;
		int[] arrCp = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (counter(array, array[i]) == 1)
				arrCp[count++] = array[i];
		}
		return Arrays.copyOfRange(arrCp, 0, count);
	}

	// GET distinct elements in the array.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}
	// Output: 12, 10, 9, 45, 2
	public int[] getDistinctElements() {
		int[] arrCp = new int[array.length];
		int count = 0;
		int i = 0;
		int k = 0;
		while (i < array.length) {
			arrCp[count++] = array[i];
			if (counter(arrCp, arrCp[i]) == 1) {
				arrCp[k++] = array[i];
			}
			i++;
		}
		return Arrays.copyOfRange(arrCp, 0, k);
	}

	// Common items that belong to two different sets
	public static int[] getIntersectionElements(int[] array1, int[] array2) {
		int[] arrCp = new int[array1.length + array2.length];
		int count = 0;
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					arrCp[count++] = array1[i];
					break;
				}
			}
		}
		return Arrays.copyOfRange(arrCp, 0, count);
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int[] array1 = { 12, 10, 7, 2, 6 };

		MyArray myArray = new MyArray(array);
//		System.out.println(myArray.toString());
//		myArray.update(4, 10);

//		System.out.println(myArray.find(10));
		System.out.println(myArray.getMode());
//		for (int i : myArray.getUniqueElements()) {
//			System.out.print(i + " ");
//		}
//		for (int i : myArray.getDistinctElements()) {
//			System.out.print(i + " ");
//		}
		for (int i : myArray.getIntersectionElements(array, array1)) {
			System.out.print(i + " ");
		}
	}
}
