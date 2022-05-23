package One_DimensionalArray;

import java.util.Arrays;
import java.util.Scanner;

public class Bai56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number element of array");
        int n = sc.nextInt();
        System.out.println("Enter element of array");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        sc.close();
    }
}