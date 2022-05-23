package lab3_Search_T.Du;

public class Task1_1 {
	/*
	 * To find the index of the target in the array. If the target is not found in
	 * the array, then the method returns-1.
	 */

	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public static int iterativeLinearSearch(int[] array, int target) {
		for (int i = 0; i < array.length; i++) {
			if (target == array[i])
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
		return supportLineSearch(array, array.length, target);
	}

	public static int supportLineSearch(int[] array, int size, int target) {
		if (size == 1) {
			if (array[0] == target)
				return 0;
			else
				return -1;
		} else {
			if (array[size - 1] == target)
				return size - 1;
			else
				return supportLineSearch(array, size - 1, target);
		}
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		System.out.println(iterativeLinearSearch(array, 45));
		System.out.println(recursiveLinearSearch(array, 15));
	}
}
