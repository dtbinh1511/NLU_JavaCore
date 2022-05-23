package Bai2_Part2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ex5InsertArray
 */
public class Ex5InsertArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element number array a, b");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = m + n;
        int p;

        System.out.println("Enter array a " + n + " element");
        int[] a = enter(n, sc);
        System.out.println("Enter array b " + m + " element");
        int[] b = enter(m, sc);
        
        int[] c = new int[k];

        System.out.println("Enter p");
        do {
            p = sc.nextInt();
        } while (p >= n|| p < 0);

        for (int i = 0; i < p; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < m; i++) {
            c[i + p] = b[i];
        }
        for (int i = p; i < n; i++) {
            c[i + m] = a[i];
        }
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));

    }

    public static int[] enter(int n, Scanner sc) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}