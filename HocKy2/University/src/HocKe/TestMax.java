package HocKe;

public class TestMax {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 6, 2, 6, 4 };
		System.out.println("Max value = " + maxValues(array));
		coutMaxValues(array);
	}

	public static int maxValues(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		return max;
	}

	public static void coutMaxValues(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == maxValues(array)) {
				count++;
			}
		}
		System.out.println("Number time of max value: " + count);
	}
}
