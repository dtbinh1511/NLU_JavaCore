package lab2_T.Du;

import java.util.Arrays;

public class Task2_1 {
	public static void drawPyramid(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n; j > i; j--) {
				System.out.print("  ");
			}
			System.out.println(toString(getPyramid(i)));
		}
	}

	public static String toString(char[] arr) {
		StringBuilder s = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			s.append(arr[i] + " ");
		}
		return String.valueOf(s);
	}

	public static char[] getPyramid(int n) {
		char[] chars;
		if (n == 1) {
			chars = new char[n];
			chars[0] = 'X';
			return chars;
		} else {
			chars = nextRow(getPyramid(n - 1));
			return chars;
		}
	}

	public static char[] nextRow(char[] prevRow) {
		char[] chars = new char[prevRow.length + 2];
		Arrays.fill(chars, 'X');
		return chars;
	}

	public static void main(String[] args) {
		drawPyramid(10);
	}
}
