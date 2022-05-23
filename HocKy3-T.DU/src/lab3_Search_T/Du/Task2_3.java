package lab3_Search_T.Du;

import java.util.Arrays;
import java.util.Comparator;

public class Task2_3 {
	/*
	 * To find the index of the target in the sorted array. If the target is not
	 * found in the array, then the method returns -1.
	 */
	public static int iterativeBinarySearchForEmployee(Employee[] array, Employee target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid].equals(target))
				return mid;
			else if (array[mid].compareTo(target) < 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	/*
	 * To find the index of the target in the sorted array. If the target is not
	 * found in the array, then the method returns -1.
	 */
	public static int recursiveBinarySearchForEmployee(Employee[] array, Employee target) {
		return supportBinarySearchForEmployee(array, target, 0, array.length - 1);
	}

	public static int supportBinarySearchForEmployee(Employee[] array, Employee target, int low, int high) {
		if (low > high)
			return -1;
		else {
			int mid = (low + high) / 2;
			if (array[mid].equals(target))
				return mid;
			else if (target.compareTo(array[mid]) > 0)
				return supportBinarySearchForEmployee(array, target, mid + 1, high);
			else
				return supportBinarySearchForEmployee(array, target, low, mid - 1);
		}
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("01", "A", "B", 1999, 9);
		Employee e2 = new Employee("02", "C", "D", 1999, 8);
		Employee e3 = new Employee("01", "A", "E", 1999, 9);
		Employee e4 = new Employee("02", "C", "F", 1999, 8);
		Employee[] array = { e1, e2, e3, e4 };

		Employee e = new Employee("02", "C", "D", 1999, 8);

		Arrays.sort(array);
		System.out.println(Arrays.toString(array));

		System.out.println(iterativeBinarySearchForEmployee(array, e));
		System.out.println(recursiveBinarySearchForEmployee(array, e));
	}
}
