package One_DimensionalArray;

import java.util.Scanner;

public class Bai53 {
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
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (max == a[i]) {
                count++;
            }
        }
        System.out.printf("Max = %2d appear %2d times.",max,count);
        sc.close();
    }
}