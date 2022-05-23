package AddEx;

public class MatranXoanOc {
	public static void main(String[] args) {
		create();
	}

	static int count = 0;
/* x1		x2
 * a11 a12 a13  y1
 * a21 a22 a23
 * a31 a32 a33  y2
 * 
 */
	public static void topRight(int[][] matrix, int x1, int y1, int x2, int y2) {
		for (int i = x1; i <= x2; i++)
			matrix[y1][i] = count++;

		for (int i = y1 + 1; i <= y2; i++)
			matrix[i][x2] = count++;

		if (x2 - x1 > 0 && y2 - y1 > 0) {
			y1++;
			x2--;
			buttomLeft(matrix, x1, y1, x2, y2);
		}

	}

	public static void buttomLeft(int[][] matrix, int x1, int y1, int x2, int y2) {
		for (int i = x2; i >= x1; i--)
			matrix[y2][i] = count++;

		for (int i = y2 - 1; i >= y1; i--)
			matrix[i][x1] = count++;

		if (x2 - x1 > 0 && y2 - y1 > 0) {
			y2--;
			x1++;
			topRight(matrix, x1, y1, x2, y2);
		}
	}

	public static void show(int[][] matrix) {
		for (int[] x : matrix) {
			for (int y : x)
				System.out.printf("%5d", y);
			System.out.println();
		}

	}

	public static void create() {
		int[][] matrix;
		int m = 8, n = 4;
		matrix = new int[m][n];
		topRight(matrix, 0, 0, n - 1, m - 1);
		show(matrix);
	}
}
