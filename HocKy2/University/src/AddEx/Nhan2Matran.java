package AddEx;

/* a11 a12 a13 		a11 a12		
 * a21 a22 a23		a21	a22
 * 					a31	a32
 * 
 * 
 */
public class Nhan2Matran {
	public static void main(String[] args) {
		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] arr2 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

		System.out.println("============== nhân ");
		show(nhanMaTran(arr1, arr2));
		System.out.println("=============== cộng ");
		show(congMaTran(arr1, arr1));
		System.out.println("=============== trừ ");
		show(truMaTran(arr1, arr1));
	}

	public static int[][] nhanMaTran(int[][] arr1, int[][] arr2) {
		int[][] array = new int[arr1.length][arr1[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				for (int j2 = 0; j2 < arr2[0].length; j2++) {
					array[i][j2] += arr1[i][j] * arr2[j][j2];

				}
			}
		}
		return array;
	}

	public static int[][] congMaTran(int[][] arr1, int[][] arr2) {
		int[][] array = new int[arr1.length][arr1[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				array[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		return array;
	}

	public static int[][] truMaTran(int[][] arr1, int[][] arr2) {
		int[][] array = new int[arr1.length][arr1[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[0].length; j++) {
				array[i][j] = arr1[i][j] - arr2[i][j];
			}
		}
		return array;
	}

	public static void show(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
