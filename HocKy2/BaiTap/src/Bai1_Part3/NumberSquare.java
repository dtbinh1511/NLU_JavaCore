package Bai1_Part3;

import java.util.Scanner;

public class NumberSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter m,n");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int count = 0;
        System.out.print("Number square: ");
        for (int i = m; i <= n; i++) {
            int res = (int) Math.sqrt(i);
            if (res * res == i) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nThere are " + count + " number square.");
        sc.close();
    }
}