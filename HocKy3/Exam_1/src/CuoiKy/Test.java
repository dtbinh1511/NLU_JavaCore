package CuoiKy;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 5, 3, 7, 9 } };
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void m(int number, int[] numbers) {
		number = 1001;
		numbers[0] = 5555;
	}
}
