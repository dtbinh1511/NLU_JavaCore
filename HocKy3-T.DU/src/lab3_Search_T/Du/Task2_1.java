package lab3_Search_T.Du;

public class Task2_1 {
	/*
	 * To find the index of the target in the sorted array. If the target is not
	 * found in the array, then the method returns-1.
	 */

	public static int iterativeBinarySearch(int[] array, int target) {
		int low = 0;
		int high = array.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == target)
				return mid;
			else {
				if (target > array[mid])
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		return -1;
	}

	/*
	 * To find the index of the target in the sorted array. If the target is not
	 * found in the array, then the method returns-1.
	 */

	public static int recursiveBinarySearch(int[] array, int target) {
		return supportBinarySearch(array, target, 0, array.length - 1);
	}

	public static int supportBinarySearch(int[] array, int target, int low, int high) {
		if (low > high)
			return -1;
		else {
			int mid = (low + high) / 2;
			if (array[mid] == target)
				return mid;
			else if (target < array[mid])
				return supportBinarySearch(array, target, low, mid - 1);
			else
				return supportBinarySearch(array, target, mid + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(iterativeBinarySearch(array, 3));
		System.out.println(recursiveBinarySearch(array, 3));
	}
}
