package ThucHanhBuoi4;

public class Bai5 {

	public static void main(String[] args) {
		show(createPascalTriagle(4));
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

	public static void show(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
