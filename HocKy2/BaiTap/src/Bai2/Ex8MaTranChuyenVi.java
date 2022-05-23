package Bai2;

import java.util.Scanner;

public class Ex8MaTranChuyenVi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m,n");
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println("Enter matrix a[][] ");
        int[][] arr = enter(m, n, sc);
        int[][] brr = transposition(arr);

        System.out.println("Matrix origin");
        show(arr);
        System.out.println("Matrix transposition");
        show(brr);
    }

    private static int [][] transposition(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int [] [] brr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                brr[i][j] = arr[j][i];
            }
        }
        return brr;
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

    private static void show(int [][]arr){
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}