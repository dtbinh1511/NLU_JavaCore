package lab2_T.Du;

import java.util.Arrays;

public class Task2_3 {
	public static void drawChristmasTree(int n) {
		for (int i = 1; i <= n; i++) {
			drawPyramid(i, n);
		}
	}

	public static void drawPyramid(int n, int h) {
		for (int i = 1; i <= n; i++) {
			for (int k = 1; k <= h - n; k++) {
				System.out.print(" ");
			}
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			System.out.println(toString(getRow(i)));
		}
	}

	public static String toString(char[] arr) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			s.append(arr[i]);
		}
		return String.valueOf(s);
	}

	public static char[] getRow(int n) {
		char[] row;
		if (n == 1) {
			row = new char[1];
			Arrays.fill(row, 'X');
			return row;
		} else
			return getNextRow(getRow(n - 1));
	}

	public static char[] getNextRow(char[] prevRow) {
		char[] nextRow = new char[prevRow.length + 2];
		Arrays.fill(nextRow, 'X');
		return nextRow;
	}

	public static void main(String[] args) {
		drawChristmasTree(8);
	}
}
