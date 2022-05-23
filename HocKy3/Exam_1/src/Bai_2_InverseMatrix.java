import java.util.Arrays;

public class Bai_2_InverseMatrix {
	public static int[][] getTransposition(int[][] array) {
		int m = array.length;
		int n = array[0].length;
		int[][] result = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = array[j][i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] array = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		System.out.println(Arrays.deepToString(getTransposition(array)));
	}
}
