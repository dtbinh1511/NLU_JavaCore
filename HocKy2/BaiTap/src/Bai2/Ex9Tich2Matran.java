package Bai2;

import java.util.Scanner;

public class Ex9Tich2Matran {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m,n");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("Enter column matrix b");
        int k = sc.nextInt();
        System.out.println("Enter matrix a");
        int[][] a = enter(m, n, sc);
        System.out.println("Enter matrix b");
        int[][] b = enter(n, k, sc);

        System.out.println("Result multiply: ");
        int[][] c = MultiplyTheMatrix(a, b);
        show(c);
    }

    public static int[][] MultiplyTheMatrix(int[][] a, int[][] b) {
        int[][] c = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int j2 = 0; j2 < a[0].length; j2++) {
                    c[i][j2] += a[i][j] * b[j][j2];
                }
            }
        }
        return c;
    }

    private static int[][] enter(int m, int n, Scanner sc) {
        int[][] x = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = sc.nextInt();
            }
        }
        return x;
    }

    private static void show(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%5d", arr[i][j]);
            }
            System.out.println();
        }
    }
}