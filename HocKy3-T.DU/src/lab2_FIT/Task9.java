package lab2_FIT;

public class Task9 {
	public static int max(int[] arr, int size) {
		if (size == 1)
			return arr[0];
		else {
			if (arr[size - 1] > max(arr, size - 1))
				return arr[size - 1];
			else
				return max(arr, size - 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 4, 8, 5, 2, 1 };
		System.out.println(max(arr, arr.length));
	}
}
