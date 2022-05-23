package AddEx;

public class MangDanDau {
	public static void main(String[] args) {

		int[] arr1 = { 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 15, 15 };
		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		for (int i : danDau(arr1, arr2)) {
			System.out.print(i + " ");

		}
	}

	public static int[] danDau(int[] arr1, int[] arr2) {
		int[] check = new int[arr2.length];
		for (int i = 0; i < check.length; i++) {
			check[i] = 1;
		}
		int index = 0;
		int[] array = new int[arr2.length - arr1.length + 1];
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				if (arr2[i] == arr1[j]) {
					check[i] = 0;
				}
			}
			if (check[i] != 0) {
				array[index++] = arr2[i];

			}

		}
		return array;
	}
}
