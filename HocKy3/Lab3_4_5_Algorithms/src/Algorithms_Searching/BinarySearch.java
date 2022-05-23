package Algorithms_Searching;

import java.util.Arrays;

public class BinarySearch {
	public static int iterativeBinarySearch(int[] array, int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == target)
				return mid;
			if (array[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public static int recursiveBinarySearch(int[] array, int target) {
		return supportRecursive(array, target, 0, array.length);
	}

	public static int supportRecursive(int[] array, int target, int low, int high) {
		int mid = (low + high) / 2;
		if (low <= high) {
			if (array[mid] == target)
				return mid;
			if (array[mid] > target)
				return supportRecursive(array, target, low, mid - 1);
			else
				return supportRecursive(array, target, mid + 1, high);
		}
		return -1;
	}

	public static int iterativeBinarySearchForEmployee(Employee[] array, Employee target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid].equals(target))
				return mid;
			if (array[mid].compareTo(target) > 0)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
	}

	public static int recursiveBinarySearchForEmployee(Employee[] array, Employee target) {
		return supportRecursive(array, target, 0, array.length);
	}

	public static int supportRecursive(Employee[] array, Employee target, int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid].equals(target))
				return mid;
			if (array[mid].compareTo(target) > 0)
				return supportRecursive(array, target, low, mid - 1);
			else
				return supportRecursive(array, target, mid + 1, high);
		}
		return -1;
	}

	public static void main(String[] args) {
//		int[] array = { 12, 10, 9, 45, 2 };
//		Arrays.sort(array);
//		System.out.println(iterativeBinarySearch(array, 2));
//		System.out.println(recursiveBinarySearch(array, 2));

		Employee e1 = new Employee("01", "A", "B", 1999, 9);
		Employee e2 = new Employee("02", "C", "D", 1999, 8);
		Employee[] employees = { e2, e1 };
		Arrays.sort(employees);
		Employee e4 = new Employee("01", "C", "B", 1999, 9);
		Employee e3 = new Employee("01", "A", "B", 1999, 9);

		System.out.println(iterativeBinarySearchForEmployee(employees, e3));
		System.out.println(recursiveBinarySearchForEmployee(employees, e3));

	}
}
