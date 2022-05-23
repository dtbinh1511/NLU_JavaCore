package Bai2_Part3;

import java.util.Scanner;

public class MaxRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element of array");
        int n = sc.nextInt();
        System.out.println("Enter array");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int count = 1;
        int max = 0;
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] < a[i + 1]) {
                count++;
            }
            if (a[i] > a[i + 1]) {
                index = count;
                count = 1;
            }
            if (i == n - 2) {
                index = count;
            }
            if (max < index) {
                max = index;
            }
        }

        System.out.println("Max round: " + max);
        sc.close();
    }
}