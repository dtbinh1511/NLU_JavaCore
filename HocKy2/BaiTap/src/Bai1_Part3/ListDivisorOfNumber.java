package Bai1_Part3;

import java.util.Scanner;

public class ListDivisorOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
        int count = 0;
        System.out.print("Divisors of " + n +": ");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nThere are " + count + " divisor.");
        sc.close();
    }
}