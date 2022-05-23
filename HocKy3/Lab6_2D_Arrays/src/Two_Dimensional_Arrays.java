import java.util.Arrays;

public class Two_Dimensional_Arrays {
	public static void replaceMissingValuesByMin(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0)
					matrix[i][j] = findMin(matrix[i]);
			}
		}
	}

	public static int findMin(int[] array) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min && array[i] != 0)
				min = array[i];
		}
		for (int i = 0; i < array.length; i++)
			if (array[i] != 0)
				return min;
		return -1;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0 }, { 0, 2, 0 }, { 0, 3, 4 } };

		replaceMissingValuesByMin(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}
}
