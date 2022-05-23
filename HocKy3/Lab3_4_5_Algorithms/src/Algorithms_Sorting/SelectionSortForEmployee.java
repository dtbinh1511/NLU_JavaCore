package Algorithms_Sorting;

import java.util.Arrays;

import Algorithms_Searching.Employee;

public class SelectionSortForEmployee {
	public static void swap(Employee[] array, int i, int j) {
		Employee temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// sort by ascending order
	public static Employee[] selectionSortIteration(Employee[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[min]) < 0)
					min = j;
			}
			swap(array, i, min);
		}
		return array;
	}

	// sort by ascending order
	public static Employee[] selectionSortRecursion(Employee[] array, int stepNum) {
		if (stepNum > array.length - 1) {
			return array;
		} else {
			for (int j = stepNum; j < array.length; j++) {
				int min = stepNum;
				if (array[j].compareTo(array[min]) > 0) {
					min = j;
				}
				swap(array, j, min);
			}
			return selectionSortRecursion(array, stepNum + 1);
		}
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("01", "A", "B", 1999, 9);
		Employee e2 = new Employee("02", "C", "D", 1999, 8);
		Employee e3 = new Employee("01", "A", "E", 1999, 9);
		Employee e4 = new Employee("02", "C", "F", 1999, 8);
		Employee[] array = { e1, e2, e3, e4 };

		System.out.println(Arrays.toString(selectionSortIteration(array)));
//		System.out.println(Arrays.toString(selectionSortRecursion(array, 0)));
	}
}
