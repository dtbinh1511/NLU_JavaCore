package ThucHanhBuoi3;

public class Bai9Arrange {
	public static void main(String[] args) {
		int[] array = { 9, 5, 1, 4, 2, 7, 3 };
		show(sortUpAscending(array));
		System.out.println();
		show(sortDescending(array));
	}

	public static int[] sortUpAscending(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}

		}
		return array;
	}

	public static int[] sortDescending(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] < array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;

	}

	public static void show(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
