package Bai1_Part2;

import java.util.Scanner;

/**
 * Ex1DrawRectanglesWithStars
 */
public class Ex1DrawRectanglesWithStars {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length, width");
        int n = sc.nextInt();
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