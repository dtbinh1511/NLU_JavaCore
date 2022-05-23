package Bai1_Part3;

import java.util.Scanner;

public class DrawSymmetricalTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter height");
        int h = sc.nextInt();
        for (int i = 0; i <= h; i++) {
            for (int j = i - 1; j < h; j++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print(j + "  ");
                if (j >= i) {
                    break;
                }
            }
            for (int j = i - 1; j > 0; j--) {
                System.out.print(j + "  ");
            }
            System.out.println();
        }
        sc.close();
    }
}