package lab2_T.Du;

import java.util.Arrays;

public class Task2_2 {
	public static void drawPyramid(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n; j > i; j--) {
				System.out.print(" ");
			}
			System.out.println(toString(getRow(i)));
		}
	}

	public static String toString(int[] arr) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			s.append(arr[i] + " ");
		}
		return String.valueOf(s);
	}

	public static int[] getRow(int n) {
		int[] row = new int[n];
		Arrays.fill(row, n);
		return row;
	}

	public static void main(String[] args) {
		drawPyramid(9);
	}
}
