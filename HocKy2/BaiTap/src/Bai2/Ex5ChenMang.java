package Bai2;

import java.util.Arrays;
import java.util.Scanner;

public class Ex5ChenMang {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n,m ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = n + m;
        int p;

        System.out.println("Enter array arr " + n + " element");
        int[] arr = Enter(n);
        System.out.println("Enter array brr " + m + " element");
        int[] brr = Enter(m);
        int[] crr = new int[k];

        System.out.println("Enter p");
        do {
            p = sc.nextInt();
        } while (p < 0 || p >= n);

        // copy data
        for (int i = 0; i < p; i++) {
            crr[i] = arr[i];
        }
        // copy array b -> array c
        for (int i = 0; i < m; i++) {
            crr[i + p] = brr[i];
        }
        // copy array a -> array c
        for (int i = p; i < n; i++) {
            crr[i + m] = arr[i];
        }

        System.out.println("Array arr[]: " + Arrays.toString(arr));
        System.out.println("Array brr[]: " + Arrays.toString(brr));
        System.out.println("Array crr[]: " + Arrays.toString(crr));
        sc.close();
    }

    public static int[] Enter(int n) {
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        return x;
    }
}