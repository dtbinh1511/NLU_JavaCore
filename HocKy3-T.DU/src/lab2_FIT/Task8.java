package lab2_FIT;

public class Task8 {
	public static int sumElement(int[] arr, int size) {
		if (size == 1)
			return arr[0];
		else
			return arr[size - 1] + sumElement(arr, size - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 6 };
		System.out.println(sumElement(arr, arr.length));
	}
}
