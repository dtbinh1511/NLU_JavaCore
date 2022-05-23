package ThayToan;

import java.util.Scanner;

public class Cau2 {
	public static boolean kiemTraNgTo(int number) {
		if (number < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	public static int[][] taoMang(int m, int n) {
		Scanner sc = new Scanner(System.in);
		int[][] array2D = new int[m][n];
		for (int i = 0; i < array2D.length; i++) {
			for (int j = 0; j < array2D[i].length; j++) {
				array2D[i][j] = sc.nextInt();
			}
		}
		return array2D;
	}

	public static int tongSoNgTo(int[][] array2D) {
		int sum = 0;
		for (int i = 0; i < array2D.length; i++) {
			for (int j = 0; j < array2D[i].length; j++) {
				if (kiemTraNgTo(array2D[i][j]))
					sum += array2D[i][j];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập số dòng");
		int m = sc.nextInt();
		System.out.println("Nhập số cột");
		int n = sc.nextInt();
		int[][] array2D = taoMang(m, n);

		System.out.println(tongSoNgTo(array2D));
	}
}
