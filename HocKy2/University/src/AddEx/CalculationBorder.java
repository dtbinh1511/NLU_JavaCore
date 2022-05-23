package AddEx;

public class CalculationBorder {
	public static int calculate(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[i].length - 1) {
					sum += matrix[i][j];
				}
			}
		}
		return sum;
	}

	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 5 }, { 4, 5, 6, 5 }, { 7, 8, 9, 5 } , {4,1,1,3}};
		print(matrix);
		System.out.println("Tổng của viền ma trận = " + calculate(matrix));
	}
}
