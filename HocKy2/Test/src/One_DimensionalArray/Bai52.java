package One_DimensionalArray;

import java.util.Scanner;

public class Bai52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number element of array");
        int n = sc.nextInt();
        System.out.println("Enter element of array");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
            sum += a[i];
        }
        System.out.println("Max of array: " + max);
        System.out.println("Min of array: " + min);
        System.out.println("Sum = " + sum);
        sc.close();
    }
}