package lab1_T.Du;

import java.util.Arrays;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// to string
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			s.append(array[i] + "\t");
		}
		return String.valueOf(s);
	}

	// update the value at index
	public void upDate(int i, int newValue) {
		if (find(i))
			array[i] = newValue;
	}

	// CHECK whether there exist a value at index i in the array
	public boolean find(int i) {
		return array[i] != 0;
	}

	// GET the element which its occurence is the most in the array.
	public int getMode() {
		int mode = array[0];
		for (int i = 1; i < array.length; i++) {
			if (countElement(array[i]) > countElement(mode))
				mode = array[i];
		}
		return mode;
	}

	// dem so lan xuat hien cua 1 gia tri trong mang
	public int countElement(int value) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == value)
				count++;
		}
		return count;
	}

	// GET unique elements in the array.
	public int[] getUniqueElements() {
		int index = 0;
		int[] arrCp = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (countElement(array[i]) == 1) {
				arrCp[index] = array[i];
				index++;
			}
		}
		int[] arrReturn = new int[index];
		System.arraycopy(arrCp, 0, arrReturn, 0, index);
		return arrReturn;
	}

	// GET distinct elements in the array.
	public int[] getDistinctElements() {
		int index = 0;
		boolean checkSame = false;
		int[] arrCp = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					checkSame = true;
					break;
				}
			}
			if (!checkSame) {
				arrCp[index] = array[i];
				index++;
			}
			checkSame = false;
		}
		int[] arrReturn = new int[index];
		System.arraycopy(arrCp, 0, arrReturn, 0, index);
		return arrReturn;
	}

	// Common items that belong to two different sets
	public static int[] getIntersectionElements(int[] array1, int[] array2) {
		int index = 0;
		int[] arrCp = new int[array1.length];
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					arrCp[index] = array1[i];
					index++;
					break;
				}
			}
		}
		int[] arrReturn = new int[index];
		System.arraycopy(arrCp, 0, arrReturn, 0, index);
		return arrReturn;
	}

	public static void main(String[] args) {
		int[] arr = { 12, 10, 9, 45, 2, 10, 10, 45 };
		int[] arr1 = { 2, 3, 4, 10, 7 };
		MyArray myArray = new MyArray(arr);
//		System.out.println(Arrays.toString(myArray.getUniqueElements()));
//		System.out.println(Arrays.toString(myArray.getDistinctElements()));
//		System.out.println(myArray.getMode());
		System.out.println(Arrays.toString(getIntersectionElements(arr, arr1)));
	}
}
