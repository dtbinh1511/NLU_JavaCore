package One_DimensionalArray;

import java.util.Scanner;

public class Bai58 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number element of array");
        int n = sc.nextInt();
        System.out.println("Enter element of array");
        int[] a = new int[n];
        int[] b = a;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int arrange = 0;
        boolean tang = false;
        for (int i = 0; i < n; i++) {
            if (a[i] < b[i + 1]) {
                arrange++;
            }
        }

        if (arrange == n - 1) {
            System.out.println("Dãy tăng");
        } else {
            System.out.println("Dãy không tăng");
        }

    
}