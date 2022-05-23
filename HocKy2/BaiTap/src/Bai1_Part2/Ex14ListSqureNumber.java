package Bai1_Part2;

import java.util.Scanner;

public class Ex14ListSqureNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n,m");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        System.out.print("List square number: ");
        for (int i = n; i <= m; i++) {
            int res = (int) Math.sqrt(i);
            if (res * res == i) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("\nThere are " + count + " square numbers.");
        sc.close();
    }
}