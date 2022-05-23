package AddEx;

public class Matrix {
	public static void show(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%2d ", matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static int[][] createPascalTriagle(int size) {
		int[][] matrix = new int[size][];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[i + 1];
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = j + 1;
			}
		}
		return matrix;
	}

	public static int[][] createPascalTriagle(int[] diagonalValues) {
		int[][] matrix = new int[diagonalValues.length][];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[i + 1];
		}

		for (int i = 0; i < matrix.length; i++) {
			int k = diagonalValues[i];
			for (int j = matrix[i].length - 1; j >= 0; j--) {
				matrix[i][j] = k--;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		int[] input = { 1, 5, 2, 0 };
		show(createPascalTriagle(4));
		System.out.println("====================");
		show(createPascalTriagle(input));
	}
}
