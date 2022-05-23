package Algorithms_Sorting;

import java.util.Arrays;

import Algorithms_Searching.Employee;

public class InsertionSortForEmployee {
	public static Employee[] insertionSortIterative(Employee[] array) {
		for (int i = 1; i < array.length; i++) {
			Employee key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j].compareTo(key) > 0) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
		return array;
	}

	public static void insertionSortRecursive(Employee[] array, int n) {
		if (n <= 1) {
			return;
		}
		insertionSortRecursive(array, n - 1);
		Employee last = array[n - 1];
		int j = n - 2;

		while (j >= 0 && array[j].compareTo(last) > 0) {
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = last;
	}

	public static void insertionSortRecursive(Employee[] array) {
		insertionSortRecursive(array, array.length);

		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("01", "A", "B", 1999, 9);
		Employee e2 = new Employee("02", "C", "D", 1999, 8);
		Employee e3 = new Employee("01", "A", "E", 1999, 9);
		Employee e4 = new Employee("02", "C", "F", 1999, 8);
		Employee[] array = { e1, e2, e3, e4 };

//		System.out.println(Arrays.toString(insertionSortIterative(array)));

		insertionSortRecursive(array);
	}
}
