package Bai2;

public class Matrix {
	public static int findMax(int matrix[][]) {
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] > max) {
					max = matrix[i][j];
				}
			}
		}
		return max;
	}

	public static boolean checkIsPrime(int number) {
		if (number < 2)
			return false;
		else
			for (int i = 2; i < Math.sqrt(number); i++) {
				if (number % i == 0)
					return false;
			}
		return true;
	}

	public static void findAndChange(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (checkIsPrime(matrix[i][j]))
					System.out.print(matrix[i][j] + " ");
				else
					System.out.print(0 + " ");
			}
			System.out.println();
		}
	}

	public static void findRow(int matrix[][]) {
		int count = 0;
		int max = 0;
		int index = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (checkIsPrime(matrix[i][j]))
					count++;
			}
//			System.out.println(count);
			if (count > max) {
				index = i;
				max = count;
			}
			count = 0;
		}
		System.out.println("Row have much prime: " + (index + 1));
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3, 5 }, { 5, 6, 7, 11 }, { 10, 22, 3, 43 } };
		System.out.println("Number max: " + findMax(matrix));
		System.out.println("=============");
		findAndChange(matrix);
		System.out.println("=============");
		findRow(matrix);
	}
}
