package AddEx;

public class Plus {
	public static int[] arraysPlus(int[] arr1, int[] arr2) {
		int[] array = new int[arr1.length + arr2.length];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (i >= arr1.length)
				array[i] = arr2[k++];
			else {
				array[i] = arr1[i];
			}
		}

		return array;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 4, 5 };
		for (int i : arraysPlus(arr1, arr2)) {
			System.out.print(i + " ");
		}
	}
}
