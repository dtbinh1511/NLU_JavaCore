package Bai2_Part2;

import java.util.Scanner;

public class Ex8MatrixTransposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m,n");
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("Enter array a");
        int[][] arr = enter(m, n, sc);
        int[][] brr = transposition(arr);

        System.out.println("Matrix Origin");
        show(arr);
        System.out.println("Matrix Transposition");
        show(brr);
    }

    public static int[][] transposition(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] brr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                brr[i][j] = arr[j][i];
            }
        }
        return brr;
    }

    public static int[][] enter(int m, int n, Scanner sc) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }

    public static void show(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}