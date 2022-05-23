package lab3_Search_T.Du;

public class Task1_2 {
	/*
	 * To find the index of the target in the array. If the target is not found in
	 * the
	 */

	// array, then the method returns -1.
	public static int iterativeLinearSearchForEmployee(Employee[] array, Employee target) {
		for (int i = 0; i < array.length; i++) {
			if (target.equals(array[i]))
				return i;
		}
		return -1;
	}

	/*
	 * To find the index of the target in the array. If the target is not found in
	 * the
	 */

	// array, then the method returns -1.
	public static int recursiveLinearSearchForEmployee(Employee[] array, Employee target) {
		return supportLinearSearchForEmployee(array, array.length, target);
	}

	public static int supportLinearSearchForEmployee(Employee[] array, int size, Employee target) {
		if (size == 1) {
			if (array[0].equals(target))
				return 0;
			else
				return -1;
		} else {
			if (array[size - 1].equals(target))
				return size - 1;
			else
				return supportLinearSearchForEmployee(array, size - 1, target);
		}
	}

	public static void main(String[] args) {
		Employee e1 = new Employee("01", "A", "B", 1999, 9);
		Employee e2 = new Employee("02", "C", "D", 1999, 8);
		Employee[] array = { e1, e2 };

		Employee e = new Employee("01", "A", "B", 1999, 9);
		System.out.println(iterativeLinearSearchForEmployee(array, e));
		System.out.println(recursiveLinearSearchForEmployee(array, e));

	}
}
