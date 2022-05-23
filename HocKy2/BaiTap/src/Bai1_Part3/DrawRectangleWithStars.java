package Bai1_Part3;

import java.util.Scanner;

/**
 * DrawRectangleWithStars
 */
public class DrawRectangleWithStars {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length");
        int n = sc.nextInt();
        System.out.println("Enter width");
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
        sc.close();
    }
}