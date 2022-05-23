package Recursive;

import java.util.Arrays;

public class PascalTriangle {
	// This method is used to display a Pascal triangle based
	// on the parameter n.
	// Where n represents the number of rows
	public static void printPascalTriangle(int row) {
		for (int i = 1; i <= row; i++) {
			for (int j = row; j > i; j--) {
				System.out.print(" ");
			}
			System.out.println(toString(getPascalTriangle(i)));
		}
	}

	public static String toString(int[] arr) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			builder.append(arr[i] + " ");
		}
		return builder.toString();
	}

	// get the nth row.
	// For example: n=1 ==> {1}, n=2 ==> {1, 1}, ...
	public static int[] getPascalTriangle(int n) {
		if (n == 1)
			return new int[] { 1 };
		if (n == 2)
			return new int[] { 1, 1 };
		return generateNextRow(getPascalTriangle(n - 1));
	}

	// generate the next row based on the previous row
	// Ex. prevRow = {1} ==> nextRow = {1, 1}
	// Ex. prevRow = {1, 1} ==> nextRow = {1, 2, 1}
	public static int[] generateNextRow(int[] prevRow) {
		int[] nextRow = new int[prevRow.length + 1];
		for (int i = 1; i < nextRow.length - 1; i++) {
			nextRow[i] = prevRow[i] + prevRow[i - 1];
		}
		nextRow[0] = 1;
		nextRow[nextRow.length - 1] = 1;
		return nextRow;
	}

	public static void main(String[] args) {
		printPascalTriangle(5);
	}
}
