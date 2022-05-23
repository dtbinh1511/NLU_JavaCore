package Bai2_Part3;

import java.util.Scanner;

public class MatrixInverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m,n");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("Enter matrix a");
        int[][] a = enter(m, n, sc);
        int[][] b = transposition(a);
        System.out.println("Matrix a: ");
        show(a);
        System.out.println("Matrix Inverse b: ");
        show(b);
        sc.close();
    }

    public static int[][] transposition(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] b = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = a[j][i];
            }
        }
        return b;
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

    public static void show(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }
}