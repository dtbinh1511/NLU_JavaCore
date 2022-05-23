package One_DimensionalArray;

import java.util.Scanner;

public class Bai60 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number element of array");
		int n = sc.nextInt();
		System.out.println("Enter element in array");
		int[] arr = new int[n];
		int[] brr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			brr[i] = -1;
		}
//		int[] arr = { 1, 2, 3, 1, 2 };
//		int[] brr = { 1, 1, 1, 1, 1 };

		for (int i = 0; i < n; i++) {
			int count = 1;
			for (int j = i + 1; j < n; j++) {
				if (arr[i] == arr[j]) {
					brr[j] = 0;
					count++;
				}
			}
			if (brr[i] != 0 && count == 1) {
				System.out.println("Number appear one times: " + arr[i]);// error
			}			
			if (brr[i] == 0) {
				System.out.println("Number appear more one times: " + arr[i]);
			}
		}
		
	}
}
