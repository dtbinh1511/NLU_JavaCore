
public class Replacemax {
	public static void replaceMissingValuesByMax(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == -1)
					matrix[i][j] = findMax(matrix[i]);
			}
		}
	}

	public static int findMax(int[] array) {
		int max = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max)
				max = array[i];
		}
		return max;
	}

	public static String toString(int[][] matrix) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				res.append(matrix[i][j] + "  ");
			}
			res.append("\n");
		}
		return res.toString();
	}

	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%3d", matrix[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, -1, 3 }, { -1, -1, 5 }, { 9, -1, 3 } };
		System.out.println("Before:");
		print(matrix);
		replaceMissingValuesByMax(matrix);
		System.out.println("After:");
		print(matrix);
	}
}
