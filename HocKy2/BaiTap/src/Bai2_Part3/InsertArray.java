package Bai2_Part3;

import java.util.Scanner;

public class InsertArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element of array a");
        int n = sc.nextInt();
        System.out.println("Enter element of array b");
        int m = sc.nextInt();
        int k = n + m;
        System.out.println("Enter array a");
        int[] a = enter(n, sc);
        System.out.println("Enter array b");
        int[] b = enter(m, sc);

        int[] c = new int[k];
        int p;
        System.out.println("Enter value p");
        do {
            p = sc.nextInt();
        } while (p < 0 || p >= n);// condition to continue running (don't meet conditions -> stop)

        for (int i = 0; i < p; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < m; i++) {
            c[i + p] = b[i];
        }
        for (int i = p; i < n; i++) {
            c[m + i] = a[i];
        }
        show(a);
        show(b);
        show(c);
        sc.close();
    }

    public static int[] enter(int n, Scanner sc) {
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        return x;
    }

    public static void show(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();
    }
}