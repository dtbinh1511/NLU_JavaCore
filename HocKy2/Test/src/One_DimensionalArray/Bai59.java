package One_DimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class Bai59 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number element of array");
		int n = sc.nextInt();
		System.out.println("Enter element in array");
		int[] a = enter(n, sc);

		System.out.println(checkSymmetry(a, n));
		System.out.println(checkDanDau(a, n));
	}

	public static int[] enter(int n, Scanner sc) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		return a;
	}

//doi xung
	public static String checkSymmetry(int[] a, int n) {

		int a1[] = Arrays.copyOf(a, a.length);
		for (int i = 0; i < n / 2; i++) {
			int temp = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = temp;
		}
		int[] a2 = Arrays.copyOf(a, a.length);
		if (Arrays.equals(a1, a2)) {
			return "Symmetry array";
		} else {
			return "Not symmetry array";
		}
	}

	public static String checkDanDau(int[] a, int n) {
		for (int i = 0; i < n;) {
			if (a[i] * a[i + 1] < 0) {
				return "Mảng đan dấu";
			} else {
				return "Mảng không đan dấu";
			}
		}
		return "";
	}

//	for (int j = 1; j < n; j += 2) {
//		if ((a[i] < 0 && a[j] > 0) || (a[i] > 0 && a[j] < 0)) {
//			// a[i]*a[i+1]<0
//			count = 1;
//		}
//	}

//if (count == 1) {
//	return "Dan Dau";
//} else {
//	return "Khong dan dau";
//
//}
}