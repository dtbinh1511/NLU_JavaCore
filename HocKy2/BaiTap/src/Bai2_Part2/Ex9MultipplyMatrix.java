package Bai2_Part2;

import java.util.Scanner;

/**
 * Ex9MultipplyMatrix
 */
public class Ex9MultipplyMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m,n");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("Enter column array b");
        int k = sc.nextInt();
        System.out.println("Enter matrix a");
        int[][] a = enter(m, n, sc);
        System.out.println("Enter matrix b");
        int[][] b = enter(n, k, sc);

        int[][] c = multiply(a, b);
        System.out.println("Result: ");
        show(c);
    }

    public static int[][] multiply(int[][] x, int[][] y) {
        int[][] c = new int[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[0].length; j++) {
                for (int j2 = 0; j2 < y[0].length; j2++) {
                    c[i][j2] += x[i][j] * y[j][j2];
                }
            }
        }
        return c;
    }

    public static int[][] enter(int m, int n, Scanner scanner) {
        int[][] x = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = scanner.nextInt();
            }
        }
        return x;
    }

    public static void show(int[][] x) {
        int n = x.length;
        int m = x[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }
}