package One_DimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class Bai58 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number element of array");
		int n = sc.nextInt();
		System.out.println("Enter element of array");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		System.out.println(checkIncrease(a, n));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}

	public static String checkIncrease(int[] a, int n) {
		int dem = 0;
		for (int i = 0; i < n - 1; i++) {
			if (a[i + 1] >= a[i])
				dem++;
		}
		if (dem == n - 1)
			return "Array Increase.";
		else
			return "Array Decrease.";
	}
}