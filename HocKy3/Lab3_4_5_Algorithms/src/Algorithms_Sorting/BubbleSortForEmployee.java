package Algorithms_Sorting;

import java.util.Arrays;

import Algorithms_Searching.Employee;

public class BubbleSortForEmployee {
	public static void swap(Employee[] array, int i, int j) {
		Employee temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static Employee[] bubbleSortIteration(Employee[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j].compareTo(array[j + 1]) > 0)
					swap(array, j, j + 1);
			}
		}
		return array;
	}

	public static Employee[] bubbleSortRecursive(Employee[] array, int n) {
		for (int i = 0; i < n - 1; i++) {
			if (array[i].compareTo(array[i + 1]) > 0)
				swap(array, i, i + 1);
		}
		if (n - 1 > 1)
			return bubbleSortRecursive(array, n - 1);
		return array;
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("01", "A", "B", 1999, 9);
		Employee e2 = new Employee("02", "C", "D", 1999, 8);
		Employee e3 = new Employee("01", "A", "E", 1999, 9);
		Employee e4 = new Employee("02", "C", "F", 1999, 8);
		Employee[] array = { e1, e2, e3, e4 };

//		System.out.println(Arrays.toString(bubbleSortIteration(array)));
		System.out.println(Arrays.toString(bubbleSortRecursive(array, array.length)));

	}
}