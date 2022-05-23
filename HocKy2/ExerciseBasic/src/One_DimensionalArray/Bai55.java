package One_DimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class Bai55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number element of array");
        int n = sc.nextInt();
        System.out.println("Enter element of array");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            int temp = a[0];
            a[0] = a[n - 1];
            a[n - 1] = temp;

            int temp2 = a[1];
            a[1] = a[n - 2];
            a[n - 2] = temp2;
        }
        System.out.println(Arrays.toString(a));
        sc.close();
    }
}