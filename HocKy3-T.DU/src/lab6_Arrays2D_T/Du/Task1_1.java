package lab6_Arrays2D_T.Du;

import java.util.Arrays;

public class Task1_1 {

	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		try {
			int[][] totalArray = new int[a.length][a[0].length];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					totalArray[i][j] = a[i][j] + b[i][j];
				}
			}
			return totalArray;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	// subtract 2 matrices
	public static int[][] subtract(int[][] a, int[][] b) {
		try {
			int[][] subtractArray = new int[a.length][a[0].length];
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i].length; j++) {
					subtractArray[i][j] = a[i][j] - b[i][j];
				}
			}
			return subtractArray;
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		try {
			int[][] multiplyArray = new int[a.length][b[0].length];
			for (int i = 0; i < multiplyArray.length; i++) {
				for (int j = 0; j < multiplyArray[i].length; j++) {
					for (int k = 0; k < b.length; k++) {
						multiplyArray[i][j] += (a[i][k] * b[k][j]);
					}
				}
			}
			return multiplyArray;
		} catch (Exception e) {
			return null;
		}
	}

	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int[][] resultArray2D = new int[a[0].length][a.length];
		for (int i = 0; i < resultArray2D.length; i++) {
			for (int j = 0; j < resultArray2D[i].length; j++) {
				resultArray2D[i][j] = a[j][i];
			}
		}
		return resultArray2D;
	}

	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2, 5 }, { 7, 8, 9 } };
		int[][] arr2 = { { 1, 2 }, { 7, 8 }, { 5, 6 } };
		System.out.println(arr1.length);

		System.out.println(Arrays.deepToString(add(arr1, arr2)));

		System.out.println(Arrays.deepToString(multiply(arr1, arr2)));
		System.out.println(Arrays.deepToString(transpose(arr1)));
	}
}
