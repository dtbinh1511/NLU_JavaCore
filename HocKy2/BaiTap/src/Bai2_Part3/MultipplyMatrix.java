package Bai2_Part3;

import java.util.Scanner;

public class MultipplyMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m,n,k");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println("Enter array a");
        int[][] a = enter(m, n, sc);
        System.out.println("Enter array b");
        int[][] b = enter(n, k, sc);
        int[][] c = multiply(a, b);

        System.out.println("Matrix c =");
        show(c);
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int j2 = 0; j2 < b[0].length; j2++) {
                    c[i][j2] += a[i][j] * b[j][j2];
                }
            }
        }
        return c;
    }

    public static void show(int[][] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                System.out.print(n[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] enter(int m, int n, Scanner sc) {
        int[][] x = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = sc.nextInt();
            }
        }
        return x;
    }
}