package Two_DimensionalArray;

import java.util.Scanner;

public class Bai63 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number line ");
		int m = sc.nextInt();
		System.out.println("Enter number column");
		int n = sc.nextInt();
		System.out.println("Enter matrix ");
		int[][] arr = enter(m, n, sc);
		System.out.println("Number max is: " + findMax(arr));
		System.out.println("Number min is: " + findMin(arr));
		System.out.println("Total number in array: " + sum(arr));
	}

	public static int sum(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

	public static int findMax(int[][] arr) {
		int index = 0;
		int index2 = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
					index = i;
					index2 = j;
				}
			}
		}
		return arr[index][index2];
	}

	public static int findMin(int[][] arr) {
		int index = 0;
		int index2 = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] < min) {
					min = arr[i][j];
					index = i;
					index2 = j;
				}
			}
		}
		return arr[index][index2];
	}

	public static int[][] enter(int m, int n, Scanner sc) {
		int[][] x = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				x[i][j] = sc.nextInt();
			}
		}
		return x;
	}

	public static void show(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
