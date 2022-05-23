package lab4_sorting_T.Du;

import java.util.Arrays;
import java.util.Comparator;

import lab3_Search_T.Du.Employee;

public class Task1_1 {

	// sort by ascending order
	public static Employee[] selectionSortIteration(Employee[] array, Comparator<Employee> c) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				// Find the index of the minimum value
				// SWAP
				if (c.compare(array[j], array[i]) < 0) {
					Employee t = array[j];
					array[j] = array[i];
					array[i] = t;
				}
			}
		}
		return array;
	}

	// sort by ascending order
	public static Employee[] selectionSortRecursion(Employee[] array, int stepNum) {
		if (stepNum > array.length - 1) {
			return array;
		} else {
			for (int j = stepNum; j < array.length; j++) {
				// Find the index of the minimum value
				// SWAP
				if (array[j].compareTo(array[stepNum - 1]) < 0) {
					Employee t = array[j];
					array[j] = array[stepNum - 1];
					array[stepNum - 1] = t;
				}
			}
		}
		return selectionSortRecursion(array, stepNum + 1);
		
	}

	// sort by ascending order
	public static Employee[] bubbleSortIteration(Employee[] array) {
		// (array.length - 1) iterarion
		for (int k = 0; k < array.length - 1; k++) {
			// last k items are already sorted, so inner loop can
			// avoid looking at the last k items
			for (int i = 0; i < array.length - 1 - k; i++) {
				// HOW TO COMPARE 2 EMPLOYEES???
				if (array[i].compareTo(array[i + 1]) > 0) {
					// SWAP
					Employee t = array[i];
					array[i] = array[i + 1];
					array[i + 1] = t;
				}
			}
			// the algorithm can be stopped if the inner loop
			// didn’t do any swap
		}
		return array;
	}

	// sort by ascending order
	public static Employee[] bubbleSortRecursion(Employee[] arr, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (arr[i].compareTo(arr[i + 1]) > 0) {
				// SWAP
				Employee t = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = t;
			}
		}
		if (n - 1 > 1) {
			bubbleSortRecursion(arr, n - 1);
		}
		return arr;
	}

	// insert sort
	// sort by ascending order
	public static Employee[] insertionSortIteration(Employee array[]) {
		for (int i = 1; i < array.length; ++i) {
			Employee key = array[i];
			int j = i - 1;
			// Move elements of array[0..i-1],
			// that are greater than key, to one position ahead of
			// their current position
			// HOW TO COMPARE 2 EMPLOYEES???
			while (j >= 0 && array[j].compareTo(key) > 0) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
		return array;
	}

	public static Employee[] insertSortRecursive(Employee[] array) {
		return insertionSortRecursive(array, array.length);
	}

	// sort by ascending order
	public static Employee[] insertionSortRecursive(Employee[] array, int n) {
		// Base case
		if (n <= 1)
			return array;
		// Sort first n-1 elements
		insertionSortRecursive(array, n - 1);
		// Insert last element at its correct position
		// in sorted array.
		Employee last = array[n - 1];
		int j = n - 2;
		// Move elements of array[0..i-1], that are greater
		// than key,
		// to one position ahead of their current position
		while (j >= 0 && array[j].compareTo(last) > 0) {
			array[j + 1] = array[j];
			j--;
		}
		array[j + 1] = last;
		return null;
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("01", "A", "B", 1999, 9);
		Employee e2 = new Employee("02", "C", "D", 1999, 8);
		Employee e3 = new Employee("01", "A", "E", 1999, 9);
		Employee e4 = new Employee("02", "C", "F", 1999, 8);
		Employee[] array = { e1, e2, e3, e4 };

		Comparator<Employee> comparator = new Comparator<Employee>() {
			
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.compareTo(o2);
			}
		};
		
		Employee[] arr = selectionSortIteration(array, comparator);
//		Employee[] arr = bubbleSortRecursion(array, array.length);
//		insertionSortIteration(array);
//		Employee[] arr = insertionSortIteration(array);

		System.out.println(Arrays.toString(array));
	}
}
