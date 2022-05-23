package Algorithms_Searching;

public class LinearSearch {
	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public static int iterativeLinearSearch(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == target)
				return i;
		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found in the
	// array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public static int recursiveLinearSearch(int[] array, int target) {
		return supportRecursive(array, target, 0);
	}

	public static int supportRecursive(int[] array, int target, int from) {
		if (from < array.length) {
			if (array[from] == target)
				return from;
			return supportRecursive(array, target, from + 1);
		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found in the
	// array, then the method returns -1.
	public static int iterativeLinearSearchForEmployee(Employee[] array, Employee target) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(target))
				return i;
		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found in the
	// array, then the method returns -1.
	public static int recursiveLinearSearchForEmployee(Employee[] array, Employee target) {
		return supportRecursive(array, target, 0);
	}

	public static int supportRecursive(Employee[] array, Employee target, int from) {
		if (from < array.length) {
			if (array[from].equals(target))
				return from;
			return supportRecursive(array, target, from + 1);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		System.out.println(iterativeLinearSearch(array, 45));
		System.out.println(recursiveLinearSearch(array, 15));

		Employee e1 = new Employee("01", "A", "B", 1999, 9);
		Employee e2 = new Employee("02", "C", "D", 1999, 8);
		Employee[] employees = { e2, e1 };

		Employee e4 = new Employee("01", "C", "B", 1999, 9);
		Employee e3 = new Employee("01", "A", "B", 1999, 9);

		System.out.println(iterativeLinearSearchForEmployee(employees, e3));
		System.out.println(recursiveLinearSearchForEmployee(employees, e4));
	}
}
