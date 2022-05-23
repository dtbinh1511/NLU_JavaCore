package ThucHanhBuoi3;

public class Bai1 {
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] createPascalTriagle(int size) {
		int[][] matrix = new int[size][];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[i + 1]; // tao tung phan tu theo hang
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = j + 1;
			}
		}
		return matrix;
	}

	public static void show(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%2d ", matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static int[][] createPascalTriagle(int[] diagonalValues) {
		int[][] matrix = new int[diagonalValues.length][];
		for (int i = 0; i < diagonalValues.length; i++) {
			matrix[i] = new int[i + 1];
		}
		for (int i = 0; i < matrix.length; i++) {
			int k = diagonalValues[i];
			for (int j = matrix[i].length - 1; j >= 0; j--) {
				matrix[i][j] = k;
				k--;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
		printMatrix(matrix);
		System.out.println("===================================================");
		show(createPascalTriagle(4));
		System.out.println("===================================================");
		int[] diagonalValues = { 1, 5, 2, 0 };
		show(createPascalTriagle(diagonalValues));
	}
}
